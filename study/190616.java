import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
	//https://www.acmicpc.net/problem/10250
	// 호실이 같다면 아래층을 선호함
		int floor, room_num, input_count, guest, count;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
//		Scanner sc = new Scanner(System.in);
//		input_count = sc.nextInt();
		
		input_count = Integer.parseInt(br.readLine());
		
		for(int i=0;i<input_count;i++) {
			String input_num = new String();
			
			
			input_num = br.readLine();
			String[] numm = input_num.split(" ");
			
			floor = Integer.parseInt(numm[0]);
			room_num = Integer.parseInt(numm[1]);
			guest = Integer.parseInt(numm[2]);
			
//			floor = sc.nextInt();
//			room_num = sc.nextInt();
//			guest = sc.nextInt();
			
			count = 0;
			for(int j=1;j<=room_num;j++) {
				for(int k=1;k<=floor;k++) {
					count++;
					if(count == guest) {
						//System.out.println(k*100+j);
						bw.write(k*100+j + "\n");
						break;
					}
				}
				
				if(count == guest)
					break;
			}
		}
		bw.flush();
		bw.close();
		
//		sc.close();
	}
}

---------------------------------------------------------------------------------------------------

