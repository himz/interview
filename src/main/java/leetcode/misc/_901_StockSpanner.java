package leetcode.misc;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
 *
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
 *
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 *
 *
 *
 * Example 1:
 *
 * Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * Output: [null,1,1,1,2,1,4,6]
 * Explanation:
 * First, S = StockSpanner() is initialized.  Then:
 * S.next(100) is called and returns 1,
 * S.next(80) is called and returns 1,
 * S.next(60) is called and returns 1,
 * S.next(70) is called and returns 2,
 * S.next(60) is called and returns 1,
 * S.next(75) is called and returns 4,
 * S.next(85) is called and returns 6.
 *
 * Note that (for example) S.next(75) returned 4, because the last 4 prices
 * (including today's price of 75) were less than or equal to today's price.
 *
 *
 *
 * Note:
 *
 *     Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
 *     There will be at most 10000 calls to StockSpanner.next per test case.
 *     There will be at most 150000 calls to StockSpanner.next across all test cases.
 *     The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
 https://leetcode.com/problems/online-stock-span/
 */
public class _901_StockSpanner {
    public static void main(String [] args) {
        StockSpanner ss = new StockSpanner();
        int val = ss.next(100);
        val = ss.next(80);
        val = ss.next(60);
        val = ss.next(70);
        val = ss.next(60);
        val = ss.next(75);
        val = ss.next(85);
    }
}

/**
 * ALgo: Basically realize that any particular day is the sum of spans of previous smaller. So if we just keep aggregating
 * every day, we should be good.
 *    We should have a stack of a pair of (current  price, maximum number of consecutive days)
 *    Since we don't have an access to the indicies.
 *
 *    Let's trace the algorithm together on [100, 80, 60, 70, 60, 75, 85]
 *    1. calling StockSpanner.next(100) should result in first element in our stack will be (100, 1) (s.size() == 1)
 *    2. calling StockSpanner.next(80) should result in second element in our stack will be (80, 1) (s.size() == 2)
 *    3. calling StockSpanner.next(60) should result in third element in our stack will be (60, 1) (s.size() == 3)
 *    4. Now on calling StockSpanner.next(70) we should add span of (60) + 1 {the current day}
 *    and remove it from stack (70, 2) (s.size() == 3)
 *    5. Now on calling StockSpanner.next(60) result in fourth element in our stack will be (60, 1) (s.size() == 4)
 *    6. Now on calling StockSpanner.next(75) we should add span of (60) and (70) + 1 {the current day}
 *    and remove it from stack : (75, 4) (s.size() == 3)
 *    7. Now on calling StockSpanner.next(85) we should add span of (75) and (80) + 1 {the current day}
 *    and remove it from stack : (85, 6) (s.size() == 2)
 *
 */
class StockSpanner {

    Stack<StockPriceSpan> stack;
    public StockSpanner() {
        stack = new Stack<StockPriceSpan>();


    }

    public int next(int price) {
        int count = 0;
        while(true){
            if(stack.size() > 0) {
                if(stack.peek().price <= price) {
                    count = count + stack.pop().span;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        int span = count + 1;
        stack.push(new StockPriceSpan(price, span));
        return span;
    }
}

class StockPriceSpan {
    int price;
    int span;

    public StockPriceSpan(int price, int span) {
        this.price = price;
        this.span = span;
    }
}


