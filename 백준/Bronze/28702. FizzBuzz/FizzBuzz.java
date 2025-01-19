import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int [] nums = new int [3];
    static int ans_index = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < nums.length; i++) {
            String now = br.readLine();
            if (!now.equals("FizzBuzz") && !now.equals("Fizz") && !now.equals("Buzz")) {
                nums[i] = Integer.parseInt(now);
                ans_index = i;
            }
        }

        int ans = nums[ans_index];
        for (int i = ans_index; i < 3; i++) {
            ans++;
        }

        if (ans % 15 == 0) {
            System.out.println("FizzBuzz");
        }else if(ans % 3 == 0) {
            System.out.println("Fizz");
        }else if(ans % 5 == 0) {
            System.out.println("Buzz");
        }else {
            System.out.println(ans);
        }
    }
}
