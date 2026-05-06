// https://school.programmers.co.kr/learn/courses/30/lessons/42583
// 22M

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int N = truck_weights.length;
        
        int[] go = new int[N];
        
        int currWeight = 0;
        
        int time = 0;
        
        int idx = 0;
        int bridgeIdx = 0;
        while (idx < N) {
            time++;
            if (weight >= currWeight+truck_weights[idx] && go[idx] == 0) {
                currWeight += truck_weights[idx];
                idx++;
            }
            for(int i=bridgeIdx; i<idx;i++) {
                go[i]++;
            }
            if (go[bridgeIdx] == bridge_length) {
                // System.out.println("time:"+time+" bridgeIdx 통과:"+bridgeIdx);
                currWeight -= truck_weights[bridgeIdx];
                bridgeIdx++;
            }
        }
        time += (bridge_length-go[N-1]+1);
        
        return time;
    }
}
