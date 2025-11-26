// https://www.acmicpc.net/problem/9375

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String,Integer> hs = new HashMap<>();
			
			for(int n=0;n<N;n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				if (hs.containsKey(type)) {
					int org = hs.get(type);
					hs.put(type, ++org);
//					System.out.println("기존에서 추가: "+type+" "+org);
				} else {
					hs.put(type, 2);
//					System.out.println("기존에서 추가: "+type+" "+hs.get(type));
				}
			}
			int cnt = 1;
			for(String k : hs.keySet()) {  // 모든 조합계산할 때에는 요소+1 다 곱해서 마지막에 -1
				cnt *= hs.get(k);
			}
			
			System.out.println(--cnt);
		}
		
	}


}
