import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
    static int N;
    static int [] list;
    public static void main(String[] args) throws IOException {
        init();
        finding_median();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int [N];

        for(int i = 0 ; i < N; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void finding_median() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2) -> o2 - o1);
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for(int i = 0; i < list.length; i++) {
            if(max.size() == min.size()) max.add(list[i]);
            else min.add(list[i]);

            while(!max.isEmpty() && !min.isEmpty() && max.peek() > min.peek()) {
                int left    = max.poll();
                int right   = min.poll();
                max.add(right);
                min.add(left);
            }

            sb.append(max.peek()).append("\n");
        }

        System.out.println(sb);
    }
}