package algo;

import java.util.Arrays;
import java.util.Scanner;

public class 백준1051_권아윤 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		int[][] nums = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String input = scan.next();
			
			for (int j = 0; j < M; j++) {
				nums[i][j] = input.charAt(j) - '0';
			}
		} //인풋값 입력
		
		int ans = 1;
		int size = Integer.min(N, M); //길이 둘중에 작은거보다 최대 정사각형 크기가 넘어갈수없다
		
		for (int k = 2; k <= size; k++) { //정사각형 길이 계속 늘려!
			
			for (int i = 0; i < N-k+1; i++) { //N과 M을 못벗어나게
				for (int j = 0; j < M-k+1; j++) {
					
					if(nums[i][j]==nums[i+k-1][j] && 	//모서리들이 같으면~
							nums[i][j]==nums[i][j+k-1] && 
							nums[i][j]==nums[i+k-1][j+k-1]) {
						
						if(ans < k) { //정사각형의 길이가 더 긴게 나왔으면 변경
							ans = k;
						}
					}
				}
			}
		}
		System.out.println(ans*ans); //넓이
		
		scan.close();

	}
	
}
