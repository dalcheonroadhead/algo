import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 2018번 수들의 합 5
 * */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        // a    -> 왼 pointer, b -> 오 포인터,
        // acc  -> 축적값 (맨 처음에 더해지는 1은 더했다.)
        // cnt  -> N = N 즉 자기 자신으로 구간합이 되는 경우는 미리 세고 간다.
        int a = 0, b = 0, acc = 0, cnt = 1;

        // 오른쪽 포인터가 N이 되는 순간 구간합은 무조건 N보다 커진다. 그래서 셀 필요가 없다.
        while (b != N) {

            if(acc < N){
                b++;
                acc +=b;
            }

            else if(acc == N) {
                cnt ++;
                b ++;
                acc += b;
            }

            else {
                acc -= a;
                a++;
            }
        }

        System.out.println(cnt);

    }
}