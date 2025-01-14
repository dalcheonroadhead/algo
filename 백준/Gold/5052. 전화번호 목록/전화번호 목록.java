import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int T, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            Tri tri = new Tri();
            boolean isValid = true;
            for (int i = 0; i < N; i++) {
                String now = br.readLine();
                if(!tri.insert(now)) isValid = false;
            }
            ans.append(isValid? "YES" : "NO").append("\n");
        }
        System.out.println(ans);
    }
}

class Tri {
    Node root;

    public Tri () {
        root = new Node();
    }

    public boolean insert(String str) {
        Node cur = this.root;   // 초기화
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            cur.child.putIfAbsent(now, new Node());
            cur = cur.child.get(now);
            if(cur.isEnd) return false; // 현재 값을 넣고 있는 도중인데, isEnd = true 되어 있으면 이 문자열은 접두사가 존재한다는 뜻
        }
        cur.isEnd = true;
        if(!cur.child.isEmpty()) return false; // 현재 값을 다 넣었는데, 하위노드가 존재, 이 문자열은 어떤 문자열의 접두사이다.
        return true;
    }

}

class Node {
    HashMap<Character, Node> child;
    boolean isEnd;

    public Node(){
        child = new HashMap<>();
        this.isEnd = false;
    }
}