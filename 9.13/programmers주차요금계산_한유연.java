package algo.programmers;

import java.util.HashMap;
import java.util.PriorityQueue;

public class programmers_주차요금계산 {
	static int freeM;
	static int baseC;
	static int unitM;
	static int unitC;
	
	static HashMap<Integer, Car> carMap;
	static class Car implements Comparable<Car>{
		int number;
		int in;
		int out = 1440; //24:00
		int time = 0; //누적 시간
		int cost = 0;
		
		Car(int number, int in){
			this.number = number;
			this.in = in;
		}
		void In(int in) {
			this.in = in;
			this.out = 1440;
		}
		void Out(int out) {
			this.out = out;
			this.time += this.out - this.in;
		}
		void Cost() {
			if(this.out == 1440) this.Out(1439);
			int addT = (this.time>freeM) ? this.time-freeM : 0;
			this.cost += baseC + (addT/unitM)*unitC + (addT%unitM ==0 ? 0: unitC);
		}
		@Override
		public int compareTo(Car o) {
			return this.number - o.number;
		}
	}
	
	public static int[] solution(int[] fees, String[] records) {
		freeM = fees[0];
		baseC = fees[1];
		unitM = fees[2];
		unitC = fees[3];
		
		carMap = new HashMap<>();
		PriorityQueue<Car> Cars = new PriorityQueue<>();
		int n = records.length;
		int m = 0; //차량 개수
		for(int i=0; i<n; i++) {
			String[] arr = records[i].split("\\s+");
			int num = Integer.parseInt(arr[1]);
			int time = parseTime(arr[0]);
			if(arr[2].equals("IN") && !carMap.containsKey(num)) {
				Car c = new Car(num,time);
				carMap.put(num, c);
				Cars.add(c);
				m++;
			}else if(arr[2].equals("IN")) {
				carMap.get(num).In(time);
			}else if(arr[2].equals("OUT")){
				carMap.get(num).Out(time);
			}
		}

		int[] answer = new int[m];
		for(int i=0; i<m; i++) {
			Car c = Cars.poll();
			c.Cost();
			answer[i] = c.cost;
		}
		
        return answer;
    }
	
	static int parseTime(String time) {
		int t = ((time.charAt(0)-'0')*10 + (time.charAt(1)-'0'))*60 +
				((time.charAt(3)-'0')*10 + (time.charAt(4)-'0'));
		return t;
	}
	
	public static void main(String[] args) {
		int[] fees = {180,5000,10,600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		solution(fees,records);
	}
}
