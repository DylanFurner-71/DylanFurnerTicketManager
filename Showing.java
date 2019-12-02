public class Showing {
    ticket ticketsForShow[][];
    String movieName, showTime;
    private static int theaterNum;
    Showing(){

    }
    Showing(int rows, int width, String movie, String showTime, double price){
        theaterNum++;
        movieName = movie;
        this.showTime = showTime;
        ticketsForShow = new ticket[rows][width];
        int counter = 0;
        for (int i = 0; i < width; i++){
            for (int k = 0; k < rows; k++){
                ticketsForShow[k][i] = new ticket(price, showTime, movie, counter+1, theaterNum, "");
                counter++;
            }
        }
    }
    boolean checkAvailability(int z, int k){
        return ticketsForShow[z][k].getAvailability();
    }
    void setAvailability(String movieName, String movieTime, int col, int row){
        ticketsForShow[col][row].available = false;

    }
    boolean getMovieName(String z){
        if (movieName.equals(z)) {
            return true;
        } else {
            return false;
        }
    }
    boolean getShowTime(String z){
        if (showTime.equals(z)) {
            return true;
        } else {
            return false;
        }
    }
    ticket getTicket(int c, int r){
        return ticketsForShow[c][r];
    }

}
