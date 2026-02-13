// https://www.acmicpc.net/problem/25757
// 소요시간: 11M /
// 1. sert은 String도 구분함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char type = st.nextToken().charAt(0);

		Set<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
//			mans[i] = br.readLine();
			set.add(br.readLine());
		}

//		for(String s: set) {
//			System.out.print(s+" ");
//		}
//		System.out.println();

		int size = set.size();
		int member = -1;
		if (type == 'Y') {
			member = 1;
		} else if (type == 'F') {
			member = 2;
		} else {
			member = 3;
		}

		System.out.println(size / member);

	}

}
