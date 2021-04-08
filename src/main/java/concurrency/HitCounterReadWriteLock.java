package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * This is good read write lock implementation
 * readLock.lock();
 *
 *     This means that if any other thread is writing (i.e. holds a write lock) then stop here until no other thread is writing.
 *     Once the lock is granted no other thread will be allowed to write (i.e. take a write lock) until the lock is released.
 *
 * writeLock.lock();
 *
 *     This means that if any other thread is reading or writing, stop here and wait until no other thread is reading or writing.
 *     Once the lock is granted, no other thread will be allowed to read or write (i.e. take a read or write lock) until the lock is released.
 */
public class HitCounterReadWriteLock {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    // store each last get hit timestamp with that bucket
    int[] times;
    // store the number of hit for that bucket
    int[] hits;

    /** Initialize your data structure here. */
    public HitCounterReadWriteLock() {
        hits = new int[300];
        times = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        w.lock();
        try {
            int idx = timestamp % 300;
            if (times[idx] != timestamp) {
                // not in the same 5 minute window
                times[idx] = timestamp;
                hits[idx] = 1;
            } else {
                hits[idx]++;
            }

        } finally {
            w.unlock();
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int sum = 0;
        r.lock();
        try {
            for (int i = 0; i < 300; i++) {
                if (timestamp - times[i] < 300) sum += hits[i];
            }
        } finally {
            r.unlock();
        }
        return sum;
    }

}
