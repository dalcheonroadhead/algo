import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long [] sum = new long [N+1];
        long [] c = new long [M];
        long cnt = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i-1];
            
            int remainder = (int)(sum[i]%M);

            if(remainder == 0) cnt ++;

            c[remainder]++;

        }

        for (int i = 0; i < M; i++) {
            // 두 개 이상일 경우만 세주면 된다.
            if(c[i] > 1){
                cnt += (c[i]*(c[i] -1)/2);
            }
        }

        System.out.println(cnt);
    }
}