
public class programmers행렬의곱셈_박예인 {
	public static void main(String[] args) {
		int[][] a = {{1, 4}, {3, 2}, {4, 1}};
		int[][] b = {{3, 3}, {3, 3}};
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		//새로운 배열 answer 선언! 
		//배열 a X b * b X c = a X c
		int a = arr1.length;
		int b = arr2[0].length;
		int c = arr1[0].length;
		//따라서 arr1의 크기와 arr2[0]의 크기로 배열 생성
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
