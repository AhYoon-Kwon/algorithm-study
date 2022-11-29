import java.util.Scanner;
import java.util.Stack;

public class 백준9935_유동윤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String b = sc.next();
		Stack<Character> sC = new Stack<>();

		// stack에 하나씩 넣으면서 폭탄배열이 되는지 확인한다.
		for (int i = 0; i < s.length(); i++) {
			sC.add(s.charAt(i));
			if (sC.size() >= b.length()) {
				boolean flag = true;
				// 하나라도 폭탄배열이랑 다르면 stack에 하나 더 넣고 비교 ㄱㄱ
				for (int j = 0; j < b.length(); j++) {
					if (sC.get(sC.size() - b.length() + j) != b.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < b.length(); j++) {
						sC.pop();
					}
				}
			}
		}
		// 다 빠졌으면
		if (sC.isEmpty())
			System.out.println("FRULA");
		// 남아있으면 출력
		else {
			for (char c : sC)
				System.out.print(c);
		}
	}
}
