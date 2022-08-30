import java.util.Scanner;

public class 백준17406_배준성 {
    static int index = 0;
    static int K;
    static int[][] checkArr;
    static int[] resultArray;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        //모든 경우의 수 구할 수 있도록 배열 선언
        int size = 1;
        for (int fac = 2; fac <= K; fac++) {
            size *= fac;
        }
        checkArr = new int[size][K];

        resultArray = new int[K];

        visited = new boolean[K];

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

//순서대로 돌리는게 아니라 돌리는 순서를 조절해서
//최적의 값을 찾아야함
        int[] R = new int[K];
        int[] C = new int[K];
        int[] S = new int[K];

        for (int i = 0; i < K; i++) {
            R[i] = sc.nextInt();
            C[i] = sc.nextInt();
            S[i] = sc.nextInt();
        }

//        재귀로 짰어야 하는데 그러지 않아서
//        순열을 생성해주는 함수 만들어서 2차원 배열에 입력하고 그 값을 인덱스로 사용
//        checkArr[per][i]
        permutation(0);

        int min = Integer.MAX_VALUE;

        for (int per = 0; per < size; per++) {
            int[][] arrNew = new int[N][M];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    arrNew[j][k] = arr[j][k];
                }
            }

            for (int i = 0; i < K; i++) {
                int[][] arrAfter = new int[N][M];

//          배열 복사
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        arrAfter[j][k] = arrNew[j][k];
                    }
                }

                int r = R[checkArr[per][i]];
                int c = C[checkArr[per][i]];
                int s = S[checkArr[per][i]];

//                좀 더 간략화 가능할듯
                int initX = r - s - 1;
                int initY = c - s - 1;
                int finX = r + s - 1;
                int finY = c + s - 1;


                for (int rotate = 0; rotate < s; rotate++) {
                    int dl = finX - initX + 1;

                    for (int d = 1; d < dl; d++) {
                        arrAfter[initX][initY + d] = arrNew[initX][initY + d - 1];
                    }
                    for (int d = 1; d < dl; d++) {
                        arrAfter[initX + d][finY] = arrNew[initX + d - 1][finY];
                    }
                    for (int d = 1; d < dl; d++) {
                        arrAfter[finX][initY + d - 1] = arrNew[finX][initY + d];
                    }
                    for (int d = 1; d < dl; d++) {
                        arrAfter[initX + d - 1][initY] = arrNew[initX + d][initY];
                    }

                    initX++;
                    initY++;
                    finX--;
                    finY--;
                }

                for (int l = 0; l < N; l++) {
                    for (int j = 0; j < M; j++) {
                        arrNew[l][j] = arrAfter[l][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += arrNew[i][j];
                }
                if (min > sum) min = sum;
            }
        }
        System.out.println(min);
    }

//    순열
    public static void permutation(int depth) {
        if (depth == K) {
            for (int i = 0; i < K; i++) {
                checkArr[index][i] = resultArray[i];
            }
            index++;
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                resultArray[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
