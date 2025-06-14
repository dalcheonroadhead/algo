import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    static int n,r;
    static int [] arr;
    static boolean [] isVisited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int [n];
        isVisited = new boolean [n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutation(0, new int [r]);
        System.out.println(sb);
    }

    public static void permutation (int depth, int [] answer) {
        // base-case
        if(depth == r) {
            for(int temp : answer){
                sb.append(temp).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            answer[depth] = arr[i];
            permutation(depth+1, answer);
            isVisited[i] = false;
        }
    }
}