// https://www.acmicpc.net/problem/9655
// 소요시간: 8M / 
// 1. 엥?(휴리스틱하게 품) 2. 정석은 DP

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 상근 1 3 5 7
// 차영 2 4 6
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if (N%2==0) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}
		
//		boolean sk = true;
//		while(N>0) {
//			if (sk) {
//			}else {
//			}
//		}
		
		
	}

}
