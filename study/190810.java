import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/2798
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int count = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int max = 0;

        int[] card = new int[count];

        StringTokenizer st_card = new StringTokenizer(br.readLine().trim());
        for(int i=0;i<count;i++)
            card[i] = Integer.parseInt(st_card.nextToken());

        for(int i=0;i<count-2;i++){
            for(int j=i+1;j<count-1;j++){
                for(int k=j+1;k<count;k++){
                    int card_sum = card[i] + card[j] + card[k];
                    if(card_sum <= sum){
                        max = max > card_sum ? max : card_sum;
                    }

                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1436
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int ser = Integer.parseInt(br.readLine().trim());
       int i = 665;
       int cnt=0;

       while(true){
           if(String.valueOf(++i).contains("666")){
               cnt++;
           }

           if(cnt==ser)
               break;
       }

       bw.write(String.valueOf(i) + "\n");
       bw.flush();
       bw.close();
    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int chess_x, chess_y;
    static char[][] chess;

    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1436
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        chess_x = Integer.parseInt(st.nextToken());
        chess_y = Integer.parseInt(st.nextToken());

        chess = new char[chess_x][chess_y];

        for(int i=0;i<chess_x;i++){
            String st_chess = br.readLine().trim();
            for(int j=0;j<chess_y;j++)
                chess[i][j] = st_chess.charAt(j);
        }

        int chess_result = 90;

        for(int i=0;i<=chess_x-8;i++){
            for(int j=0;j<=chess_y-8;j++){
                chess_result = Math.min(chess_result, chess_resolv(i,j));
            }
        }

        bw.write(chess_result + "\n");
        bw.flush();
        bw.close();

    }

    private static int chess_resolv(int x, int y){
        int B_result = 0;
        char temp = 'B';//시작이 B일때
						//마지막과 첫번째가 같음

        for(int i=x;i<x+8;i++){
            if(chess[i][y]!=temp)//줄에 첫번째가 temp와 다를때 
                B_result++;

            for(int j=y+1;j<y+8;j++){
                if(chess[i][j]==temp){
                    B_result++;
                    if(temp=='B')
                        temp = 'W';
                    else
                        temp = 'B';
                }
                else
                    temp = chess[i][j];
            }
        }

        int W_result = 0;
        temp = 'W'; // 시작이 W일때

        for(int i=x;i<x+8;i++){
            if(chess[i][y]!=temp) //줄에 첫번째가 temp와 다를때
                W_result++;

            for(int j=y+1;j<y+8;j++){
                if(chess[i][j]==temp){
                    W_result++;
                    if(temp=='W')
                        temp = 'B';
                    else
                        temp = 'W';
                }
                else
                    temp = chess[i][j];
            }


        }

        return Math.min(B_result,W_result);
    }
}

