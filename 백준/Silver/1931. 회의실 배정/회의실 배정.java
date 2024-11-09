import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] lecture = new int [N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            lecture[i][0] = Integer.parseInt(st.nextToken());
            lecture[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lecture, (a,b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return Integer.compare(a[1], b[1]);
        });

        int end_time = lecture[0][1];
        int cnt = 1;
        for(int i = 1; i < N; i++){
            if(lecture[i][0] < end_time) continue;

            cnt++;
            end_time = lecture[i][1];

        }
        System.out.println(cnt);
    }
}