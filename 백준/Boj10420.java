// https://www.acmicpc.net/problem/10420

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int year;
	static int month;
	static int day;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		N--;
		year = 2014;
		month = 4;
		day = 2;

		for (int n = 0; n < N; n++) {
			if (++day > monthDay()) {
				month++;
				if (month > 12) {
					year++;
					month = 1;
				}
				day = 1;
			}

		}

//		366 + 365
		System.out.println(String.format("%04d-%02d-%02d", year, month, day));
	}

	static int monthDay() {
		if (month == 2) {
			if ((year % 100 != 0) && (year % 4 == 0)) {
				return 29;
			} else {
				return 28;
			}
		} else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
			return 30;
		} else {
			return 31;
		}
	}

}
