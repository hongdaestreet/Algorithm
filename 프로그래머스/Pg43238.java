// https://school.programmers.co.kr/learn/courses/30/lessons/43238
// 22M / AI(SUPPORT)
// 1.int끼리 곱하면 오버플로우 날 수 있는 점 고려
// 2.최솟값구하는 문제이기


import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int N = times.length;
        Arrays.sort(times);
        
        
        long start = 1;
        long end = (long)times[N-1] * n;
        
        long mid = 0;
        
        while (start<end) {
            long cnt = 0;
            mid = (start+end)/2;
            for(int i=0;i<N;i++) {
                cnt += mid/times[i];
                if (cnt>=n) {
                    end = mid;  // end가 답일 수 있으니까 -1하면 안됨
                    break;
                }
            }
            // System.out.println("mid: "+mid+" start: "+start+"end: "+end+" cnt: "+cnt);
            
            if (cnt<n) {  // 성립이 안되는 경우임
                start = mid+1;  // mid를 버려야 하므로 mid+1을 출발점으로 둠
            }
            
        }
        
        
        return start;
    }
}
