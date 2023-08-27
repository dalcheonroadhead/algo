import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        ArrayList<Coordinate> list =new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            list.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }

        Collections.sort(list);

        for (int j = 0; j < list.size(); j++) {
            sb.append(list.get(j).x).append(" ").append(list.get(j).y).append("\n");
        }

        System.out.println(sb);
    }
}

class Coordinate implements Comparable<Coordinate>{
    int x;
    int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Coordinate o) {
        if(this.y == o.y){
            return this.x - o.x;
        }
        return this.y - o.y;
    }
}