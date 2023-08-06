package ui.pantallas;

import db.BaseDatos;
import db.exception.BaseDatosException;
import ui.AplicacionBanco;
import ui.PantallaAplicacion;

/**
 * Pantalla para retirar saldo
 * 
 * @author Tomas
 */
public class RetiroSaldo extends PantallaAplicacion {

	/**
	 * Constructor
	 */
	public RetiroSaldo() {
		super(2, "Retiro de efectivo");
	}

	/**
	 * Acciones del retiro de saldo
	 * 
	 * @param aplicacion {@link AplicacionBanco}
	 * @param baseDatos {@link BaseDatos}
	 */
	@Override
	public void ejecutarAccion(AplicacionBanco aplicacion, BaseDatos baseDatos) {


		double retiro = leerDouble("Cuanto deseas retirar");
		baseDatos.retirarSaldo(retiro);


		imprimir("Retiraste: " + String.format("$%.2f", retiro));
		pause("Tu saldo actual es de: " + String.format("$%.2f", baseDatos.consultarSaldo()));
		aplicacion.ejecutarPantalla(MenuPrincipal.class);

	}

	@Override
	public void onError(AplicacionBanco aplicacion, BaseDatosException excepcion) {
		pause("Ocurrió un error al hacer el retiro: " + excepcion.getMessage());
		aplicacion.ejecutarPantalla(MenuPrincipal.class);
	}

}
