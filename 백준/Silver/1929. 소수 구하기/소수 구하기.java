import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static boolean [] nums;
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new boolean [M + 1];
        prime_shifter();
        for (int i = N; i <= M; i++) {
            if(nums[i]) ans.append(i).append("\n");
        }
        System.out.println(ans);
    }

    public static void prime_shifter(){
        Arrays.fill(nums, true);
        nums[1] = false;
        nums[0] = false;
        for (int i = 2; i <= Math.sqrt(M); i++) {
            if(nums[i]){
                for (int j = i*i; j <= M; j+=i) {
                    nums[j] = false;
                }
            }
        }
    }
}
