import java.util.*;
public class 백준11053_권아윤 {
 
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max=0;
        int[] A = new int[n+1]; //주어진 수열A
        int[] l = new int[n+1]; //수열의 길이 저장할 배열
 
        for(int i=0; i<n; i++){
            A[i]=sc.nextInt(); 
            l[i]=1;
        }
    
        for(int i=0; i<n ; i++){
            for(int j=0 ; j<=i ; j++){
                // 증가하는 값이고 &&  수열을 만들수 있으면 길이를 늘린다
                if(A[j]<A[i] && l[j]>=l[i]){
                    l[i]=l[j]+1;
                }
            }
        }
        
        for(int i=0; i<n ; i++){
            //제일 긴 친구
            if(l[i]>max)
                max=l[i];
        }
 
        System.out.println( max );
        
    }  
}
