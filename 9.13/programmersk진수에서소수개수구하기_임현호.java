import java.util.stream.Stream;

class Solution {
    public int solution(int n, int k) {
        int answer = countPrime(toKJinsoo(n,k));
       
        return answer;
    }
    
   
    public String toKJinsoo(int n, int k){
        String str = "";
        while(n > 0){
            str = Integer.toString(n % k) + str;
            n = n / k;
        } 
            
        return str;
    }
    
    public boolean isPrime(long num){
        if(num == 1) 
            return false;
        
        for(long i=2 ; i * i <= num; i++) {
            if(num % i ==0) {
                return false;
            }
        }
        return true;
    }
    
    public int countPrime(String str){
      	
        return (int) Stream.of(str.split("0"))
             	  .filter(x -> !x.equals(""))
          		  .mapToLong(Long::parseLong)
          		  .filter(x -> isPrime(x))
         		  .count();
        
        
    }
}