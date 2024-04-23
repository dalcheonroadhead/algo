import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 10250 ACM 호텔
* */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());


            int a = 0;

            for (int j = 1; j <= W; j++) {
                for (int k = 1; k <= H; k++) {
                    ++a;
                    if(a == N){
                        System.out.println(j<10? (k+"0"+j) : (k+""+j));
                    }
                }
            }

        }

    }
}