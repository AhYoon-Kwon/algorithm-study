import java.util.*;


public class Programmersk진수에서소수개수구하기_박예인 {
	public static int n = 110011;
	public static int k = 10;
	
	public static void main(String[] args) {
		int res = solution(n,k);
		System.out.println(res);
	}
	
	public static int solution(int n, int k) {
		int answer = 0;
		String num = convert(n, k);
		String[] cut = num.split("0");
		for (String s : cut) {
			if (s.equals("1") || s.equals("0") || s.equals(""))
				continue;
			if (isPrime(Long.parseLong(s))) {
				answer++;}
		}		
		return answer;
	}
	
	public static String convert(int n, int k) {
		String s = "";
		while (n>0) {
			s = n%k + s;
			n /= k;
		}
		return s;
	}
	
	public static boolean isPrime(long a) {
		if (n <= 1) 
			return false;
		for (int i =2; i <= Math.sqrt(a); i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}

}
