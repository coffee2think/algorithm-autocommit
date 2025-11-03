import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[5];
        int squareSum = 0;
        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            squareSum += numbers[i] * numbers[i];
        }

        int checkNumber = squareSum % 10;

        System.out.println(checkNumber);
        br.close();
    }
}
