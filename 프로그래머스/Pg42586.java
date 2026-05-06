// https://school.programmers.co.kr/learn/courses/30/lessons/42586
// 18M

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int N = progresses.length;
        int[] date = new int[N];
        int cnt = 1;
        int maxDate = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            // int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];  // 정수 올림 공식 이용
            int last = 100 - progresses[i];
            date[i] = last/speeds[i];
            if (last%speeds[i] != 0) {
                date[i]++;
            }
            if (i == 0) {
                maxDate = date[i];
            } else {
                if (maxDate<date[i]) {
                    maxDate = date[i];
                    list.add(cnt);
                    cnt = 1;
                } else {
                    cnt++;
                }
                
                if (i == N-1) {
                    list.add(cnt);
                }
            }
            
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}
