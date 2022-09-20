import java.util.Arrays;

public class programmers가장큰수 {
	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };
		String result = solution(numbers);
		System.out.println(result);
	}

	public static String solution(int[] numbers) {
		String answer = "";
		
		//받은 int[]를 string[]으로 변환
		String[] s = new String[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			s[i] = String.valueOf(numbers[i]);
		}
		//여기는 찾아봤다... 
		//sort 하기 위하여 comparator를 사용할 것
		//34, 30, 3이 있으면 34, 3, 30이 되어야 하는데 34, 30, 3이 되기 때문에
		//아스키코드값을 비교
		Arrays.sort(s, (a,b)->{
            return (a+b).compareTo(b+a);
        });
		
		//문자열 연결 
		for(int i=numbers.length-1; i>=0; i--){
            answer+=s[i];
        }
		
		//입력 데이터가 모두 0이면 예외처리
		if(s[0].equals("0")) 
			answer = "0";
		
		return answer;
	}

}
