//		//https://www.acmicpc.net/problem/10809
//		String input_txt;
//		int count, check;
//		char[] txt;
//		Scanner sc = new Scanner(System.in);
//		
//		input_txt = sc.next();
//		
//		//string_length = input_txt.length();
//		
//		txt = new char[input_txt.length()];
//				
//		for(char c='a';c<='z';c++) {
//			count = 0;
//			check = -1;
//			for(int i=0;i<input_txt.length();i++) {
//				txt[i] = input_txt.charAt(i);
//				if(txt[i] == c) {
//					System.out.printf("%d ", count);
//					check = 0;
//					break;
//				}
//				count++;
//			}
//			
//			if(check == -1) {
//				System.out.printf("-1 ");
//			}
//		}
//		
//		sc.close();

---------------------------------------------------------------------------------------------------

//		//https://www.acmicpc.net/problem/2675
//
//		String[] input_txt;
//		char[][] txt = new char[1000][8];
//		int[] input_count;
//		int count;
//		
//		Scanner sc = new Scanner(System.in);
//		
//		count = sc.nextInt();
//		input_count = new int[count];
//		input_txt = new String[count];
//		
//		for(int i=0;i<count;i++) {
//			input_count[i] = sc.nextInt();
//			input_txt[i] = sc.next();
//			for(int j=0;j<input_txt[i].length();j++) {
//				txt[i][j] = input_txt[i].charAt(j);
//			}
//		}
//		
//		for(int i=0;i<count;i++) {
//			for(int j=0;j<input_txt[i].length();j++) {
//				for(int k=0;k<input_count[i];k++) {
//					System.out.printf("%c", txt[i][j]);
//				}
//			}
//			System.out.println();
//		}
//				
//		sc.close();