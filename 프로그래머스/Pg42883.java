// https://school.programmers.co.kr/learn/courses/30/lessons/42883
// 35M

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int N = number.length();
        char[] num = new char[N];
        boolean[] trash = new boolean[N];
        
        for(int i=0;i<N;i++) {
            num[i] = number.charAt(i);
        }
        
        int count = 0;
        
        for(int i=0;i<N-1;i++) {
            // System.out.println(i+" 인덱스 시작");
            int maxIdx = i;
            for(int j=1; j<=k-count && i+j < N;j++) {
                // System.out.println(maxIdx+" 인덱스 앞까지 삭제 값: "+num[maxIdx]);
                if (num[maxIdx] < num[i+j]) {
                    maxIdx = i+j;
                }
            }
            if (maxIdx != i) {
            // System.out.println(maxIdx+" 인덱스 앞까지 삭제 값: "+num[maxIdx]);
                for (int j=i;j<maxIdx;j++) {
                    trash[j] = true;
                    count++;
                }
                i = maxIdx;
            }
            if (count >= k){
                break;
            }
           
        }
        
        if (count<k) {
            int idx = N-1;
            while (idx>=0) {
                if (!trash[idx]){
                    trash[idx] = true;
                    if (++count >= k){
                        break;
                    }
                }
                idx--;
            }
        }
        
        for(int i=0;i<N;i++) {
            if (!trash[i]) {
                answer += num[i];
            }            
        }
        
        
        return answer;
    }
}
