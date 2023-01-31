import java.util.*;

public class Main {
	static ArrayList<Integer> [] tree;
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		tree = new ArrayList[N];
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++)
			tree[i]=new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			if(x==-1) continue;
			tree[x].add(i);
		}
		
		int num = sc.nextInt();
		remove(num);
		
		int cnt=0;
		
		for(int i=0; i<N; i++) {
			if(tree[i].size()==0&&!list.contains(i)) {
				cnt++;
			}else if(tree[i].size()==1) {
				if(tree[i].get(0)==num) cnt++;
			}
		}
		
		System.out.println(cnt);

	}
	
	public static void remove(int cur) {
		list.add(cur);
		if(tree[cur].size()==0) return;
		
		while(tree[cur].size()!=0) {
			remove(tree[cur].remove(0));
		}
	}

}
