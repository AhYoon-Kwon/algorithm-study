import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		int [] lan = new int[n];
		for(int i=0; i<n; i++)
			lan[i]=sc.nextInt();
		Arrays.sort(lan);
		
		long min = 1;
		long max = lan[n-1];
		long mid=0;
		
		while(min<=max) {
			mid=(min+max)/2;
			
			long cnt=0;
			for(int i=0; i<n; i++)
				cnt+=(lan[i]/mid);
			
			if(cnt>=target) 
				min=mid+1;
			else 
				max=mid-1;
		}
		System.out.println(max);
	}
}
