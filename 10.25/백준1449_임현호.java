import java.util.Scanner;

public class 수리공항승 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        boolean[] arr = new boolean[1001];
        int cnt = 0;

        for(int i = 0; i < N; i++)
            arr[sc.nextInt()] = true;

        for(int i = 1; i <= 1000; i++) {
            if(arr[i]) {
                i += L - 1;
                cnt++;
            }

        }


        System.out.println(cnt);
    }
}
