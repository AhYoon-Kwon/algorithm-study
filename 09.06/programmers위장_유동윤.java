import java.util.HashMap;
import java.util.Set;

public class programmers위장 {
    static public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<clothes.length; i++) {
        	String item = clothes[i][0];
        	String category = clothes[i][1];
        	map.put(category, map.getOrDefault(category, 0)+1);
        }
        System.out.println();
        for(int a : map.values()) {
        	answer *= (a+1);
        }
        return answer-1;
    }
    
    public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
		
	}
}
