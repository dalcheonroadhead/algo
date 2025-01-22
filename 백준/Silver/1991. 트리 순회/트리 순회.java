import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    private static class Node {
        int left;
        int right;

        public Node () {

        }
    }
    // 'A' = 65, '.' = 46
    static int N;
    static StringBuilder[] ans = new StringBuilder[3];
    static Node [] nodes = new Node[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = st.nextToken().charAt(0) - 65;
            int left  = st.nextToken().charAt(0) - 65;
            int right = st.nextToken().charAt(0) - 65;

            if(nodes[start] == null) nodes[start] = new Node();
            nodes[start].left = left;
            nodes[start].right = right;
        }
        ans[0] = new StringBuilder();
        ans[1] = new StringBuilder();
        ans[2] = new StringBuilder();
        preorder(0); inorder(0); postorder(0);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
        System.out.println(ans[2]);
    }

    public static void preorder(int now) {
        if(now < 0) return;
        ans[0].append((char)(now + 65));
        preorder(nodes[now].left);
        preorder(nodes[now].right);
    }

    public static void inorder(int now) {
        if(now < 0) return;
        inorder(nodes[now].left);
        ans[1].append((char)(now + 65));
        inorder(nodes[now].right);
    }

    public static void postorder(int now) {
        if(now < 0) return;
        postorder(nodes[now].left);
        postorder(nodes[now].right);
        ans[2].append((char)(now + 65));
    }

}