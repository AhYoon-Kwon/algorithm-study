import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int max = 1;

        for(int i = 0; i < N; i++) {
            int count = 0;
            int point = arr[i] + 4;
            for(int j = i; j < i + 5; j++) {
                if(j < N && arr[j] <= point)
                    count++;
            }
            max = Math.max(count , max);
            count = 0;

        }


        System.out.println((max >= 5) ? 0 : 5 - max);
    }
}
