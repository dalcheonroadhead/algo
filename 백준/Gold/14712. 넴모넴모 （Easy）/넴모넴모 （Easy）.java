import java.util.*;
import java.io.*;

public class Main {
    static int R,C;
    static int ans = 0;
    static int [][] b;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        b = new int [R][C];
        back_tracking(0,0);
        System.out.println(ans);
    }

    public static void back_tracking(int row, int col) {
        if(row == R) {
            ans++;
            return;
        }
        int nr = (col == C-1)? row+1 : row;
        int nc = (col == C-1)? 0 : col+1;
        back_tracking(nr,nc);
        
        if(!isNemoNemo(row,col) && !OOB(row,col)) {
            b[row][col] = 1;
            back_tracking(nr, nc);
            b[row][col] = 0;
        }
    }

    private static boolean isNemoNemo(int r, int c){
        if(OOB(r-1, c-1)) return false;
        if(b[r-1][c] == 1 && b[r-1][c-1] == 1 && b[r][c-1] == 1) return true;
        return false;
    }

    private static boolean OOB(int r, int c){
        return r < 0 || c < 0 || r >= R || c >= C;
    }
}