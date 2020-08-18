import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/3053
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int r = Integer.parseInt(br.readLine().trim());

        bw.write(String.format("%.6f\n%.6f",Math.pow(r,2)*Math.PI, 2*(double)(Math.pow(r,2))));
        bw.flush();
        bw.close();
    }

}
// 택시기하학 + 유클리드기하학에 대해 알아보기
---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/7568
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim());

        int[][] people = new int[count][2];
        int[] rank = new int[count];

        Arrays.fill(rank,1); // 배열초기화



        for(int i=0;i<count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }


        for(int i=0;i<count;i++){
            for(int j=0;j<count;j++){
                if(i != j) {
                    if (people[i][0] < people[j][0] && people[i][1] < people[j][1])
                        rank[i]++;
                }
            }
            bw.write(rank[i] + "\n");
        }

        bw.flush();
        bw.close();

    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/7568
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean check = false;
        int input_num = Integer.parseInt(br.readLine().trim());
        int bunbahap = 0;


        for(int i=1;i<input_num;i++){
            bunbahap = 0;
            int number = i;
            int jare = (int)Math.pow(10,Math.floor((Math.log10(i))));
            for(int j=10;j<=jare;j*=10){
                bunbahap += number % 10;
                number/=10;
            }

            bunbahap += number;

            if(bunbahap + i == input_num){
                bw.write(i + "\n");
                check = true;
                break;
            }
        }


        if(!check)
            bw.write("0" + "\n");


        bw.flush();
        bw.close();

    }

}

---------------------------------------------------------------------------------------------------