import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
//         numbers의 원소를 Int >> String으로 변환
//         strNum에 저장
        String[] strNum = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strNum[i] = String.valueOf(numbers[i]);
        }

//         정렬
//         2개의 number를 정렬해 더 큰 것이 리턴되도록 comparator 오버라이딩
//         Arrays.sort(strNum, new Comparator<String>(){
// //             비교 기준
//             public int compare(String a, String b){
// //                 크면+ 작으면- 동일0
//                 return (b+a).compareTo(a+b);
//             }
//         });

//         정렬2 - 람다식
        Arrays.sort(strNum, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));


        String answer = "";

//         0제외
        if(strNum[0].equals("0")){
            answer = "0";
        }
//         0이 아닌경우 문자열로 만들어서 결과 출력
        else{
            for(String a : strNum){
                answer+=a;
            }
        }

        return answer;
    }
}