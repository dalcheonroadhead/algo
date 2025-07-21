import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 폴더 정리 (small)
* 1. 폴더와 파일 입력으로 unionfind 만들기 -> 경로 압축하지 말기
* 2. 파일 입력 시 부모 노드 타고 가며 + 1씩 다 해주기
* */

public class Main {
    static HashMap<String, Integer> folders = new HashMap<>(); // <폴더_이름, 폴더 번호>
    static HashMap<String, Integer> files = new HashMap<>(); // <파일_유형, 파일 번호>
    static HashMap<Integer, HashSet<Integer>> per_folder_file_cnt = new HashMap<>(); // <폴더 번호, 보유 파일 번호>
    static int [] parents; // index  = 폴더 번호, value = 부모 폴더 번호 (처음엔 자기 자신을 가리킴)
    static int [] accFiles; // 자기 하위 누적 파일 수
    static int N,M,Q; // 각각 폴더의 개수, 파일의 개수
    static int folder_counter = 1;
    static int file_counter = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int [N+2];
        accFiles = new int [N+2];
        for(int i = 1; i <= N+1; i++){
            parents[i] = i;
            per_folder_file_cnt.put(i, new HashSet<>());
        }
        String [][] inputOrders = new String[N+M][3];
        for (int i = 0; i < N+M; i++){
            inputOrders[i] = br.readLine().split(" ");
        }

        Arrays.sort(inputOrders, (row1, row2) -> {
            int row1_order = Integer.parseInt(row1[2]);
            int row2_order = Integer.parseInt(row2[2]);
            return row2_order - row1_order;
        });

        for (int i = 0; i < inputOrders.length; i++) {
            if(inputOrders[i][2].equals("1")) setParents(inputOrders[i][0], inputOrders[i][1]);
            else setAccFiles(inputOrders[i][0], inputOrders[i][1]);
        }

        Q = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < Q; i++){
            String [] paths = br.readLine().split("/");
            int folder_num = folders.get(paths[paths.length-1]);
            answer.append(per_folder_file_cnt.get(folder_num).size()).append(" ").append(accFiles[folder_num]).append("\n");
        }
        System.out.println(answer);
    }

    public static void setParents(String parent, String child){
        if(folders.getOrDefault(parent, 0) == 0){
            folders.put(parent, folder_counter++);
        }
        if(folders.getOrDefault(child, 0) == 0) {
            folders.put(child, folder_counter++);
        }
        int p_num = folders.get(parent);
        int c_num = folders.get(child);
        parents[c_num] = p_num;
    }

    public static void setAccFiles(String folder, String file){
        if(files.getOrDefault(file, 0) == 0){
            files.put(file, file_counter++);
        }
        int folder_num = folders.get(folder);
        int file_num = files.get(file);
        doAcc(folder_num, file_num);
    }


    public int find(int a){
        if(a == parents[a]) return parents[a]; // 부모가 자기자신이라면 그것을 return
        else return find (parents[a]);
    }

    public static void doAcc(int child, int file_type_num){
        accFiles[child]++;
        per_folder_file_cnt.get(child).add(file_type_num);
        if(child == parents[child]) return;
        doAcc(parents[child], file_type_num);
    }
}
