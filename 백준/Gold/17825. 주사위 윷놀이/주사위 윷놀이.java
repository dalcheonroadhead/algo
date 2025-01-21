import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    private static class Node {
        int score;
        int blue;
        int red;

        public Node (int score, int blue, int red){
            this.score = score;
            this.blue = blue;
            this.red = red;
        }
    }
    static int ans = 0;
    static Node [] nodes = new Node[33];
    static int [] horse_loc;                                     // 현재 각 말들의 위치
    static boolean [] is_exist;                                  // 해당 노드 번호에 말이 존재하는지
    static int [] dice_num = new int [10];                      // 10개의 주사위 넘버
    static int [] horse_order = new int [10];                   // 각 10개의 주사위 당 움직일 말 번호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            dice_num[i] = Integer.parseInt(st.nextToken());
        }
        init();
        set_order(10, 0);
        System.out.println(ans);
    }

    public static void set_order(int n, int k){
        if(n == k) {
            ans = Math.max(ans, move());
            return;
        }

        for (int i = 0; i < 4; i++) {
            horse_order[k] = i;
            set_order(n, k+1);
        }
    }

    public static int move(){
        int sum_score = 0;
        horse_loc = new int [4];
        is_exist = new boolean[33];
        for (int i = 0; i < 10; i++) {
            int now_horse_num = horse_order[i];
            int now_moving_cnt = dice_num[i];
            int now_horse_location = horse_loc[now_horse_num];
            is_exist[now_horse_location] = false;
            for (int j = 0; j < now_moving_cnt; j++) {
                if(j == 0 && nodes[now_horse_location].blue != -1){
                    now_horse_location = nodes[now_horse_location].blue;
                }else{
                    now_horse_location = nodes[now_horse_location].red;
                }
            }
            if(now_horse_location < 32 && is_exist[now_horse_location]) return -1; // 이미 그 위치에 누군가 있다면, 이번 주기는 안되는 주기 따라서 그냥 탈출
            horse_loc[now_horse_num] = now_horse_location;
            is_exist[now_horse_location] = true;
            sum_score += nodes[now_horse_location].score;
        }
        return sum_score;
    }

    public static void init(){
        for (int i = 0; i <= 20; i++) {
            nodes[i] = new Node(i*2, -1, i+1);
        }
        // 중앙 십자가 표현
        nodes[21] = new Node(13,-1,22);
        nodes[22] = new Node(16,-1,23);
        nodes[23] = new Node(19,-1,24);
        nodes[24] = new Node(25,-1,30); // 중앙 노드
        nodes[25] = new Node(26,-1,24);
        nodes[26] = new Node(27,-1,25);
        nodes[27] = new Node(28,-1,26);
        nodes[28] = new Node(22,-1,29);
        nodes[29] = new Node(24,-1,24);
        nodes[30] = new Node(30,-1,31);
        nodes[31] = new Node(35,-1,20);
        // 파란색 길 추가
        nodes[5].blue = 21;
        nodes[10].blue = 28;
        nodes[15].blue = 27;
        // 도착 노드 추가 및 도착 전 노드 red 수정
        nodes[32] = new Node(0, -1,32);
        nodes[20].red = 32;
    }
}
