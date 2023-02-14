import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] fa = new long[1000001];
        long[] gn = new long[1000001];

        for(int i = 1; i <= 1000000; i++) {
            for(int j = 1; i * j <= 1000000; j++) {
                fa[i*j] += i;
            }
        }
        for(int i = 1; i <= 1000000; i++)
            gn[i] = gn[i - 1] + fa[i];

        StringBuilder sb = new StringBuilder();

        for(int t=0; t<N; t++) {
            sb.append(gn[sc.nextInt()]).append("\n");
        }

        System.out.println(sb);



    }
}
