package utilities.messages;

import utilities.output.OutputProducer;

public class Message {
    private static OutputProducer out = new OutputProducer();

    public static  void printMainMenu() {
        out.produce("=========== PAGRINDINIS ===========");
        out.produce("Sveiki atvykę į įdarbinimo agentūrą");
        out.produce("1. Darbuotojų meniu");
        out.produce("2. Užsakovų meniu");
        out.produce("0. Baigti programą");
        out.produce("===================================");
    }

    public static void printEmployeeMenu() {
        out.produce("==== Darbuotojų meniu ====");
        out.produce("1. Registuoti darbuotoją.");
        out.produce("2. Priimti darbuotoją.");
        out.produce("0. Grįžti į pagrindinį.");
        out.produce("==========================");
    }

    public static void printClientMenu() {
        out.produce("1. Pridėti užsakymą.");
        out.produce("2. Atšaukti užsakymą.");
        out.produce("3. Redaguoti užsakymą.");
        out.produce("4. Grįžti į pagrindinį.");
    }
    public static void printRemoveClientMenu() {
        out.produce("1. Atšaukti užsąkymą naudojant užsąkymo ID");
        out.produce("2. Pateikti užsąkymų sąrašą");
        out.produce("3. Redaguoti užsakymą.");
        out.produce("4. Grįžti į pagrindinį.");
    }

}
