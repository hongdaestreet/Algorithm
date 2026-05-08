// https://school.programmers.co.kr/learn/courses/30/lessons/42577#
// 39M / AI(Support)
// 1.접두어 == 문장 앞 단어 2.일반 정렬->사전 순 정렬 3.사전 순으로 정렬하면 바로 뒤만 확인하면 됨


import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);  // 사전순 정렬 ex. "12", "123", "1234"
        
        int N = phone_book.length;
        
        for(int i=0;i<N-1;i++) {
            String curr = phone_book[i];
            String next = phone_book[i+1]; // 사전 순 정렬이니까 바로 뒤만 확인하면 됨
            boolean same = true;
            for(int j = 0; j < curr.length();j++) {
                if (curr.charAt(j) != next.charAt(j)) {
                    same = false;
                    break;
                }            
            }
            if (same) {
                return false;
            }            

        }
        
        
        return true;
    }
}
