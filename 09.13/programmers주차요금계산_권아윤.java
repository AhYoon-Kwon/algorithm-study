import java.util.*;

class programmers주차요금계산_권아윤 {
    // int[] fees : 주차 요금 [기본 시간, 기본 요금, 단위 시간, 단위 요금]
    // String[] records : 자동차의 입출차 내역
    
    //차량 번호가 작은 자동차부터 청구할 주차 요금
    public int[] solution(int[] fees, String[] records) {
        String[][] detail = new String[records.length][3];
        
        //records[] 문자열 split후 저장
        for(int i = 0; i < records.length; i++) {
            detail[i] = records[i].split(" ");
        }
        
        int check = 0; // 입차 했는지 체크 (0: 입차X, 1: 입차O/출차X, 2: 출차O)
        
        out: for(int i = 0; i < detail.length; i++) {
            if(detail[i][2] == "OUT") {
                
                String car = detail[i][1]; //출차한 차번호 저장
                String out = detail[i][0]; //출차 시간 저장
                int[] tempp = Integer.parseInt(out.split(":"));
                int out_time = tempp[0] * 60 + tempp[1];
                
                int in_time = 0;
                int total = 0;
                for(int j = 0; j < i; j++) { 
                    
                    //출차 전 입차한 동일 차번호 조회
                    if(car == detail[j][1] && detail[j][2] == "IN") {
                        String in = detail[j][0]; //입차 시간
                        int[] temp = Integer.parseInt(in.split(":"));
                        in_time = temp[0] * 60 + temp[1];
                        
                        total = out_time - in_time;
                    }
                }
            }
        }
        
        int[] answer = new int[records.length];
        return answer;
    }
    
    static int cal(int[] fees, int time) {
        //전체 입출차에 걸린 시간(분)으로 주차 요금 계산
        
        int tot = 0; //주차 요금
        
        //1. 기본 시간 이상이면
        if(time > fees[0]) {
            //1-1. 단위 시간만큼의 초과 시간 계산
            time -= fees[0];
            int unit = time/fees[2];
            int 
            
            tot = fees[1] + unit*fees[3] + 
        }
        //2. 기본 시간 이하면: 기본 요금
        else {
            tot = fees[1];
        }
    }
}
