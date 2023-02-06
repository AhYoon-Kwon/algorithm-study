import java.util.*;

public class BOJ_16198 {
	static ArrayList<Integer> list;
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		list = new ArrayList<>();
		for(int i=0; i<N; i++)
			list.add(sc.nextInt());
		
		res=0;
		
		dfs( 0);
		
		System.out.println(res);
	}
	public static void dfs(int total) {
		if(list.size()==2) {
			res = Math.max(total, res);
			return;
		}
		
		for(int i=1; i<list.size()-1; i++) {
			int val = list.get(i);
			int sum = list.get(i-1)*list.get(i+1);
			list.remove(i);
			dfs(total+sum);
			list.add(i, val);
		}
	}
	
}
