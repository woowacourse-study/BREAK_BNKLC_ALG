import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long sum = 0;

        String lengthString = br.readLine();
        List<Long> lengths = Arrays.stream(lengthString.split(" "))
                .map(length -> Long.parseLong(length))
                .collect(Collectors.toList());
        String priceString = br.readLine();
        List<Long> prices = Arrays.stream(priceString.split(" "))
                .map(length -> Long.parseLong(length))
                .collect(Collectors.toList());

        long minPrice = prices.get(0);

        for (int i = 0; i < n-1; i++) {
            minPrice = Math.min(minPrice, prices.get(i));
            sum += minPrice * lengths.get(i);
        }
        System.out.println(sum);

    }
}