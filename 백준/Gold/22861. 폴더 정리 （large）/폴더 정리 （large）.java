import java.io.*;
import java.util.*;

/*
* 폴더 정리 (Large)
* 1. 폴더와 파일 입력으로 unionfind 만들기 -> 경로 압축하지 말기
* 2. 파일 입력 시 부모 노드 타고 가며 + 1씩 다 해주기
*/

public class Main {
    static class Folder {
        HashSet<String> subFolders;
        HashSet<String> subFiles; // 직속 파일만 저장

        public Folder (){
            subFolders = new HashSet<>();
            subFiles = new HashSet<>();
        }
    }
    static int N,M,K,Q; // 폴더 수, 파일 수, 이동 명령어 수, 프린트 명령어
    static String [][] relation_order;
    static String [][][] move_order;
    static String [] print_order;
    static HashMap<String, Folder> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        input();
        for (String [] order : relation_order){
            if(order[2].equals("1")) makeDir(order[0], order[1]);
            else addFile(order[0], order[1]);
        }
        for (String [][] order : move_order){
            moveFolder(order[0], order[1]);
        }
        StringBuilder answer = new StringBuilder();
        HashSet<String> all_types = new HashSet<>();
        int [] sum = new int[1];
        for(String order : print_order){
            all_types.clear();
            sum[0] = 0;
            calculate(order, sum, all_types);
            answer.append(all_types.size()).append(" ").append(sum[0]).append("\n");
        }
        System.out.println(answer);
    }

    public static void makeDir(String parent, String child){
        tree.compute(parent, (k,ov)-> ov == null? new Folder() : ov);
        tree.compute(child, (k,ov) -> ov == null? new Folder() : ov);
        tree.get(parent).subFolders.add(child);
    }

    public static void addFile(String folder, String file){
        tree.get(folder).subFiles.add(file);
    }

    public static void moveFolder(String [] fromPaths, String [] toPaths){
        Folder from = tree.get(fromPaths[fromPaths.length-1]);
        Folder to = tree.get(toPaths[toPaths.length-1]);
        // from 폴더 자체를 원래 경로에서 지우기
        tree.get(fromPaths[fromPaths.length-2]).subFolders.remove(fromPaths[fromPaths.length-1]);
        // from 폴더의 폴더들과 파일들을 to 폴더에 쏟기
        to.subFolders.addAll(from.subFolders);
        to.subFiles.addAll(from.subFiles);
        // from 폴더 비우기
        from.subFolders.clear();
        from.subFiles.clear();
    }

    public static void calculate(String folder, int [] sum, HashSet<String> set){
        Folder now = tree.get(folder);
        sum[0] += now.subFiles.size();
        set.addAll(now.subFiles);
        for (String sub : now.subFolders){
            calculate(sub, sum, set);
        }
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relation_order = new String[N+M][3];
        for(int i = 0; i < N+M; i++){
            relation_order[i] = br.readLine().split(" ");
        }
        Arrays.sort(relation_order, (row1, row2) -> Integer.parseInt(row2[2]) - Integer.parseInt(row1[2]));
        K = Integer.parseInt(br.readLine());
        move_order = new String[K][2][N+1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String [] to = st.nextToken().split("/");
            String [] from = st.nextToken().split("/");
            move_order[i][0] = to;
            move_order[i][1] = from;
        }
        Q = Integer.parseInt(br.readLine());
        print_order = new String[Q];
        for (int i = 0; i < Q; i++) {
            String [] path = br.readLine().split("/");
            print_order[i] = path[path.length-1];
        }
    }
}