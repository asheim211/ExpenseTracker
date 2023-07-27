import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private String name;
    private double amount;

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}

public class ExpenseTracker {
    private List<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void displayExpenses() {
        System.out.println("Expense List:");
        System.out.println("-------------");
        for (Expense expense : expenses) {
            System.out.println(expense.getName() + ": $" + expense.getAmount());
        }
        System.out.println("-------------");
    }

    public double calculateTotalExpenses() {
        double total = 0.0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. Display Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter expense name: ");
                    String expenseName = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    Expense expense = new Expense(expenseName, expenseAmount);
                    expenseTracker.addExpense(expense);
                    System.out.println("Expense added successfully!");
                    break;
                case 2:
                    expenseTracker.displayExpenses();
                    break;
                case 3:
                    double totalExpenses = expenseTracker.calculateTotalExpenses();
                    System.out.println("Total expenses: $" + totalExpenses);
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}
