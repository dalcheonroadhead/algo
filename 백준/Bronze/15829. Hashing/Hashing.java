import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        String str;
        long sum = 0;
        long  ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        for (int i = 0; i < N; i++) {
            int now = str.charAt(i) - 'a' + 1;
            sum += ((long)now * (long)Math.pow(31,i));
        }
        ans = (sum % 1234567891);
        System.out.println(ans);
    }
}