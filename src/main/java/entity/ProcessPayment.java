package entity;

import com.hotelreservation.simpreserv.Payment;

public interface ProcessPayment{
   public void processPayment(Payment payment);
   public void cancelPayment();
   public void pointsReward();
}
