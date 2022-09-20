import java.util.*;

class programmers가장큰수_권아윤 {
    public String solution(int[] numbers) {
        String answer = "";
        
        // 1. int 배열 -> String 으로 변환
        String[] temp = new String[numbers.length];
        for(int i  =0; i < numbers.length ; i++){
            temp[i]=String.valueOf(numbers[i]);
        }
        
        // 2. Comparator로 내림차순 정렬
        Arrays.sort(temp, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        /*
            Arrays.sort(array, Comparator.reverseOrder())
            -> 30과 3이 있을 때 30>3이라 303으로 조합
               그러나 330이 사실 더 큼
            -> 결과 실패
            -> 두개의 문자열을 더한값을 비교하여 내림차순 정렬해야 함
            
            o2+o1과 o1+o2의 순서 이유?
            -> 첫번째 숫자가 큰게 더 크다!!
            -> 4과 30이 있을 때 4가 30보다 앞에 와야 함,
            -> 430과 304를 비교하고 내림차순 정렬!
        */
        
        // 3. answer에 정렬된 것을 담기
        for(int i = 0; i < temp.length; i++) {
            answer += temp[i];
        }
        
        // 4. numbers가 0으로 시작하는 경우 
        if(answer.startsWith("0")) {
            answer="0";
        }
        
        return answer;
    }
}
