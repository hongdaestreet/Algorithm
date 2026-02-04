// https://www.acmicpc.net/problem/1515
// 소요시간: 58M / GPT
// 1.빡구현으로 가야 함 2.3000자리라서 빡구현해도 무관함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] target = br.readLine().toCharArray();
		int idx = 0;  // 타겟의 길이
		int n = 0;  // 커지는 수
		
		while(idx<target.length) {
			n++;
			String s = Integer.toString(n);
			for(int i=0;i<s.length() && idx < target.length;i++) {
				if (s.charAt(i) == target[idx])
					idx++;
			}
		}
		System.out.println(n);
		
	}

}
