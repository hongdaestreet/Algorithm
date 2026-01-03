// https://www.acmicpc.net/problem/25501

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String word = br.readLine();
			char[] arr = word.toCharArray();
			int[] ans = isPalindrome(arr, 0);
			System.out.println(ans[0] + " " + ans[1]);
		}

	}

	static int[] isPalindrome(char[] s, int cnt) {
		return recursion(s, 0, s.length - 1, cnt);
	}

	static int[] recursion(char[] s, int l, int r, int cnt) {
		cnt++;
		if (l >= r)
			return new int[] { 1, cnt };
		else if (s[l] != s[r])
			return new int[] { 0, cnt };
		else
			return recursion(s, l + 1, r - 1, cnt);
	}

}
