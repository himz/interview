package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _20 {
    Map<Character, Character> map;
    _20() {
        map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        map.put('#', '#');

    }
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                charStack.push(c);
            } else {
                // It is one of the values
                Character popChar;
                if(charStack.isEmpty()) {
                    popChar = '#';
                } else {
                    popChar = charStack.pop();
                }

                // If pop char is equal to value of map, -- desired case.
                if (!map.get(popChar).equals(c)) {
                    return false;
                }
            }
        }
        if(charStack.isEmpty()) {
            return true;
        }
        return false;
    }
}