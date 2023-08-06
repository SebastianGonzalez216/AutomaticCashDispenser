package ui.pantallas;

import db.BaseDatos;
import db.exception.BaseDatosException;
import ui.AplicacionBanco;
import ui.PantallaAplicacion;

/**
 * Pantalla para depositar saldo
 * 
 * @author Tomas
 */
public class DepositoSaldo extends PantallaAplicacion {

	/**
	 * Constructor
	 */
	public DepositoSaldo() {
		super(3, "Deposito de efectivo");
	}

	/**
	 * Acciones del menú principal
	 * 
	 * @param aplicacion {@link AplicacionBanco}
	 * @param baseDatos {@link BaseDatos}
	 */
	@Override
	public void ejecutarAccion(AplicacionBanco aplicacion, BaseDatos baseDatos) {

		double deposito = leerDouble("Cuanto deseas depositar");
		baseDatos.depositarSaldo(deposito);

		imprimir("Depositaste: " + String.format("$%.2f", deposito));
		pause("Tu saldo actual es de: " + String.format("$%.2f", baseDatos.consultarSaldo()));
		aplicacion.ejecutarPantalla(MenuPrincipal.class);

	}

	@Override
	public void onError(AplicacionBanco aplicacion, BaseDatosException excepcion) {
		pause("Ocurrió un error al hacer el depósito: " + excepcion.getMessage());
		aplicacion.ejecutarPantalla(MenuPrincipal.class);
	}

}
