import java.util.*;
import java.io.*;

// 평범한 배낭 12865
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] coins = new int [N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int [] dp = new int [K+1];
        Arrays.fill(dp, K+1);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j < K+1; j++) {
                dp[j] = Math.min(dp[j-coins[i]] + 1, dp[j]);
            }
        }
        System.out.println(dp[K] >= K+1 ? -1 : dp[K]);
    }
}