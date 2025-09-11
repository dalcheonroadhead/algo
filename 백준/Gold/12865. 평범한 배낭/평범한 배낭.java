import java.util.*;
import java.io.*;

// 평범한 배낭 12865
public class Main {
    static class Stuff {
        int w;
        int v;

        public Stuff (int w, int v){
            this.w = w;
            this.v = v;
        }
    }
    static Stuff [] stuffs;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stuffs = new Stuff[N+1];

        for (int i = 1; i <= N; i++) {
            st= new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            stuffs[i] = new Stuff(w,v);
        }

        int [] dp = new int [K+1]; // dp[i] = 무게가 i일 때 최대 가치

        for (int i = 1; i <= N; i++) {
            Stuff now = stuffs[i];
            for (int j = K; j >= now.w; j--) {
                dp[j] = Math.max(dp[j - now.w] + now.v , dp[j]);
            }
        }
        System.out.println(dp[K]);
    }
}