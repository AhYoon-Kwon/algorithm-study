
public class programmers신규아이디추천_유동윤 {
	public static void main(String[] args) {
		String new_id = "abcdefghijklmn.p";
		System.out.println(solution(new_id));
	}

	static public String solution(String new_id) {
		String answer = "";

		// 1단계 : 대문자->소문자
		new_id = new_id.toLowerCase();

		// 2단계 : 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		new_id = new_id.replaceAll("[^-_.a-z0-9]", "");

		// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		for (int i = 0; i < 10; i++) {
			new_id = new_id.replace("..", ".");
		}

		// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		if (new_id.charAt(0) == '.')
			new_id = new_id.substring(1);
		if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.')
			new_id = new_id.substring(0, new_id.length() - 1);

		// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if (new_id.equals(""))
			new_id = "a";

		// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
		// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if (new_id.charAt(14) == '.')
				new_id = new_id.substring(0, 14);
		}

		// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		while (new_id.length() <= 2)
			new_id += new_id.charAt(new_id.length() - 1);
		answer = new_id;
		return answer;
	}
}
