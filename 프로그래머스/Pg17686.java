// https://school.programmers.co.kr/learn/courses/30/lessons/17686
// 40M / AI(hint)
// 1.String은 주소 직접 비교하는게 아니라 equals로 객체 비교해야 함

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // String[] answer = {};
        int N = files.length;
        HashMap<String,Integer> map = new HashMap<>();
        int idx = 0;
        for (int i=0;i<N;i++) {
            map.put(files[i],idx++);
        }
        
        Arrays.sort(files, (a,b) -> {
           if (!convertSmall(a).equals(convertSmall(b))) {
               return convertSmall(a).compareTo(convertSmall(b));
           } else if (getNumber(a) != getNumber(b)) {
               return getNumber(a) - getNumber(b);
           } else {
               return map.get(a) - map.get(b);
           }
        });
        
        return files;
    }
    
    
    static String convertSmall(String file) {
        
        char[] ch = file.toCharArray();
        int idx = 0;
        for (int i=0;i<ch.length;i++) {
            if (ch[i]>='0' && ch[i]<='9') {
                break;
            }
            idx++;
        }
        char[] head = file.substring(0,idx).toCharArray();
        for (int i=0;i<head.length;i++) {
            if (head[i]>='A' && head[i]<='Z') {
                head[i] -= ('A'-'a');
            }
        }
        
        return String.valueOf(head);
    }
    
    static int getNumber(String file) {
        char[] ch = file.toCharArray();
        boolean start = false;
        String strnum = "";
        for (int i=0;i<ch.length;i++) {
            if (ch[i]<'0' || ch[i]>'9') {
                if (start) {
                    break;
                }
                continue;
            } else {
                start = true;
                strnum += ch[i];
            }
        }
        return Integer.parseInt(strnum);
    }
    
}
