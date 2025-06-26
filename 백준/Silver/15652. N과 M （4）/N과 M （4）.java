import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        duple_permutation(0, 1, new int [M]);
        System.out.println(ans);
    }

    public static void duple_permutation(int depth, int start, int [] answer) {
        // base-case
        if(depth == M) {
            for(int i = 0 ; i < answer.length; i++){
                ans.append(answer[i]).append(" ");
            }
            ans.append("\n");
            return;
        }

        for(int i = start; i <= N; i++){
            answer[depth] = i;
            duple_permutation(depth+1, i, answer);
        }
    }
}