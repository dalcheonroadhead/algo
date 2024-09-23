import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(1);
            return;
        }
        int [] dp = new int [N+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        int ans = 1;
        int vip_recent = 0;
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            int vip_now = Integer.parseInt(br.readLine());
            ans *= dp[vip_now - vip_recent-1];
            vip_recent = vip_now;
        }
        ans *= dp[N-vip_recent];
        System.out.println(ans);
    }
}