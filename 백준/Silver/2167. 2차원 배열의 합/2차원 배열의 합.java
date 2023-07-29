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
        int K;


        int [][]arr = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
         st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        for (int I = 0; I < K; I++) {
            st = new StringTokenizer(br.readLine());
            int sum =0;
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int k = (i-1); k <= (x-1); k++) {
                for (int l = (j-1); l <= (y-1); l++) {
                   sum += arr[k][l];
                }
            }
            System.out.println(sum);
        }


    }

}