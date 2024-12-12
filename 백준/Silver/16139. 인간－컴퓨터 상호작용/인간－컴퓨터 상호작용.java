import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    * b16391 인간-컴퓨터 상호작용
    * 1. 알파벳을 행, 해당 알파벳이 나온 횟수 누적을 열로 표현
    * 2. 알파벳 a가 나온 횟수의 누적합 배열을 Sa라고 할때,
    * 3. Sa[B] - Sa[A-1]은 A ~ B까지의 a가 나온 횟수가 됨.
    *
    * ex)   만약 2-1이라면, a는 구간 전에 한번 등장했다는 뜻임.
    *       A-1번까지의 누적합 = 1 이란 소리임으로
     * */
    public static void main(String[] args) throws IOException {
        int [][] sum;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        sum = new int [26][s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            int w = (int)s.charAt(i) - 97;
            for (int j = 0; j < 26; j++) {
                if(j == w)  sum[j][i+1] = sum[j][i] + 1;
                else        sum[j][i+1] = sum[j][i];
            }
        }

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = (int)st.nextToken().charAt(0) - 97;
            int start   = Integer.parseInt(st.nextToken());
            int end     = Integer.parseInt(st.nextToken());
            sb.append(sum[w][end+1] - sum[w][start]).append("\n");
        }
        System.out.println(sb);
    }
}