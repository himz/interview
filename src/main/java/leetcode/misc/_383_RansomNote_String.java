package leetcode.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class _383_RansomNote_String {
    public boolean canConstruct(String ransomNote, String magazine) {

        int ransomNoteLen = ransomNote.length();
        int magazineLen = magazine.length();

        if(ransomNoteLen > magazineLen){
            return false;
        }


        int[] ransomArray = new int[26];
        int[] magazineArray = new int[26];

        int i;
        for(i = 0; i < ransomNoteLen; i++) {
            ransomArray[ransomNote.charAt(i) - 97]++;
        }

        for(i = 0; i < magazineLen; i++) {
            magazineArray[magazine.charAt(i) - 97]++;
        }

        for(i = 0; i < 26; i++) {
            if(magazineArray[i] < ransomArray[i]) {
                return false;
            }
        }

        return true;
    }
}
