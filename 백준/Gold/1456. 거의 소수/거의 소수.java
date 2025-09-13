import java.util.*;
import java.io.*;

// 1456 거의 소수
public class Main {
    static Long A, B;
    static long [] nums = new long [(int) Math.pow(10,7) + 1]; // 0 = prime
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        sieve();
        int sum = 0;
        for (long i = 2; i < nums.length; i++) {
            if(nums[(int)i] == 1) continue;   // 소수가 아니면 넘어감
            long temp = i * i;
            while (temp <= B){
                if(temp >= A) sum++;
                if(temp > (B/i)) break;
                temp *= i;
            }
        }
        System.out.println(sum);
    }

    public static void sieve () {
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < Math.sqrt(nums.length); i++) {
            if(nums[i] == 1) continue;
            for (int j = i*i; j < nums.length; j+=i) {
                nums[j] = 1;
            }
        }
    }
}