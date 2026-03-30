// https://school.programmers.co.kr/learn/courses/30/lessons/118668?language=java
// 1H / AI(hint)
// dp를 각 능력 상태로 도달하는 시간으로 생각하면 됨, 항상 최단값 보장하게 만들어야 함
// 처음: 완탐 후 구현 -> 개선: 순회하면서 최적값 도출

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int N = problems.length;
        int maxAlp = Integer.MIN_VALUE;
        int maxCop = Integer.MIN_VALUE;
        
        for(int i=0;i<N;i++) {
            maxAlp = Math.max(maxAlp,problems[i][0]);
            maxCop = Math.max(maxCop,problems[i][1]);
        }
        
        // 시작점부터 이미 목표치를 초과할 수도 있으니까 방지하기
        alp = Math.min(alp,maxAlp);  
        cop = Math.min(cop,maxCop);
        
        int[][] dp = new int[maxAlp+1][maxCop+1];
        
        for(int a=alp;a<=maxAlp;a++) {
            for(int c=cop;c<=maxCop;c++) {
                dp[a][c] = Integer.MAX_VALUE;
            }
        }
        
        for(int a=alp;a<=maxAlp;a++) {
            for(int c=cop;c<=maxCop;c++) {
                if (a==alp && c==cop) {
                  dp[a][c] = 0;  
                } else if (a != alp && c != cop) {
                    dp[a][c] = Math.min(dp[a][c],Math.min(dp[a-1][c],dp[a][c-1])+1);
                } else if (a == alp) {
                    dp[a][c] = Math.min(dp[a][c],dp[a][c-1]+1);  // 최단값 보장
                } else if (c == cop) {
                    dp[a][c] = Math.min(dp[a][c],dp[a-1][c]+1);
                }
                for(int i=0;i<N;i++) {
                    int nextA = Math.min(a+problems[i][2],maxAlp);  // 다음 애가 max넘어도 결국 만족하는거니까 넣어도 됨
                    int nextC = Math.min(c+problems[i][3],maxCop);
                    if(a>=problems[i][0] && c>=problems[i][1]) {
                        // 완탐 후 문제 풀이 최적화
                        dp[nextA][nextC]= Math.min(dp[nextA][nextC],dp[a][c]+problems[i][4]);
                    }
                }
            }
        }
      
        // for(int a=alp;a<=maxAlp;a++) {
        //     for(int c=cop;c<=maxCop;c++) {
        //         System.out.print(dp[a][c]+" ");
        //     }
        //     System.out.println();
        // }
        
        return dp[maxAlp][maxCop];
    }
}
