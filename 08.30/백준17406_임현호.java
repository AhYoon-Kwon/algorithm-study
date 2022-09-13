import java.util.Arrays;
import java.util.Scanner;

public class 백준17406_임현호 {
	static int N, M, K;
	static int[][] arr;
	static int[][] arrTemp;
	static int min;
	static int[][] rcs;
	static int[] seq;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][M];
		arrTemp = new int[N][M];
		min = Integer.MAX_VALUE;
		rcs = new int[K][3];
		seq = new int[K];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < K; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			int s = sc.nextInt();
			rcs[i][0] = r;
			rcs[i][1] = c;
			rcs[i][2] = s;
		}
		
		
		permutation(0, 0);
		

		System.out.println(min);
		
	}
	
	static void rotate(int r, int c, int s) {
		int[][] temp = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				temp[i][j] = arrTemp[i][j];
			}
		}
		
		

		for(int i = r - s; i <= r + s; i++) {
			for(int j = c - s; j <= c + s; j++) {
				int x = i - r;
				int y = j - c;
				
				if(x + y <= 0 && y - x > 0) arrTemp[i][j] = temp[i][j - 1];
				else if(x + y > 0 && y - x >= 0) arrTemp[i][j] = temp[i - 1][j];
				else if(x + y >= 0 && y - x < 0) arrTemp[i][j] = temp[i][j + 1];
				else if(x + y < 0 && y - x <= 0) arrTemp[i][j] = temp[i + 1][j];
			}
		}
		
		for(int i = 0; i < N; i++ )
			System.out.println(Arrays.toString(arrTemp[i]));
		System.out.println();
		for(int i = 0; i < N; i++ )
			System.out.println(Arrays.toString(temp[i]));
		System.out.println();
	}
	
	static void cal() {
		for(int i = 0; i < N; i++) {
			min = Math.min(Arrays.stream(arrTemp[i]).sum(), min);
		}
		
	}
	
	static void permutation(int num, int visited) {
		if(num == K) {
			System.out.println(Arrays.toString(seq));
			
			for(int i = 0 ; i < N; i++){
				for(int j = 0; j < M; j++)
					arrTemp[i][j] = arr[i][j];
			}
			
			for(int i = 0; i < K; i++)
				rotate(rcs[seq[i]][0],rcs[seq[i]][1], rcs[seq[i]][2]);
			
			cal();
			

			return;
		}
		
		for(int i=0; i < K; i++) {
			if((visited & 1 << i) != 0) continue;
			seq[num] = i;
			permutation(num + 1, visited | 1 << i);
		}
	}
}
