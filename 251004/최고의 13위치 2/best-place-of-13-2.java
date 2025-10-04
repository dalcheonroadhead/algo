import java.util.*;

public class Main {
    static int [][] arr;
    static int n;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        // Please write your code here.
        combination(0,0,0,new int[2][2], new boolean[n][n]);
        System.out.println(ans);
    }

    public static void combination(int startR, int startC, int depth, int [][] chosen, boolean [][] check) {
        if(depth == 2){
            int firR = chosen[0][0];
            int firC = chosen[0][1];
            int secR = chosen[1][0];
            int secC = chosen[1][1];
            int sum = arr[firR][firC] + arr[firR][firC+1] + arr[firR][firC+2] + arr[secR][secC] + arr[secR][secC+1] + arr[secR][secC+2];
            if(ans < sum){
                ans = sum;
            //    System.out.printf("(%d %d) (%d %d) (%d %d) \t, (%d %d) (%d %d) (%d %d) \n", firR,firC,firR,firC+1, firR,firC+2, secR,secC, secR,secC+1, secR,secC+2);
            }
            return;
        }
        
        for(int r = startR; r < n; r++){
            for(int c = startC; c < n-2; c++){
                if(check[r][c] || check[r][c+1] || check[r][c+2]) continue;
                chosen[depth][0] = r;
                chosen[depth][1] = c;
                check[r][c] = check[r][c+1] = check[r][c+2] = true;
                combination( (c == n-3)? r+1 : r, (c == n-3)? 0 : c+1, depth+1, chosen, check);
                check[r][c] = check[r][c+1] = check[r][c+2] = false;
            }
            startC = 0;
        }
    }

    public static boolean OOB (int r, int c){
        return r < 0 || c < 0 || r >= n || c >= n;
    }
}