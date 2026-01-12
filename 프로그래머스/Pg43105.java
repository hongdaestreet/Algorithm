// https://school.programmers.co.kr/learn/courses/30/lessons/43105

class Solution {
    public int solution(int[][] tri) {
        
        int H = tri.length;
        int[][] dp = new int[H][H];
        dp[0][0] = tri[0][0];
        
        for(int h=1;h<H;h++){
            for(int i=0;i<=h;i++){
                dp[h][i] = Math.max(dp[h-1][Math.max(i-1,0)],dp[h-1][Math.min(i,h-1)]) + tri[h][i];
            }
        }
        
        int max = -1;
        for(int i=0;i<H;i++){
            max = Math.max(dp[H-1][i],max);
        }
        
        return max;
    }
}
