import java.util.*;

public class BOJ_2668 {
	static boolean [] visit;
	static int [] nums;
	static int check;
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		check=0;
		list = new ArrayList<>();
		visit = new boolean [N+1];
		nums = new int [N+1];
		
		for(int i=1; i<N+1; i++) {
			nums[i]=sc.nextInt();
		}
		
        for(int i=1;i<N+1;i++){
            visit[i]=true;
            check=i;
            dfs(i);
            visit[i]=false; 
        }
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int num: list)
			System.out.println(num);

	}
	
	public static void dfs(int x) {
        if(!visit[nums[x]]){ 
            visit[nums[x]]=true; 
            dfs(nums[x]);
            visit[nums[x]]=false; 
        }
        if(nums[x] == check){ 
            list.add(check);
        }
	}

}
