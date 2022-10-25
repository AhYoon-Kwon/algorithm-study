import java.util.Scanner;
import java.util.Stack;

public class 백준3986_권아윤 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		Stack<Character> stack = new Stack<>();
		
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			String word = scan.next();
			
			for (int j = 0; j < word.length(); j++) {
				// 지금 문자와 스택 top 값이 같으면 제거
				if(!stack.isEmpty() && word.charAt(j) == stack.peek()) stack.pop();
				// 다르면 스택 고고
				else stack.push(word.charAt(j));
			}
			
			//모든 친구들이 짝이 맞으면 굿
			if(stack.size() == 0) ans++;
			
			stack.clear();
		}
		
		System.out.println(ans);
		scan.close();

	}

}
