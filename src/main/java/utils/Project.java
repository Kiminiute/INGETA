package utils;

import java.util.Scanner;

public class Project {
    Scanner scanner = new Scanner(System.in);
    int choice;


    public void startApp() {
        while (true) {
            System.out.println("Sveiki atvykę į įdarbinimo agentūrą\n" +
                    "1. Darbuotojam.\n" +
                    "2. Užsakovams\n" +
                    "0. Iseiti");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    employee();
                    break;
                case 2:
                    uzsakovam();
                    break;
                case 0:
                    break;
            }
        }
    }


    private void employee() {
        while (true) {
            System.out.println("1. Registruoti darbuotoja\n" +
                    "2. Priimti darbuotoja\n" +
                    "0. Iseiti");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
//                    addEmployee();
            }
        }
    }

//    private Employee addEmployee() {
//
//    }

    private void uzsakovam() {
        while (true) {
            System.out.println("1. Prideti uzsakyma\n" +
                    "2. Atsaukti uzsakyma\n" +
                    "3. Redaguoti uzsakyma\n" +
                    "0. Iseiti");
            choice = scanner.nextInt();
        }
    }
}