package controller;

import com.hotelreservation.simpreserv.Payment;
import entity.ProcessPayment;

public class ControllerEmployee implements ProcessPayment {

  @Override // This method process the payment
  public void processPayment(Payment payment) {
    /*Clase necesarios para este metodo
     * clase payment
     * clase empleado
     * clase reservacion
     * clase habitacion
     * clase correo
     * clase cliente
     *
     * */
  }

  @Override
  public void cancelPayment() {}

  @Override
  public void pointsReward() {}
}
