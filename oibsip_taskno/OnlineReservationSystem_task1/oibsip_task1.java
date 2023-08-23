package oibsip_taskno.OnlineReservationSystem_task1;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}

class Reservation {
    private Map<String, String> reservations;

    public Reservation() {
        this.reservations = new HashMap<>();
    }

    public void makeReservation(String pnr, String details) {
        reservations.put(pnr, details);
    }

    public String getReservationDetails(String pnr) {
        return reservations.get(pnr);
    }

    public void cancelReservation(String pnr) {
        reservations.remove(pnr);
    }
}

public class oibsip_task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User("username", "password");
        Reservation reservation = new Reservation();

        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        if (user.authenticate(inputUsername, inputPassword)) {
            System.out.println("Login successful!");
            System.out.println("Welcome to the Online Reservation System");

            while (true) {
                System.out.println("1. Make Reservation");
                System.out.println("2. Cancel Reservation");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (choice == 1) {
                    System.out.print("Enter Train Number: ");
                    String trainNumber = scanner.nextLine();
                    System.out.print("Enter Date of Journey (DD-MM-YYYY): ");
                    String journeyDate = scanner.nextLine();
                    System.out.print("Enter PNR: ");
                    String pnr = scanner.nextLine();
                    System.out.print("Enter Reservation Details: ");
                    String details = scanner.nextLine();
                    reservation.makeReservation(pnr, details);
                    System.out.println("Reservation successful! Press 'Insert' button.");
                } else if (choice == 2) {
                    System.out.print("Enter PNR to Cancel: ");
                    String pnr = scanner.nextLine();
                    String reservationDetails = reservation.getReservationDetails(pnr);
                    if (reservationDetails != null) {
                        System.out.println("Reservation Details: " + reservationDetails);
                        System.out.print("Confirm cancellation (OK/Cancel): ");
                        String confirmation = scanner.nextLine();
                        if (confirmation.equalsIgnoreCase("OK")) {
                            reservation.cancelReservation(pnr);
                            System.out.println("Reservation canceled successfully.");
                        } else {
                            System.out.println("Cancellation not confirmed.");
                        }
                    } else {
                        System.out.println("Reservation not found for PNR: " + pnr);
                    }
                } else if (choice == 3) {
                    System.out.println("Exiting the Online Reservation System. Thank you!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        } else {
            System.out.println("Login failed. Exiting the system.");
        }

        scanner.close();
    }
}



