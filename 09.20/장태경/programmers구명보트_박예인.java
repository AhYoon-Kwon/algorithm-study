import java.util.*;

public class programmers구명보트_박예인 {
	public static void main(String[] args) {
		int[] a = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println(solution(a, limit));
	}

	public static int solution(int[] people, int limit) {

		int answer = 0;
		// sort를 함
		Arrays.sort(people);
		// 젤 큰 애부터 태우고 젤 작은 애 키울 수 있나? 보고 없으면 출발 태웠으면 담놈 보기

		int cnt = 0;

		for (int max = people.length - 1; cnt <= max; max--) {
			// 젤작은놈 + 젤큰놈 <= limit 이면 둘다 하나씩 키우고/줄여주고
			if (people[cnt] + people[max] <= limit)
				cnt++;
			// 배출발했으니까 answer++;
			answer++;
		}

		return answer;

	}
}
