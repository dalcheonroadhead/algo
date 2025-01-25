import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        System.out.println(euler_phi_f(N));
    }

    public static long euler_phi_f(long n){
        if(n == 1) return 1;
        long ans = n;
        for(long p = 2; p <= Math.sqrt(n); p++){
            if(n%p == 0) ans = ans - (ans/p);
            while (n%p == 0) n /= p;
        }
        if(n > 1) {    // n의 제곱근보다 큰 소수는 최대 하나만 존재한다.
            ans = ans - ans/n;
        }
        return ans;
    }
}
