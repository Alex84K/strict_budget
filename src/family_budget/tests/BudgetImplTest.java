package family_budget.tests;

import family_budget.dao.BudgetImpl;
import family_budget.model.Product;
import family_budget.model.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetImplTest {
    List<Purchase> purchaseList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    List<Product> productList1 = new ArrayList<>();
    List<Product> productList2 = new ArrayList<>();
    List<Product> productList3 = new ArrayList<>();
    List<Product> productList4 = new ArrayList<>();

    BudgetImpl budget = new BudgetImpl(purchaseList ,0);

    @BeforeEach
    void setUp() {
        productList = List.of(
                new Product("milk", 1.0, 2),
                new Product("wine", 3.0, 1),
                new Product("bred", 1.5, 3),
                new Product("chocolate", 0.5, 2),
                new Product("salt", 1, 3)
        );
        productList1 = List.of(
                new Product("milk", 1.0, 2),
                new Product("wine", 3.0, 1),
                new Product("bred", 1.5, 3),
                new Product("chocolate", 0.5, 2),
                new Product("salt", 1, 3)
        );
        productList2 = List.of(
                new Product("milk", 1.0, 2),
                new Product("wine", 3.0, 1),
                new Product("bred", 1.5, 3)
        );
        productList3 = List.of(
                new Product("bred", 1.5, 3),
                new Product("chocolate", 0.5, 2),
                new Product("salt", 1, 3)
        );
        productList4 = List.of(
            new Product("sofa", 900, 1)
        );
        purchaseList = List.of(
                new Purchase(1, LocalDate.of(2023,12,02), "Lidl", "Mama", productList),
                new Purchase(2, LocalDate.of(2023,12,11), "Aldi", "Mama", productList2),
                new Purchase(3, LocalDate.of(2023,12,01), "Penny", "Mama", productList1),
                new Purchase(4, LocalDate.of(2023,12,12),  "Action", "Tolik", productList3),
                new Purchase(5, LocalDate.of(2023, 12, 20), "Ikea", "Dad", productList4)
        );
        for (Purchase p : purchaseList) {
            budget.addPurchase(p); //заполняем бюджет
        }
        double b = budget.calcBudget();
        System.out.println(b);
    }

    @Test
    void addPurchase() {
        assertFalse(budget.addPurchase(null));
        assertFalse(budget.addPurchase(purchaseList.get(0)));
        Purchase p = new Purchase(5, LocalDate.of(2023,10,11), "Aldi", "Mama", productList2);
        assertTrue(budget.addPurchase(p));
        double b = budget.calcBudget();
        System.out.println(b);
    }

    @Test
    void calcBudget() {
        assertEquals(945, budget.calcBudget());
    }

    @Test
    void budgetByPerson() {
        assertEquals(36.5, budget.budgetByPerson("Mama"));
    }

    @Test
    void budgetByStore() {
        assertEquals(13.5, budget.budgetByStore("Lidl"));
        assertEquals(8.5, budget.budgetByStore("Action"));
    }

    @Test
    void budgetByPeriod() {
        assertEquals(945, budget.budgetByPeriod(LocalDate.of(2023, 12, 01), LocalDate.of(2023, 12, 21)));
    }

    @Test
    void addMoney() {
        //TODO
        // Допилить...не проходит
        assertEquals(1000, budget.addMoney(1000));
        assertEquals(1500, budget.addMoney(500));
    }

    @Test
    void checkBudget() {
    }

    @Test
    void checkMoney() {
    }
}