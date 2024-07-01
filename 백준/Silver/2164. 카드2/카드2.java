import java.io.*;
import java.util.ArrayDeque;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            aq1.add(i+1);
        }

        while (aq1.size() != 1){
            // 맨 위에꺼 하나 빼기
            aq1.poll();
            // 맨 위에꺼 밑으로 넣기
            aq1.add(aq1.poll());
        }

        System.out.println(aq1.peek());

    }
}