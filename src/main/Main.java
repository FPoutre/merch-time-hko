import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
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

    public ArrayList<Integer> greedy(ArrayList<Integer> items, int amountToSpend) {
        try {
            int chosen_item = Collections.max(items); // We choose the heaviest item

            if (chosen_item <= amountToSpend) { // If the item fits the backpack
                // Put it in the backpack
                items.remove(chosen_item);
                ArrayList<Integer> res = greedy(items, amountToSpend-chosen_item);
                res.add(chosen_item);
                return res;
            } else {
                // Else, don't use it
                items.remove(chosen_item);
                return greedy(items, amountToSpend);
            }
        } catch (NoSuchElementException e) { // If there are no more items to add
            // Then return nothing
            return new ArrayList<Integer>();
        }

    }

}
