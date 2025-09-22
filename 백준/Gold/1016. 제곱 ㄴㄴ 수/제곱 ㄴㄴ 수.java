import java.util.*;
import java.io.*;

// 1016 제곱 ㄴㄴ 수
public class Main {
    static long max, min;
    static boolean [] range; // index의 원래 의미 = index + min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());
        range = new boolean [(int)(max - min) + 1];
        Arrays.fill(range, true);
        exclude_square_number();
        int ans = 0;
        for (int i = 0; i < range.length; i++) {
            if (range[i]) ans++;
        }
        System.out.println(ans);
    }

    public static void exclude_square_number () {
        for (long i = 2; i <= Math.sqrt(max); i++) {
            long square = i*i; // 최대 10^6 x 10^6까지 나올 수 있으므로 
            long quotient = -1; // 몫
            if(min%square == 0) quotient = min/square; // 최소값 부터 나눠지면 최소값이 제곱수로 나눠지는 수이므로 시작점이 됨.
            else quotient = min/square + 1; // 최소값에서 안 나눠지면 최소값을 제곱수로 나눈 몫 + 1이 가장 가까운 제곱수로 나눠지는 수가 되고 거기가 시작점임.
            for(long j = quotient; square*j <= max; j++){
                range[(int)(j*square - min)] = false;
            }
        }
    }
}