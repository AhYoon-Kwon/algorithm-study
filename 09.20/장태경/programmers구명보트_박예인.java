import java.util.*;

public class programmers����Ʈ_�ڿ��� {
	public static void main(String[] args) {
		int[] a = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println(solution(a, limit));
	}

	public static int solution(int[] people, int limit) {

		int answer = 0;
		// sort�� ��
		Arrays.sort(people);
		// �� ū �ֺ��� �¿�� �� ���� �� Ű�� �� �ֳ�? ���� ������ ��� �¿����� ��� ����

		int cnt = 0;

		for (int max = people.length - 1; cnt <= max; max--) {
			// �������� + ��ū�� <= limit �̸� �Ѵ� �ϳ��� Ű���/�ٿ��ְ�
			if (people[cnt] + people[max] <= limit)
				cnt++;
			// ����������ϱ� answer++;
			answer++;
		}

		return answer;

	}
}
