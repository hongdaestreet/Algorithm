// https://school.programmers.co.kr/learn/courses/30/lessons/84021
// 4H / AI(SUPPORT)

import java.util.*;

class Solution {
    static int N;
    static int M;
    static final int[] dr = {1,-1,0,0};
    static final int[] dc = {0,0,1,-1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        N = table.length;
        M = table[0].length;
        
        List<List<int[]>> blanks = new ArrayList<>();
        List<List<int[]>> blocks = new ArrayList<>();
        
        boolean[][] boardVisited = new boolean[N][M];
        boolean[][] tableVisited = new boolean[N][M];
        
        for (int r=0;r<N;r++) {
            for (int c=0;c<M;c++) {
                if (table[r][c] == 1 && !tableVisited[r][c]) {
                    blocks.add(BFS(table,tableVisited,r,c,1));
                }
                if (game_board[r][c] == 0 && !boardVisited[r][c]) {
                    blanks.add(BFS(game_board, boardVisited,r,c,0));
                }
            }
        }
        
        boolean[] used = new boolean[blocks.size()];
        
        for (List<int[]> blank : blanks) {
            for(int i=0;i<blocks.size();i++) {
                if (used[i]) continue;
                
                List<int[]> block = blocks.get(i);
                if (blank.size() != block.size()) continue;
                
                if (canMatch(blank,block)) {
                    used[i] = true;
                    answer += block.size();
                    break;  // 다음 blank로 이동
                }
            }
        } 
        
        return answer;
    }
    
    // target: 1 - block, 0 - blank
    static List<int[]> BFS(int[][] board, boolean[][] visited, int sr, int sc, int target) {
        List<int[]> shape = new ArrayList<>();
        
        Queue<int[]> q = new ArrayDeque<>();
        
        visited[sr][sc] = true;
        q.offer(new int[]{sr,sc});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            shape.add(new int[]{r,c});
            
            for(int i=0;i<4;i++) {
                int nr = r+dr[i];
                int nc = c+dc[i];
                
                if (!check(nr,nc) || visited[nr][nc] || board[nr][nc] != target) continue;
                
                visited[nr][nc] = true;
                q.offer(new int[]{nr,nc});
            }
        }
        
        return normalize(shape);
    }
    

    static boolean check(int r,int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    
    
    // 90도 회전 경우의 수 포함해서 같은지 비교
    static boolean canMatch(List<int[]> blank, List<int[]> block) {
        List<int[]> curBlock = block;
        
        for(int i=0;i<4;i++) {
            if (same(blank,curBlock)) {
                return true;
            }
            
            curBlock = rotate(curBlock);
        }
        return false;
    }
    
    
    // 90도 회전
    static List<int[]> rotate(List<int[]> block) {
        List<int[]> block90 = new ArrayList<>();
        
        for (int[] b : block) {
            int r = b[0];
            int c = b[1];
            block90.add(new int[]{c,-r});
        }
        
        return normalize(block90);
    }
    
    // 왼쪽 최상단 기준으로 정규화 진행
    static List<int[]> normalize(List<int[]> org) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        
        for(int[] p: org) {
            minR = Math.min(minR,p[0]);
            minC = Math.min(minC,p[1]);
        }
        
        List<int[]> normal = new ArrayList<>();
        
        for(int[] p: org) {
            normal.add(new int[]{p[0]-minR,p[1]-minC});
        }
        
        normal.sort((a,b)->{
            if (a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        return normal;
    }
    
    // 두 도형 같은지 비교
    static boolean same(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;
        
        for (int i=0;i<a.size();i++) {
            if (a.get(i)[0] != b.get(i)[0]) return false;
            if (a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }

    
    
}
