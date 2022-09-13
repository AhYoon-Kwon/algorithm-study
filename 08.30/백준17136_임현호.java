import java.util.Scanner;

public class 백준17136_임현호 {
    static int[][] arr = new int[10][10];
    static int[] papers = {0, 5,5,5,5,5};
    static int min = Integer.MAX_VALUE;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++)
                arr[i][j] = sc.nextInt();
        }

        DFS(0,0);

        if(min > 25)
            System.out.println(-1);
        else
            System.out.println(min);


    }

    public static void DFS(int r, int c){
        if(r == 10) {
            if(Final() && cnt < min) {
                //System.out.println("cnt " + cnt);
                min = cnt;
            }
            return;
        }

        if(c == 10){
            DFS(r + 1, 0);
            return;
        }

        if(arr[r][c] == 1){
            for(int i = 5; i >= 1; i--){
                if(papers[i] == 0) continue;

                if(SizeCheck(r, c, i)){
                    Cover(r, c, i, 0);
                    cnt++;
                    papers[i]--;
                    DFS(r, c + 1);
                    cnt--;
                    Cover(r, c, i, 1);
                    papers[i]++;
                }
            }
        }
        else {
            DFS(r, c + 1);
        }




    }

    public static boolean SizeCheck(int r, int c, int size){

        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                if(!RangeCheck(i, j) || arr[i][j] == 0){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean RangeCheck(int r, int c){
        if(r >= 0 && r < 10 && c >= 0 && c < 10)
            return true;
        return false;
    }

    public static void Cover(int r, int c, int size, int num){
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                arr[i][j] = num;
            }
        }

    }

    public static boolean Final(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(arr[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;

    }


}
