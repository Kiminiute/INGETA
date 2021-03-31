package controllers;

import hibernate_utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.tables.Client;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ClientController {
    Scanner scan = new Scanner(System.in);
    private int answer = 0;


    public void addClient(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

    public void removeClient(int clientsId) {
        boolean goodAnswer = false;
        String answer;
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.find(Client.class, clientsId);
            System.out.printf("Ar tikrai pašalinti klientą: [%s]\n [t/n]", client.toString());
            do {
                answer = scan.nextLine();
                if (answer.equalsIgnoreCase("t")) {
                    session.delete(client);
                    transaction.commit();
                    goodAnswer = true;
                } else if (answer.equalsIgnoreCase("n")) {
                    goodAnswer = true;
                } else System.out.println("netinkamas atsakymas, prašom pasirinkti [t] arba [n]");

            } while (!goodAnswer);

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void getClients() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            List<Client> clients = session.createQuery("from Client", Client.class).list();
            clients.forEach(c -> System.out.println(c.toString()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void updateClient(int clientId) {
        int selection =
                getChoice("pakeisti kliento:\n" +
                        "1) pavadinimą \n" +
                        "2) vietovę \n" +
                        "3) darbo pradžią \n" +
                        "4)darbo pabaigą \n" +
                        "5) profesiją \n" +
                        "6) valandinį atlygį\n", 1, 6);
        executeUpdate(selection, clientId);
    }

    private int getChoice(String listOfChoice, int from, int to) {
        System.out.println(listOfChoice);

        if (scan.hasNextInt()) {
            answer = scan.nextInt();
            if (answer < from || answer > to) {
                System.err.println("tokio pasirinkimo nėra");
                getChoice(listOfChoice, from, to);

            }
        } else {
            System.err.println("tokio pasirinkimo nėra");
            scan.next();
            getChoice(listOfChoice, from, to);
        }
        return answer;
    }

    private void executeUpdate(int updateNr, int id) {
        if (updateNr == 1) changeName(id);
        else if (updateNr == 2) changeLocation(id);
        else if (updateNr == 3) changeStartDate(id);
        else if (updateNr == 4) changeEndDate(id);
        else if (updateNr == 5) changeOccupation(id);
        else if (updateNr == 6) changeHourlyRate(id);
    }


    private LocalDate dateInput() {
        System.out.print("įveskite metus: ");
        int year = scan.nextInt();
        System.out.print("įveskite mėnesį: ");
        int month = scan.nextInt();
        System.out.print("įveskite dieną: ");
        int day = scan.nextInt();
        return LocalDate.of(year, month, day);
    }
    private void changeStartDate(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.find(Client.class, id);
            System.out.println("įveskite darbų pradžią: ");
            client.setJobStart(dateInput());
            session.update(client);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void changeEndDate(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.find(Client.class, id);
            System.out.println("įveskite darbų pabaigą: ");
            client.setJobEnd(dateInput());
            session.update(client);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void changeName(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.find(Client.class, id);
            System.out.println("įveskite naują pavadinimą: ");
            client.setCompanyName(scan.next());
            session.update(client);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void changeLocation(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.find(Client.class, id);
            System.out.println("įveskite naują vietovę: ");
            client.setLocation(scan.next());
            session.update(client);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void changeOccupation(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.find(Client.class, id);
            System.out.println("įveskite naują specialybę: ");
            client.setOccupation(scan.next());
            session.update(client);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void changeHourlyRate(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.find(Client.class, id);
            System.out.println("įveskite valandinį atlygį: ");
            client.setLocation(scan.next());
            session.update(client);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
