// https://www.acmicpc.net/problem/20125
// 소요시간: 29M / 
// 1. 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] graph = new char[N][N];
		int leftArm =0;
		int rightArm =0;
		int waist = 0;
		int leftLeg = 0;
		int rightLeg = 0;
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				graph[i][j] = line.charAt(j);
			}
		}
		int headR = -1;
		int headC = -1;

		loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == '*') {
					headR = i;
					headC = j;
					break loop;
				}
			}
		}

		int heartR = headR+1;
		int heartC = headC;
		
		int r = heartR;
		int c = heartC;
		// 왼팔
		while (true) {
			c--;
			if (c>=0 && graph[r][c] == '*') {
				leftArm++;
			} else {
				break;
			}
		}
		c = heartC;
		// 오른팔
		while (true) {
			c++;
			if (c<N && graph[r][c] == '*') {
				rightArm++;
			} else {
				break;
			}
		}
		c = heartC;
		r++;
		//허리
		while (true) {
			if (r<N && graph[r][c] == '*') {
				waist++;
				r++;
			} else {
				break;
			}
		}
		int centerR = r-1;
		int centerC = c;
		r = centerR+1;
		c = centerC-1;
		// 왼다리
		while (true) {
			if (r<N && graph[r][c] == '*') {
				leftLeg++;
				r++;
			} else {
				break;
			}
		}

		r = centerR+1;
		c = centerC+1;
		// 오른다리
		while (true) {
			if (r<N && graph[r][c] == '*') {
				rightLeg++;
				r++;
			} else {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(heartR+1).append(" ").append(heartC+1).append("\n")
		.append(leftArm).append(" ")
		.append(rightArm).append(" ")
		.append(waist).append(" ")
		.append(leftLeg).append(" ")
		.append(rightLeg);
		
		System.out.println(sb);

	}

}
