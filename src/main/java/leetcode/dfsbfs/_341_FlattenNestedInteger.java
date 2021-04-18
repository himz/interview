package leetcode.dfsbfs;

import common.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _341_FlattenNestedInteger  implements Iterator<Integer> {

        List<Integer> list;
        int start = 0;
        public _341_FlattenNestedInteger(List<NestedInteger> nestedList) {
            // convert to list
            list = new ArrayList<Integer>();
            dfs(nestedList, list);
        }

        void dfs(List<NestedInteger> nl, List<Integer> list) {
            for(NestedInteger n : nl) {
                if(n.isInteger()) {
                    list.add(n.getInteger());
                } else {
                    dfs(n.getList(), list);
                }
            }
        }


        @Override
        public Integer next() {
            return list.get(start++);


        }

        @Override
        public boolean hasNext() {
            return start < list.size();
        }
}


