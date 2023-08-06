package ui.pantallas;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import db.BaseDatos;
import db.exception.BaseDatosException;
import ui.AplicacionBanco;
import ui.PantallaAplicacion;

/**
 * Pantalla de menú principal
 * 
 * @author Tomas
 */
public class MenuPrincipal extends PantallaAplicacion {

	/**
	 * Constructor
	 */
	public MenuPrincipal() {
		super(0, "Menú principal");
	}

	/**
	 * Acciones del menú principal
	 * 
	 * @param aplicacion {@link AplicacionBanco}
	 * @param baseDatos {@link BaseDatos}
	 */
	@Override
	public void ejecutarAccion(AplicacionBanco aplicacion, BaseDatos baseDatos) {

		// Obtiene una lista de id de pantallas ordenadas de menor a mayor, excepto de la pantalla actual
		Set<Integer> idMenus = aplicacion.getPantallasPorId().keySet().stream()
				.filter(Predicate.not(Integer.valueOf(this.getId())::equals))
				.sorted().collect(Collectors.toSet());

		// Genera el menú de opciones
		imprimir("Porfavor seleccione una opción:");
		
		// Imprime las pantallas
		for (Integer idMenu : idMenus)
		{
	
			// Obtiene referencia de la pantalla
			PantallaAplicacion pantalla = aplicacion.getPantallasPorId().get(idMenu);
	
			imprimir("\t" + pantalla.getId() + ". " + pantalla.getDescripcion() + ".");

		}

		// Pide la pantalla al usuario
		int eleccion = leerInteger("Opción");
		if (idMenus.contains(eleccion))
		{
			// Ejecuta la pantalla
			aplicacion.ejecutarPantalla(eleccion);
		}
		else
		{
			// Regresa al menú principal
			pause("Opción incorrecta, favor de intentar de nuevo");
			aplicacion.ejecutarPantalla(MenuPrincipal.class);
		}

	}

	@Override
	public void onError(AplicacionBanco aplicacion, BaseDatosException excepcion) {
		imprimir(excepcion.getMessage());
	}

}
