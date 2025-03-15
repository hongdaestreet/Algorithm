import java.util.Arrays;

class UserSolution {
	static Player[][] leagues;
	static int league;
	static int playerL;
	
	class Player implements Comparable<Player> {
		private int id;
		private int ability;
		
		Player(int id,int ability){
			this.id = id;
			this.ability = ability;
		}
		
		
		@Override
		public int compareTo(Player other) {
			if (this.ability != other.ability) {
				return other.ability - this.ability;  // 높은 애들 먼저
			}
			return this.id-other.id;  // 낮은 애들 먼저
		}
		
		
	}
	
    void init(int N, int L, int mAbility[]) {
    	int players = N;
    	league = L;
    	playerL = N/L;
    	
    	leagues = new Player[league][playerL];
    	int idx = 0;
    	for(int i=0;i<league;i++) {
    		for(int j=0;j<playerL;j++) {
    			leagues[i][j] = new Player(idx,mAbility[idx]);
    			idx++;
    		}
    	}
    	
    	sortAll();
    	
    	
    }
    
    void sortAll() {
    	for(int i=0;i<league;i++) {
    		Arrays.sort(leagues[i]);
    	}
    }

    int move() {
    	int sumId = 0;
    	for(int i=1;i<league;i++) {
    		Player lowTop = leagues[i][0];
    		Player highBottom = leagues[i-1][playerL-1];
    		
    		leagues[i-1][playerL-1] = lowTop;
    		leagues[i][0] = highBottom;
    		
    		sumId += (lowTop.id + highBottom.id);
    	}
    	sortAll();
    	
        return sumId;
    }

    int trade() {
    	int sumId = 0;
    	
    	for(int i=1;i<league;i++) {
    		Player lowTop = leagues[i][0];
    		Player highMid = leagues[i-1][(playerL+1)/2-1];
    		
    		leagues[i][0] = highMid;
    		leagues[i-1][(playerL+1)/2-1] = lowTop;
    		
    		sumId += (lowTop.id+highMid.id);
    	}
    	
    	sortAll();
        return sumId;
    }

}