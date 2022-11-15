import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int cnt = 0;
		HashSet<String> set = new HashSet<>();
		while (cnt != s.length()) {
			for (int i=0; i<s.length()-cnt; i++) {
					String str = s.substring(i, i+cnt+1);
				if (!set.contains(str)) 
					set.add(str);
			}
			cnt++;
		}
		System.out.println(set.size());
	}
}
