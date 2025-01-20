import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static long  A, B;
    static long [] nums;        // 0 = true, 1 = false
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        nums = new long [(int)Math.sqrt(B) + 1];
        prime_shifter();
        System.out.println(counting_almost_prime());
    }

    public static void prime_shifter(){
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= Math.sqrt(Math.sqrt(B)); i++) {
            if(nums[i] == 0){
                for (int j = i*i; j <= Math.sqrt(B); j+=i) {
                    nums[j] = 1;
                }
            }
        }
    }

    public static int counting_almost_prime(){
        int cnt = 0;
        for (long i = 2; i <= Math.sqrt(B); i++) {
            if(nums[(int)i] == 0){
                double j = i*i;
                double acc = 2;
                while(j <= B){
                    if(j >= A) cnt++;
                    j = Math.pow(i, ++acc);
                }
            }
        }
        return cnt;
    }
}
