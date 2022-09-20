import java.util.Arrays;
import java.util.Collections;

public class programmers구명보트_유동윤 {
	// 제일 무거운놈이랑 제일 가벼운놈이랑 매칭시켜서 태운다.
	public static void main(String[] args) {
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println(solution(people, limit));
	}

	static public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int size = people.length;
		int cnt = 0;
		for (int i = size - 1; i >= 0; i--) {
			// 1명남음
			if (cnt + answer == size - 1) {
				answer++;
				break;
			}
			// 끝남
			if (cnt + answer == size)
				break;
			// 2명 태웠다.
			if (people[i] + people[cnt] <= limit) {
				cnt++;
				answer++;
			} else {
				answer++;
			}
		}
		return answer;
	}
}
