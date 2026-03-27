// 다음문제: 
// https://www.acmicpc.net/problem/2512
// 소요시간: 90M /AI
// 1.이분탐색 시 조건 범위 설정 제대로 해야함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;          // 지방의 수
    static int[] cost;     // 각 지방의 예산 요청액
    static int M;          // 국가 총 예산

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 지방의 수 입력
        N = Integer.parseInt(br.readLine());

        cost = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;       // 모든 요청액의 총합
        int maxRequest = 0;  // 요청액들 중 최댓값

        // 각 지방의 요청액 입력
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            total += cost[i];
            maxRequest = Math.max(maxRequest, cost[i]);
        }

        // 국가 총 예산 입력
        M = Integer.parseInt(br.readLine());

        /*
         * 만약 모든 지방의 요청을 다 더한 값(total) < 국가 총 예산 M
         * 즉, 각 지방이 요청한 금액 그대로 배정 가능 
         * -> 배정된 예산들 중 최댓값은 그냥 원래 요청액의 최댓값이다.
         */
        if (total <= M) {
            System.out.println(maxRequest);
            return;
        }

        /*
         * 이제부터는 "상한액(cap)"을 이분탐색으로 찾아야 한다.
         *
         * 상한액이란:
         * 어떤 지방의 요청액이 cap보다 크면 cap만 배정하고,
         * cap 이하이면 원래 요청액 그대로 배정하는 기준값이다.
         *
         * cap의 가능한 범위:
         * 최소 0
         * 최대 요청액의 최댓값(maxRequest)
         *
         * 예를 들어 maxRequest가 150이면
         * cap은 0~150 사이에서만 찾으면 된다.
         */
        int start = 0;
        int end = maxRequest;

        int answer = 0; // 조건을 만족하는 cap들 중 가장 큰 값을 저장할 변수

        /*
         * 이분탐색 기본 구조:
         * start <= end 동안 반복
         */
        while (start <= end) {
            int mid = (start + end) / 2; // 이번에 시험해볼 상한액(cap)

            // mid를 상한액으로 했을 때 실제 배정되는 총 예산 계산
            long allocated = 0;
            /*
             * mid를 상한액으로 했을 때 실제 배정되는 총 예산 계산
             *
             * 각 지방마다:
             * - 요청액이 mid보다 작거나 같으면 그대로 배정
             * - 요청액이 mid보다 크면 mid만 배정
             *
             * 즉, Math.min(cost[i], mid)를 더하면 된다.
             */
            
            for (int i = 0; i < N; i++) {
                allocated += Math.min(cost[i], mid);
            }

            /*
             * allocated <= M 이라는 뜻:
             * 현재 상한액 mid로 배정했더니 총 예산을 넘지 않았다.
             *
             * 즉, 이 mid는 "가능한 상한액"이다.
             * 그런데 문제는 가능한 상한액 중 "최댓값"을 구하는 것이므로,
             * 더 큰 상한액도 가능한지 오른쪽 구간을 탐색해야 한다.
             */
            if (allocated <= M) {
                answer = mid;      // 일단 현재 mid는 가능한 값이므로 저장
                start = mid + 1;   // 더 큰 상한액이 가능한지 탐색
            }
            // 상한액(mid)이 예산 초과 -> 왼쪽 구간 탬색
            else {
                end = mid - 1;
            }
        }

        // 이분탐색이 끝나면 answer에는 가능한 상한액 중 최댓값이 들어 있다.
        System.out.println(answer);
    }


}
