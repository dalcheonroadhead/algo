import java.util.*;
import java.io.*;

// 14567 선수과목
public class Main {
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            recur(Integer.parseInt(br.readLine()));
            sb.append(answer).append("\n");
            answer = 0;
        }
        System.out.println(sb);
    }

    public static void recur (int cur){
        if(cur == 0) {
            answer ++;
            return;
        }
        if(cur - 1 < 0) return;
        else recur(cur - 1);

        if(cur-2 < 0) return;
        else recur(cur - 2);

        if(cur-3 < 0) return;
        else recur(cur - 3);
    }
}