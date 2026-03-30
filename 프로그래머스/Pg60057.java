
// https://school.programmers.co.kr/learn/courses/30/lessons/60057
// 1H / AI(Support)
// 1.마지막에 연속적일 때 상황 고려안했음. 2.문자열이 1인 경우 고려안함

import java.util.*;

class Solution {
    static char[] data;
    static int N;
    public int solution(String s) {
        data = s.toCharArray();
        N = data.length;
        int minLen = Integer.MAX_VALUE;
        for(int token=1;token<=Math.max(N/2,1);token++) {
            minLen = Math.min(minLen,calculate(token));
            // System.out.println(token+" "+calculate(token));
        }
        
        return minLen;
    }
    
    static int calculate(int token){
        int len = N;
        boolean last = true;
        int seq = 1;
        for(int i=0;i<N-token*2+1;i+=token) {
            for(int t=0;t<token;t++){
                // System.out.println((i+t)+" "+(i+t+token)+" "+data[i+t]+" "+data[i+t+token]);
                if (data[i+t] != data[i+t+token]){
                    last = false;
                    break;
                }
            }
            
            if (last) {
                seq++;
            } else {
                len -= (seq-1)*token;
                // 숫자 달릴 수
                if (seq==1){
                    
                } else if (seq<10){
                    len += 1;
                } else if (seq<100){
                    len += 2;
                } else if (seq<1000){
                    len += 3;
                } else {
                    len += 4;
                }
                seq = 1;
                last = true;
            }
        }
        if (last) {  // 마지막인데 연속돼서 넘길 경우 체크
            len -= (seq-1)*token;
            // 숫자 달릴 수
            if (seq==1){
                
            } else if (seq<10){
                len += 1;
            } else if (seq<100){
                len += 2;
            } else if (seq<1000){
                len += 3;
            } else {
                len += 4;
            }
            
        }
        
        return len;
    }
}
