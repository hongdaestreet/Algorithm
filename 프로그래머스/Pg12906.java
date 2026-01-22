// https://school.programmers.co.kr/learn/courses/30/lessons/12906

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int pre = -1;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0;i<arr.length;i++){
            if (pre != arr[i]) {
                list.add(arr[i]);    
            }
            pre = arr[i];
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
