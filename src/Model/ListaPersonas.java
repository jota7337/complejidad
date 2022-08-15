package Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class ListaPersonas {
	 Nodo raiz;
	private Persona persona;
	private  ArrayList<Persona> FilaPersonas;
	public ListaPersonas() {
		FilaPersonas=new ArrayList<Persona>();
	}
	public Nodo insertarRaiz(ArrayList<Persona> Lista) {
	 
		
	int dat=0;
		System.out.println("linea 54");
		Collections.sort(Lista,new Comparator<Persona>() {
			@Override public int compare(Persona p1, Persona p2) {
	            return p1.getUnico() - p2.getUnico(); // Ascending
	        }
		});
		for(Persona pers:Lista) {
		
			dat = Lista.get(0).getId();
	    
		}
           System.out.println("Esta es la raiz "  + dat);
	raiz =new Nodo (dat);
	
	
		return raiz;
		
	}
	
	public void nodoinsert(Nodo nodo,int Dato,int padre ) {
		Nodo nuevo=new Nodo (Dato);
		
		if (nodo.getDato()==padre) {
			nodo.aumentar(nuevo);
		}
		else {
			for (int i =0;i< nodo.getNohijos();i++) {
				if(nodo.hijos[i].getDato()==padre) {
					nodo.hijos[i].aumentar(nuevo);
				}else {
					nodoinsert(nodo.hijos[i], Dato, padre);
				}
			}
			
		}
		
	}
	
	public void ver2(Nodo nodo) {
		for(int i=0;i<nodo.getNohijos();i++) {
			nodo.hijos[i].ver();
			ver2(nodo.hijos[i]);
		}
	}
	
	public int generateid(ArrayList<Persona> filapersonas) {
		int n_id=(int) (Math.random()*99+1);
		while(existe(n_id,filapersonas) == true) {
			n_id=(int) (Math.random()*99+1);
		}
		return n_id;
	}
	public ArrayList<Persona> lista_Unic(ArrayList<Persona> filaper) {
		ArrayList<Persona> res= new ArrayList<Persona>();
		for(Persona pers:filaper) {
			pers.setUnico(generateunico(pers.getDate()));
			res.add(pers);
		}
		return res;
		
	}
	public int generateunico(String personadate) {
		Date today=new Date();
		Calendar myNextCalendar=Calendar.getInstance();
		String[] data=personadate.split("/");
		myNextCalendar.set(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
		Date nyd=myNextCalendar.getTime();
		long difference = (((today.getTime()-nyd.getTime())/86400000));
		return Math.round(difference); 
	}
	
	public  ArrayList<Persona> insert(ArrayList<Persona> FilaPersonas,String nombre,String fecha,int id,int unico){
		persona=new Persona(nombre,fecha,id,unico);
		int mayor=mayor(FilaPersonas);
		System.out.println("este es el mayor "+mayor);
		System.out.println("este es el id de la persona nuevo "+persona.getId());
		System.out.println("este es el id de la persona "+persona.getUnico());
		if(persona.getId()> mayor) {
			System.out.println("esta ingresando por mayor");
			for(int i=0;i<FilaPersonas.size();i++) {
				if(FilaPersonas.get(i).getId() == mayor ) {
					FilaPersonas.remove(i);
					persona.setUnico(generateunico(fecha));
					FilaPersonas.add(1, persona);
				}
			}
		}else {
			System.out.println("se esta metineod por el else");
			persona.setUnico(generateunico(fecha));
			FilaPersonas.add(persona);
		}
		return FilaPersonas;
	} 
	public boolean existe(int id,ArrayList<Persona> filapersona) {
		boolean res=false;
		for(Persona pers: filapersona) {
			if(pers.getId() == id) {
				res = true;
			}
		}
		return res;
	}
	public int mayor( ArrayList<Persona> FilaPersonas) {
		int res=0;
		for(Persona pers:FilaPersonas) {
			if(pers.getId()>res) {
				res=pers.getId();
			}
		}
		return res;		
	}
	
}
