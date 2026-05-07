// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// 7M / 효율성 통과 / AI(Support)
// Stack<Character>는 괄호 하나를 만날 때마다 Character 객체를 다루고, 내부 배열에 넣고 빼는 작업을 함.
// 반면 int count는 숫자 하나만 증가/감소하면 끝임.
// java.util.Stack은 내부적으로 동기화 비용도 있음. push, pop 같은 메서드가 Vector 기반이라 상대적으로 느림

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int N = s.length();
        int count = 0;
        
        for(int i=0;i<N;i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
                if (count<0) {
                    answer = false;
                    break;                    
                }
            }
        }
        
        if (count != 0) {
            answer = false;
        }

        return answer;
    }
    
    
}
