import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/10989
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim());
        int[] arr_num = new int[count];

        for(int i=0;i<count;i++)
            arr_num[i] = Integer.parseInt(br.readLine().trim());

        Arrays.sort(arr_num);

        for(int i=0;i<count;i++)
            bw.write(arr_num[i] + "\n");

        bw.flush();
        bw.close();
    }
}
//퀵정렬 구현해보기
---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/10814
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim()); // 횟수 입력

        String[][] people = new String[count][2];

        for(int i=0;i<count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<2;j++){
                people[i][j] = st.nextToken();
            }
        }

        Arrays.sort(people, new Comparator<String[]>(){
            public int compare(String[] one, String[] two){
                return Integer.compare(Integer.parseInt(one[0]), Integer.parseInt(two[0]));
            }
        }); // 이부분 이해가 안됨

        for(int i=0;i<count;i++)
            bw.write(people[i][0] + " " + people[i][1] + "\n");


        bw.flush();
        bw.close();

    }
}
//다시 풀어봐야됨