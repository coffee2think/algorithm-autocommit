import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];
        int maxSum = 0;
        boolean flag = false;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum == M){
                        maxSum = sum;
                        flag = true;
                        break;
                    } else if(sum < M && sum > maxSum){
                        maxSum = sum;
                    } else if(sum > M){
                        break;
                    }
                }
                if(flag) break;
            }
            if(flag) break;
        }

        System.out.println(maxSum);
        br.close();
    }
}