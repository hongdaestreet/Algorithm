// http://acmicpc.net/problem/20920
// 소요시간: 68M / AI(정렬파트)
// 1.Arrays 정렬할 때에는 default가 내림차순으로 가는거임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String word = br.readLine();
			if (word.length()<M)  // 길이 짧으면 제외
				continue;
			if (map.containsKey(word)) {
				map.put(word,map.get(word)+1);
			}else {
				map.put(word,1);
			}
		}
		
		int len = map.size();
		String[] words = new String[len];
		int idx = 0;
		for(String s: map.keySet()) {
			words[idx++] = s;
		}
		
		// 정렬하기
		
		Arrays.sort(words, (a,b) -> {
			int fa = map.get(a), fb = map.get(b);  // 각 단어에 대한 빈도
			if (fa != fb)  // 빈도가 같으면 다음으로 보냄
				return fb - fa;  // 내림차순 정렬
			if (a.length() != b.length())  // 단어 길이
				return b.length() - a.length();
			return a.compareTo(b);  // 알파벳 순서 정렬
		});
		StringBuilder sb = new StringBuilder();
		idx = 0;
		for(int i=0;i<len;i++) {
			sb.append(words[i]).append("\n");
		}
		System.out.println(sb);
		
	}

}
