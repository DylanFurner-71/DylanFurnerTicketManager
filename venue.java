import java.util.*;

public class venue {
    private int numMovies = 4;
    private int widthTheater = 4;
    private int numRowsTheater = 4;
    private Vector<String> movieNames;
    private Vector<String> showTimes;
    private Showing showings[] = new Showing[24]; //magic number here is number of movieNames * number of showtimes
    private Scanner s;
    private boolean printedTheater = false;
    private int numOpenSeats = 16;
    venue() {
        movieNames = new Vector<String>();
        showTimes = new Vector<String>();
        createTheatres();
    }

    void createTheatres() {
        movieNames.add("Frozen 2");
        movieNames.add("Midway");
        movieNames.add("Ford v Ferrari");
        movieNames.add("Queen & Slim");
        showTimes.add("9:30 AM");
        showTimes.add("11:30 AM");
        showTimes.add("1:30 PM");
        showTimes.add("4:30 PM");
        showTimes.add("7:30 PM");
        showTimes.add("10:30 PM");

        int prevI = 0;
        int prevK = 0;

        for (int i = 0; i < numMovies; i++) {
            for (int k = 0; k < showTimes.size(); k++) {
                showings[i + prevK + k] = new Showing(numRowsTheater, widthTheater, movieNames.elementAt(i), showTimes.elementAt(k), 10.00);
                if (k == showTimes.size() -1){
                    prevK +=k;
                }
            }
        }

    }
    public int getNumMovies(){
        return numMovies;
    }
    public int getWidthTheater(){
        return widthTheater;
    }
    public int getNumRowsTheater(){
        return numRowsTheater;
    }
    public int getNumSeats(){
        return widthTheater * numRowsTheater;
    }

    public Vector<String> getMovieNames() {
        return movieNames;
    }
    private int getSeatRow(int seatNum) {
        if (seatNum >= 0 && seatNum < 4) {
            return 0;
        } else if (seatNum < 8 && seatNum >= 4) {
            return 1;
        } else if (seatNum < 12 && seatNum >= 8) {
            return 2;
        } else if (seatNum >= 12 && seatNum < 17) {
            return 3;
        }
        return seatNum;
    }

    private int getColumn(int seatNum) {
        if (seatNum == 0 || seatNum == 4 || seatNum == 8 || seatNum == 12) {
            return 0;
        } else if (seatNum == 1 || seatNum == 5 || seatNum == 9 || seatNum == 13) {
            return 1;
        } else if (seatNum == 2 || seatNum == 6 || seatNum == 10 || seatNum == 14) {
            return 2;
        } else {
            return 3;
        }
    }
    public boolean isAvailable(String movieChoice, String movieTime, int seatNum){
                for (int i = 0; i < showings.length; i++) {
                    if (showings[i].getMovieName(movieChoice) == true) {
                        if (showings[i].getShowTime(movieTime) == true) {
                            if (showings[i].checkAvailability(getColumn(seatNum), getSeatRow(seatNum)) == true) { //if it's available
                                numOpenSeats = showings[i].getEmpty();
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            public Vector<String> getShowTimes() {
            return showTimes;
        }

        public ticket getTicket(String movieChoice, String movieTime, int seatNum){
            int seatRow = getSeatRow(seatNum);
            int seatColumn = getColumn(seatNum);
            for (int i = 0; i < showings.length; i++) {
                if (showings[i].getMovieName(movieChoice) == true) {
                    if (showings[i].getShowTime(movieTime) == true) {
                        showings[i].setAvailability(movieChoice, movieTime, getColumn(seatNum), getSeatRow(seatNum));
                        numOpenSeats = showings[i].getEmpty();
                        return showings[i].getTicket(seatColumn, seatRow);
                    }
                }
            }
            return null;
        }
        public void printTheatre(String movieChoice, String movieTime) {
            if (printedTheater) {
                int numEmptySeats = 0;
            for (int i = 0; i < 16; i++) {
                if (i % 4 == 0 && i != 0) {
                    System.out.println("");
                }
                if (isAvailable(movieChoice, movieTime, i)) {

                    System.out.print("O ");
                    numEmptySeats++;

                } else {
                    System.out.print("X ");

                }
                System.out.println("There are "+ numEmptySeats +" empty seats in this theater");

            }
        } else {
                for (int i = 0; i < 16; i++) {
                    if (i % 4 == 0) {
                        System.out.println("");
                    }
                    if (isAvailable(movieChoice, movieTime, i)) {
                        System.out.print("O ");
                    } else {
                        System.out.print("X ");
                    }
                    System.out.println("There are 16 empty seats in this theater");

                }
            printedTheater = true;
            }
            System.out.println("");
            }

        }
