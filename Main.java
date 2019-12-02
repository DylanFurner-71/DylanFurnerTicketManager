import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        userVenue v1 = new userVenue(in);
        do {
            v1.runMenu();

        } while (v1.getUser());



    }
}

