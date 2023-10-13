import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*  1167 트리의 지름
 * */

/*  문제 풀이 방법
 *  다익스트라를 이용하여 각 정점에서의 다른 정점으로의 거리를 구한다.
 *  최단 거리가 가장 긴 녀석을 출력한다.
 * */

public class Main {

    static int N;
    static ArrayList<int[]> [] lists;
    static boolean [] isVisited;

    static int totalLong = 0;
    static int curLong = 0;
    static int startPoint  = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        lists = new  ArrayList[N+1];


        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()){
                int end = Integer.parseInt(st.nextToken());

                if(end == -1) break;
                else{
                    int weight = Integer.parseInt(st.nextToken());
                    lists[start].add(new int[]{end, weight});
                }
            }
        }

        isVisited = new boolean[N+1];
        vertical(1);
        isVisited = new boolean[N+1];
        vertical(startPoint);
//            System.out.println("출발점: " + i + "현재 최고 지름:" + totalLong);


        System.out.println(totalLong);
    }


    public static void vertical(int start){
        isVisited[start] = true;

        int passCnt = 0;
        for (int i = 0; i < lists[start].size(); i++) {
            int end = lists[start].get(i)[0];
            if(!isVisited[end]) {
                curLong += lists[start].get(i)[1];
                isVisited[end] = true;
                vertical(end);
                curLong -= lists[start].get(i)[1];
                isVisited[end] = false;
            }else{
                passCnt++;
            }
        }
        if(passCnt == lists[start].size()){
            if(totalLong < curLong){
                totalLong = curLong;
                startPoint = start;
            }
        }
    }
}