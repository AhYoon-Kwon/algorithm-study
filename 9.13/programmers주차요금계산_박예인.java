import java.util.*;

public class programmers������ݰ��_�ڿ��� {
	public static String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
	public static int[] fees = { 180, 5000, 10, 600 }; //�⺻�ð� �⺻��� �����ð� �������
	
	public static void main(String[] args) {
		int[] answer = {};

		// ����� �� ��ȣ�� �̿� �ð��� ������ ��
		HashMap<String, Integer> feeMap = new HashMap<>();

		// ����� ���� �ִ� ����? out �ð��� ���� ������ ���� �־����
		HashMap<String, Integer> cars = new HashMap<>();

		// in�̸� �����ϰ� out�̸� ������ �� �ҷ��ͼ� ����ϰ� �� ��ȣ�� �־��!
		for (String record : records) {
			String a = record.split(" ")[0];
			String b = record.split(" ")[1];
			String c = record.split(" ")[2];
			if (c.equals("IN")) {
				int time = getTime(a);
				cars.put(b, time);
				if (feeMap.containsKey(b) == false)
					feeMap.put(b, 0);
			} else {
				String carNum = b;
				int inTime = cars.get(carNum);
				int outTime = getTime(a);
				feeMap.put(carNum, (feeMap.get(carNum)+outTime-inTime));
				cars.remove(carNum);
			}//end else
		}//end for
		//�ȳ������ ó��
		if (cars.size() != 0) {
			for (String num : cars.keySet()) {
				int inTime = cars.get(num);
				int outTime = 1439;
				feeMap.put(num, (feeMap.get(num)+outTime-inTime));
				cars.remove(num);
			}
		}//end if
		
		
		//���� ����� ������ �� ����� �غ��ô���
		answer = calculate(feeMap);
		System.out.println(Arrays.toString(answer));
	}//end main
	
	public static int getTime(String time) {
		String[] t = time.split(":");
		return Integer.valueOf(t[0])*60+Integer.valueOf(t[1]);
	}//end of getTime
	
	public static int[] calculate(HashMap<String, Integer> map) {
		int[] result = new int[map.size()];
		int cnt = 0;
		List<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		for (Object a : keySet) {
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
			result[cnt++] =fee;
		}
		return result;
	}

}
