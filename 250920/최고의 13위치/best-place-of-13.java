import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int [][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for(int i =0; i < N; i ++){
            for(int j = 0; j < N-2; j++){
                ans = Math.max(ans, arr[i][j] + arr[i][j+1] + arr[i][j+2]);
            }
        }

        System.out.println(ans);
    }
}