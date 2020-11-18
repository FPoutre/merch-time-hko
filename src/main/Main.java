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

        //System.out.println(greedy(items , amountToSpend));
        if (solver(items, amountToSpend)) {
            System.out.println("OUI");
            System.out.println(greedy(items, amountToSpend));
        } else {
            System.out.println("NON");
        }
    }

    public static boolean solver(ArrayList<Integer> items, int amountToSpend) {
        ArrayList<Integer> our_items = greedy(new ArrayList<>(items), amountToSpend);
        ArrayList<Integer> bobs_items = new ArrayList<>(items);
        for (int n : our_items) {
            bobs_items.remove((Object) n);
        }
        bobs_items = greedy(bobs_items, amountToSpend);

        int our_amount = 0;
        int bobs_amount = 0;
        for (int n : our_items) our_amount += n;
        for (int n : bobs_items) bobs_amount += n;

        return our_amount > bobs_amount && our_amount == amountToSpend;
    }

    public static ArrayList<Integer> greedy(ArrayList<Integer> items, int amountToSpend) {
        try {
            ArrayList<Integer> items_copy = new ArrayList<>(items);
            int chosen_item = Collections.max(items_copy); // We choose the heaviest item

            if (amountToSpend == 0) { // If there's no space left in the backpack
                // Then return nothing
                return new ArrayList<>();
            } else if (chosen_item <= amountToSpend) { // If the item fits the backpack
                // Put it in the backpack
                items_copy.remove((Object) chosen_item);
                ArrayList<Integer> res = greedy(items_copy, amountToSpend-chosen_item);
                res.add(chosen_item);
                return res;
            } else {
                // Else, don't use it
                items_copy.remove((Object) chosen_item);
                return greedy(items_copy, amountToSpend);
            }
        } catch (NoSuchElementException e) { // If there are no more items to add
            // Then return nothing
            return new ArrayList<>();
        }

    }

}


/*
System.out.println(amountToSpend);
System.out.println(numberOfItems);
System.out.println(items);
 */