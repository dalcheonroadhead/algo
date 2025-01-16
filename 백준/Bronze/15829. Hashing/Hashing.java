import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final long M = 1234567891;
    private static final long r = 31;
    public static void main(String[] args) throws IOException {
        int N;
        String str;
        long sum = 0;
        long  ans;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        for (int i = 0; i < N; i++) {
            int now = str.charAt(i) - 'a' + 1;
            long ri = 1;
            for (int j = 0; j < i; j++) {
                ri *=r;
                ri %=M;
            }
            sum += ((long)now * ri)%M;
        }
        ans = (sum % M);
        System.out.println(ans);
    }
}