import java.util.*;
import java.io.*;

public class Main {
    static int n,r;
    static boolean [] isVisited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        isVisited = new boolean [n+1];
        permutation(0, new int [n]);
        System.out.println(sb);
        
    }

    public static void permutation(int depth, int [] answer) {
        // base-case
        if(depth == r) {
            for(int i = 0; i < n; i++){
                if(answer[i] == 0) continue;
                sb.append(answer[i]).append(" ");
                
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i < n+1; i++){
            if(isVisited[i]) continue;

            isVisited[i] = true;
            answer[depth] = i; 
            permutation(depth+1, answer);
            isVisited[i] = false;
        }
    }
}