import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our little cash register! We can sort your change in the most optimal way. Please enter how much money in Euro would you like to get back?");
        System.out.println("Example: 10.55 or any number with 2 integers after decimal point: (x)x.xx");

        Scanner s = new Scanner(System.in);
        Double number = s.nextDouble();
        s.close();

        System.out.println("\n***** *****\n");
        Cash_Register a = new Cash_Register(number);
        a.count_change();
        a.print_amount();
        System.out.println("\n***** *****\n");
        a.money_check();
    }
}

