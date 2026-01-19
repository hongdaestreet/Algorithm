// https://www.acmicpc.net/problem/1735
// 소요시간: 18M
// 1. 입력값이 기약분수가 아닐 수 있다는 점을 간과함 2. 합산값이 기약분수가 아닐 수도

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int A1 = Integer.parseInt(st1.nextToken());
		int B1 = Integer.parseInt(st1.nextToken());
		int gcd1 = GCD(A1, B1); // 입력값 기약분수화
		A1 /= gcd1;
		B1 /= gcd1;
//		System.out.println(A1 + " " + B1);

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int A2 = Integer.parseInt(st2.nextToken());
		int B2 = Integer.parseInt(st2.nextToken());
		int gcd2 = GCD(A2, B2);
		A2 /= gcd2;
		B2 /= gcd2;
//		System.out.println(A2 + " " + B2);

		int B = LCM(B1, B2);

		A1 *= (B / B1);
		A2 *= (B / B2);

		int A = A1 + A2;

		int gcd = GCD(A, B);
		A /= gcd;
		B /= gcd;

		System.out.println(A + " " + B);

	}

	static int LCM(int x, int y) {
		return (x * y) / GCD(x, y);
	}

	static int GCD(int x, int y) {

		int s = Math.min(x, y);
		int ans = 1;
		for (int i = 2; i <= s; i++) {
			if (x % i == 0 && y % i == 0) {
				ans *= i;
				x /= i;
				y /= i;
				s /= i;
				i--;
			}
		}

		return ans;
	}

}
