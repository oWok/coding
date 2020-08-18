import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/2775
		int[][] people_count = {{0}};
		
		int count, floor, room_num;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		people_count = new int[15][15];
		
		for(int i=0;i<15;i++) {
			people_count[0][i] = i+1;
			people_count[i][0] = 1;
		}
		
		for(int i=1;i<15;i++) {
			for(int j=1;j<15;j++) {
				for(int k=0;k<=j;k++) {
					people_count[i][j] += people_count[i-1][k];
				}
			}
		}
		
		count = Integer.parseInt(br.readLine());
				
		for(int i=0;i<count;i++) {
			floor = Integer.parseInt(br.readLine());
			room_num = Integer.parseInt(br.readLine());
			
			bw.write(people_count[floor][room_num-1] + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}

---------------------------------------------------------------------------------------------------

