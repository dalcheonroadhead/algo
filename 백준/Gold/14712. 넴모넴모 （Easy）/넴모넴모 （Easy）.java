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
            if(isValid()) ans++;
            return;
        }
        
        if(col == C-1) {
            b[row][col] = 1;
            back_tracking(row+1, 0);
            b[row][col] = 0;
            back_tracking(row+1, 0);
        }else{
            b[row][col] = 1;
            back_tracking(row, col+1);
            b[row][col] = 0;
            back_tracking(row, col+1);
        }
    }

    private static boolean isValid(){
        for(int i = 0 ; i < R; i++){
            for(int j = 0; j < C; j++){
                if(OOB(i+1, j+1)) continue;
                if(b[i][j] == 1 && b[i+1][j] == 1 && b[i][j+1] == 1 && b[i+1][j+1] == 1) return false;
            }
        }
        return true;
    }

    private static boolean OOB(int r, int c){
        return r < 0 || c < 0 || r >= R || c >= C;
    }
}