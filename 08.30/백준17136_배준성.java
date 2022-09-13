import java.util.Scanner;

public class 백준17136 {
    static boolean[][] map;
    static int[] cnt = {5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new boolean[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    map[i][j] = true;
                }
            }
        }

        DFS(0, 0, 0);

        if(ans == Integer.MAX_VALUE)
            ans = -1;

        System.out.println(ans);
    }

    public static void DFS(int x, int y, int now) {
        if (now >= ans) return;

        if (x >= 9 && y > 9) {
            if (ans > now) ans = now;
            return;
        }

        if (y > 9) {
            DFS(x + 1, 0, now);
            return;
        }

        //1 발견하면 최대 사이즈 찾음
        if (map[x][y]) {
            all:
            for (int n = 4; n >= 0; n--) {
//              해당 종이 있는지 확인
                if (cnt[n] <= 0)
                    continue all;

                for (int c = 0; c <= n; c++) {
                    for (int r = 0; r <= n; r++) {
                        if(x+r > 9 || y+c > 9)
                            continue all;
                        if (!map[x + r][y + c])
                            continue all;
                    }
                }
                //종이 붙이기, map을 0로 만들고, 사용한 종이 종류 하나 줄임
                Attach(x, y, n);

                DFS(x, y + 1, now + 1);

                //종이 다시 뗌
                Detach(x, y, n);
            }
        } else {
            DFS(x, y + 1, now);
        }
    }

    //    종이 붙어
    public static void Attach(int x, int y, int n) {
        for (int c = 0; c <= n; c++) {
            for (int r = 0; r <= n; r++) {
                map[x + r][y + c] = false;
            }
        }
        cnt[n]--;
    }

    //    종이 떼
    public static void Detach(int x, int y, int n) {
        for (int c = 0; c <= n; c++) {
            for (int r = 0; r <= n; r++) {
                map[x + r][y + c] = true;
            }
        }
        cnt[n]++;
    }
}
