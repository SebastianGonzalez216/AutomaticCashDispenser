package db.exception;

import db.BaseDatos;

/**
 * Excepci�n para errores controlados que ocurran durante proceso de intercambio de datos
 * 
 * @author Tomas
 */
public class BaseDatosException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private BaseDatos baseDatos;
	
	/**
	 * @param interface para conexi�n con base de datos {@link BaseDatos}
	 * @param mensaje de error
	 * @param datos para formatear en el mensaje de error
	 */
	public BaseDatosException(BaseDatos baseDatos, String mensaje, Object... data)
	{
		super(String.format(mensaje, data));
		this.baseDatos = baseDatos;	
	}

	/**
	 * Obtiene la conexi�n con la base de datos
	 * 
	 * @return una instancia de {@link BaseDatos}
	 */
	public BaseDatos getBaseDatos()
	{
		return baseDatos;
	}
	
}
