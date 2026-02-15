// https://www.acmicpc.net/problem/1431
// 소요시간: 17M /
// 1. 정렬 쭉가보자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] serial = new String[N];
		for (int i = 0; i < N; i++) {
			serial[i] = br.readLine();
		}

		Arrays.sort(serial, (a, b) -> {
			if (a.length() != b.length()) //
				return a.length() - b.length(); // 길이 오름차순

			int asum = 0;
			int bsum = 0;
			for (int i = 0; i < a.length(); i++) { // 숫자 합 오룸처슌
				int ch = a.charAt(i);
				if (ch <= '9' && ch >= '0')
					asum += (ch - '0');
			}
			for (int i = 0; i < b.length(); i++) {
				int ch = b.charAt(i);
				if (ch <= '9' && ch >= '0')
					bsum += (ch - '0');
			}
			if (asum != bsum)
				return asum - bsum;

			return a.compareTo(b); // 사전 순
		});

		StringBuilder sb = new StringBuilder();
		for (String s : serial)
			sb.append(s).append("\n");

		System.out.println(sb);

	}
}
