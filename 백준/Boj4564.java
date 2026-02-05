// https://www.acmicpc.net/problem/4564
// 소요시간: 13M / 
// 1.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String S = br.readLine();
			if (S.charAt(0) == '0')
				break;
			System.out.print(S);
			int num = Integer.parseInt(S);
			while (num > 0) {
				char[] nums = Integer.toString(num).toCharArray();
				int cur = 1;
				for (int i = 0; i < nums.length; i++) {
					cur *= (nums[i] - '0');
				}
				if (num == cur)
					break;
				num = cur;
				System.out.print(" " + num);
			}
			System.out.println();
		}

	}

}
