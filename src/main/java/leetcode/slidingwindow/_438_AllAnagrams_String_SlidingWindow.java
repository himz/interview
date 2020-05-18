package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _438_AllAnagrams_String_SlidingWindow {

    private Map<Character, Integer> initMap(String p, Map<Character, Integer> bMap) {
        if (bMap != null) {
            return new HashMap<>(bMap);
        }
        Map<Character, Integer> pMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            if (pMap.containsKey(c)) {
                Integer i = pMap.get(c);
                pMap.put(c, ++i);
            } else {
                pMap.put(c, 1);
            }
        }
        return pMap;
    }
    // Works but very bad complexity -- do not use hash map
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> pMap = initMap(p, null);
        Map<Character, Integer> bMap = new HashMap<>(pMap);
        int sw = 0;
        int q = 0;
        int counter = p.length();
        while (q < s.length()) {
            if (pMap.containsKey(s.charAt(q))) {
                int i = pMap.get(s.charAt(q));
                pMap.put(s.charAt(q), --i);
                if (pMap.get(s.charAt(q)) == 0) {
                    pMap.remove(s.charAt(q));
                }

                if (pMap.size() == 0) {
                    result.add(sw);
                    // this done. Move the sw to next location
                    sw = sw + 1;
                    q = sw;
                    pMap = initMap(p, bMap);
                } else {
                    q++;
                }
            } else {
                // not an anagram. Discard the elements till now.
                sw = sw + 1;
                q = sw;
                // map might have been bad.
                // init map
                pMap = initMap(p, bMap);
            }
        }

        return result;
    }

    // COpied funcition from Somewhere
    //https://www.youtube.com/watch?v=fvEw13A5O1o
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int[] pMap = new int[26];

        for (char c : p.toCharArray()) {
            pMap[c - 'a']++;
        }

        int begin = 0, end = 0;
        int counter = p.length();

        while (end < s.length()) {

            if (pMap[s.charAt(end) - 'a'] >= 1) {

                counter--;
            }
            pMap[s.charAt(end) -'a']--;
            end++;


            if (counter == 0) {
                result.add(begin);
            }

            if (end - begin == p.length()) {
                if(pMap[s.charAt(begin) - 'a'] >= 0) {
                    counter++;

                }
                pMap[s.charAt(begin) - 'a']++;
                begin++;
            }


/*
            if (pMap[s.charAt(end++) - 'a']-- >= 1) {
                counter--;
            }


            if (counter == 0) {
                result.add(begin);
            }

            if (end - begin == p.length() && pMap[s.charAt(begin++) - 'a']++ >= 0) {
                counter++;
            }*/




        }
        return result;
    }
}
