import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // given
        int N = Integer.parseInt(br.readLine());

        // 방법1 우선순위큐 : 품질 내림차순 후 가격 오름차순
        PriorityQueue<Miniature> approach1 = new PriorityQueue<>((m1, m2) -> {
            if (m1.getQuality() == m2.getQuality()) {
                return m1.getPrice() - m2.getPrice();
            }

            return m2.getQuality() - m1.getQuality();
        });

        // 방법2 우선순위큐 : 가격 오름차순 후 품질 내림차순
        PriorityQueue<Miniature> approach2 = new PriorityQueue<>((m1, m2) -> {
            if (m1.getPrice() == m2.getPrice()) {
                return m2.getQuality() - m1.getQuality();
            }

            return m1.getPrice() - m2.getPrice();
        });

        // 미니어처 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int quality = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            Miniature miniature = new Miniature(quality, price);

            approach1.add(miniature);
            approach2.add(miniature);
        }

        // 방법1 결과 기록
        sb.append(approach1.poll()).append(" ").append(approach1.poll()).append("\n");
        // 방법2 결과 기록
        sb.append(approach2.poll()).append(" ").append(approach2.poll()).append("\n");

        // then
        System.out.println(sb.toString());
        br.close();
    }

}

class Miniature {
    private int quality;
    private int price;

    public Miniature(int quality, int price) {
        this.quality = quality;
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return quality + " " + price;
    }
}