// https://www.acmicpc.net/problem/1934

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			long ans = ((long)A) * B / gcd(A, B);
			System.out.println(ans);
		}

	}
	
	static long gcd(long a, long b) {
		if (a < b) {
			long temp = a;
			a = b;
			b = temp;
		}

		if (a % b == 0) {
			return b;
		} else {
			return gcd(b, a % b);
		}

	}
	
}
