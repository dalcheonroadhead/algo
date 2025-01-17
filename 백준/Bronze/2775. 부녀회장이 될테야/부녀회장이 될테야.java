import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T,k,n;
    static int [][] apt = new int [15][15];
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 15; i++) {
           apt[0][i] = i;
        }

        for (int a = 1; a < 15; a++) {
            for (int b = 1; b < 15; b++) {
                for (int c = 1; c <= b; c++) {
                    apt[a][b] += apt[a-1][c];
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            ans.append(apt[k][n]).append("\n");
        }
        System.out.println(ans.toString());
    }
}