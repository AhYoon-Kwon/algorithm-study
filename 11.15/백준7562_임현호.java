import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Point {
        int r, c, cnt;

        Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dc = {1, -1, 2, -2, 2, -2, 1, -1};

    static boolean[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            int l = sc.nextInt();
            board = new boolean[l][l];
            Queue<Point> q = new LinkedList<>();
            int min = Integer.MAX_VALUE;

            Point from = new Point(sc.nextInt(), sc.nextInt(), 0);
            Point to = new Point(sc.nextInt(), sc.nextInt(), 0);

            board[from.r][from.c] = true;
            q.add(new Point(from.r, from.c, 0));

            while(!q.isEmpty()){
                Point cur = q.poll();

                if(cur.r == to.r && cur.c == to.c) {
                    min = cur.cnt;
                    break;
                }

                for(int i = 0; i < 8; i++) {
                    Point next = new Point(cur.r + dr[i], cur.c + dc[i], cur.cnt + 1);

                    if(next.r >= l || next.r < 0) continue;
                    if(next.c >= l || next.c < 0) continue;
                    if(board[next.r][next.c]) continue;

                    q.add(next);
                    board[next.r][next.c] = true;
                }

            }

            System.out.println(min);
        }

    }
}
