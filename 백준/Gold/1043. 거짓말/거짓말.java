import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int N, M, know_cnt;
    static boolean [] knowTruth;
    static int [] members;
    static int [] parties;

    public static void main(String[] args) throws IOException {
        init();
        if(know_cnt == 0) return;

        int ans = M;
        for(int i = 1; i < M+1; i++){
            if(knowTruth[find(parties[i])]) ans--;
        }
        System.out.println(ans);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // people
        M = Integer.parseInt(st.nextToken()); // parties
        members = new int[51];
        parties = new int[51];
        knowTruth = new boolean[51];

        for(int i = 1; i < 51; i++) {
            members[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        know_cnt = Integer.parseInt(st.nextToken());
        if (know_cnt == 0) {
            System.out.println(M);
            return;
        }
        for(int i = 0; i < know_cnt; i++){
            knowTruth[Integer.parseInt(st.nextToken())] = true;
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int cnt =  Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            for(int j = 1; j < cnt; j++){
                union(first, Integer.parseInt(st.nextToken()));
            }
            parties[i] = find(first);
        }
    }


    public static void union(int a, int b) {
        int ancestorA = find(a);
        int ancestorB = find(b);
        boolean did_a_know_truth = knowTruth[a];
        boolean did_b_know_truth = knowTruth[b];
        if(did_a_know_truth) {
            members[ancestorB] = ancestorA;
            knowTruth[b] =true;
        }else if (did_b_know_truth){
            members[ancestorA] = ancestorB;
            knowTruth[a] = true;
        }else {
            members[ancestorB] = ancestorA;
        }
    }

    public static int find (int a) {
        // base-case
        if(members[a] == a) return a;
        members[a] = find(members[a]);
        if(knowTruth[members[a]]) knowTruth[a] = true;
        return members[a];
    }
}