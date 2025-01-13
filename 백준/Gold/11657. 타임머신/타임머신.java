import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder ans = new StringBuilder();
    static int N, M;
    static int [] a, b;
    static long [ ] c, dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long [N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        a = new int [M]; b = new int [M]; c = new long [M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            long weight =  Long.parseLong(st.nextToken());
            a[i] = start; b[i] = end; c[i] = weight;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                int start   = a[j];
                int end     = b[j];
                long weight  = c[j];
                if(dist[start] != Long.MAX_VALUE){
                    dist[end] = Math.min(dist[end], dist[start] + weight);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int start   = a[i];
            int end     = b[i];
            long weight  = c[i];
            long oldValue = dist[end];

            if(dist[start] != Long.MAX_VALUE){
                dist[end] = Math.min(dist[end], dist[start] + weight);
            }
            
            if(oldValue != dist[end]){
                System.out.println(-1);
                return;
            }
        }

        if (N == 1) {
            System.out.println(dist[1]);
            return;
        }

        for (int i = 2; i <= N; i++) {
            ans.append(dist[i] == Long.MAX_VALUE? -1 : dist[i]).append("\n");
        }
        System.out.println(ans);
    }
}