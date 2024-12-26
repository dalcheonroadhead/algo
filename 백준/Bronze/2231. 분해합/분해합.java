import java.io.*;
import java.util.*;

public class Main {

    /*
    *   b_2231 분해합
    *   N <= 1000000임으로 자릿수는 최대 6개가 가능
    *   10번씩 6번 반복, 각 반복은 전부 연속된 것임으로, 10^6의 시간복잡도가 든다.
    *   N을 만들 수 있는 M 중에서 최소값을 찾는다.
    *  */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = Integer.MAX_VALUE;
        int [] nums = new int [6];

        for (int i = 0; i < 10; i++) {
            nums[0] = i;
            for (int j = 0; j < 10; j++) {
                nums[1] = j;
                for (int k = 0; k < 10; k++) {
                    nums[2] = k;
                    for (int l = 0; l < 10; l++) {
                        nums[3] = l;
                        for (int m = 0; m < 10; m++) {
                            nums[4] = m;
                            for (int n = 0; n < 10; n++) {
                                nums[5] = n;
                                int M = nums[0]*100000 + nums[1]*10000 + nums[2]*1000 + nums[3]*100 + nums[4]*10 +nums[5];
                                int sum = M + nums[0] + nums[1]+ nums[2] + nums[3]+nums[4]+ nums[5];
                                if(sum == N) ans = Math.min(ans, M);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans==Integer.MAX_VALUE? 0 : ans);
    }
}