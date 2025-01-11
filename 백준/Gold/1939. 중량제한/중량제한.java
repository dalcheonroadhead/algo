import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M, START_POINT, END_POINT;
    static int MAX_WEIGHT;
    static boolean isValid = false;
    static Island [] islands;
    static boolean [] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        islands = new Island [N + 1];
        isVisited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            islands[i] = new Island();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            islands[start].add(end, weight);
            islands[end].add(start, weight);
            MAX_WEIGHT = Math.max(MAX_WEIGHT, weight);
        }
        st = new StringTokenizer(br.readLine());
        START_POINT = Integer.parseInt(st.nextToken());
        END_POINT = Integer.parseInt(st.nextToken());
        System.out.println(binary_search());
    }

    public static int binary_search() {
        int start = 1;
        int end = MAX_WEIGHT;
        while (start <= end) {
            isVisited[START_POINT] = true;
            int mid = start + (end - start)/2;
            f(START_POINT, mid);
//            System.out.println(isValid);
            if(isValid) start = mid + 1;
            else end = mid - 1;
            Arrays.fill(isVisited, false);
            isValid = false;
        }
        return start-1;
    }

    public static void f(int v, int min_weight) {
//        System.out.printf("NOW NODE: %d \n", v);

        // 기저 조건
        if(v == END_POINT) return;
        // 계산
        for(int key : islands[v].keySet()){
            if(!isVisited[key]){
                if(islands[v].get(key) < min_weight) continue; // 최소 중량으로 갈 수 없으면 넘어간다.
                isVisited[key] = true;
//                System.out.printf("NEXT NODE: %d isVisited: %s \n", key, Arrays.toString(isVisited));
                if(isVisited[END_POINT]) isValid = true;
                f(key, min_weight);
                if(isValid) return;
            }
        }
    }
}

class Island {
    HashMap<Integer, Integer> arrivals;

    public Island () {
        arrivals = new HashMap<>();
    }

    public void add (int v, int w) {
        if(arrivals.containsKey(v)){
            if(arrivals.get(v) < w) arrivals.put(v,w);
        }else{
            arrivals.put(v, w);
        }
    }

    public Set<Integer> keySet() {
        return arrivals.keySet();
    }

    public int get(int v) {
        return arrivals.get(v);
    }

    public String toString() {
        return arrivals.toString();
    }
}