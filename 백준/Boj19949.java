// https://www.acmicpc.net/problem/19949
// 소요시간: 23M / 
// 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count;
	static int[] answer;
	static int[] predict;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = new int[10];
		for(int i=0;i<10;i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		
		count = 0;
		
		predict = new int[10];
		
		guess(0,0);
		
		System.out.println(count);
	}
	
	
	static void guess(int depth,int correct) {  // depth: 문제 수, correct: 맞춘 수
		if (correct + (10 - depth)<5) {
			return;
		}
		
		if(depth==10) {
			if (correct >= 5) {
				count++;
			}
			return;
		}
		
		for(int i=1;i<=5;i++) {
			if (depth>=2 && i == predict[depth-1] && (predict[depth-1] == predict[depth-2])) {
				continue;
			}
			predict[depth] = i;
			guess(depth+1, correct+(i==answer[depth] ? 1 : 0));
			
		}
		
		
		return;
	}

}
