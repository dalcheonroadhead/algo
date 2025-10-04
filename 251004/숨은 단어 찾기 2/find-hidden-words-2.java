import java.util.*;

public class Main {
    static int n,m;
    static char [][] alpha;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        alpha = new char[n][m];
        for (int i = 0; i < n; i++) {
            alpha[i] = sc.next().toCharArray();
        }
        // Please write your code here.
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(alpha[i][j] == 'L'){
                    if(garo_s(i,j)) { cnt++;}
                    if(garo_r(i,j)) { cnt++;}
                    if(sero_s(i,j)) {cnt++;}
                    if(sero_r(i,j)) {cnt++;}
                    if(right_dagak_s(i,j)) {cnt++;}
                    if(right_dagak_r(i,j)) {cnt++;}
                    if(left_dagak_s(i,j)) {cnt++;}
                    if(left_dagak_r(i,j)) {cnt++;}
                }
            }
        }
        System.out.println(cnt);
    }

    public static boolean garo_s(int r, int c) {
        return !OOB(r,c) && !OOB(r, c+1) && !OOB(r, c+2) && alpha[r][c] == 'L' && alpha[r][c+1] == 'E' && alpha[r][c+1] == 'E';
    }
    public static boolean garo_r(int r, int c) {
        return !OOB(r,c) && !OOB(r, c-1) && !OOB(r, c-2) && alpha[r][c] == 'L' && alpha[r][c-1] == 'E' && alpha[r][c-2] == 'E';
    }

    public static boolean sero_s(int r, int c) {
        return !OOB(r,c) && !OOB(r+1, c) && !OOB(r+2, c) && alpha[r][c] == 'L' && alpha[r+1][c] == 'E' && alpha[r+2][c] == 'E';
    }

    public static boolean sero_r(int r, int c) {
        return !OOB(r,c) && !OOB(r-1, c) && !OOB(r-2, c) && alpha[r][c] == 'L' && alpha[r-1][c] == 'E' && alpha[r-2][c] == 'E';
    }

    public static boolean right_dagak_s(int r, int c){
        return !OOB(r,c) && !OOB(r+1, c+1) && !OOB(r+2, c+2) && alpha[r][c] == 'L' && alpha[r+1][c+1] == 'E' && alpha[r+2][c+2] == 'E';
    }

    public static boolean right_dagak_r(int r, int c){
        return !OOB(r,c) && !OOB(r-1, c+1) && !OOB(r-2, c+2) && alpha[r][c] == 'L' && alpha[r-1][c+1] == 'E' && alpha[r-2][c+2] == 'E';
    }

    public static boolean left_dagak_s(int r, int c){
        return !OOB(r,c) && !OOB(r+1, c-1) && !OOB(r+2, c-2) && alpha[r][c] == 'L' && alpha[r+1][c-1] == 'E' && alpha[r+2][c-2] == 'E';
    }

    public static boolean left_dagak_r(int r, int c){
        return !OOB(r,c) && !OOB(r-1, c-1) && !OOB(r-2, c-2) && alpha[r][c] == 'L' && alpha[r-1][c-1] == 'E' && alpha[r-2][c-2] == 'E';
    }

    public static boolean OOB(int r, int c){
        return r <0 || c < 0 || r >= n || c >= m;
    }
}