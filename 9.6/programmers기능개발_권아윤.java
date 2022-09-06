import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class programmers기능개발_권아윤 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    //progresses[] : 작업의 진도가 적힌 정수 배열
    //speeds[] : 작업의 개발 속도가 적힌 정수 배열
    //각 배포마다 몇 개의 기능이 배포되는지

    static int[] solution(int[] progresses, int[] speeds) {

        int[] temp = new int[progresses.length]; //임시로 days 저장할 배열
        int max = 0;

        for(int i = 0; i < progresses.length; i++) {
            int tempP = progresses[i];
            int tempS = speeds[i];

            //tempP + tempS * days >= 100
            int result = 0;
            int days = -1;
            while(result < 100) {
                result = tempP + tempS * days;
                if(result >= 100) break;
                days++;
            }
//            System.out.println(days);
            temp[i]= days; //기능 개발이 완료된 날 days 체크
            max = Integer.max(temp[i], max); //최대로 걸리는날 체크

        }

        int[] answer = new int[100]; //배포 수만큼 배열 생성


        return answer;
    }

}
