import java.io.*;
import java.util.*;


public class Main {
    static int N, last_one, cnt;
    static int answer = 0;
    static ArrayList<Integer> [] lists;
    static boolean [] check;
    public static void main(String[] args) throws IOException {
        init();
        inorder_traversal(1);
        similar_inorder(1);
        System.out.printf("%d", answer);
    }

    public static void inorder_traversal(int now) {
        if(lists[now].get(0) != -1) inorder_traversal(lists[now].get(0));
        last_one = now;
        if(lists[now].get(1) != -1) inorder_traversal(lists[now].get(1));
    }

    public static void similar_inorder(int now) {
        if(lists[now].get(0) != -1 && !check[lists[now].get(0)]) {
            cnt++;
            similar_inorder(lists[now].get(0));
            cnt++;
        }
        if(lists[now].get(1) != -1 && !check[lists[now].get(1)]) {
            cnt++;
            similar_inorder(lists[now].get(1));
            cnt++;
        }
        if(now == last_one) {
            answer = cnt;
            return;
        } else check[now] = true;
    }


    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N+1];
        check = new boolean[N+1];

        for(int i = 1; i <= N; i++){
            lists[i] = new ArrayList<>();
        }

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