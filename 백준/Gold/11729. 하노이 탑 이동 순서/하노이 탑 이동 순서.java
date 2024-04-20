import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 11729번 [하노이 탑 이동 순서]
* */


public class Main {

    static StringBuilder sb = new StringBuilder();
    static int movingCnt = 0;

    public static void main(String[] args) throws IOException {

        // 1. 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 원판 갯수
        int diskCnt = Integer.parseInt(br.readLine());

        Hanoi(1,2,3, diskCnt);

        System.out.println(movingCnt);
        System.out.println(sb);
    }

    /*
    * Hanoi(출발지, 경유지, 도착지, 옮기는 원판의 넘버링)
    *  -> 먼저 diskNum-1 부터 그 위 원판들 모두를 경유지로 옮긴다. -> 이들은 경유지 자체가 최종 도착지가 됨.
    *  -> 맨 밑의 diskNum을 도착지로 옮긴다.
    *  -> diskNum-1 부터 그 윗부분 모두를 도착지로 옮긴다.
    * */
    public static void Hanoi (int start, int middle, int end, int diskNum) {

        if(diskNum == 0){
            return;
        }

        Hanoi(start, end, middle, diskNum-1);
        sb.append(start).append(" ").append(end).append("\n");
        movingCnt++;
        Hanoi(middle,start,end,diskNum-1);


    }
}