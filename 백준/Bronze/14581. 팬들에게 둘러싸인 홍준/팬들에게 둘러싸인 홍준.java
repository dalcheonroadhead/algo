import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String id = br.readLine();
        StringBuilder ans = new StringBuilder();
        ans.append(":fan::fan::fan:").append("\n");
        ans.append(":fan:").append(":").append(id).append(":").append(":fan:").append("\n");
        ans.append(":fan::fan::fan:");
        System.out.println(ans);
    }
}