import java.util.*;

public class 백준7562_김민지 {
	static int [][] box;
	static boolean [][] visited;
	static int depX, depY, cnt, L;
	static Queue<Node> que;
	
	static int [] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int [] dy = {1, -1, 2, -2, 2, -1, 1, -1};
	
	public static class Node{
		int x, y, moveCnt;
		Node(int x, int y, int moveCnt){
			this.x=x;
			this.y=y;
			this.moveCnt=moveCnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=0; tc<TC; tc++){
			L = sc.nextInt();
			box = new int[L][L];
			//방문확인 
			visited = new boolean[L][L];
			//현재위치
			int curX = sc.nextInt();
			int curY =  sc.nextInt();
			visited[curX][curY]=true;
			
			//목표지점
			depX = sc.nextInt();
			depY = sc.nextInt();
			
			que = new LinkedList<>();
			que.add(new Node(curX, curY, 0));
			System.out.println(bfs());
		}
	}
	private static int bfs(){
		while(!que.isEmpty()) {
			Node cur = que.poll();
			// 목표 지점 도착했는지 확인
			if(cur.x==depX&&cur.y==depY){
				return cur.moveCnt;
			}
			//이동
			for (int idx = 0; idx < 8; idx++) {
				int x = cur.x + dx[idx];
				int y = cur.y + dy[idx];
				if (isOut(x, y)||visited[x][y]) continue;
				//방문체크
				visited[x][y]=true;
				que.add(new Node(x, y, cur.moveCnt+1));
			}
		}
		return -1;
	}
	private static boolean isOut(int x, int y ){
		if(x<0||y<0||x>=L||y>=L) return true;
		return false;
	}
}
