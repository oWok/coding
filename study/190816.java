import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/2108
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim());
        int num_avg = 0, num_range = 0, num_mid = 0, sum = 0; //산술평균, 범위, 최빈값, 중앙값
        int[] number = new int[count + 1];

        // 범위 변수
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        // 배열 초기화하고
        Arrays.fill(number, 0);

        // 마지막 값 고정
        number[count] = 4002;

        // 입력
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            number[i] = Integer.parseInt(st.nextToken());

            // 총합구하기
            sum += number[i];

            // 범위 구하기
            max = max < number[i] ? number[i] : max;
            min = min > number[i] ? number[i] : min;
        }

        Arrays.sort(number);

        int longestFrequentNumberIndex = 0;
        int longestSubsequneceCount = 0;
        int subsequnceCount = 0;

        boolean isSecond = false;

        for (int i = 0; i < count; ++i) {

            subsequnceCount++;

            if (number[i] != number[i + 1]) {

                // 빈도수가 더 큰 경우
                if (longestSubsequneceCount < subsequnceCount) {
                    longestSubsequneceCount = subsequnceCount;
                    longestFrequentNumberIndex = i;
                    isSecond = false;
                }

                // 값 빈도수가 같은 경우
                else if (longestSubsequneceCount == subsequnceCount && !isSecond) {
                    longestFrequentNumberIndex = i;
                    isSecond = true;
                }

                subsequnceCount = 0;
            }
        }

        bw.write(Math.round((double) sum / count) + "\n");
        bw.write(number[count / 2] + "\n");
        bw.write((number[longestFrequentNumberIndex]) + "\n");
        bw.write(max - min + "\n");

        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;


public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/11729

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine().trim());
        int check_count = (int) Math.pow(2, count) -1;

        bw.write(check_count + "\n");
        hanoitop(count, 1, 2, 3);

        bw.flush();
        bw.close();


    }


    public static void hanoitop(int floor_count, int from, int by, int to) throws IOException{
        if(floor_count == 0)
            return ;

        hanoitop(floor_count-1, from, to, by);
        bw.write(from + " " + to + "\n");
        hanoitop(floor_count-1, by, from, to);
    }
}

---------------------------------------------------------------------------------------------------

