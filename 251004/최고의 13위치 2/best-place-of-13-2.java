import java.util.*;

public class Main {
    static int [][] acc;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        acc = new int [n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        // Please write your code here.
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-2; j++){
                acc[i][j] = arr[i][j] + arr[i][j+1] + arr[i][j+2];
            }
        }
        int r,c,v;
        r = c = v = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0; j < n; j++){
                if(v < acc[i][j]) {
                    v = acc[i][j];
                    r = i; c = j;
                }
            }
        }
        answer += v;
        acc[r][c] = -99999;
        acc[r][c+1] = -99999;
        acc[r][c+2] = -99999999;
        if(!OOB(r,c-1)) acc[r][c-1] = -99999;
        if(!OOB(r,c-2)) acc[r][c-2] = -999999;
        
        r = c = v = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0; j < n; j++){
                if(v < acc[i][j]) {
                    v = acc[i][j];
                    r = i; c = j;
                }
            }
        }
        answer += v;
        System.out.println(answer);
    }

    public static boolean OOB (int r, int c){
        return r < 0 || c < 0 || r >= n || c >= n;
    }
}