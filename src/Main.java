
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};

        int[] amountProducts = new int[3];


        Scanner scanner = new Scanner(System.in);

        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + "." + " " + products[i] + " " + prices[i] + " " + "руб/шт");
        }

        int sumProducts = 0;
        while (true) {
            int productNumber = 0;
            int productCount = 0;

            System.out.println("Выберите товар и количество или введите 'end' ");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            try {
                String[] amount = input.split(" ");
                if (amount.length != 2) {
                    System.out.println("Вы должны ввести два числа: номер и количество товара. ");
                    continue;
                }
                productNumber = Integer.parseInt(amount[0]) - 1;
                if (productNumber < 0 || productNumber >= products.length) {
                    System.out.println("Вы вышли за пределы, повторите попытку.");
                    continue;
                }
                productCount = Integer.parseInt(amount[1]);
                if (productCount == 0) {
                    int sumSum = prices[productNumber] *  amountProducts[productNumber];
                    sumProducts -= sumSum;
                    amountProducts[productNumber]=0;

                }else{
                int currentPrice = prices[productNumber];
                amountProducts[productNumber] = amountProducts[productNumber] + productCount;
                int sumSum = currentPrice * productCount;
                sumProducts += sumSum;}
            } catch (NumberFormatException e) {
                System.out.println("Ввод должен состоять из чисел=) ");
                continue;
            }


            System.out.println("Ваша корзина: ");
            for (int i = 0; i < products.length; i++) {
                if (amountProducts[i] > 0)
                    System.out.println(products[i] + ": " + amountProducts[i] + " шт " + prices[i] + " руб/шт " + (amountProducts[i] * prices[i]) + " рублей в сумме. ");
            }
            System.out.println("Итого: " + sumProducts + " рублей. ");
        }
    }
}