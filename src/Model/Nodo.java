package Model;

import javax.swing.JOptionPane;

public class Nodo {

	
	private int dato;
	private int nohijos;
	Nodo hijos[];
	Nodo hijosT[];
	
	
	public  Nodo(int dat){
		dato=dat;
		this.nohijos=0;
		
	}
	
	public void copiar() {
		hijosT=new Nodo[nohijos+1];
		for (int i=0;i<this.nohijos;i++) {
			hijosT[i]=hijos[i];
		}
	}
	
	public void aumentar(Nodo nodo) {
		copiar();
		hijosT[this.nohijos+1]=nodo;
		hijos=hijosT;
		this.nohijos++;
	}



	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public int getNohijos() {
		return nohijos;
	}

	public void setNohijos(int nohijos) {
		this.nohijos = nohijos;
	}

	public Nodo[] getHijos() {
		return hijos;
	}

	public void setHijos(Nodo[] hijos) {
		this.hijos = hijos;
	}

	public Nodo[] getHijosT() {
		return hijosT;
	}

	public void setHijosT(Nodo[] hijosT) {
		this.hijosT = hijosT;
	}
	public void ver() {
	JOptionPane.showMessageDialog(null, "{"+dato+"}");
	}
	 
}
