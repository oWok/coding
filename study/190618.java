import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
	//https://www.acmicpc.net/problem/2750
		
		int[] num;
		int input_count, temp;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input_count = Integer.parseInt(br.readLine());
		
		num = new int[input_count];
		
		for(int i=0;i<input_count;i++)
			num[i] = Integer.parseInt(br.readLine());
		
		for(int i=0;i<input_count-1;i++) {
			for(int j=i+1;j<input_count;j++) {
				if(num[i] == num[j]) {
					temp = num[j];
					num[j] = num[input_count];
					input_count--;
				}
				
				if(num[i] > num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			
			}
		}
			
		for(int i=0;i<input_count;i++)
			bw.write(num[i] + "\n");
		
		bw.flush();
		bw.close();
	}
}

---------------------------------------------------------------------------------------------------

