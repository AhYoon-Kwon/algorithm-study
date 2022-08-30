// ��͸� ���� 1 �߽߰� 
package Gold;

import java.util.Scanner;

public class ����17136_�ڿ��� {
	static int[][] map = new int[10][10];
	static int result = 30;
	static int[] paper = { 0, 5, 5, 5, 5, 5 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ���� �Է�
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
			}
		} // endOfMap

		dfs(0, 0, 0);

		// result �ʱ�ȭ (������ �� 25���ϱ� 26�� �̻��̸� �˳��� ��)

		if (result == 30) {
			System.out.println(-1);
		} else
			System.out.println(result);

	}// endOfMain

	// dfs + ��Ʈ��ŷ���� Ǯ���
	static void dfs(int x, int y, int cnt) {
		// �̹� result ���� ũ�� �ð�����
		if (result <= cnt) {
			return;
		}

		// ������ ���� �ٴٶ��� ��� result�� cnt ��
		if (x >= 9 && y > 9) {
			result = Math.min(result, cnt);
			return;
		}

		// ���η� �� ���� �ǵ� ���� ������ ���� �����Ѵٸ� ���� �ٷ� ����
		if (y > 9) {
			dfs(x + 1, 0, cnt);
			return;
		}
		// ���� ������ ���̱�
		// �� �κк��� ���� �����ߴ�... �̤�... �μ� �� �ٽ� ����� �������� �� ���� �����س�����

		if (map[x][y] == 1) {
			// ū �����̺��� �غ�
			for (int i = 5; i > 0; i--) {
				if (paper[i] > 0 && check(x, y, i)) {
					// ������ ����
					putorputoff(x, y, i, 0);
					// ���� ������ ������ŭ ���ֱ�
					paper[i]--;
					// �������� ���~
					dfs(x, y + 1, cnt + 1);
					// ������ ���ֱ�
					putorputoff(x, y, i, 1);
					// ������ ���� ���󺹱�
					paper[i]++;
				}
			}

		} else
			dfs(x, y + 1, cnt);

	}// endOfDfs

	// �����̸� ���̰� �� �� ���
	// state�� 1�� ��� ���󺹱�
	// state�� 0�� ��� �����̸� �ٿ��� �ű�� ���� �� ���δٴ� ��
	public static void putorputoff(int x, int y, int size, int state) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = state;
			}
		}
	}

	// �������� ũ�⸸ŭ Ȯ���� �ſ���
	public static boolean check(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				// ���� ���̰ų� 1�� �ƴϸ� false
				if (i < 0 || i >= 10 || j < 0 || j >= 10 || map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}// endOfCheck
}// endOfClass

// ���̵�� �������� ���� �ɷȴ� 
// 1�� �Ǵ� ������ ã�Ƽ� nxn�� ��� ���δٸ� �����ߴµ� 
// �׳� ������ ū�ź��� ������ ��� �� ������
