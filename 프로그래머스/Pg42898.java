// https://school.programmers.co.kr/learn/courses/30/lessons/42898
// 28M / AI(SUPPORT)
// 1.초기설정도 주의하면서 설정하자

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] graph = new int[m][n];
        for(int i=0;i<puddles.length;i++) {
            graph[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }
        graph[0][0] = 1;
        for(int i=1;i<Math.max(m,n);i++) {
            if (i<m && graph[i][0] == 0) { // 초기 설정을 잘못함.
                graph[i][0] += Math.max(graph[i-1][0],0);
            }
            if (i<n && graph[0][i] == 0) {
                graph[0][i] += Math.max(graph[0][i-1],0);
            }
        }
        
        for(int i=1;i<m;i++) {
            // System.out.println();
            for(int j=1;j<n;j++) {
                if (graph[i][j] == -1) {
                    // System.out.print(graph[i][j]+" ");
                    continue;
                }
                graph[i][j] = (Math.max(graph[i-1][j],0) + Math.max(graph[i][j-1],0))%1_000_000_007;
                // System.out.print(graph[i][j]+" ");
            }
        }
        
        return graph[m-1][n-1];
    }
}
