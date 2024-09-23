import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int ans = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1];
        dp[0] = -1;
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            int now = Integer.parseInt(br.readLine());
            dp[now] = -1;
        }
        for (int i = 1; i <= N; i++) {
            if(dp[i] == -1) continue;
            if(dp[i-1] == -1) {dp[i] = 1;}
            else if(dp[i-2] == -1) {dp[i] = 2;}
            else dp[i] = dp[i-1] + dp[i-2];

            if(i+1 > N || dp[i+1] == -1) ans *= dp[i];
        }
        System.out.println(ans);
    }
}