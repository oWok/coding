import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/11718
		String txt;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		while(true) {
			txt = br.readLine().trim();
			if(txt.isEmpty())
				break;
			
			bw.append(txt + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}