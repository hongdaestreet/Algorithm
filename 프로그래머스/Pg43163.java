// https://school.programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        char[] begins = begin.toCharArray();
        char[] targets = target.toCharArray();
        if (begins.length != targets.length) return 0;
        int size = begins.length;
        // HashMap<String,Integer> wordMap = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        // if (!set.contains(target)) return 0;
        
        
        int len = words.length;
        boolean[] visited = new boolean[len];
        
        Queue<String> q = new LinkedList<String>();
        // for(int i=0;i<len;i++) {
        //     wordMap.put(words[i],i);
        //     int change = 0;
        //     for(int j=0;j<size;j++) {
        //         if (begins[j] != words[i][j]) {
        //             change++;
        //         }
        //     }
        //     if (change == 1) {
        //         q.offer(words[i]);
        //     }
        // }
        int depth = 0;
        q.offer(begin);
        while(!q.isEmpty()) {
            int term = q.size();
            depth++;
            for(int n=0;n<term;n++) {
                String curr = q.poll();
                for(int i=0;i<len;i++) {
                    if (visited[i]) continue;
                    int change = 0;
                    for(int j=0;j<size;j++) {
                        if (curr.charAt(j) != words[i].charAt(j)) {
                            change++;
                        }
                    }
                    if (change == 1) {
                        q.offer(words[i]);
                        visited[i] = true;
                        if (words[i].equals(target))
                            return depth;
                    }
                }
            }
        }
        
        
        return 0;
    }
}
