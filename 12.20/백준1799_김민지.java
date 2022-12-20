import java.util.*;

public class 백준1799_김민지 {
	static int N, black, white;
	static int [][] box;
	static boolean [][] visit, color;
	
	static int[] dx = { -1, -1 };
	static int[] dy = { -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		box = new int [N][N];
		visit = new boolean [N][N];
		color = new boolean [N][N];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++) {
				box[i][j]= sc.nextInt();
				if((i+j)%2==0) color[i][j]=true;
			}
		
		//검은칸이 true
		//체스 검은칸, 흰칸으로 나눠서 탐색
		black=0; 
		white =0;
		bishop(-1, true, 0);
		bishop(-1, false, 0);

		System.out.println(black+white);
	}
	static void bishop(int col, boolean check, int cnt) {
		 for (int i = col+1; i < N*N; i++) {
	            int x = i / N;
	            int y = i % N;
	            
	            if(color[x][y]!=check||box[x][y]==0||!isOk(x,y))  continue;
	            
	            visit[x][y] = true;
	            bishop(i, check, cnt+1);
	            visit[x][y] = false;
	        }
	        if(check) black=Math.max(black, cnt);
	        else white=Math.max(white, cnt);
	}
	// 양 대각선 위쪽에 비숍이 놓여져있는지 확인.
	static boolean isOk(int x, int y) {
		for(int idx=0; idx<2; idx++) {
			int i = x+dx[idx];
			int j = y +dy[idx];
			while(true) {
				if(isOut(i, j)) break;
				if(visit[i][j]) return false;
				i+=dx[idx];
				j+=dy[idx];
			}
		}
		return true;
	}
	static boolean isOut(int x, int y ) {
		if(x<0||y<0||x>=N||y>=N) return true;
		return false;
	}
}
