import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] arr = new char[N][N];
        int max = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = sc.next().toCharArray();
        }

        for(int i = 0; i < N; i++) {
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 'Y') {
                    count++;
                }
                else if(i != j) {
                    for (int k = 0; k < N; k++) {
                        if (arr[k][j] == 'Y' && arr[i][k] == 'Y') {
                            count++;
                            break;
                        }
                    }
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);

    }
}
