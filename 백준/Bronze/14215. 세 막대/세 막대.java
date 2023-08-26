import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        list.add(Integer.parseInt(st.nextToken()));
        list.add(Integer.parseInt(st.nextToken()));
        list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);

        if(list.get(2) >= list.get(0) + list.get(1)){
            list.set(2 ,(list.get(0) + list.get(1))-1);
        }


        System.out.println(list.stream().reduce(Integer::sum).orElse(-1));

    }
}