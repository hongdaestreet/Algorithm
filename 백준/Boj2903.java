// https://www.acmicpc.net/problem/2903

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ad = 1;
		for(int i=0;i<N;i++) {
			ad *= 2;
		}

		int len = (ad+1)*(ad+1);
		System.out.println(len);
	}

}
