// https://school.programmers.co.kr/learn/courses/30/lessons/42839

import java.util.*;

class Solution {
    public int solution(String strNum) {
        int length = strNum.length();
        int[] nums = new int[length];
        for(int i=0;i<length;i++){
            nums[i] = strNum.charAt(i)-'0';
        }
        Set<Integer> numSet = new HashSet<>();
        boolean[] used = new boolean[length];
        
        dfs(numSet,nums,used,0);
        
        int cnt = 0;
        for(int n : numSet){
            if(isPrime(n)) {
                cnt++;
                // System.out.print(n+" ");
            }
        }
        
        return cnt;
    }
    
    static void dfs(Set<Integer> set, int[] nums, boolean[] used, int curr){
        if(curr>0)
            set.add(curr);
        
        Set<Integer> sameDepth = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if (used[i] || sameDepth.contains(num)) continue;
            
            sameDepth.add(num);
            used[i] = true;
            int next = curr * 10 + num;
            dfs(set,nums,used,next);
            used[i] = false;
        }
    }
    
    static boolean isPrime(int num){
        if (num==1)
            return false;
        int n = (int) Math.sqrt(num);
        for(int i=2;i<=n;i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
    
}
