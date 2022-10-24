import java.util.Scanner;
import java.util.Stack;

public class 백준3986_유동윤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		Stack<Character> st;
		int cnt = 0;
		for (int i = 0; i < a; i++) {
			st = new Stack<>();
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (!st.isEmpty() && st.peek() == c) {
					st.pop();
				} else {
					st.add(c);
				}
			}
			if (st.isEmpty())
				cnt++;
		}
		System.out.println(cnt);
	}
}
