package design.kvstore;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Distributed K,V cache implementation with consistent hashing.
 * Algo:
 * -
 */
public class DistributedKeyValueCache {
    // Define max set of hosts that we are going to support
    private final int HOST_COUNT = 25;

    // TODO - change to auto wiring
    private ConsistentHashService csService = new ConsistentHashService();


    VirtualHost arr[] = new VirtualHost[HOST_COUNT];
    int minHost = HOST_COUNT + 1;
    int maxHost = -1;

    public DistributedKeyValueCache() {
        init(); // mimic some other service managing the hosts
    }

    void init() {
        // Add host to the kvcache. Ideally should be done by some other service
        addHost("192.168.1.10");
        addHost("192.168.1.20");
        addHost("192.168.1.30");
    }

    /**
     * Return true, if we are able to add the host, else false
     * @param ip
     * @return
     */
    boolean addHost(String ip) {
        // check if there is a free slot

        for(int i = 0; i < HOST_COUNT; i++) {
            if(arr[i] == null) {
                // found a bucket
                arr[i] = new VirtualHost(ip);
                updateMinMaxHost();
                return true;
            }
        }


        return false;
    }

    boolean removeHost(String ip) {
        for(int i = 0; i < HOST_COUNT; i++) {
            if(arr[i].ip.equals(ip)) {
                // found a bucket
                arr[i] = null;
                updateMinMaxHost();
                return true;
            }
        }

        return false;
    }

    // Keep track of min and max host in our circle.
    void updateMinMaxHost() {
        long maxHostHash = Long.MIN_VALUE;
        long minHostHash = Long.MAX_VALUE;

        for(int i = 0; i < HOST_COUNT; i++) {
            if(arr[i] != null) {
                if(maxHostHash < arr[i].hash) {
                    maxHostHash = arr[i].hash;
                    maxHost = i;
                }

                if(minHostHash > arr[i].hash) {
                    minHostHash = arr[i].hash;
                    minHost = i;
                }

            }
        }

    }


    String get(String key) {
        // get host number
        int i = getHostNumber(key);
        System.out.println("Possible key host location: " + arr[i].ip);
        if(arr[i].map.containsKey(key)) {
            System.out.println("Found key in the host: " + arr[i].ip);
            return arr[i].map.get(key);
        }
        else {
            System.out.println("Could Not find the key in the host");
            return null;
        }
    }

    void put(String key, String value) {
        int hostNumber = getHostNumber(key);
        System.out.println("host location to put key: " + arr[hostNumber].ip + ":" + key);
        // save the pair in cache
        arr[hostNumber].map.put(key, value);
    }

    int getHostNumber(String key){
        long keyHash = csService.getLongNumber(DigestUtils
                .md5(key));
        int hostNumber = -1;
        long maxHash = Long.MIN_VALUE;
        for(int i = 0; i < HOST_COUNT; i++) {
            if(arr[i] != null) {
               if(keyHash > arr[i].hash && arr[i].hash > maxHash) {
                   hostNumber = i;
                   maxHash = arr[i].hash;
               }
            }
        }

        if(hostNumber == -1) {
            // circular case
            hostNumber = maxHost;
        }
        return hostNumber;
    }
}
