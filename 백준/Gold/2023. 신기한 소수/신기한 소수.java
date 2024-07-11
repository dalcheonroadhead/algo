import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;


public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs(0,2);
        dfs(0,3);
        dfs(0,5);
        dfs(0,7);

        System.out.println(sb);
    }

    public static void dfs (int depth, int previous) {
        if(depth == n-1){
            sb.append(previous).append("\n");
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (isPrime((previous*10 + i))){
                dfs(depth+1, (previous*10+i));
            }
        }
    }

    public static boolean isPrime(int i){
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if(i%j == 0) return false;
        }
        return true;
    }
}