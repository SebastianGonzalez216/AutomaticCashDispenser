package ui;

import java.util.HashMap;
import java.util.Map;

import db.BaseDatos;
import db.exception.BaseDatosException;

/**
 * Clase para manejar un conjunto de estatus que conforman a la aplicación
 * 
 * @author Tomas
 *
 */
public class AplicacionBanco {

	private BaseDatos baseDatos;
	private Map<Integer, PantallaAplicacion> pantallasPorId;
	private Map<Class<? extends PantallaAplicacion>, PantallaAplicacion> pantallasPorClase;

	
	/**
	 * Constructor de la aplicación
	 * 
	 * @param baseDatos {@link BaseDatos}
	 */
	public AplicacionBanco(BaseDatos baseDatos)
	{
		this.baseDatos = baseDatos;
		this.pantallasPorId = new HashMap<>();
		this.pantallasPorClase = new HashMap<>();
	}

	/**
	 * Regresa las pantallas por Id
	 * 
	 * @return mapa de pantallas por Id {@link Map}<{@link Integer}, {@link PantallaAplicacion}
	 */
	public Map<Integer, PantallaAplicacion> getPantallasPorId()
	{
		return pantallasPorId;
	}

	/**
	 * Registra las pantallas a utilizar en la aplicación
	 * 
	 * @param pantalla {@link PantallaAplicacion}
	 */
	public void registrarPantalla(PantallaAplicacion pantalla)
	{

		if (pantallasPorId.containsKey(pantalla.getId()))
			throw new IllegalArgumentException("Ya se registro la id de la pantalla " + pantalla.getId());

		if (pantallasPorClase.containsKey(pantalla.getClass()))
			throw new IllegalArgumentException("Ya se registro la clase de la pantalla " + pantalla.getClass().getSimpleName());

		pantallasPorId.put(pantalla.getId(), pantalla);
		pantallasPorClase.put(pantalla.getClass(), pantalla);

	}

	/**
	 * Ejecuta pantalla por clase
	 * 
	 * @param pantalla {@link Class}<{@link PantallaAplicacion}>
	 */
	public void ejecutarPantalla(Class<? extends PantallaAplicacion> pantalla)
	{
		PantallaAplicacion pantallaSeleccionada = pantallasPorClase.get(pantalla);
		if (pantallaSeleccionada == null)
			throw new IllegalArgumentException("Pantalla desconocida: " + pantalla.getClass().getSimpleName());
		
		pantallaSeleccionada.separador();
		ejecutarPantalla(pantallaSeleccionada);
		System.out.println();

	}

	/**
	 * Ejecuta pantalla por id
	 * 
	 * @param id
	 */
	public void ejecutarPantalla(int id)
	{
		PantallaAplicacion pantallaSeleccionada = pantallasPorId.get(id);
		if (pantallaSeleccionada == null)
			throw new IllegalArgumentException("Id de pantalla desconocida: " + id);
		ejecutarPantalla(pantallaSeleccionada);
	}

	/**
	 * Ejecuta las acciones de una pantalla y maneja sus excepciones
	 * 
	 * @param pantalla {@link PantallaAplicacion}
	 */
	public void ejecutarPantalla(PantallaAplicacion pantalla)
	{

		try
		{
			pantalla.ejecutarAccion(this, baseDatos);
		}
		catch(BaseDatosException e)
		{
			pantalla.onError(this, e);
		}

	}

	/**
	 * Ejecuta el ciclo de vida de la aplicación
	 * 
	 * @param pantallaInicial {@link Class}<{@link PantallaAplicacion}
	 */
	public void iniciarAplicacion(Class<? extends PantallaAplicacion> pantallaInicial)
	{
		this.baseDatos.iniciar();
		ejecutarPantalla(pantallaInicial);
		this.baseDatos.cerrar();
	}	
	
}
