package db;

public interface BaseDatos {
   public void iniciar();
   public void cerrar();
   public double consultarSaldo();
   public void depositarSaldo(double saldo);
   public void retirarSaldo(double saldo);
}
