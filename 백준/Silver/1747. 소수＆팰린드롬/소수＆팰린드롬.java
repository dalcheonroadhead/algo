import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder straight, reverse;
    static boolean [] isPrime = new boolean[2_000_001]; // true = 소수, false = 소수 아닌 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        prime_shifter();
        System.out.println(find_first_palindrome(input));
    }

    private static void prime_shifter(){
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        double root_max = Math.sqrt(2_000_000);
        for (int i = 2; i < root_max; i++) {
            if(isPrime[i]) {
                for (int j = i*i; j <= 2_000_000; j+=i) {
                    if(!isPrime[j]) continue;
                    isPrime[j] = false;
                }
            }
        }
    }

    private static int find_first_palindrome(int input){
        for (int i = input; i < 2_000_001; i++) {
            if (!isPrime[i]) continue;
            if (is_palindrome(i)) return i;
        }
        return -1;
    }

    private static boolean is_palindrome(int num){
        straight    = new StringBuilder(Integer.toString(num));
        reverse     = new StringBuilder(Integer.toString(num)).reverse();
        boolean ans = straight.toString().equals(reverse.toString());
        straight.setLength(0);
        reverse.setLength(0);
        return ans;
    }
}
