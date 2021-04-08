package design.kvstore;

public class CacheUser {

    public static void main(String []args) {
        DistributedKeyValueCache kvCache = new DistributedKeyValueCache();




        // Run the simulation
        kvCache.put("key1", "value1");
        kvCache.put("key2", "value2");
        kvCache.put("qwercasdafdsfasdf", "value3");
        kvCache.put("key4", "value4");
        kvCache.put("key5", "value5");



        kvCache.get("key1");
        kvCache.get("key8");
        kvCache.get("key2");



    }
}
