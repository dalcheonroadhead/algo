import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 0. 값 입력 받기
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        int [] standard = new int [4];
        int [] now = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            standard[i] = Integer.parseInt(st.nextToken());
        }
        // 1. 초기값 세팅
        for (int i = 0; i < P; i++) {
            switch (s.charAt(i)){
                case 'A': now[0]++; break;
                case 'C': now[1]++; break;
                case 'G': now[2]++; break;
                case 'T': now[3]++; break;
            }
        }
        check(standard, now);

        // 2. 슬라이딩 하면서 상태 체크
        for (int i = P; i < S; i++) {
           switch (s.charAt(i -P)){
               case 'A': now[0]--; break;
               case 'C': now[1]--; break;
               case 'G': now[2]--; break;
               case 'T': now[3]--; break;
           }

            switch (s.charAt(i)){
                case 'A': now[0]++; break;
                case 'C': now[1]++; break;
                case 'G': now[2]++; break;
                case 'T': now[3]++; break;
            }

            check(standard, now);
        }

        System.out.println(cnt);
    }

    public static boolean check(int [] standard, int [] now){
        for (int i = 0; i < 4; i++) {
            if(standard[i] > now[i]) return false;
        }
        cnt ++;
        return true;
    }
}