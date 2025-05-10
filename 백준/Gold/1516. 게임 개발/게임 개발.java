import java.util.*;
import java.io.*;

public class Main {

    static class Building {
        int index;
        int time;

        public Building(int i, int t){
            this.index = i;
            this.time = t;
        }
    }
    static int N;
    static ArrayList<Building> [] lists;
    static int [] inDegree;
    static int [] completeTime;
    
    public static void main(String[] args) throws Exception {
        init();
        topological_graph();
        print();
        
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList [N+1];
        inDegree = new int [N+1];
        completeTime = new int [N+1];

        for(int i = 1; i <= N; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 1; i<= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 지금 짓는 건물의 번호
            int now = i;
            int time = Integer.parseInt(st.nextToken());
            completeTime[now] = time;

            // 인접리스트 초기화 (후행정점의 배열에 선행 정점들을 Building class로 저장) 
            while(st.hasMoreTokens()){
                // 먼저 지어져야 하는 건물의 번호
                int prev = Integer.parseInt(st.nextToken());
                if(prev == -1) break;
                lists[prev].add(new Building(now, time));
                inDegree[now]++;
            }
        }
    }

    public static void topological_graph() {
        PriorityQueue<Building> pq = new PriorityQueue<>((o1, o2) -> (o1.time - o2.time));
        // 초기값 넣어주기
        // 진입 차수 배열인 inDegree가 -1 이면 이미 방문한 배열임.
        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0){
                pq.add(new Building(i, completeTime[i]));
                inDegree[i] = -1;
            }
        }

        while(!pq.isEmpty()) {
            Building prev = pq.poll();

            for(int i = 0; i < lists[prev.index].size(); i++){
                Building now = lists[prev.index].get(i);
                inDegree[now.index]--;

                if(inDegree[now.index] == 0) {
                    inDegree[now.index] = -1;
                    completeTime[now.index] += prev.time;
                    pq.add(new Building(now.index, completeTime[now.index]));
                }
            }
        } 
    }

    public static void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i < N + 1; i ++){
            bw.write(String.valueOf(completeTime[i]) + "\n");
        }

        bw.flush();
        bw.close();
    }
}