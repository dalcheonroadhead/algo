import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int chicken, cola, beer, consume;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chicken = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cola = Integer.parseInt(st.nextToken());
        beer = Integer.parseInt(st.nextToken());
        consume = cola/2 +  beer;
        System.out.println(Math.min(chicken, consume));
    }
}
