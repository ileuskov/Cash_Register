import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double money = Double.parseDouble(s.nextLine());
        s.close();

        double money_copy = money;

        double[] euro = {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
        int[] amount = new int[15];

        for(int i = 0; i< euro.length; i++){
            while(money_copy >= euro[i]){
                money_copy -= euro[i];
                amount[i]++;
            }
        }
        for(int i = 0; i<amount.length; i++){
            System.out.println(amount[i]);
        }
        double money_check = 0.0;
        for(int i = 0; i<amount.length; i++){
            while(amount[i] > 0){
                money_check += euro[i];
                amount[i]--;
            }
        }
        System.out.println(money_check);

        if(money == money_check){
            System.out.println("Congratulations!");
        }
    }
}

// add a BigDecimal and classes? Would be great
