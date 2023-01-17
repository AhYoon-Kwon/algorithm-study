package Gold;
import java.io.*;
import java.util.*;
public class Q2179_비슷한단어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] list = new String[n];
		String[] result = new String[2];
		for(int i=0; i<n; i++)
			list[i]=br.readLine();
		String[] copy = list.clone();
		Arrays.sort(copy);
		int max = 0;
		for (int i=0; i<n-1; i++) {
			String a = copy[i];
			String b = copy[i+1];
			if (!a.equals(b)) {
				int cnt = 0;
				for (int j=0; j<a.length()+1; j++) {
					if (a.length() <= j || b.length() <= j || a.charAt(j) != b.charAt(j)) 
					{
						if (cnt > max)
							{max = cnt;
							result[0] = a;
							result[1] = b;
							}
						break;
					}
					else cnt++;
				}
			}
		}
		int a = -1;
		int b = -1;
		for (int i=0; i<n; i++) {
			if (a == -1)
				if (list[i].equals(result[0]))
					a=i;
			if (b == -1)
				if (list[i].equals(result[1]))
					b=i;
		}
		if (a > b) 
			System.out.println(result[1]+"\n"+result[0]);
		else
		System.out.println(result[0]+"\n"+result[1]);
	}
}
