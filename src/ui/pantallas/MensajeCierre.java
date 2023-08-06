package ui.pantallas;

import db.BaseDatos;
import db.exception.BaseDatosException;
import ui.AplicacionBanco;
import ui.PantallaAplicacion;

/**
 * Pantalla para salir del programa
 * 
 * @author Tomas
 */
public class MensajeCierre extends PantallaAplicacion {

	/**
	 * Constructor
	 */
	public MensajeCierre() {
		super(4, "Salir");
	}

	/**
	 * Acciones del mensaje de despedida
	 * 
	 * @param aplicacion {@link AplicacionBanco}
	 * @param baseDatos {@link BaseDatos}
	 */
	@Override
	public void ejecutarAccion(AplicacionBanco aplicacion, BaseDatos baseDatos) {

		imprimir("¡Gracias!, vuelva pronto.");

	}

	@Override
	public void onError(AplicacionBanco aplicacion, BaseDatosException excepcion) {
		imprimir(excepcion.getMessage());
	}

}
