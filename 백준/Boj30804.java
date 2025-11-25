// https://www.acmicpc.net/problem/30804
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] fruit;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		fruit = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruit[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solve());
	}

	// 슬라이싱 윈도우
	static int solve() {
		int left = 0;  // 좌측 끝
		int ans = 0;
		int[] cnt = new int[10];
		int kind = 0;  // 종류 수

		for (int right = 0; right < N; right++) {
			int x = fruit[right];  // 최우측 성분
			if (cnt[x] == 0)
				kind++;
			cnt[x]++;
			while (kind > 2) {  // 종류 수가 초과하면 좌측을 오른쪽으로 옮기기
				int y = fruit[left];
				cnt[y]--;
				if (cnt[y] == 0) {
					kind--;
				}
				left++;
			}
			ans = Math.max(ans, right - left + 1);  // 최신화
		}
		return ans;
	}

}
