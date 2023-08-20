import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  N = Integer.parseInt(br.readLine());

        // 문제에서는 1일 부터 시작하므로, 배열도 0이 아닌 1부터쓰기 위해 N+1 한 것
        // dp의 경우 N+1칸도 N일에 대한 값을 구하기 위해 사용됨으로, N+2부터 시작.
        int [] T = new int[N+1];
        int [] P = new int[N+1];
        int [] dp = new int[N+2];


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 역순으로 뒤에서 부터 쌓아서 온다.
        for (int i = N; i > 0 ; i--) {

            // 10일날 퇴사(N = 10)인데, 10일째에 당일 하루만 일해도 되는 경우 i + T[i]는 11일로 이것도 포함시켜줘야 함.
            // 따라서 N+1로 하는 것
            if( i + T[i] > N+1){
                // default 초기화 이용
                dp[i] = dp[i+1];
            }

            else{
                // 당일 일 안하고, 그 후 일해서 돈 벌었을 때랑, 당일 일하고, 일이 끝난 다음 일 했을 때 중 큰 값을 뽑는다.
                dp[i] = Math.max(dp[i+1], P[i] + dp[i + T[i]] );
            }

        }

        // dp1은 최종적으로 첫 날까지 모두 계산하여, 최적의 값이 나온다. 
        System.out.println(dp[1]);

    }
}