import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Tracking(N,0);
		System.out.println(cnt);
	}
	
	public static void Tracking(int N, int count) {
		
		// 기저조건 
		if(N ==0) {
			cnt = count;
			return;
		}
		
		if(N == 1 || N == 2) {
			cnt = -1;
			return;
		}
		
		
		// 유도부분
		if(N>=5) {
			Tracking(N-5,count+1);
			if(cnt == -1) {
				Tracking(N-3, count+1);
				return;
			}
		}
		if(N>=3 && N<5) {
			Tracking(N-3,count+1);
			if(cnt == -1) return;
		}
		
		
	}
}