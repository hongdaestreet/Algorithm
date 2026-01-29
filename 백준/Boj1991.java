// https://www.acmicpc.net/problem/1991
// 소요시간: 95M / GPT도움(후위 파트)
// 1.변수관리가 중요한 문제였음 2.로직에 따른 자료구조를 적절히 사용하자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] tree;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int[N][3];  // 부모 왼 오
		tree[0][0] = -1;
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = st.nextToken().charAt(0) - 'A';
			int left = st.nextToken().charAt(0);
			int right = st.nextToken().charAt(0);
			if (left < 'A' || left > 'Z') { // 알파벳 아니면 -1 처리
				left = -1;
			} else {
				left -= 'A';
				tree[left][0] = parent; // 부모
			}
			if (right < 'A' || right > 'Z') { // 알파벳 아니면 -1 처리
				right = -1;
			} else {
				right -= 'A';
				tree[right][0] = parent; // 부모
			}
			
			tree[parent][1] = left;
			tree[parent][2] = right;
		}
		
		preorder();
		inorder();
		postorder();
		
		System.out.println(sb);
	}
	
	// 전위 - 중왼오
	static void preorder() {
		Stack<Integer> s1 = new Stack<>();
		boolean[] visited1 = new boolean[N];
		s1.add(0);  // 'A'부터 시작
		visited1[0] = true;
		
		while (!s1.isEmpty()) {
			int cur = s1.pop();
			sb.append((char)(cur + 'A'));
			if (tree[cur][2]>=0 && !visited1[tree[cur][2]]) {  // 오른쪽 부터 넣기
				s1.add(tree[cur][2]);
				visited1[tree[cur][2]] = true;
			}
			if (tree[cur][1]>=0 && !visited1[tree[cur][1]]) {
				s1.add(tree[cur][1]);
				visited1[tree[cur][1]] = true;
			}
		}
		sb.append('\n');
	}

	// 중위 - 왼중오
	static void inorder() {
		Stack<Integer> s2 = new Stack<>();
		boolean[] visited2 = new boolean[N];
		s2.add(0);
		visited2[0] = true;
		int cur2 = 0;  // 현재 위치
		while(!s2.isEmpty()) {
			if (tree[cur2][1]>=0 && !visited2[tree[cur2][1]]) {  // 왼쪽부터 다 넣는다
				s2.add(tree[cur2][1]);
				visited2[tree[cur2][1]] = true;
				cur2 = tree[cur2][1];  // 왼쪽 자식으로 이동
			} else {  // 왼쪽 가는거 끝나면
				cur2 = s2.pop();  // 왼쪽 끝부터 꺼내
				sb.append((char)(cur2+'A'));
				if (tree[cur2][2]>=0 && !visited2[tree[cur2][2]]) {  // 오른쪽 자식이 있다면 넣기
					s2.add(tree[cur2][2]);
					visited2[tree[cur2][2]] = true;
					cur2 = tree[cur2][2];  // 오른쪽 자식으로 이동
				}
			}
		}
		sb.append('\n');
	}

	// 후위 - 왼오중  ```GPT```
	static void postorder() {
		Stack<Integer> s3 = new Stack<>();
		int cur = 0;  // 현재 내려가는 노드
		int last = -1;  // 마지막으로 출력한 노드
		
		while (cur != -1 || !s3.isEmpty()) {
			// 1. 왼쪽 끝까지 내려가기
			if (cur != -1) {
				s3.push(cur);
				cur = tree[cur][1];  // 왼쪽 자식으로 이동
			} 
			// 2. 왼쪽으로 못가면 top 기즌으로 오른쪽으로 가거나 출력 결정
			else {
				int peek = s3.peek();  // 현재 노드 (끄트머리)
				int right = tree[peek][2];  // 오른쪽 자식 시도
				if (right != -1 && last != right) {  // 처리하지 않으면 오른쪽 존재 시
					cur = right;  // 오른쪽으로 이동
				}
				// 오른쪽이 없거나 이미 오른쪽을 처리했으면 출력
				else {
					sb.append((char)(peek+'A'));
					last = s3.pop();
				}
			}
			
		}
		
	}
	

}
