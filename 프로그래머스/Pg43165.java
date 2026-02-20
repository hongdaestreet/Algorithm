// https://school.programmers.co.kr/learn/courses/30/lessons/43165
class Solution {
    static int N;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        answer = 0;
        dfs(0,0,numbers, target);
        
        
        return answer;
    }
    
    static void dfs(int idx,int total,int[] numbers,int target) {
        if (idx == N) {
            if (total == target)
                answer++;
            return;
        }
        
        dfs(idx+1,total+numbers[idx],numbers,target);
        dfs(idx+1,total-numbers[idx],numbers,target);
    }
    
}
