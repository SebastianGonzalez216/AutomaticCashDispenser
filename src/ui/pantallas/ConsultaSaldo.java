package ui.pantallas;

import db.BaseDatos;
import db.exception.BaseDatosException;
import ui.AplicacionBanco;
import ui.PantallaAplicacion;

/**
 * Pantalla para consultar saldo
 * 
 * @author Tomas
 */
public class ConsultaSaldo extends PantallaAplicacion {

	/**
	 * Constructor
	 */
	public ConsultaSaldo() {
		super(1, "Consulta de saldo");
	}

	/**
	 * Acciones de la consulta de saldo
	 * 
	 * @param aplicacion {@link AplicacionBanco}
	 * @param baseDatos {@link BaseDatos}
	 */
	@Override
	public void ejecutarAccion(AplicacionBanco aplicacion, BaseDatos baseDatos) {

		pause("Tu saldo actual es de: " + String.format("$%.2f", baseDatos.consultarSaldo()));
		aplicacion.ejecutarPantalla(MenuPrincipal.class);

	}

	@Override
	public void onError(AplicacionBanco aplicacion, BaseDatosException excepcion) {
		pause("Ocurrió un error al consultar saldo: " + excepcion.getMessage());
		aplicacion.ejecutarPantalla(MenuPrincipal.class);
	}

}
