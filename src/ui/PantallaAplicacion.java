package ui;

import javax.swing.JOptionPane;

import db.BaseDatos;
import db.exception.BaseDatosException;

/**
 * Acciones que debe de realizar una pantalla de una aplicación
 * 
 * @author Tomas
 */
public abstract class PantallaAplicacion {

	private int id;
	private String descripcion;
	
	/**
	 * Inicializa pantalla aplicación
	 */
	public PantallaAplicacion(int id, String descripcion)
	{
		this.id = id;
		this.descripcion = descripcion;
	}

	public abstract void ejecutarAccion(AplicacionBanco aplicacion, BaseDatos baseDatos);
	public abstract void onError(AplicacionBanco aplicacion, BaseDatosException excepcion);

	/**
	 * Obtiene la id de la pantalla
	 * 
	 * @return int
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Obtiene la descripción de la pantalla
	 * 
	 * @return String
	 */
	public String getDescripcion()
	{
		return descripcion;
	}

	/**
	 * Shorcut para system.out
	 * 
	 * @return String
	 */
	public void imprimir(String mensaje)
	{
		System.out.println(mensaje);
	}

	/**
	 * Imprime un simple separador
	 */
	public void separador()
	{
		imprimir("--------------------------------");
	}

	/**
	 * Pausa la consola
	 * 
	 * @param mensaje
	 */
	public void pause(String mensaje)
	{
		imprimir(mensaje);
		JOptionPane.showMessageDialog(null, "Click para continuar");
	}

    public static double leerDouble(String mensaje) {
        while (true) {
            try {
                String response = JOptionPane.showInputDialog(null, mensaje + ": ");
                return Double.parseDouble(response);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Favor de solo escribir números decimales");
            }
        }
    }

	/**
	 * Lee un valor entero
	 * 
	 * @param mensaje
	 * @return int
	 */
    public static int leerInteger(String mensaje) {
        while (true) {
            try {
                String response = JOptionPane.showInputDialog(null, mensaje + ": ");
                return Integer.parseInt(response);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Favor de solo escribir números enteros");
            }
        }
    }

}
