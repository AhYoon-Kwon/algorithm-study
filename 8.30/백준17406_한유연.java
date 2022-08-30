package algo.baekjoon;

import java.util.*;

public class Baekjoon17406_배열돌리기4 {
	
	static int[] dx = {-1,0,1,0}; //시계방향
	static int[] dy = {0,1,0,-1};
	static int N,M,K;
	static int[][] map;
	static operation[] oper;
	static boolean[] visited;
	
	static int ans;
	
	static class operation{
		int r,c,s;
		operation(int r, int c, int s){
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		oper = new operation[K];
		visited = new boolean[K];
		for(int i=0; i<K; i++) {
			oper[i] = new operation(sc.nextInt()-1,sc.nextInt()-1,sc.nextInt());
		}
		
		
		ans = Integer.MAX_VALUE;
		
		perm(map, 0);
		
		System.out.println(ans);
		
		
	}
	static void perm(int[][] map, int idx) {
		if(idx == K) {
			ans = Math.min(ans, matValue(map));
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(!visited[i]) {
				
				int[][] newMap = new int[N][M];
				
				turn(map, newMap, oper[i], true);
				visited[i]=true;
				
				perm(newMap,idx+1);
				
				visited[i]=false;
			}
		}
		
	}
	static void turn(int[][] map,int[][] newMap, operation o, boolean clockwise) {
		
		int r = o.r;
		int c = o.c;
		int s = o.s;
		
		newMap[r][c] = map[r][c];
		
		for(int x=r-s; x<=r+s; x++) {
			for(int y=c-s; y<=c+s; y++) {
				if(y<c && y<x-r+c && y<=-x+r+c) {
					int nx = x+dx[0];
					int ny = y+dy[0];
					
					newMap[nx][ny]=map[x][y];
					
				}else if(x<r && y>=x-r+c && y<-x+r+c) {
					int nx = x+dx[1];
					int ny = y+dy[1];
			
					newMap[nx][ny]=map[x][y];
					
				}else if(y>c && y>x-r+c && y>=-x+r+c) {
					int nx = x+dx[2];
					int ny = y+dy[2];
					
					newMap[nx][ny]=map[x][y];
					
				}else if(x>r && y<=x-r+c && y>-x+r+c) {
					int nx = x+dx[3];
					int ny = y+dy[3];
					
					newMap[nx][ny]=map[x][y];
					
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(newMap[i][j]==0)
					newMap[i][j]=map[i][j];
			}
		}
		
	}
	
	static int matValue(int[][] mat) {
		int n = mat.length; //행
		int m = mat[0].length; //열
		
		int min = 987654321;
		for(int i=0; i<n; i++) {
			int tmp = 0; 
			for(int j=0; j<m; j++) {
				tmp +=mat[i][j];
			}
			min = Math.min(tmp, min);
		}
		
		return min;
	}
	
}
