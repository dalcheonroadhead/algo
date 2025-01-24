import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static long min, max;
    static int [] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());
        nums = new int [(int)(max-min+1)];
        Arrays.fill(nums, 1);
        square_sieve();
        System.out.println(Arrays.stream(nums).sum());
    }

    public static void square_sieve () {
        for (long i = 2; i <= Math.sqrt(max); i++) {
            long square = i*i;
            long delete_start = 0;
            if(min%square != 0) delete_start = (min/square) + 1;
            else delete_start = min/square;

            for (long j = delete_start; j*square <= max; j++) {
                nums[(int)(j*square - min)] = 0;
            }
        }
    }
}