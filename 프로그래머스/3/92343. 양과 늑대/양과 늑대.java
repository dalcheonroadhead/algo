import java.util.*;

class Solution {
    static class Node {
        int left;
        int right;
        
        public Node () {
            this.left   = -1;
            this.right  = -1;
        }
    }
    
    static int [] INFO;
    static Node [] tree = new Node [17];
    public int solution(int[] info, int[][] edges) {
        // 입력 받기
        INFO = info;
        
        for(int i = 0; i < 17; i++){
            tree[i] = new Node();
        }
        
        for(int i = 0; i < edges.length; i++){
            int parent  = edges[i][0];
            int child   = edges[i][1];
            if(tree[parent].left == -1) tree[parent].left = child;
            else tree[parent].right = child;
        }
        return move();
    }
    
    //  bfs 왼, bfs 오, dfs 왼, dfs 오 중 양이 제일 많고, 양 늑대 격차가 제일 작은 것을 선택 
    //  선택한 길이 사용한 노드에 있는 양과 늑대는 모두 제거, 양과 늑대 누적
    public int move(){
        int lamp = 0; int wolf = 0;
        int [][][] cand = new int[4][2][17];
            while(true){
                cand[0] = bfs(true, lamp, wolf);
                cand[1] = bfs(false,lamp, wolf);
                cand[2] = dfs(true, lamp, wolf);
                cand[3] = dfs(false,lamp, wolf);
                Arrays.sort(cand, (o1,o2) -> {
                    if(o1[0][0] == o2[0][0]) return o1[0][1] - o2[0][2];
                    return o1[0][0] - o2[0][0];
                });
                
                if(lamp == cand[0][0][0]) break;
                
                lamp = cand[0][0][0];
                wolf = cand[0][0][1];
                
                for(int i = 0; i < 17; i++){
                    if(cand[0][1][i] == 1) INFO[i] = -1;
                }
                
            }
            
        return 0;
    }
    
    
    // 일련의 방문한 노드 번호, 양과 늑대의 개수 
    public int [][] bfs(boolean is_left_start, int lamp, int wolf) {
        // 초기화
        // 1단 - 양[0][0]과 늑대[0][1]의 개수, 2단 - 방문한 노드: 1, 아니면: 0
        int [][] ans            = new int [2][17];     
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        ans[0][0] = lamp; ans[0][1] = wolf;
        aq1.add(0);
        outer_loop:
        while(!aq1.isEmpty()){
            int qSize = aq1.size();
            for(int i = 0; i < qSize; i++){
                int now = aq1.poll();
                // 양, 늑대 계산
                if(INFO[now] == 1 && ans[0][0] <= ans[0][1]) break outer_loop;
                else{
                    if(INFO[now] == 0) ans[0][0]++;
                    if(INFO[now] == 1) ans[0][1]++;
                }
                int first_visit_node    = is_left_start? tree[now].left : tree[now].right;
                int second_visit_node   = is_left_start? tree[now].right : tree[now].left;
                if(first_visit_node != -1)  {
                    ans[1][first_visit_node]    = 1;
                    aq1.add(first_visit_node);
                }
                if(second_visit_node != -1) {
                    ans[1][second_visit_node]   = 1;
                    aq1.add(second_visit_node);
                }
            }
        }
        return ans;
    }
    
    public int[][] dfs(boolean is_left, int lamp, int wolf){
        // 초기화
        // 1단 - 양[0][0]과 늑대[0][1]의 개수, 2단 - 방문한 노드: 1, 아니면: 0
        int [][] ans            = new int [2][17];
        Stack<Integer> stack    = new Stack<>();
        ans[0][0] = lamp; ans[0][1] = wolf;
        stack.add(0);
        while(!stack.isEmpty()){
            int now = stack.pop();
            if(INFO[now] == 1 && ans[0][0] <= ans[0][1] + 1) break;
            else{
                if(INFO[now] == 0) ans[0][0]++;
                if(INFO[now] == 1) ans[0][1]++;
            }
            int fir = is_left? tree[now].left : tree[now].right;
            int sec = is_left? tree[now].right : tree[now].left;
            if(fir != -1) {
                ans[1][fir] = 1;
                stack.add(fir);
            }
            if(sec != -1) {
                ans[1][sec] = 1;
                stack.add(sec);
            }
            
        }
        return ans;
    }
}