package utilities.input;

import java.time.LocalDate;
import java.util.Scanner;

public class InputReceiver {

    private final Scanner input = new Scanner(System.in);

    public Scanner receiveLine() {
        return input;
    }
    public LocalDate receiveDate(){
        System.out.print("įveskite metus[YYYY]: ");
        int year = input.nextInt();
        System.out.print("įveskite mėnesį[MM]: ");
        int month = input.nextInt();
        System.out.print("įveskite dieną[DD]: ");
        int day = input.nextInt();
        return LocalDate.of(year, month, day);
    }
}
