
public class programmers행렬의곱셈_유동윤 {
	public static void main(String[] args) {
		int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
		int[][] arr2 = {{3, 3}, {3, 3}};
		System.out.println(solution(arr1, arr2));
	}

	static public int[][] solution(int[][] arr1, int[][] arr2) {
		
		int hang1 = arr1.length;
		int yeol1 = arr1[0].length;
		int hang2 = arr2.length;
		int yeol2 = arr2[0].length;
		int[][] answer = new int[hang1][yeol2];
		
        for(int i = 0 ; i < hang1 ; i++){
            for(int j = 0 ; j < yeol2 ; j++){
                for(int k = 0 ; k < yeol1 ; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
		return answer;
	}
}
