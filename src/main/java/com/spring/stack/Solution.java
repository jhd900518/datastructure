package com.spring.stack;

import java.util.*;
import java.util.Stack;

/**
 * Created by jhd on 18/5/8.
 * 校验括号匹配
 */
public class Solution {

    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution C = new Solution();
        String s = "{{}]";
        System.out.println(C.isValid(s));

        String s1="[[]]";

        System.out.println(C.isValid(s1));
    }
}
