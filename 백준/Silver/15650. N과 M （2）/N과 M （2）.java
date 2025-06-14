import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    static int n,r;
    static boolean [] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        isSelected = new boolean [n+1];
        combination(1, 0);
        System.out.println(sb);
    }

    public static void combination(int start, int depth) {
        // base-case
        if(depth == r){
            for(int i = 1; i < n+1; i++) {
                if(isSelected[i]) sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < n+1; i++){
            isSelected[i] = true;
            combination(i+1, depth+1);
            isSelected[i] = false;
        }
    }
}