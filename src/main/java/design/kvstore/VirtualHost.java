package design.kvstore;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;

public class VirtualHost{

    private ConsistentHashService csService = new ConsistentHashService();

    String ip;
    long hash;
    HashMap<String, String> map;


    public VirtualHost(String ip) {
        this.ip = ip;
        this.map = new HashMap<>();
        // get long hash for the given ip address.
        hash = csService.getLongNumber(DigestUtils
                .md5(ip));

    }
}
