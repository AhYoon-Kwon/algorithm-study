import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
		// 여기는 차 번호랑 이용 시간을 저장할 것
		HashMap<String, Integer> feeMap = new HashMap<>();

		// 여기는 지금 있는 차들? out 시간이 없는 차들을 위해 넣어놓음
		HashMap<String, Integer> cars = new HashMap<>();

		// in이면 저장하고 out이면 저장한 거 불러와서 계산하고 차 번호랑 넣어보쟝!
		for (String record : records) {
            String[] s = record.split(" ");
			String a = s[0];
			String b = s[1];
			String c = s[2];
			if (c.equals("IN")) {
				int time = getTime(a);
				cars.put(b, time);
				if (feeMap.containsKey(b) == false)
					feeMap.put(b, 0);
			} else {
				String carNum = b;
				int inTime = cars.get(b);
				int outTime = getTime(a);
				feeMap.put(b, (feeMap.get(b)+outTime-inTime));
				cars.remove(b);
			}//end else
		}//end for
		//안나간놈들 처리
		if (!cars.isEmpty()) {
			for (String num : cars.keySet()) {
				int inTime = cars.get(num);
				int outTime = 1439;
				feeMap.put(num, (feeMap.get(num)+outTime-inTime));
			}
		}//end if
		
		
		//이제 저장된 값으로 돈 계산을 해봅시다잉
		answer = calculate(feeMap, fees);
        
        return answer;
    }//endofmain
    
	public static int getTime(String time) {
		String[] t = time.split(":");
		return Integer.valueOf(t[0])*60+Integer.valueOf(t[1]);
	}//end of getTime
	
    
	public static int[] calculate(HashMap<String, Integer> map, int[] fees) {
		int[] result = new int[map.size()];
		int cnt = 0;
		List<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		for (String a : keySet) {
			int fee = 0;
			int total = map.get(a);
			if (total <= fees[0]) {
				fee = fees[1];
			} else {
				int b = (total-fees[0]) / fees[2];
				int c = (total-fees[0]) % fees[2];
				fee = fees[1] + b * fees[3];
				if (c !=0) {
					fee += fees[3];
				}
			}	
//			System.out.println(fee);
			result[cnt++] =fee;
		}
		return result;
	}
}
