import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int max = 0;
        List<Point> sharks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (sc.nextInt() == 1)
                    sharks.add(new Point(i, j));
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int temp = Integer.MAX_VALUE;
                Point cur = new Point(i, j);
                for(int n = 0; n < sharks.size(); n++) {
                    temp = Math.min(temp, dis(cur, sharks.get(n)));
                }
                max = Math.max(max, temp);
            }
        }

        System.out.println(max);


    }

    public static int dis(Point p1, Point p2) {
        int x = Math.abs(p1.x - p2.x);
        int y = Math.abs(p1.y - p2.y);
        return x + y - Math.min(x, y);
    }


}
