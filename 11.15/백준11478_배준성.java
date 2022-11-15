import java.util.HashSet;
import java.util.Scanner;

public class 백준11478 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		HashSet<String> set = new HashSet<String>();
		
		String tmp;
		
		int len = s.length();
		for(int i = 0; i < len; i++) {
			tmp = "";
			for(int j = i; j < len; j++) {
				tmp += s.substring(j, j+1);
				set.add(tmp);
			}
		}
		
		System.out.println(set.size());
	}
}
