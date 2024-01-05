import java.util.*;
import java.io.*;

public class Main {

    // IOIOI 문제
    // 투포인터로 풀어야 할 듯?
    // 앞에 것, 뒤의 것 계속 움직이기

    static int N ;
    static int S ;

    // 전체 문자열
    static String str;

    // Pn 문자열
    static String Pn;

    public static void main(String[] args) throws IOException {

        // 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = Integer.parseInt(br.readLine());

        str = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2*N+1; i++) {
            if(i%2 == 0){
                sb.append("I");
            }
            else {
                sb.append("O");
            }
        }

        Pn = sb.toString();

        int start = 0;
        int end = 0;
        int PnLoc = 0;

        int validCnt = 0;

        for (int i = 0; i < S; i++) {

            // 현재 투 포인터의 시작 점과 끝 점이 같다.
                // -> start가 표본값과 같으면 end를 출발시킨다.
                // -> 같지 않으면, start, end를 다음 문자를 바라보도록 넘긴다.
            if(start == end){
//                System.out.printf("%s || %s\n", str.charAt(start), Pn.charAt(PnLoc));
             if(str.charAt(start) == Pn.charAt(PnLoc)){

                 PnLoc = (PnLoc+1)%(2*N+1);
                 end++;

             }else {
                 PnLoc = 0;
                 start ++;
                 end ++;
                 i = start;
             }

            }else {
//                System.out.printf("%s || %s\n", str.charAt(end), Pn.charAt(PnLoc));
                // end 포인터가 표본값과 같다. end를 다음 문자로 넘긴다. 표본 조회도 다음 조회로 넘긴다.
                if(str.charAt(end) == Pn.charAt(PnLoc)){
                    end++;
                    PnLoc++;

                    // 확인한 문자열의 길이가 표본값과 같으면
                    if(PnLoc == 2*N+1){
//                        System.out.printf("스타트의 위치: %d\n", start);
                        validCnt++;
                        start++;
//                        System.out.println("바뀐 start의 위치" + start);
                        end = start;
                        i = start;
                        PnLoc = 0;
                    }
                }
                // end 포인터와 표본값이 같지 않다. start를 한칸 올리고 재시작한다.
                else {
                    start ++;
                    end = start;
                    PnLoc = 0;
                    i = start;
                }





            }
        }
        System.out.printf("%d", validCnt);
    }
}