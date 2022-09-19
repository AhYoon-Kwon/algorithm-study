import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len = o1.length() * o2.length();
                for(int i = 0; i < len; i++){
                    int temp = o2.charAt(i % o2.length()) - o1.charAt(i % o1.length());
                    if(temp != 0) return temp;
                }
                return 0;

            }
        };

        List<String> strNumbers =
                IntStream.of(numbers)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.toList());


        Collections.sort(strNumbers, comparator);

        String answer = strNumbers.stream()
                            .collect(Collectors.joining())
        					.replaceAll("^[0]{1,}", "0");
        

        return answer;
    }
}