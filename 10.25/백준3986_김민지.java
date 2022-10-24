import java.util.Scanner;
import java.util.Stack;

public class 백준3986_김민지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer=0;
		for(int i=0; i<N; i++) {
			String str = sc.next();
			Stack<Character> stack = new Stack<>();
			for(int j=0; j<str.length();j++) {
				char c = str.charAt(j);
				if(stack.isEmpty()||stack.peek()!=c) {
					stack.add(c);
				}else {
					stack.pop();
				}
			}
			if(stack.isEmpty()) answer++;
		}
		System.out.println(answer);
	}
}
