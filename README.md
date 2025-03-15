# Algorithm

## 삼성 B형 대비 문제
Solution, UserSolution으로 나누어져있음. UserSolution으로 구현해야 함.


## 25.03.15 B형 시험 후기
### 시간대에 따른 사원 음악청취자 count하는 문제<br><br>

- method<br>
    - init(int 실행시간) : 초기 method, 실행시간 제공해줌 <br>
    - add(int mID, int 출근시간, int 퇴근시간) : 사번이 mID인 사원의 출근시간,퇴근시간 <br>
    - remove(int mID) : 사번이 mID인 사원 삭제<br>
    - count(int 시작시각) : 시작시각부터 종료시각까지 회사에 있는 사원 수 count<br>

### 나의 풀이
출근시간, 퇴근시간에 대한 HashMap 각각 사용. <사번,출/퇴근시간> 쌍으로 사용<br>
테스트 케이스는 다 맞음. But 실행시간이 오래 걸림.<br>
list<Hashmap>을 정렬하는 방법을 알고 싶었지만 comparator 사용할 줄 몰라 실패 (사실 HashMap<HashMap,HashMap>정렬하고 싶었음)<br>
결국 iDs라는 list<Integer> 배열 선언 -> 순서 지정해줌 (출근 오름차순,2번째 comparator는 퇴근 내림차순)<br>
binarysearch 시도했지만 능력 부족으로 실패...

### 후기
생각보다 쉬웠음.<br>
테스트케이스 통과는 40분 컷 냄<br>
근데 시간초과 뜸. 아마도 정렬을 통해 인정되지 않는 출근시간 넘어가면 break해야하는데 안해서 시간초과 뜬 뜻<br>
**자료구조** 공부하면 충분히 승산있을거라고 보임<br>
공부해야 할 것 : HashMap, HashSet, Comparator, sort, ArrayList 정렬방법 등
