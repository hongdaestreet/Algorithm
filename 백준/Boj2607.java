// https://www.acmicpc.net/problem/2607 
// 소요시간: 85M / AI
// 1.문제 이해를 완벽히 하고 변수 정의하자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] org = br.readLine().toCharArray();
		int len = org.length;

		Map<Character, Integer> orgMap1 = new HashMap<>();

		for (int i = 0; i < len; i++) {
			orgMap1.put(org[i], orgMap1.getOrDefault(org[i], 0) + 1);
		}

		int answer = 0;

		loop: for (int n = 1; n < N; n++) {
			Map<Character, Integer> orgMap = new HashMap<>(orgMap1);
			String line = br.readLine();
			char[] word = line.toCharArray();
			if (word.length < len - 1 || word.length > len + 1)
				continue;

			int plus = 0; // 원본보다 더 많은 문자 개수 (원본에 없거나, 초과 사용)

			// 알파벳 순회
			for (int i = 0; i < word.length; i++) {
				char ch = word[i];
				Integer cnt = orgMap.get(ch); // 원래 단어에서 있을 때만 count 수 반환함

				if (cnt == null) { // 원본에 없는 문자 -> 초과
					plus++;
				} else if (cnt > 0) { // 원본에서 사용 가능
					orgMap.put(ch, cnt - 1);
				} else { // 원본에서 이미 다 쓴 문자 -> 초과
					plus++;
				}

				if (plus > 1)
					continue loop; // 초과가 2개 이상이면 무조건 불가능
			}

			int minus = 0; // 원본에서 부족한 문자 개수 (사용되지 않은 단어 합)
			for (int v : orgMap.values()) {
				minus += v;
				if (minus > 1)
					continue loop; // 부족이 2개 이상이면 무조건 불가능
			}

			if (word.length == len) {
				if (!((plus == 0 && minus == 0) || (plus == 1 && minus == 1)))
					continue;
			} else if (word.length == len + 1) {
				if (!(plus == 1 && minus == 0))
					continue;
			} else {
				if (!(plus == 0 && minus == 1))
					continue;
			}

			answer++;

		}

		System.out.println(answer);
	}
}
