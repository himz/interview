package design.kvstore;

public class ConsistentHashService {
    long getLongNumber(byte[] digest) {
        long h = 0;
        for (int i = 0; i < 4; i++) {
            h <<= 8;
            h |= ((int) digest[i]) & 0xFF;
        }
        return h;
    }


}
