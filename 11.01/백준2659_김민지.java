//틀림


import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> clockList = new ArrayList<>();
		for(int i=1111; i<10000; i++) {
			String str = Integer.toString(i);
			if(str.contains("0")) continue;
			clockList.add(Integer.parseInt(str));
		}
		
		String [] nums = new String [4];
		for(int i=0; i<4; i++) {
			nums[i]=sc.next();
		}
		ArrayList<String> list = new ArrayList<>();
		int min=Integer.MAX_VALUE;
		for(int i=0; i<4; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(nums[i]).append(nums[(i+1)%4]).append(nums[(i+2)%4]).append(nums[(i+3)%4]);
			list.add(sb.toString());
			min = min<Integer.parseInt(sb.toString())?min:Integer.parseInt(sb.toString());
		}
		int answer=1;
		for(int i: clockList) {
			if(i==min) {
				System.out.println(--answer);
				break;
			}
			answer++;
		}
	}
}
