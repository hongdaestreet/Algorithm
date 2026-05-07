// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// 7M / 효율성 실패
// Stack 쓰면 시간 초과?

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int N = s.length();
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<N;i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else {
                if (st.isEmpty()) {
                    answer = false;
                    break;                    
                } else {
                    st.pop();
                }
            }
        }
        if (!st.isEmpty()) {
            answer = false;
        }

        return answer;
    }
    
    
}
