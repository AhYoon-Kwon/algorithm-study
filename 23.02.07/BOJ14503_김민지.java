import java.util.*;

public class BOJ_14503 {
	static int N, M;
	static int [][] map;
	
	static int [] dx = {0, -1, 0, 1};
	static int [] dy = {-1, 0, 1, 0};
	
	static int [] dr = {1,0,-1,0};
	static int [] dc = {0,-1,0,1};
	
	static class Info{
		int r, c, d, cnt;
		
		Info(int r, int c, int d,int cnt){
			this.r=r;
			this.c=c;
			this.d=d;
			this.cnt=cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int [N][M];
		
		Queue<Info> que = new LinkedList<>();
		int r=sc.nextInt();
		int c =sc.nextInt();
		que.add(new Info(r, c, sc.nextInt(), 0));
		
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				map[i][j]=sc.nextInt();
		
		int res =0;
		
		while(!que.isEmpty()) {
			Info cur = que.poll();
			
			if(map[cur.r][cur.c]==0) {
				res++;
				map[cur.r][cur.c]=2;
			}
			
			int x = cur.r+dx[cur.d];
			int y = cur.c+dy[cur.d];
			
			if(isIn(x,y)&&map[x][y]==0) {
				que.add(new Info(x, y, (cur.d+3)%4, 0));
			}else if(cur.cnt<4){
				que.add(new Info(cur.r, cur.c, (cur.d+3)%4, cur.cnt+1));
			}else if(cur.cnt==4) {
				int nextX=cur.r+dr[cur.d];
				int nextY=cur.c+dc[cur.d];

				if(isIn(nextX, nextY)&&map[nextX][nextY]!=1) {
					que.add(new Info(nextX, nextY, cur.d, 0));
				}
			}
		}
		
		System.out.print(res);
	}
	
	public static boolean isIn(int x, int y) {
		if(x<0||y<0||x>=N||y>=N) return true;
		return true;
	}

}
