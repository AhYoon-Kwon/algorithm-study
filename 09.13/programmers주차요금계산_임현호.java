import java.util.Arrays;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] result = new int[10000];
        String[] time = new String[10000];
        boolean[] flag = new boolean[10000];
 
        for(int i = 0; i < records.length; i++){
            String[] record = records[i].split(" ");
            int num = Integer.parseInt(record[1]);

            if(record[2].equals("IN")) {
                time[num] = record[0];
                flag[num] = true;
            }
            else {
                result[num] += calTime(time[num], record[0]); // 누적 시간 계산
                flag[num] = false;
            }
        }

        for(int i = 0; i < 10000; i++){
            if(flag[i])
                result[i] += calTime(time[i], "23:59");
        }


        int[] answer = Arrays
                            .stream(result)
                            .filter(x -> x != 0)
                            .map(x -> calFee(x, fees))
                            .toArray();       
        return answer;
    }


    public int calTime(String inTime, String outTime){
        String[] in = inTime.split(":");
        String[] out = outTime.split(":");
        int inMin = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]);
        int outMin = Integer.parseInt(out[0]) * 60 + Integer.parseInt(out[1]);
        return outMin - inMin;
    }

    public int calFee(int time, int[] fees){
        double min =  time > fees[0] ? time - fees[0] : 0;
        int fee = fees[1] + (int) Math.ceil(min / fees[2]) * fees[3];

        return fee;
    }
    
}