// 재귀를 통해 1 발견시 
package Gold;

import java.util.Scanner;

public class 백준17136_박예인 {
	static int[][] map = new int[10][10];
	static int result = 30;
	static int[] paper = { 0, 5, 5, 5, 5, 5 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 종이 입력
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
			}
		} // endOfMap

		dfs(0, 0, 0);

		// result 초기화 (색종이 수 25개니까 26개 이상이면 넉넉할 듯)

		if (result == 30) {
			System.out.println(-1);
		} else
			System.out.println(result);

	}// endOfMain

	// dfs + 백트래킹으로 풀어보자
	static void dfs(int x, int y, int cnt) {
		// 이미 result 보다 크면 시간낭비
		if (result <= cnt) {
			return;
		}

		// 종이의 끝에 다다랐을 경우 result랑 cnt 비교
		if (x >= 9 && y > 9) {
			result = Math.min(result, cnt);
			return;
		}

		// 가로로 쭉 훑을 건데 만약 가로의 끝에 도달한다면 다음 줄로 간다
		if (y > 9) {
			dfs(x + 1, 0, cnt);
			return;
		}
		// 본격 색종이 붙이기
		// 이 부분부터 거의 참고했다... ㅜㅜ... 두세 번 다시 써봐서 다음에는 꼭 내가 생각해내야지

		if (map[x][y] == 1) {
			// 큰 색종이부터 준비
			for (int i = 5; i > 0; i--) {
				if (paper[i] > 0 && check(x, y, i)) {
					// 색종이 붙임
					putorputoff(x, y, i, 0);
					// 붙인 색종이 갯수만큼 빼주기
					paper[i]--;
					// 다음으로 기기~
					dfs(x, y + 1, cnt + 1);
					// 색종이 떼주기
					putorputoff(x, y, i, 1);
					// 색종이 갯수 원상복구
					paper[i]++;
				}
			}

		} else
			dfs(x, y + 1, cnt);

	}// endOfDfs

	// 색종이를 붙이고 뗄 때 사용
	// state가 1일 경우 원상복귀
	// state가 0일 경우 색종이를 붙여서 거기는 이제 못 붙인다는 뜻
	public static void putorputoff(int x, int y, int size, int state) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = state;
			}
		}
	}

	// 색종이의 크기만큼 확인할 거예용
	public static boolean check(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				// 범위 밖이거나 1이 아니면 false
				if (i < 0 || i >= 10 || j < 0 || j >= 10 || map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}// endOfCheck
}// endOfClass

// 아이디어 생각까지 오래 걸렸다 
// 1이 되는 범위를 찾아서 nxn일 경우 붙인다만 생각했는데 
// 그냥 색종이 큰거부터 가져다 대면 더 간단함
