import java.util.LinkedList; //import
import java.util.Queue; //import
class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int cnt = 0;
		int idx = 0;
		int[] answer = {};
		Queue<Integer> queue = new LinkedList<>();

		while(idx < progresses.length){
			int tmp = 0;
			cnt = (100-progresses[idx] + speeds[idx] - 1)/speeds[idx];
			for(int i = idx; i < progresses.length; i++){
				if(progresses[i] + speeds[i] * cnt < 100){
					break;
				} else {
					tmp++;
					idx++;
				}
			}
			queue.add(tmp);
		}
		int size = queue.size();
		answer = new int[size];
		for(int s = 0; s < size; s++){
			answer[s] = queue.poll();
		}
		return answer;

	}
}