import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    static int n,r;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        duple_combination(0, 0, new int [r]);
        System.out.println(sb);
    }

    public static void duple_combination(int start, int depth, int [] answer) {
        // base-case
        if(depth == r) {
            for(int now : answer){
                sb.append(now+1).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < n; i++){
            answer[depth] = i;
            duple_combination(i, depth+1, answer);
        }
    }
}