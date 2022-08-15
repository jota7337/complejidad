package Vista;

import javax.swing.JOptionPane;

public class Vista {
	
	public String pedirdato(String mensaje){
		return JOptionPane.showInputDialog(mensaje);
	}
	
	public void mostrarmensaje(String mensaje) {
		 JOptionPane.showMessageDialog(null, mensaje);
	}
	public int leerDato(String mensaje) {
		int respuesta=0;
		String instruccion=JOptionPane.showInputDialog(mensaje);
		respuesta=Integer.parseInt(instruccion);
		return respuesta;
	}

}
