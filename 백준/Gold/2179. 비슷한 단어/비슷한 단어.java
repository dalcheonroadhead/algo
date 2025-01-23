import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
    private static class Node {
        HashMap<Character,Node> children;
        int word_idx;

        public Node(int idx){
            children = new HashMap<>();
            this.word_idx = idx;
        }
    }

    private static class Tri {
        Node root = new Node(-1);

        public void insert(String str, int word_idx) {
            Node now = this.root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(!now.children.containsKey(c)) now.children.put(c, new Node(word_idx));
                else {
                    // 현재 들어온 tri의 깊이가 지금까지의 최대값보다 크다.
                    // 현재 확인하려는 Node(다음 Node)를 저장시켰던 단어가 현재 보는 단어랑 같지 않다.
                    if(i >= Max && !str.equals(Words[now.children.get(c).word_idx])) {
                        if(i > Max) {
                            Max = i;
                            ans[0] = now.children.get(c).word_idx;
                            ans[1] = word_idx;
                        } else if (i == Max) {
                            if(now.children.get(c).word_idx < ans[0]) {
                                ans[0] = now.children.get(c).word_idx;
                                ans[1] = word_idx;
                            }
                        }
                    }
                }
                now = now.children.get(c);
            }

        }
    }

    private static int [] ans = new int [2];
    private static String [] Words;
    private static int Max = -1;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Words = new String[N];
        Tri tri = new Tri();
        for (int i = 0; i < N; i++) {
            Words[i] = br.readLine();
            tri.insert(Words[i], i);
        }

        if(Max == -1) {
            ans[0] = 0;
            ans[1] = 1;
        }

        System.out.println(Words[ans[0]]);
        System.out.println(Words[ans[1]]);
    }
}
