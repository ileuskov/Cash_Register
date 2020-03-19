import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cash_Register {
    double money_back; //Initial amount of money that has to be returned. The value is given by the user
    double money_copy; // A copy of the same amount of money. To be used later to compare if the amount of money in the end is equal to the one in the beginning
    double[] euro = {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01}; // An array that represent all possible note and coin values of Euro. 500 is 500 euro, 0.01 is 1 euro cent.
    int[] amount_back; // An array that stores amount of how many times each note and coin is given back to user

    Cash_Register(double money_back) { // A constructor that creates an object with the user's amount of money he wants to get back and the new amount array
        this.money_back = money_back;
        this.money_copy = money_back;
        this.amount_back = new int[15];
    }

    public int[] count_change() { // A method that checks if the amount of user's money higher than a note or a coin from an array to subtract this note/coin and mark it in the amount array
        for (int i = 0; i < euro.length; i++) {
            while (this.money_copy >= euro[i]) { // Run this loop as long some amount of money greater than or equal to any of the note or coins in our euro array
                this.money_copy -= euro[i]; // if there is a match, than subtract it from the amount (copy)
                this.amount_back[i]++; // and mark it in the amount array by post-incrementing this number. This number is equal to the euro's note/coin position so it can easily be seen which note or coin was chosen and how many times
            }
        }
        return this.amount_back;
    }

    public void print_amount() { // printing out every number from an amount array. It show which note/coin was chosen and how many times
        for (int i = 0; i < this.amount_back.length; i++) {
            System.out.println(amount_back[i]); // CHANGE: INSTEAD OF PRINTING 0 and 1. Transfer into real money;

            /*for (int i = 0; i < amount_back.length; i++) {
                while (amount_back[i] > 0) {
                    money_check += euro[i];
                    amount_back[i]--;
                }
             */
        }
    }

    public void money_check() {
        double money_check = 0.0;

        for (int i = 0; i < this.amount_back.length; i++) {
            while (this.amount_back[i] > 0) {
                money_check += euro[i];
                this.amount_back[i]--;
            }
        }
        BigDecimal temp = new BigDecimal(Double.toString(money_check));
        BigDecimal real_check = temp.setScale(2, RoundingMode.CEILING);

        System.out.println("The amount of money you were supposed to be given is: " + this.money_back);
        System.out.println("The amount of money you were given is: " + real_check);
        if (real_check.equals(BigDecimal.valueOf(this.money_back))) {
            System.out.println("Congratulations! You have received a correct amount of change!");
        } else {
            System.out.println("Oh my, oh my! Something is not right here. Where is the money, Lebowski?");
        }

    }
}
