import java.util.Arrays;

public class programmersk진수에서소수개수구하기_유동윤 {
	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
		System.out.println(solution(n, k));
	}

	static public int solution(int n, int k) {
		int answer = 0;
		String num = convert(n, k);
		String[] arr = num.split("0");
		System.out.println(Arrays.toString(arr));

		for (String q : arr) {
			if (!q.equals("") && isPrime(Long.parseLong(q)))
				answer++;
		}
		return answer;
	}

	// k진수로 바꾸기
	static public String convert(int n, int k) {
		StringBuilder sb = new StringBuilder();
		int current = n;

		while (current > 0) {
			sb.append(current % k);
			current /= k;
		}
		return sb.reverse().toString();
	}

	// 소수인지 판별
	public static boolean isPrime(long num) {
		boolean result = true;
		if (num == 1) {
			result = false;
			return result;
		}
		for (int i = 2; i <= (int) Math.sqrt(num); i++) {
			if (num % i == 0) {
				result = false;
				break;
			}
		}
		return result;
	}
}
