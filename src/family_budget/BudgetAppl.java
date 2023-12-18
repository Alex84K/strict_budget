package family_budget;

import family_budget.dao.BudgetImpl;
import family_budget.model.Menu;
import family_budget.model.Product;
import family_budget.model.Purchase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BudgetAppl {
    public static void main(String[] args) {

        List<Purchase> purchaseList = new ArrayList<>(); // ???
        List<Product> productList = new ArrayList<>(); // OK

        BudgetImpl budget = new BudgetImpl(purchaseList, 0);
        LocalDate now = LocalDate.now();

        while (true) {
            Menu.printMenu();
            Scanner scanner =new Scanner(System.in);
            System.out.println("Input your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:{
                    System.out.println("Inp budget amount: ");
                    double b = scanner.nextDouble();
                    //??
                    break;
                }
                case 2:{
                    //load data
                    // print
                    break;
                }
                case 3:{
                    System.out.println("Purchases by Stores: ");
                    //metod + print
                    break;
                }
                case 4:{
                    System.out.println("Purchases by Person: ");
                    // print
                    break;
                }
                case 5:{
                    System.out.println("Purchases by Period: ");
                    // print
                    break;
                }
                case 6:{
                    System.out.println("Input amount of purchase: ");
                    // print
                    break;
                }
                case 7:{
                    return;
                }
                default:{
                    System.out.println("Wrong choise!!!");
                }
            }
        }

    }
}
