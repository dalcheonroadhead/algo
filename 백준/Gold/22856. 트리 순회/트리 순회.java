import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] lists;
    static int lastNode; // 중위순회 마지막 노드 번호
    static int lastDepth; // 마지막 노드까지의 depth

    public static void main(String[] args) throws IOException {
        init();
        findLastNode(1);          // 1. 중위순회로 마지막 노드 찾기
        findDepth(1, 0);          // 2. 마지막 노드까지의 depth 탐색

        int edgeCount = N - 1;    // 3. 전체 간선 개수
        int answer = edgeCount * 2 - lastDepth;
        System.out.println(answer);
    }

    // 중위순회로 마지막 노드 발견
    static void findLastNode(int now) {
        if (lists[now].get(0) != -1) findLastNode(lists[now].get(0));
        lastNode = now;
        if (lists[now].get(1) != -1) findLastNode(lists[now].get(1));
    }

    // DFS로 lastNode까지의 거리(depth) 측정
    static void findDepth(int now, int depth) {
        if (now == -1) return;
        if (now == lastNode) lastDepth = depth;
        if (lists[now].get(0) != -1) findDepth(lists[now].get(0), depth + 1);
        if (lists[now].get(1) != -1) findDepth(lists[now].get(1), depth + 1);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N+1];

        for(int i = 1; i <= N; i++)
            lists[i] = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int me = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            lists[me].add(left);
            lists[me].add(right);
        }
    }
}
