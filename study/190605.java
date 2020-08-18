////https://www.acmicpc.net/problem/1316
//String[] input_word;
//char[][] word;
//int check, count = 0, check_txt = 0;
//Scanner sc = new Scanner(System.in);
//
//check = sc.nextInt();
//input_word = new String[check];
//word = new char[check][100];
//
//for(int i=0;i<check;i++) {
//	input_word[i] = sc.next();
//	for(int j=0;j<input_word[i].length();j++) {
//		word[i][j] = input_word[i].charAt(j);
//	}
//}
//
//for(int i=0;i<check;i++) {
//	check_txt = 0;
//		if(input_word[i].length() > 2) {
//		for(int j=0;j<input_word[i].length()-2;j++) {
//			for(int k=j+2;k<input_word[i].length();k++) {
//				if(word[i][j] == word[i][k]) {
//					check_txt--;
//					break;
//				}
//			}
//			
//			if(check_txt != 0)
//				break;
//		}
//	}
//		else if(input_word[i].length() == 2) {
//			if(word[i][0] == word[i][1]) {
//				check_txt--;
//				break;
//			}
//				
//		}
//	
//	if(check_txt == 0)
//		count++;
//}
//
//System.out.println(count);
//
//sc.close();