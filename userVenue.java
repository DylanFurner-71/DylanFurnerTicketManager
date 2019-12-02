import java.util.Scanner;
import java.util.LinkedList;
import java.util.Vector;
public class userVenue {
    LinkedList<ticket> cart = new LinkedList<ticket>();
    Scanner in;
    boolean nextUser;
    venue v1 = new venue();
    Vector<user> users = new Vector<user>();
    user user1 = new user();
    userVenue(Scanner in1){
        in = in1;
        in1.useDelimiter("\\n");
        nextUser = false;

    }
    private void buyTickets(){
        System.out.println("Which movie would you like to see?");
        Vector<String> movieNames = v1.getMovieNames();
        System.out.print(movieNames);
        System.out.println("");
        String movieChoice = in.next();
        if (movieChoice == ""){
            while (movieChoice == ""){
                movieChoice = in.next();
            }
        }
        System.out.println("Which time would you like to see the movie?");
        Vector<String> times = v1.getShowTimes();
        System.out.print(times);
        System.out.println("");
        String movieTime = in.next();
        System.out.println("How many tickets would you like to buy?");
        v1.printTheatre(movieChoice, movieTime);
        int numTicks = in.nextInt();
        while (numTicks < 0 || numTicks > 16) {
            System.out.println("Invalid input. Please enter a valid number");
            numTicks = in.nextInt();
        }
        System.out.println("Seats are numbered from 0 to capacity of the theater - 1, in this case 16");
        if (numTicks == 1) {
                System.out.println("Which seat would you like to reserve?");
                int seatNum = in.nextInt();
                System.out.println(seatNum);
                if (v1.isAvailable(movieChoice, movieTime, seatNum)){
                    cart.push(v1.getTicket(movieChoice, movieTime, seatNum));
                } else {
                    while (!v1.isAvailable(movieChoice, movieTime, seatNum)) {
                        System.out.println("Sorry. That seat is unavailable. If you would like to get a ticket in a different seat please enter it here");
                        seatNum = in.nextInt();
                    }
                    cart.push(v1.getTicket(movieChoice, movieTime, seatNum));

                }
            } else {
                int numTickets = v1.getNumSeats(); //magic number, maximum number of tickets to be bought
                int ticketList[] = new int[numTickets];
                int count = 0;
                System.out.println("Which seats would you like to reserve? Please enter the first seat now");
                int a = in.nextInt();
                ticketList[count] = a;
                count++;
                while (a != -1) {
                    System.out.println("Please enter the next seat number you would like. Please enter -1 if you have selected all of the tickets you wantn");
                    a = in.nextInt();
                    while (a < -1 || a > 16) {
                        System.out.println("Invalid input. Please enter a valid number");
                        a = in.nextInt();
                    }
                    if (a != -1) {
                        ticketList[count] = a;
                        count++;
                    }
                }
                for (int i = 0; i < count; i++) {
                    if (v1.isAvailable(movieChoice, movieTime, ticketList[i])) {
                        cart.push(v1.getTicket(movieChoice, movieTime, ticketList[i]));
                    }
                }
            }

    }

    private void EmptyCart(){
        System.out.println("Cart Emptied");
        cart.clear();
    }
    private void showCart(){
             ticket[] temporary = new ticket[cart.size()];
             cart.toArray(temporary);
            for (int i = 0; i < cart.size(); i++) {
                temporary[i].print();
            }

    }
    private void showTheater(){
        System.out.println("Please enter the name of the movie you would like to check on: ");
        String movieChoice = in.next();
        System.out.println("Please enter the time of the showing you would like to check on: ");
        String movieTime = in.next();
        v1.printTheatre(movieChoice, movieTime);

    }
    private void saveUser(user user1){ //checkout
        user1.setCart(cart);
        users.add(user1);
    }
    public boolean getUser(){
        return nextUser;
    }
    public void runMenu() {
        System.out.println("Welcome to my ticket manager!");
        boolean stillRunning = true;
        nextUser = true;
        while (nextUser == true) {
            nextUser = false;
            while (stillRunning == true) {
                System.out.println("Would you like to buy tickets (1), view your cart (2), Empty your cart (3), or view a showing's availability (4), or check out (5)?");
                int choice = (in.nextInt());
                while (choice < 1 || choice > 5) {
                    System.out.println("That is an invalid choice.");
                    choice = in.nextInt();
                }
                if (choice == 1) {
                    buyTickets();
                } else if (choice == 2) {
                    showCart();
                } else if (choice == 3) {
                    EmptyCart();
                } else if (choice == 4) {
                    showTheater();
                } else if (choice == 5) {
                    saveUser(user1);
                    stillRunning = false;
                }
            }
        }

    }

}
