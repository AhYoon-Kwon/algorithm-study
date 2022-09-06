import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class programmers기능개발 {
	public static void main(String[] args) {
		int[] progresses = { 93, 39, 55 };
		int[] speeds = { 1, 30, 5 };
//		int[] progresses = { 95, 90, 99, 99, 80, 99 };
//		int[] speeds = { 1, 1, 1, 1, 1, 1 };

		System.out.println(solution(progresses, speeds));

	}

	static public List<Integer> solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<Integer>();
		int[] days = new int[progresses.length];
		for (int i = 0; i < days.length; i++) {
			days[i] = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] != 0)
				days[i]++;
		}
		System.out.println("days : " + Arrays.toString(days));

		int day = days[0];
		int cnt = 0;
		for (int i = 0; i < days.length; i++) {
			if (days[i] <= day) {
				cnt++;
			} else {
				answer.add(cnt);
				day = days[i];
				cnt = 1;
			}
		}
		answer.add(cnt);
		return answer;
	}
}
