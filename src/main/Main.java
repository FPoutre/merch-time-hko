import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in) ;

        int amountToSpend = scanner.nextInt();
        scanner.nextLine();
        int numberOfItems = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Integer> items = new ArrayList<>() ;
        for (int i = 0; i < numberOfItems; i++) {
            items.add(scanner.nextInt());
        }

        System.out.println(amountToSpend);
        System.out.println(numberOfItems);
        System.out.println(items);
    }

}
