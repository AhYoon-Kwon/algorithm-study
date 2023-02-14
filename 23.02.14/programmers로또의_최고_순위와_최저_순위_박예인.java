class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {int[] answer = new int[2];
		int[] nums = new int[46];
		int cnt = 0;
		for (int i =0; i<lottos.length; i++) {
			if (lottos[i] == 0) {
				cnt++;
			}
			nums[win_nums[i]]++;
		}
		int base = 0;
		for (int i =0; i<6; i++) {
			if (lottos[i] !=0 && nums[lottos[i]] != 0) {
//				System.out.println("lottos[i] : "+lottos[i]+ "nums[lottos[i]] : "+ nums[lottos[i]]);
				base++;
			}
		}
		int maxResult = base + cnt;
		int minResult = base;
		answer[0] = count(maxResult);
		answer[1] = count(minResult);
		
//		System.out.println("cnt = "+cnt+" base = "+base+" : ["+answer[0]+", "+answer[1]+"]");
		return answer;
	}
		public static int count(int a) {
			if (a == 6) {
				return 1;
			}
			else if (a == 5)
				return 2;
			else if (a == 4)
				return 3;
			else if (a == 3) 
				return 4;
			else if (a == 2)
				return 5;
			else
				return 6;
			}
    }
