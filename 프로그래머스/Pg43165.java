// https://school.programmers.co.kr/learn/courses/30/lessons/43165
class Solution {
    static int count;
    static int depth;
    public int solution(int[] nums, int target) {
        count = 0;
        depth = nums.length;
        
        boolean[] visited = new boolean[depth];
        
        dfs(nums,visited,target,0);
        
        
        return count;
    }
    
    // visited 필요없을듯?
    static void dfs(int[] nums, boolean[] visited, int target, int idx){
        if (idx > depth){
            return;
        }
        
        check(nums, target);
        
        for(int i=idx;i<depth;i++){
            if (!visited[i]){
                nums[i] *= -1;
                visited[i] = true;
                dfs(nums,visited,target,i+1);
                nums[i] *= -1;
                visited[i] = false;
            }
                
        }
        // dfs(nums,visited,target,idx+1);
        
    }
    
    static void check(int[] nums, int target){
        int sum = 0;
        for(int n : nums){
            // System.out.print(n+" ");
            sum+=n;
        }
        // System.out.println();
        if (sum == target){
            for(int n : nums){
                // System.out.print(n+" ");
            }
            // System.out.println();
            count++;
        } 
    }
    
}
