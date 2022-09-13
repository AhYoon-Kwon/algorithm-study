import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    static int answer = 1;
    
    public int solution(String[][] clothes) {
        Arrays.stream(clothes)
			.collect(Collectors.groupingBy(arr -> arr[1]))
			.forEach((key, value) ->{
				answer *= value.size() + 1;
			});
        answer--;

        return answer;
    }
}