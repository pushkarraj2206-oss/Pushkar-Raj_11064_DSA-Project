import java.util.Scanner;

public class StockPriceAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] prices = {150, 180, 120, 200, 170, 220, 190};
        int n = prices.length;

        while (true) {

            System.out.println("\n--- STOCK PRICE ANALYZER ---");
            System.out.println("1. Display Prices");
            System.out.println("2. Sort Prices");
            System.out.println("3. Search Price");
            System.out.println("4. Analyze Prices");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    for (int i = 0; i < n; i++)
                        System.out.print(prices[i] + " ");
                    System.out.println();
                    break;

                case 2:
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (prices[j] > prices[j + 1]) {
                                double temp = prices[j];
                                prices[j] = prices[j + 1];
                                prices[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Sorted Prices:");
                    for (double p : prices)
                        System.out.print(p + " ");
                    System.out.println();
                    break;

                case 3:
                    double[] arr = prices.clone();

                    for (int i = 0; i < n - 1; i++)
                        for (int j = 0; j < n - i - 1; j++)
                            if (arr[j] > arr[j + 1]) {
                                double temp = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = temp;
                            }

                    System.out.print("Enter price to search: ");
                    double key = sc.nextDouble();

                    int low = 0, high = n - 1, found = -1;

                    while (low <= high) {
                        int mid = (low + high) / 2;

                        if (arr[mid] == key) {
                            found = mid;
                            break;
                        } else if (arr[mid] < key)
                            low = mid + 1;
                        else
                            high = mid - 1;
                    }

                    if (found != -1)
                        System.out.println("Price Found!");
                    else
                        System.out.println("Price Not Found!");
                    break;

                case 4:
                    double max = prices[0], min = prices[0], sum = 0;

                    for (double p : prices) {
                        if (p > max) max = p;
                        if (p < min) min = p;
                        sum += p;
                    }

                    System.out.println("Highest Price: " + max);
                    System.out.println("Lowest Price: " + min);
                    System.out.println("Average Price: " + sum / n);
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
