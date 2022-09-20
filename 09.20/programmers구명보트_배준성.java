class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;

		int[] num = new int[241];
		for(int one : people){
			num[one]++;
		}

		int numOfPeople = people.length;

		for(int i = 40; i <= 240; i++){
			int max = limit - i;
			while(num[i] != 0){
				if(num[max] == 0)
					max--;
				else if(max == i) {
					if(max <= limit/2)
						answer+=(num[max]+1)/2;
					else
						answer+=num[max];
					num[max] = 0;
				}
				else{
					if(max + i > limit)
						max--;
					else{
						if(num[max] > num[i]){
							num[max]-=num[i];
							answer+=num[i];
							num[i] = 0;
						}
						else{
							num[i]-=num[max];
							answer+=num[max];
							num[max] = 0;
						}
					}
				}
			}

		}

		return answer;
	}
}