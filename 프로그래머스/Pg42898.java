// https://school.programmers.co.kr/learn/courses/30/lessons/42898
// 소요시간: 1H
// 경로 더하기 로직 - 무조건 DP쓰자…

import java.util.*;

class Solution {
    static final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        long cnt = 0;
        long[][] map = new long[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                map[i][j] = 1;
            }
        }
        
        for(int i=0;i<puddles.length;i++){
            map[puddles[i][0]][puddles[i][1]] = 0;
        }
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if (map[i][j] == 0){
                    continue;
                }
                if (!(i==1 && j==1))
                map[i][j] = (map[i-1][j]+map[i][j-1])%MOD;
            }
        }
        
        
        int ans = (int) (map[m][n] % MOD);
        return ans;
    }
}
