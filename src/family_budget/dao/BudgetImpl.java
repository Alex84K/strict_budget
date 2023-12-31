package family_budget.dao;

import family_budget.model.Purchase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BudgetImpl implements Budget{
    List<Purchase> purchaseList;
    double budget;

    public BudgetImpl(List<Purchase> purchaseList, double budget) {
        this.purchaseList = new ArrayList<>(); // возможен HashSet, ThreeSet
        this.budget = budget;
    }

    @Override
    public boolean addPurchase(Purchase purchase) {
        //проверка на уникальность
        // не добавл пустая покупка
        if (purchase == null || purchaseList.contains(purchase)) {
            return false;
        }
        return purchaseList.add(purchase);
    }

    @Override
    public double calcBudget() {
        return purchaseList.stream()
                .mapToDouble(Purchase::getCost)
                .sum();
    }

    @Override
    public double budgetByPerson(String person) {
        return purchaseList.stream()
                .filter(purchase -> purchase.getPerson().equals(person))
                .peek(p -> System.out.println(p))
                .mapToDouble(Purchase::getCost)
                .sum();
    }

    @Override
    public double budgetByStore(String store) {
        return purchaseList.stream()
                .filter(purchase -> purchase.getStore().equals(store))
                .mapToDouble(Purchase::getCost)
                .sum();
    }

    @Override
    public double budgetByPeriod(LocalDate from, LocalDate to) {
        return purchaseList.stream()
                .filter(purchase -> purchase.getDate().isAfter(from.minusDays(1)) && purchase.getDate().isBefore(to))
                .mapToDouble(Purchase::getCost)
                .sum();
    }

    @Override
    public double addMoney(double money) {
        return this.budget + money;
    }

    @Override
    public boolean checkBudget(Purchase purchase) {
        return budget >= calcBudget();
    }

    @Override
    public double checkMoney(Purchase purchase) {
        return budget - calcBudget();
    }

    @Override
    public double getBudget() { /// Допилить
        return budget;
    }
}
