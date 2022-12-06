import java.util.Scanner;

public class Main {
    static int N, M;
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        int result = 1;

        for(int i = 0; i < N; i++) {
            arr[i] = sc.next().toCharArray();
        }

        int maxSize = Math.max(N, M);

        for(int size = 2; size <= maxSize; size++) {
            for(int i = 0; i < N - size + 1; i++) {
                for(int j = 0; j < M - size + 1; j++) {
                    if(arr[i][j] == arr[i][j + size - 1] && arr[i][j] == arr[i + size - 1][j] &&
                    arr[i][j] == arr[i + size - 1][j + size - 1])
                        result = size;
                }
            }
        }

        System.out.println(result * result);

    }
}
