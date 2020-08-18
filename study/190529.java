
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) {
		//https://www.acmicpc.net/problem/1152
		String txt;
		Scanner sc = new Scanner(System.in);
//		int count = 1;
		
		txt = sc.nextLine();
		txt = txt.trim();
		
		StringTokenizer count = new StringTokenizer(txt, " "); 
		
		System.out.println(count.countTokens());
		
		sc.close();
	}
}

// StringTokenizer에 대해 알아서 정리
// countTokens -> Stringtokenizer에서 찾은 단어의 수를 출력?

---------------------------------------------------------------------------------------------------------

