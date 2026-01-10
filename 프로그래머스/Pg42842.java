// https://school.programmers.co.kr/learn/courses/30/lessons/42842

class Solution {
    public int[] solution(int B, int Y) {
        int RC = B+Y;
        int RCPlus = (B+4)/2;  // R+C
        int RCMinus = (int) Math.sqrt(RCPlus*RCPlus - 4*RC);  // R-C
        int R = (RCPlus+RCMinus)/2;
        int C = (RCPlus-RCMinus)/2;
        
        int[] answer = new int[]{R,C};
        return answer;
    }
}
