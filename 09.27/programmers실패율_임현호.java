import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        int[] arr = new int[N + 2];
        for(int i = 0; i < stages.length; i++){
            arr[stages[i]]++;
        }
        
        Map<Integer, Double> map = new HashMap<>();
        
        int n = stages.length;
        for(int i = 1; i <= N; i++){
            if(n == 0){
                map.put(i, 0.0);
                continue;
            }
            map.put(i, arr[i] / (double) n);
            n -= arr[i];
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        
        answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        
        return answer;
    }
}