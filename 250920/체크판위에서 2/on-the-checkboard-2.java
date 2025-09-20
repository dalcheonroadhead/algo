import java.util.Scanner;
public class Main {
    static int answer = 0;
    static int R,C;
    static char [][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        // Please write your code here.
        recur(grid[0][0], 0,0,0);
        System.out.println(answer);
    }

    public static void recur (char color, int r, int c, int cnt){
        if(cnt > 3) return;
        if(cnt == 3 && r == R-1 && c == C-1) {
            answer++;
            return;
        }
        for(int i = r+1; i < R; i++){
            for(int j = c+1; j < C; j++){
                if(grid[i][j] == color) continue;

                recur(grid[i][j], i,j, cnt+1);
            }
        }
    }
}