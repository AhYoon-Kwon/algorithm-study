public class programmersk진수에서소수개수구하기_권아윤 {

	public static int solution(int n, int k) {
        int answer = 0;
        
        // Integer.toString(int i, int radix)
        // > int형을 주어진 진법의 문자열로 변환한다.
        // > 정수 n을 k진수로 변환
        String radix = Integer.toString(n, k);
        
        // 일단 0 기준 나누기
        String[] strArr = radix.split("0");
        
        for(int i=0; i<strArr.length; i++) {
        	String s = strArr[i];
        	
            // 조건에 맞는지 체크
        	if(s.equals("")) continue;
        	if(isPrime(Long.parseLong(s))) {
        		answer ++;
        	}
        }
                
        return answer;
    }
	
    // int overflow가 발생할 수 있음 주의
    // 1~N-1을 다 거르는 에라토스테네스의 체의 경우 런타임에러
	public static boolean isPrime(long n) {
		if(n == 1) return false;
		else if (n==2) return true;
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
