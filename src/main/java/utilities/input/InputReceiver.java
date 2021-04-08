package utilities.input;

import utilities.dateOperations.DateValidator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class InputReceiver<T> {
    DateValidator dateValidator = new DateValidator();
    private final Scanner input = new Scanner(System.in);

    public Scanner receiveLine() {
        return input;
    }

    public LocalDate receiveDate() {
        System.out.println("Įveskite datą [YYYY-MM-DD]: ");
        String date = input.next();
        if (dateValidator.isCorrectDate(date)){
            return dateValidator.getDateFromString(date);
        } else {
            System.out.println("Blogas datos formatas");
        return receiveDate();
        }
    }


    public Double receiveDouble() {
        if (input.hasNextDouble()) return input.nextDouble();
        else {
            System.out.println("netinkamas formatas, naudokite [XX] [X,XX]");
            input.next();
        }
        return receiveDouble();
    }

    public Integer receiveInteger() {
        return input.nextInt();
    }

    public void printList(List<T> list) {
        for (T t : list) {
            System.out.println(t.toString());
        }
    }


}
