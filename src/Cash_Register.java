import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cash_Register {
    BigDecimal money_back; //Initial amount of money that has to be returned. The value is given by the user in double but transformed into the Big Decimal to be 100% sure that the decimal numbers match up
    BigDecimal money_copy; // A copy of the same amount of money. To be used later to compare if the amount of money in the end is equal to the one in the beginning
    double[] euro = {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01}; // An array that represent all possible note and coin values of Euro. 500 is 500 euro, 0.01 is 1 euro cent.
    int[] amount_back; // An array that stores amount of how many times each note and coin is given back to user

    Cash_Register(double money_back) { // A constructor that creates an object with the user's amount of money he wants to get back and the new amount array
        this.money_back = BigDecimal.valueOf(money_back); // The user's amount of money is transformed into the Big Decimal and initialized for this object
        this.money_copy = BigDecimal.valueOf(money_back);
        this.amount_back = new int[15];
    }

    public int[] count_change() { // A method that checks if the amount of user's money higher than a note or a coin from an array to subtract this note/coin and mark it in the amount array
        for (int i = 0; i < euro.length; i++) {
            while (this.money_copy.compareTo(BigDecimal.valueOf(euro[i])) >= 0) { // Run this loop as long some amount of money greater than or equal to any of the note or coins in our euro array
                this.money_copy = this.money_copy.subtract(BigDecimal.valueOf(euro[i])); // if there is a match, than subtract it from the amount that has be changed (copy)
                this.amount_back[i]++; // and mark it in the amount array by post-incrementing this number. This number is equal to the euro's note/coin position so it can easily be seen which note or coin was chosen and how many times
            }
        }
        return this.amount_back;
    }


    public void print_amount() { // printing out every number from an amount array. It show which note/coin was chosen and how many times
        System.out.println("Here is how your change will be given back to you: ");
        int[] copy = this.amount_back.clone(); // cloning an amount array. This way we can use it without changing it

        for (int i = 0; i < copy.length; i++) { // this loop runs 15 times and checks if there are some notes' and coins' marked in the amount_back array
            int counter = 0; // creating a temporal variable to control how many times a note/coin appears in the array
            int index = 0; // a temporal variable to control which note/coin is being checked now
            while (copy[i] > 0) { // only run this part if the notes/coins are used in our change amount
                index = i; // if so, we remember its index
                copy[i]--; // post-decrementing its value in the copy array to avoid counting it twice
                counter++; // post-incrementing the counter to remember how many times the coin/note is used
            }

            if (counter > 0 && index <= 8) { // if is a note (0-8 index in the euro array) we print out how many times this note appeared in our money change algorithm
                System.out.println(counter + " time(s) " + (int) euro[index] + " Euro note(s)");
            }
            if (counter > 0 && index > 8) { // if is a coin (9-14 index in the euro array) we print out how many times this coin appeared in our money change algorithm
                System.out.println(counter + " time(s) " + (int) (euro[index] * 100) + " Euro cent(s)");
            }
        }
    }

    public void money_check() { // checking if all the coins and notes in the end really add up into that user's amount in the beginning
        BigDecimal money_check = new BigDecimal("0.0") ; // a Big Decimal value that is going to store all the notes' and coins' value and represent the amount of money they have all together

        for (int i = 0; i < this.amount_back.length; i++) { // this loop runs 15 times and checks if there are some notes' and coins' marked in the amount_back array
            while (this.amount_back[i] > 0) { // if there are indeed some coins and notes used
                money_check = money_check.add(BigDecimal.valueOf(euro[i])) ; // then we add their value (which is stored in the euro array) to the money_check variable
                this.amount_back[i]--; // and post-decrement the amount_back elements so that we don't count them 2 times
            }
        }
        System.out.println("**** **** ***** " + money_check);

        System.out.println("The amount of money you were supposed to get back is: " + this.money_back); // Printing out the initial amount of money
        System.out.println("The amount of money you were actually given is: " + money_check); // Printing out the value of all the bills and coins that were used to represent the initial amount of money
        System.out.println("");

        if(this.money_back.compareTo(money_check) == 0){ // Checking if the values of those 2 variables are correct
            System.out.println("Congratulations! You have received a correct amount of change!");
        }

        else {
            System.out.println("Oh my, oh my! Something is not right here. Where is the money, Lebowski?");
        }

    }
}
