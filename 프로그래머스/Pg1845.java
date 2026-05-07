// https://school.programmers.co.kr/learn/courses/30/lessons/1845
// 6M

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length;
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<N;i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                if (++cnt >= N/2) {
                    return cnt;
                }
            }
        }
        
        return cnt;
    }
}
