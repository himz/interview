package concurrency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Program to show how we can leverage streams/lambda to create bunch of threads quickly/neatly.
 * Combine them and run together.
 *
 */
public class WebCrawlerMultiThreaded {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> set = new HashSet<>();
        set.add(startUrl);
        String hostName = startUrl.split("/")[2];

        dfs(htmlParser, set, startUrl, hostName);



        List<String> result = new ArrayList<>(set);
        return result;
    }

    void dfs(HtmlParser hp, Set<String> set, String startUrl, String hostName) {
        List<Thread> threads = new ArrayList<>();
        for(String url : hp.getUrls(startUrl)) {
            if(url.contains(hostName)) {
                // we are in the same host name.
                if(!set.contains(url)) {
                    set.add(url);
                    // spin new threads here to do dfs.
                    Thread t = new Thread(() ->{dfs(hp, set, url, hostName);});
                    threads.add(t);
                    t.start();
                    //dfs(hp, set, url, hostName);
                }

            }

        }

        for(Thread t : threads) {
            try{
                t.join();
            } catch(Exception ex) {
                // do nothing.`
            }
        }


    }

}


class HtmlParser {
    public List<String> getUrls(String startUrl) {
        // TODO implement
        return null;
    }
}