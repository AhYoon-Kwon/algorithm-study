import java.util.Arrays;
class programmers구명보트_권아윤 {
	public int solution(int[] people, int limit) {
		int answer = 0;
		int small = 0, large = 0;

    //1. 일단 정렬 ('몸무게 제일 가벼운사람 + 무거운사람' 해서 비교하기 위해)
		Arrays.sort(people);

		//2. 몸무게가 가장 무거운 사람부터 판단
		for(large = people.length-1; small <= large; large--) {
            
			//2-1. 두명의 몸무게가 무게제한보다 크면, 가장 큰 몸무게의 인원 보냄
			if(people[large] + people[small] > limit)
				answer ++;

      //2-2. 두명의 몸무게가 무게제한 이하이면
			//    - 두명을 한 보트에 태워 보낸다.
			else {
				answer++;
				small++;
			}
		}

		return answer;
	}

}
