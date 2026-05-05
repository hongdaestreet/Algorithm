// https://school.programmers.co.kr/learn/courses/30/lessons/42885
// 40M / AI(Support)
// 1.2개합을 비교할 때에는 two-pointer sum사용

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        Arrays.sort(people);

        int N = people.length;

        int left = 0;
        int right = N-1;

        if (left == right) 
            return 1;

        while (left<=right) {
            if (people[right]+people[left]<=limit) {
                left++;
            }
            right--;
            boat++;
        }



        return boat;
    }


}
