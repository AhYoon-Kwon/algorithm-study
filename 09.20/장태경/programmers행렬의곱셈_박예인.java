
public class programmers����ǰ���_�ڿ��� {
	public static void main(String[] args) {
		int[][] a = {{1, 4}, {3, 2}, {4, 1}};
		int[][] b = {{3, 3}, {3, 3}};
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		//���ο� �迭 answer ����! 
		//�迭 a X b * b X c = a X c
		int a = arr1.length;
		int b = arr2[0].length;
		int c = arr1[0].length;
		//���� arr1�� ũ��� arr2[0]�� ũ��� �迭 ����
		int[][] answer = new int[a][b];
		for (int i = 0; i < a; ++i) {
			for (int j = 0; j < b; ++j) {
				for (int k = 0; k < c; ++k) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		return answer;
	}

}
