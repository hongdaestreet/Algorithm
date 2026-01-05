// https://www.acmicpc.net/problem/11478
// 3트 / 소요시간: 15M
// 1. String을 Set에 넣으면 중복제거 처리가 된다. 2. StringBuilder 저극적으로 이용하자.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int length = input.length;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < length; i++) {
			int start = i;
			StringBuilder sb = new StringBuilder();
			while (start < length) {
				sb.append(input[start++]);
				set.add(sb.toString());
			}
		}
		System.out.println(set.size());
	}

}
