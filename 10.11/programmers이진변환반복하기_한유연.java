package algo.programmers;

public class programmers_이진변환반복하기 {
	static int binaryCnt;
	static int rmZero;
	static int len;
    public static int[] solution(String s) {
    	len = s.length();
    	binaryCnt = 0;
    	rmZero = 0;
    	while(s.charAt(0)!='1' || len>1) {   		
    		int tmp = 0;
    		for(int i=0; i<s.length(); i++) {
    			if(s.charAt(i)=='0') tmp++;
    		}
    		rmZero+=tmp;
    		len -= tmp;
    		s = Integer.toBinaryString(len);
    		binaryCnt++;
    		len = s.length();
    	}
        
        int[] answer = {binaryCnt, rmZero};
        return answer;
    }
    public static void main(String[] args) {
		int[] ans = solution("110010101001");
		for(int i: ans) System.out.print(i+", ");
		System.out.println();
	}
}