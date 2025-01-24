import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Java의 입력/출력 속도를 높이기 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 줄 출력
        bw.write("50 49\n");

        // 나머지 줄 출력
        for (int i = 49; i > 0; i--) {
            bw.write(i + " " + (i + 1) + " " + -1 + "\n");
        }

        // 출력 버퍼 플러시
        bw.flush();
    }
}
