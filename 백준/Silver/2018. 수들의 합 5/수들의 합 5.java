import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0, start = 0, end = 0, acc = 0;

        // end++로 갱신된 값은 다음 루프부터 영향을 주므로, N+1을 해야 15까지 온전하게 더할 수 있다.
         while (end <= N){

             if(acc < N){
                 end++;
                 acc += end;
             }else {
                 if (acc == N){
                     cnt++;
                     end++;
                     acc += end;
                 }else {
                     start++;
                     acc -= start;
                 }
             }
         }

        System.out.println(cnt);
    }
}