// https://school.programmers.co.kr/learn/courses/30/lessons/87694?language=java
// 소요시간: 1H30M
// 1. ㄷ자에서 경로 따라가야할땐 2배로 해서 뛰어넘기 방지해야 함 2. map이랑 dist는 따로 구분하는게 좋음

import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int goalX;
    static int goalY;
    
    
    public int solution(int[][] rectangle, int charX, int charY, int itemX, int itemY) {
        int answer = 0;
        map = new int[102][102];
        visited = new boolean[102][102];
        int beginX = charX*2;
        int beginY = charY*2;
        goalX = itemX*2;
        goalY = itemY*2;
        
        int N = rectangle.length; // 사각형 개수
        // 일단 직사각형으로 채우기
        for(int i=0;i<N;i++) {
            int startX = rectangle[i][0]*2;
            int startY = rectangle[i][1]*2;
            int endX = rectangle[i][2]*2;
            int endY = rectangle[i][3]*2;
            for(int r=startX;r<=endX;r++){
                for(int c=startY;c<=endY;c++){
                    map[r][c] = 1;
                }
            }
        }
        
        // 안의 공간 비우기
        for(int i=0;i<N;i++) {
            int startX = rectangle[i][0]*2;
            int startY = rectangle[i][1]*2;
            int endX = rectangle[i][2]*2;
            int endY = rectangle[i][3]*2;
            for(int r=startX+1;r<=endX-1;r++){
                for(int c=startY+1;c<=endY-1;c++){
                    map[r][c] = 0;
                }
            }
        }
        
        // for(int i=0;i<102;i++){
        //     for(int j=0;j<102;j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        
        
        
        return BFS(beginX,beginY);
    }
    
    static int BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        visited[r][c] = true;
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];
            for(int n=0;n<4;n++) {
                int nr = currR+dr[n];
                int nc = currC+dc[n];
                if(check(nr,nc)){
                    map[nr][nc] = Math.max(map[currR][currC]+1,map[nr][nc]);
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc] = true;
                    if (nr==goalX && nc==goalY)
                        return (map[nr][nc]-1)/2;
                }
            }
        }
        return -1;
    }
    
    static boolean check(int r, int c) {
        if (r<0||r>101||c<0||c>101||map[r][c]<=0||visited[r][c])
            return false;
        return true;
    }
    
    
}
