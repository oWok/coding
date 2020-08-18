import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/contest/problem/5430
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            String str1[] = br.readLine().split("");
            int N = Integer.parseInt(br.readLine());
            String str2 = br.readLine();
            ArrayList<String> arr = new ArrayList<>(Arrays.asList(str2.substring(1, str2.length() - 1).split(","))); // "[", "]" 제거 하고 숫자만 list에 저장
            boolean escape = false; // 비엇는지 확인
            boolean isReverse = false; // 전환햇는지 확인
            for (String command : str1) {
                if (escape) break; // 덱이 비엇으면 종료
                switch (command) {
                    case "R":
                        isReverse = !isReverse; // 전환
                        break;
                    default:
                        if (arr.size() == 0 || N == 0) {
                            bw.write("error\n");
                            escape = true;
                        } else {
                            if (isReverse) arr.remove(arr.size() - 1);
                            else arr.remove(0);
                        }
                        break;
                }
            }
            if (!escape) {
                bw.write("[");
                StringBuilder temp = new StringBuilder("");
                if (isReverse) {
                    for (int i = arr.size() - 1; i >= 0; i--) {
                        temp.append(arr.get(i));
                        temp.append(",");
                    }
                } else {
                    for (int i = 0; i < arr.size(); i++) {
                        temp.append(arr.get(i));
                        temp.append(",");
                    }
                }
                if (temp.length() > 0) bw.write(temp.substring(0, temp.length() - 1));
                else bw.write(temp.toString());
                bw.write("]\n");
            }
        }
        bw.flush();
        bw.close();
    }
}

---------------------------------------------------------------------------------------------------

