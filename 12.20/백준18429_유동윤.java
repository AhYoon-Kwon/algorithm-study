package BaekJoon;

import java.util.Scanner;

public class 백준18310_유동윤 {

	static int N, K;
	static int[] kit, visit;
	static int result, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		kit = new int[N];
		visit = new int[N];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			kit[i] = sc.nextInt();
		}
		select(0, 500);
		System.out.println(cnt);
	}// main

	static void select(int dept, int sum) {
		if (dept >= N) {
			cnt++;
			return;
		}
		if (sum < 500) {
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i] == 1) {
				continue;
			} else {
				visit[i] = 1;
				select(dept + 1, sum + kit[i] - K);
				visit[i] = 0;
			}
		}
	}
}
