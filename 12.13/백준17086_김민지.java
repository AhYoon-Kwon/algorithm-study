import java.util.*;

public class 백준17086_김민지 {
    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
	public static class Node{
		int x, y;
		public Node(int x, int y ) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int [][] box = new int [M][N];
		int [][] res = new int [M][N];
		Queue<Node> que = new LinkedList<>();
		for(int i=0; i<M; i++)
			for(int j=0; j<N; j++) {
				res[i][j]=Integer.MAX_VALUE;
				int x = sc.nextInt();
				if(x==1) {
					box[i][j]=x;
					que.add(new Node(i, j));
					res[i][j]=0;
				}
			}
		
		int max=0;
		while (!que.isEmpty()) {
            Node cur = que.poll();

            for (int idx = 0; idx < 8; idx++) {
                int next_x = cur.x + dx[idx];
                int next_y = cur.y + dy[idx];

                if (next_x < 0||next_y<0||next_x>=N||next_y>=M) continue;
                
                if (res[next_x][next_y] > res[cur.x][cur.y] + 1) {
                        res[next_x][next_y] = res[cur.x][cur.y] + 1;
                        que.add(new Node(next_x, next_y));
                        max = Math.max(max, res[next_x][next_y]);
                    }
            }
        }
		System.out.print(max);
	}

}
