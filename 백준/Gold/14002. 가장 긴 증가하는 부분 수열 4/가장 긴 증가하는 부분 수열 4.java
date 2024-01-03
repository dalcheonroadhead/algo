import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int [N+1];

        // 각 인덱스가 해당 arr[i]를 마지막으로 하는 최장 연속 수열의 값들이 저장되어 있음.
        ArrayList<StringBuilder> LIS = new ArrayList<>();

        // index -> arr의 index를 가리킴
        // 값 -> 배열 속 해당 인덱스의 값을 끝으로 하는 최장 연속 수열의 길이
        int [] dp = new int [N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);
        dp[0] = 0;
        LIS.add(new StringBuilder());
        LIS.add(new StringBuilder().append(arr[1]).append(" "));

        for (int i = 2; i <= N; i++) {

            int max = 1;
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if(arr[j] < arr[i]){
                    // 지금까지 알아본 최장 길이보다 더 긴 수열이 가능하다.
                    if(max < dp[j] + 1){

                        // 길이 갱신, 맨 끝값의 index 기록
                        max = dp[j] + 1;
                        maxIndex = j;
                    }
                }
            }
            dp[i] = max;
            // arr[i]를 맨 끝에 넣을 수 있는 최장 연속 수열 +  arr[i]의 값
            LIS.add(new StringBuilder().append(LIS.get(maxIndex)).append(arr[i]).append(" "));


        }

        int maxDP = 0;
        int maxDPIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] > maxDP){
                maxDPIndex = i;
                maxDP = dp[i];
            }
        }

        System.out.printf("%d \n%s", maxDP, LIS.get(maxDPIndex));
    }
}