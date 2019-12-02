import java.util.*;

public class user {
    LinkedList<ticket> userCart = new LinkedList<ticket>();
    double totalCostOfReservation;
    user(){}
    public void setCart(LinkedList<ticket> cart){
        userCart = cart;
        totalCostOfReservation = 0;
        for (int i = 0; i < userCart.size(); i++){
            totalCostOfReservation += userCart.get(i).getPrice();
        }
    }
    public ticket[] getTickets(){
        ticket[] t1 = new ticket[userCart.size()];
        return userCart.toArray(t1);
    }
    public void printCart(){
        System.out.print(userCart);
    }
}

