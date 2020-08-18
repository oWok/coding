//		//https://www.acmicpc.net/problem/2941
//		String input_croatia;
//		char[] cro_to_alp;
//		int count = 0;
//		Scanner sc = new Scanner(System.in);
//		
//		input_croatia = sc.next();
//		cro_to_alp = new char[input_croatia.length()];
//		
//		for(int i=0;i<input_croatia.length();i++)
//			cro_to_alp[i] = input_croatia.charAt(i);
//		
//		for(int i=0;i<input_croatia.length();i++) {
//			if(i < input_croatia.length()-1) {
//				if(cro_to_alp[i] == 'c') {
//					if(cro_to_alp[i+1] == '-') {
//						count++;
//						i+=1;
//					}
//					else if(cro_to_alp[i+1] == '=') {
//						count++;
//						i+=1;
//					}
//					else {
//						count++;
//					}
//					
//					if(i==input_croatia.length()-1)
//						break;
//				}
//				else if(cro_to_alp[i] == 'd') {
//					if(cro_to_alp[i+1] == 'z') {
//						if(cro_to_alp[i+2] == '=') {
//							count++;
//							i+=2;
//						}
//					}
//					else if(cro_to_alp[i+1] == '-') {
//						count++;
//						i+=1;
//					}
//					else {
//						count++;
//					}
//					
//					if(i==input_croatia.length()-1)
//						break;
//				}
//				else if(cro_to_alp[i] == 'l' || cro_to_alp[i] == 'n') {
//					if(cro_to_alp[i+1] == 'j') {
//						count++;
//						i+=1;
//					}
//					else {
//						count++;
//					}
//					
//					if(i==input_croatia.length()-1)
//						break;
//				}
//				else if(cro_to_alp[i] == 's' || cro_to_alp[i] == 'z') {
//					if(cro_to_alp[i+1] == '=') {
//						count++;
//						i+=1;
//					}
//					
//					if(i==input_croatia.length()-1)
//						break;
//				}
//				else {
//					count++;
//				}
//			}
//			else {
//				count++;
//			}
//		}
//		
//		System.out.println(count);
//		sc.close();

//다시한번 풀어보기
---------------------------------------------------------------------------------------------------