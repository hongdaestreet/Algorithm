// https://school.programmers.co.kr/learn/courses/30/lessons/42577#
// 30M
// 접두어 == 문장 앞 단어


import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book,(a,b) ->{
            return a.length() - b.length();
        });
        
        int N = phone_book.length;
        
        for(int i=0;i<N-1;i++) {
            String curr = phone_book[i];
            for(int j=i+1;j<N;j++) {
                for(int k=0;k<=phone_book[j].length() - curr.length();k++) {
                    boolean same = true;
                    for(int w = 0; w < curr.length();w++) {
                        if (curr.charAt(w) != phone_book[j].charAt(w+k)) {
                            same = false;
                            break;
                        }
                    }
                    if (same) {
                        return false;
                    }
                    
                    // if (curr.equals(phone_book[j].substring(k,k+curr.length()))) {
                    //     return false;
                    // }
                }
            }
        }
        
        
        return true;
    }
}
