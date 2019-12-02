
public class ticket {
    double price;
    String showTime, movieName;
    String purchaserName;
    int ageOfPurchaser;
    int seatNum;
    int theatreNum;
    boolean available = true;
    ticket(){

    }
    ticket(double price1, String showTime1, String movieName1, int seatNum1, int theaterNum, String purchaseName){
        price = price1;
        showTime = showTime1;
        movieName = movieName1;
        seatNum = seatNum1;
        theatreNum = theaterNum;
        purchaserName = purchaseName;
    }
    void setName(String s){
        purchaserName = s;
    }
    boolean getAvailability(){
        return available;
    }
    void setAvailability(){
        available = false;
    }
    double getPrice(){
        return price;
    }
    public ticket getticket(int seatRow, int seatColumn){
        available = false;
        return this;
    }
    public void print(){
        System.out.println("Movie: " + movieName);
        System.out.println("Price: $" + price);
        System.out.println("Show time: "+ showTime);
        System.out.println("Theater: "+ theatreNum);
        System.out.println("Seat Number: " + seatNum);

    }
}
