import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        int limit = sc.nextInt();

        Arrays.sort(arr);
        int sum = Arrays.stream(arr).sum();
        int result = 0;
        if(sum < limit)
            result = Arrays.stream(arr).max().getAsInt();
        else {


            int partial = 0;
            int max = 0;

            for (int i = 0; i < N - 1; i++) {
                partial += arr[i];
                int upper = (limit - partial) / (N - (i + 1));
                if (upper > max)
                    max = upper;
            }
           
            result = Math.max(max, limit / N);
        }

        System.out.println(result);

    }
}
