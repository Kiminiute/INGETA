package utilities.input;

import java.util.Scanner;

public class InputReceiver {

    private final Scanner input = new Scanner(System.in);

    public Scanner receiveLine() {
        return input;
    }
}
