import java.util.*;

public class 백준_13549 {
	public static class Node implements Comparable<Node>{
		int x;
		int cnt;
		
		Node(int x, int cnt){
			this.x=x;
			this.cnt=cnt;
		}

		@Override
		public int compareTo(Node o1) {
			return this.cnt-o1.cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int min =0;
		
		int [] check = new int [100001];
		Arrays.fill(check, Integer.MAX_VALUE);
		
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.add(new Node(N, 0));
		check[N]=0;
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			if(cur.x==K) {
				min=cur.cnt;
				break;
			}
			
			if(cur.x+1<100001&&check[cur.x+1]>cur.cnt+1) {
				check[cur.x+1]=cur.cnt+1;
				que.add(new Node(cur.x+1, cur.cnt+1));
			}
			if(cur.x-1>=0&&check[cur.x-1]>cur.cnt+1) {
				check[cur.x-1]=cur.cnt+1;
				que.add(new Node(cur.x-1, cur.cnt+1));
			}
			if(cur.x*2<100001&&check[cur.x*2]>cur.cnt) {
				check[cur.x*2]=cur.cnt;
				que.add(new Node(cur.x*2, cur.cnt));
			}
		}
		
		System.out.println(min);
		
	}
}
