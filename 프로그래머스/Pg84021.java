// https://school.programmers.co.kr/learn/courses/30/lessons/84021
// 4H / AI(SUPPORT)

import java.util.*;

class Solution {
    static int N;
    static int M;
    static List<List<int[]>> blanks;
    static List<List<int[]>> blocks;
    static boolean[][] boardVisited;
    static boolean[][] tableVisited;
    static int[] dr;
    static int[] dc;
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        N = table.length;
        M = table[0].length;
        
        blanks = new ArrayList<>();
        blocks = new ArrayList<>();
        
        dr = new int[]{1,-1,0,0};
        dc = new int[]{0,0,1,-1};
        
        boardVisited = new boolean[N][M];
        tableVisited = new boolean[N][M];
        
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if (table[i][j] == 1 && !tableVisited[i][j]) {
                    blockBFS(i,j,table);
                }
                if (game_board[i][j] == 0 && !boardVisited[i][j]) {
                    blankBFS(i,j,game_board);
                }
            }
        }
        
        boolean[] used = new boolean[blocks.size()];
        
        for (int i=0;i<blanks.size();i++) {
            List<int[]> blank = blanks.get(i);
            loop: for(int j=0;j<blocks.size();j++) {
                List<int[]> block = blocks.get(j);
                if (blank.size() != block.size() || used[j]) {
                    continue;
                }
                for (int r=0;r<4;r++) {
                    boolean valid = true;
                    for(int k=0;k<block.size();k++) {
                        if (blank.get(k)[0] != block.get(k)[0] || blank.get(k)[1] != block.get(k)[1]) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        used[j] = true;
                        answer += block.size();
                        break loop;
                    }
                    block = rotate(block);
                }

            }
        }
        
        
        return answer;
    }
    
    
    

    static boolean check(int r,int c) {
        if (r<0 || r>=N || c<0 || c>=M) {
            return false;
        }
        return true;
    }
    
    
    static void blockBFS(int r,int c, int[][] table) {
        List<int[]> block = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        
        block.add(new int[]{r,c});
        q.offer(new int[]{r,c});
        tableVisited[r][c] = true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int curR = curr[0];
            int curC = curr[1];
            
            for(int i=0;i<4;i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];
                if (!check(nr,nc)) {
                    continue;
                }
                if (table[nr][nc] == 1 && !tableVisited[nr][nc]) {
                    q.offer(new int[]{nr,nc});
                    tableVisited[nr][nc] = true;
                    block.add(new int[]{nr,nc});
                }
            }
        }
        
        List<int[]> normalBlock = new ArrayList<>(normalize(block));
        
        blocks.add(normalBlock);
        
    }
    

    static void blankBFS(int r,int c, int[][] game_board) {
        List<int[]> blank = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        
        blank.add(new int[]{r,c});
        q.offer(new int[]{r,c});
        boardVisited[r][c] = true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int curR = curr[0];
            int curC = curr[1];
            
            for(int i=0;i<4;i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];
                if (!check(nr,nc)) {
                    continue;
                }
                if (game_board[nr][nc] == 0 && !boardVisited[nr][nc]) {
                    q.offer(new int[]{nr,nc});
                    boardVisited[nr][nc] = true;
                    blank.add(new int[]{nr,nc});
                }
            }
        }
        
        List<int[]> normalBlank = new ArrayList<>(normalize(blank));
        
        blanks.add(normalBlank);
        
    }
    
    // 90도 회전
    static List<int[]> rotate(List<int[]> block) {
        int size = block.size();
        List<int[]> block90 = new ArrayList<>();
        for(int i=0;i<size;i++) {
            int curR = block.get(i)[0];
            int curC = block.get(i)[1];
            
            block90.add(new int[]{curC,-curR});
        }
        
        List<int[]> normalBlock90 = new ArrayList<>(normalize(block90));
        
        return normalBlock90;
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

    
    
}
