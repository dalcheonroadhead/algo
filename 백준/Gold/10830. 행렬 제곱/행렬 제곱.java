import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int n;
    static long b;
    static long [][] base_a;
    public static void main(String[] args) throws IOException {
        init();
        if(b == 1) {
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++){
                    System.out.print(base_a[i][j]%1000 + " ");
                }
                System.out.println();
            }
            return;
        }
        long [][] ans = divideAndConquer(b);

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

     public static void init() throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         b = Long.parseLong(st.nextToken());
         base_a = new long [n][n];

         for(int i = 0; i < n; i++){
             st = new StringTokenizer(br.readLine());
             for(int j = 0; j < n ; j++){
                 base_a[i][j] = Long.parseLong(st.nextToken());
             }
         }
     }

     public static long[][] divideAndConquer(long exp){
         // base-case
         if(exp == 1) {
             return base_a;
         }
         long [][] result;
         long [][] half = divideAndConquer(exp/2);
         result = calculate(half, half);
         if(exp %2 != 0) {
             result = calculate(result, base_a);
         }
         return result;
     }


     public static long [][] calculate(long [][] a, long [][] b){
        long [][] ans = new long[n][n];
            for(int i =0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        ans[i][j] += (a[i][k]*b[k][j])%1000;
                    }
                    ans[i][j] %= 1000;
                }
            }
            return ans;
     }
}