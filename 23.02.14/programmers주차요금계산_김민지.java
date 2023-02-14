import java.util.*;

class Solution {
    static int basicMin, basicFee, unitMin, unitFee;
    public int[] solution(int[] fees, String[] records) {
        basicMin = fees[0];
        basicFee = fees[1];
        unitMin = fees[2];
        unitFee = fees[3];
        
        HashMap<Integer,int []> map = new HashMap<>();
        HashMap<Integer, Integer> result  = new HashMap<>();
        Set<Integer> carNum = new TreeSet<>();
        
        for(int i=0;i<records.length; i++){
            StringTokenizer st = new StringTokenizer(records[i]);
            
            int [] time = new int [2];
            String record = st.nextToken();
            time[0]=Integer.parseInt(record.substring(0,2));
            time[1]=Integer.parseInt(record.substring(3,5));
            
            int car = Integer.parseInt(st.nextToken());
            String check = st.nextToken();
            if(check.equals("out")){
                int fee = calculateFee(map.get(car), time);
                result.put(car, fee);
                map.remove(car);
            }else{
                map.put(car, time);
                carNum.add(car);
            }
        }
        for(Map.Entry<Integer, int []> tmp : map.entrySet()){
            int [] out = {23, 59};
            int fee = calculateFee(tmp.getValue(), out);
            result.put(tmp.getKey(), fee);
        }
      
        int [] answer = new int [carNum.size()];
        int idx=0;
        for(int num: carNum){
            answer[idx++]=result.get(num);
        }
        return answer;
    }
    public static int calculateFee(int [] in, int [] out){     
        //분계산
        int total =out[1]-in[1];
        int fee=basicFee;
        if(total<0){
             out[0]-=1;
            total+=60;
        }
        //시간계산
        int tmp = out[0]-in[0];
        total+=60*tmp;
        //요금게산
        if(total<=basicMin){
            return fee;
        }
        total-=basicMin;
        fee += (int)Math.ceil(total/unitMin)*unitFee;
        return fee;
    }
}
