import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] sum = new int [N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            // 누적합
            if(i == 0){
                sum[i] = Integer.parseInt(st.nextToken());
            }else{
                sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-2;
            int b = Integer.parseInt(st.nextToken())-1;

            sb.append(a < 0? sum[b] : (sum[b]- sum[a])).append("\n");
        }
        System.out.println(sb);
    }
}