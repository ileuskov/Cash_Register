import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cash_Register a = new Cash_Register(22.44);
        a.count_change();
        a.print_amount();
        a.money_check();
        Scanner s = new Scanner(System.in);
        s.close();


        // 1. create a class
        // 2. constructor with a Big Decimal (from user)
        // 3. A method hidden in the class;
        // 4. Creating an object with a parameter from the user and calling the method of the class;
        // 5. 1 method with an array, second one void with print

        // print it nicely; run while and post-decrement it until 0 to print the amount from euro[i]


    }
}

// add a BigDecimal and classes? Would be great
