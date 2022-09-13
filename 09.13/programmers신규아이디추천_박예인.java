import java.util.*;

public class programmers신규아이디추천_박예인 {
	public static String new_id = "=.=";
	public static String new_id2 = "";
	public static void main(String[] args) {
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
		//대문자를 소문자로
		new_id = new_id.toLowerCase();
//		System.out.println(new_id);
		//소문자, 숫자, 빼기, 밑줄, 마침표 빼고 다 제거
		new_id = new_id.replaceAll("[^a-zA-Z0-9-_.]", "");
//		System.out.println(new_id);
		//.. 을 .으로 대체
		while (new_id.contains("..")) {
			new_id = new_id.replace("..", ".");
		}
//		System.out.println(new_id);
		//맨앞 or 맨뒤가 .이면 삭제
		if (new_id.charAt(0) == '.')
			new_id = new_id.substring(1);
		
		if (!new_id.equals("") && new_id.charAt(new_id.length()-1) == '.')
			new_id = new_id.substring(0, new_id.length()-1);
//		System.out.println(new_id);
		
		//비었으면 a삽입
		if (new_id.length() == 0)
			new_id = "a";
//		System.out.println(new_id);
		//16자 이상이면 15까지 짜르고 15번째가 .일 경우 그것도 자름
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if (new_id.charAt(14) == '.')
				new_id = new_id.substring(0, 14);
		}
//		System.out.println(new_id);
		// new_id.length가 2이하일 경우 마지막 문자 계쏙 붙이기
		while (new_id.length() <= 2)
			new_id += new_id.charAt(new_id.length() - 1);
		
//		System.out.println(new_id);
		
		return new_id;
	}
}
