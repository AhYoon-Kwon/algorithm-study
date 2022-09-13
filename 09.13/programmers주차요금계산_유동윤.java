import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//입차면 -해주고 출차면 +해줘서 시간을 계산하고 시간이 -이면 출차를 안한거니까 24:59분(1439)을 +해준다.

public class programmers주차요금계산_유동윤 {
	static public List<Integer> solution(int[] fees, String[] records) {
		List<Integer> answer = new ArrayList<Integer>();
		// 차번호, 주차시간 map 만들기
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < records.length; i++) {
			// 띄어쓰기를 기준으로 split해주기
			// 05:34 5961 IN => 시간 / 차 번호 / 상태
			String[] info = records[i].split(" ");
			String time = info[0];
			// 05:34를 :기준으로 split해서 분으로 계산하기
			int minute = Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
			String carNum = info[1];
			String carState = info[2];
			// 입차면 빼주고 출차면 더해주기
			if (carState.equals("IN")) {
				map.put(carNum, map.getOrDefault(carNum, 0) - minute);
			}
			if (carState.equals("OUT")) {
				map.put(carNum, map.getOrDefault(carNum, 0) + minute);
			}
		}
		Object[] mapKey = map.keySet().toArray();
		Arrays.sort(mapKey);
		for (Object key : mapKey) {
			int minute = map.get(key);
			// 출차를 안했으면 23:59에 추차한걸로 친다.
			// 23:59 = 1439
			if (minute <= 0)
				minute += 1439;
			System.out.println(minute);
			// 기본요금 + 추가요금 계산하기.
			// 올림 = (값+(나누는값-1)) / 나누는 값
			if (minute > fees[0]) {
				answer.add((minute - fees[0] + fees[2] - 1) / fees[2] * fees[3] + fees[1]);
			} else {
				answer.add(fees[1]);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
//    	int[] fees = {180, 5000, 10, 600};
//    	String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] fees = { 1, 461, 1, 10 };
		String[] records = { "00:00 1234 IN" };
		System.out.println(solution(fees, records));
	}
}
