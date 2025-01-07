import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        int N, K;
        int [] orders;
        Queue<Integer> [] indexes = new Queue[101];
        HashSet<Integer> concept = new HashSet<>();

        for (int i = 1; i < 101; i++) {
            indexes[i] = new ArrayDeque();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        orders = new int [K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
              orders[i] = Integer.parseInt(st.nextToken());
              if(i < N) concept.add(orders[i]);
              else {indexes[orders[i]].add(i);}
        }

        for (int i = N; i < K; i++) {
            int now = orders[i];
            indexes[now].poll();

            if(concept.contains(now)) continue;
            if(concept.size() < N) {
                concept.add(now);
                continue;
            }

            int latest_v = 0;
            int latest_i = 0;
            for (int plug_in : concept){

                if(indexes[plug_in].peek() == null) {
                    latest_v = plug_in;
                    break;
                }

                if(!indexes[plug_in].isEmpty() && indexes[plug_in].peek() > latest_i){
                    latest_i = indexes[plug_in].peek();
                    latest_v = plug_in;
                }
            }
            concept.remove(latest_v);
            concept.add(now);
            answer++;
        }
        System.out.println(answer);
    }
}