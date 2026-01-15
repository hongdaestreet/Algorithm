// https://www.acmicpc.net/problem/5622
// 소요시간: 17M
// 1.문제 이해하는데 15분 정보 쓴 듯.. 책 많이 읽자.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char[] dials = input.toCharArray();

		int times = 0;
		char[] call = { 'C', 'F', 'I', 'L', 'O', 'S', 'V', 'Z' };

		for (int i = 0; i < dials.length; i++) {
			int time = 2;
			for (int j = 0; j < call.length; j++) {
				time++;
				if (dials[i] <= call[j]) {
					break;
				}
			}
			times += time;
		}

		System.out.println(times);
	}

}
