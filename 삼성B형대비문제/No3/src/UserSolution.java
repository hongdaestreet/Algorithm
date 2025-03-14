import java.util.Arrays;

class UserSolution {
    // 각 id와 능력치가 있는 Player 클래스 생성
    class Player implements Comparable<Player> {
        int id;
        int ability;
        
        Player(int id, int ability) {
            this.id = id;
            this.ability = ability;
        }
        
        // 성적 기준 내림차순으로 정렬 (높은 성적->상위 리그) + 같으면 낮은 ID가 앞에 오게 함
        @Override
        public int compareTo(Player other) {
            if (this.ability != other.ability) {
                return other.ability - this.ability; // 성적 내림차순
            }
            return this.id - other.id; // 낮은 ID 먼저
        }
    }
    
    // 리그 수X리그 내 선수 인 leagues 배열 생성
    private Player[][] leagues;
    private int numLeagues;     // 리그 수
    private int playersPerLeague; // 리그 내 선수
    
    // 초기설정 method
    void init(int N, int L, int mAbility[]) {
        numLeagues = L;
        playersPerLeague = N / L;
        leagues = new Player[numLeagues][playersPerLeague];
        
        int playerIdx = 0;  // 선수 ID
        // 각 선수마다 Player 클래스 생성함
        for (int leagueId = 0; leagueId < numLeagues; leagueId++) {
            for (int pos = 0; pos < playersPerLeague; pos++) {
                leagues[leagueId][pos] = new Player(playerIdx, mAbility[playerIdx]);
                playerIdx++; // ID는 초기 순서로 지정
            }
        }

        // 성적 순 정렬
        sortAllLeagues();
    }
    
    // Sort all leagues - each league's players are sorted by ability (higher first)
    
    // 각 리그마다 정렬
    private void sortAllLeagues() {
        for (int i = 0; i < numLeagues; i++) {
            Arrays.sort(leagues[i]);
        }
    }
    
    // 상위팀 꼴등<->하위팀 1등
    int move() {
        int sumMovedIds = 0;  // 이동한 선수 ID 합 기록용
        
        // 2번째 팀 1등부터 바꾸니 index는 1부터 진행
        for (int i = 1; i < numLeagues; i++) {
        	// 하위팀 1등
        	Player bestFromLower = leagues[i][0];
        	// 상위팀 꼴등
            Player worstFromUpper = leagues[i-1][playersPerLeague-1];
            
            // Swap
            leagues[i][0] = worstFromUpper;
            leagues[i-1][playersPerLeague-1] = bestFromLower;
            
            // ID 누적합
            sumMovedIds += bestFromLower.id + worstFromUpper.id;
        }
        
        // 다 끝나면 성적 순 정렬
        sortAllLeagues();
        
        return sumMovedIds;
    }
    
    // 상위팀 중간<->하위팀 1등
    int trade() {
        int sumMovedIds = 0;  // 이동한 선수 ID 합 기록용
        
        // 2번째 팀 1등부터 바꾸니 index는 1부터 진행
        for (int i = 1; i < numLeagues; i++) {
        	// 하위팀 1등
            Player bestFromLower = leagues[i][0];
            // 상위팀 중간등수 (index니까 -1해줌)
            int middleIdx = (playersPerLeague + 1) / 2 - 1;
            Player middleFromUpper = leagues[i-1][middleIdx];
            
            // Swap
            leagues[i][0] = middleFromUpper;
            leagues[i-1][middleIdx] = bestFromLower;
            
            // ID 누적합
            sumMovedIds += bestFromLower.id + middleFromUpper.id;
        }
        
        // 다 끝나면 성적 순 정렬
        sortAllLeagues();
        
        return sumMovedIds;
    }
}