import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class programmers가장큰수_유동윤 {
	// 1. 앞자리 숫자가 큰거
	// 2. 길이가 짧은게 유리
	public static void main(String[] args) {
		int[] numbers = { 3, 30, 34, 5, 9 };
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		String ans = "";
		List<String> num = new ArrayList<String>();
		// String형태로 변환
		for (int n : numbers) {
			num.add(String.valueOf(n));
		}

		// 비교규칙 만들어서 비교
		Collections.sort(num, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		for (String s : num) {
			ans += s;
		}
		if (ans.charAt(0) == '0')
			ans = "0";

		return ans;
	}
}
