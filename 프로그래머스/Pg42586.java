// https://school.programmers.co.kr/learn/courses/30/lessons/42586
// 18M

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int N = progresses.length;
        int[] date = new int[N];
        int cnt = 0;
        int currentDay = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];  // 정수 올림 공식 이용
            if (i == 0) {
                currentDay = day;
                cnt++;
            } else if (day <= currentDay) {
                cnt++;
            } else {
                list.add(cnt);
                currentDay = day;
                cnt = 1;
            }
            
        }
        
        // 마지막꺼 넣기
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}
