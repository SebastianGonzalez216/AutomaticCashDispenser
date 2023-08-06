package app;

import db.BaseDatos;
import db.Test;
import ui.AplicacionBanco;
import ui.pantallas.ConsultaSaldo;
import ui.pantallas.DepositoSaldo;
import ui.pantallas.MensajeCierre;
import ui.pantallas.MenuPrincipal;
import ui.pantallas.RetiroSaldo;

public class Main {

	public static void main(String[] args)
	{
		
		BaseDatos bd = new Test();
		
		AplicacionBanco app = new AplicacionBanco(bd);
		app.registrarPantalla(new MenuPrincipal());
		app.registrarPantalla(new ConsultaSaldo());
		app.registrarPantalla(new DepositoSaldo());
		app.registrarPantalla(new RetiroSaldo());
		app.registrarPantalla(new MensajeCierre());
		app.iniciarAplicacion(MenuPrincipal.class);
		
	}

}
