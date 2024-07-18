import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        // S와 E는 B[] 배열의 값이다. 예를 들어 B[i] = 2 라면 오름차순에서 i번째 수는 2라는 소리이다.
        long S = 1;
        long E = K;

        while(S<=E){
            long x = (S+E)/2;
            long loc = 0;
            for (int i = 1; i <= N; i++) {
                long now = Math.min(x/i, N);
                if(now != 0) loc += now;

                else break;
            }
            if(loc >= K) E = x-1;
            else {
                S = x+1;
            }
        }
        System.out.println(S);
    }
}