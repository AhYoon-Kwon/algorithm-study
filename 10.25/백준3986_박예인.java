import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stk = new Stack<>();
		int cnt = 0;
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
        //스택에 마지막으로 들어간 애랑 지금 애랑 같으면 빼주고
				if (!stk.isEmpty() && str.charAt(j) == stk.peek()) {
					stk.pop();
				} else {
          //아니면 걔도 걍 스택에 ㄱㄱ
					stk.add((int) str.charAt(j));
				}
			}
      //짝 맞춰서 다 퇴소했으면
			if (stk.isEmpty())
        //좋은단어
				cnt++;
      //비워주기
			stk.clear();
		}
		System.out.println(cnt);
	}
}
