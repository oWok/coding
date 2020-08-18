import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1021
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().trim();
        String[] input_numArr = br.readLine().split(" ");

        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);

        int[] numArr = new int[input_numArr.length];

        for(int i=0;i<input_numArr.length;i++)
            numArr[i] = Integer.parseInt(input_numArr[i]);

        LinkedList<Integer> deQ = new LinkedList<>();

        for(int i=1;i<=n;i++)
            deQ.offer(i);

        int cnt = 0, helf = 0;

        for(int i=0;i<m;i++){
            if(deQ.size()%2==0)
                helf = (deQ.size()/2)-1;
            else
                helf = deQ.size()/2;

            int idxDeQ = 0;

            for(int j=0;j<deQ.size();j++){
                if(deQ.get(j)==numArr[i]){
                    idxDeQ = j;
                    break;
                }
            }

            if(helf-idxDeQ>=0){
                for(int j=0;j<idxDeQ;j++) {
                    deQ.addLast(deQ.pollFirst());
                    cnt++;
                }
                deQ.poll();
            }

            else{
                for(int j=0;j<deQ.size()-idxDeQ;j++){
                    deQ.addFirst(deQ.pollLast());
                    cnt++;
                }
                deQ.poll();
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------

