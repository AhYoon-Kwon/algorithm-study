package algo.programmers;

public class programmers_k진수에서소수개수구하기 {
	static int K;
	static String N;
	public static int solution(int n, int k) {
		K = k;
		N = baseK(n);
		
		int answer = 0;
		String[] arr = N.split("0");
		for(int i=0; i<arr.length; i++) {
			if(arr[i].length()==0) continue;
			if(isPrime(Long.parseLong(arr[i]))) answer++;
		}
		
        return answer;
	}
	static String baseK(int n) {
		String num = "";
		int quotient = n;
		int remainder = 0;
		
		while(quotient!=0) {
			remainder = quotient % K;
			num += String.valueOf(remainder);
			quotient = quotient/K;
		}
		String flip = "";
		for(int i=num.length()-1; i>=0; i--) {
			flip+= num.charAt(i);
		}
		return flip;
	}
	static boolean isPrime(long n) {
		if(n==0 || n==1) return false;
		int m = (int)Math.sqrt(n) +1;
		for(int i=2; i<m; i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("answer: " + solution(437674,3));
		System.out.println("answer: " + solution(110011,10));
	}
}
