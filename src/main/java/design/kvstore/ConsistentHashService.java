package design.kvstore;

public class ConsistentHashService {
    //https://www.codeproject.com/Articles/56138/Consistent-hashing
    long getLongNumber(byte[] digest) {
        long h = 0;
        for (int i = 0; i < 4; i++) {
            h <<= 8;
            h |= ((int) digest[i]) & 0xFF;
        }
        return h;
    }


}
