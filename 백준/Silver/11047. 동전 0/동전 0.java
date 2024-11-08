import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] units = new int [N];

        for(int i = 0; i < N; i++){
            units[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for(int i = N-1; i >= 0; i--){
            if(K/units[i] != 0) {
                ans += K/units[i];
                K = (K%units[i]);
            }
            if(K == 0) break;
        }
        System.out.println(ans);
    }
}
