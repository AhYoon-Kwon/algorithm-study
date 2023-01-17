import java.util.*;

public class BOJ_11501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC =sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int tc=0; tc<TC; tc++) {
			int t = sc.nextInt();
			long [] num = new long [t];

			for(int i=0; i<t; i++)
				num[i]=sc.nextInt();
			
			long res=0;
			long max=0;
			for(int i=t-1; i>=0; i--) {
				long x = num[i];
				if(x>max) max=x;
				else res+=(max-x);
			}		
			sb.append(res).append("\n");
		}
		System.out.print(sb.toString());
	}
}
