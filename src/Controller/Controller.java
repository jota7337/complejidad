package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Model.ListaPersonas;
import Model.Nodo;
import Model.Persona;
import Model.Recursive;
import Vista.Vista;

public class Controller {
	private ListaPersonas Filapersonas;
	private ArrayList<Persona> filaauxiliar;
	private Vista vista;
	private Nodo nodo1;
	private Recursive recurs;
	
	public Controller() {
		nodo1=new Nodo(0);
		Filapersonas=new ListaPersonas();
		filaauxiliar=new ArrayList<Persona>();
		filaauxiliar.add(new Persona("Luis P�rez","1991/12/0",10,0));
		filaauxiliar.add(new Persona("Andres Cruz","1967/10/12",25,0));
		filaauxiliar.add(new Persona("Miguel Paz","1981/03/22",12,0));
		filaauxiliar.add(new Persona("Wilson Ruiz","1975/06/10",46,0));
		filaauxiliar.add(new Persona("Jorge Baez","2000/08/20",55,0));
		filaauxiliar.add(new Persona("Ana Sarmiento","1998/01/23",9,0));
		filaauxiliar.add(new Persona("Maria G�mez","1988/03/15",34,0));
		filaauxiliar.add(new Persona("Luis Poveda","1995/11/29",45,0));
		filaauxiliar.add(new Persona("Sandra Ruiz","1970/12/24",2,0));
		filaauxiliar.add(new Persona("Marcos Solano","2001/06/25",47,0));
		vista=new Vista();
		recurs=new Recursive();
		funcionar();
	}
	
	public  void funcionar() {
		while(true) {
			try {
				int caso=Integer.parseInt(vista.pedirdato("ingrese que quiere hacer:"+
			"\n"+"1.Verificar datos "+
						"\n"+"2.insertar usuario"+
			"\n"+"3.Verificar lista cronologicamente"+
	
			"\n"+"4.Alimentar arbol n_ario con lista"
						+"\n"+"5.Recursivo"+"\n"+"6.Salir"));
				switch(caso) {
				case 1:
					filaauxiliar=Filapersonas.lista_Unic(filaauxiliar);
					mostrardatos();
					break;
				case 2:
					String nombre=vista.pedirdato("Nombre");
					String Date=vista.pedirdato("ingrese la fecha en formato yyyy/mm/dd");
					int id=Filapersonas.generateid(filaauxiliar);
					filaauxiliar=Filapersonas.insert(filaauxiliar,nombre,Date,id,0);
					mostrardatos();
					break;
				case 3:
					vista.mostrarmensaje(mostrarCrono(filaauxiliar));	
					break;
				case 4:
					String dato ="";
					Nodo nodo= Filapersonas.insertarRaiz(filaauxiliar);
					
					int m=nodo.getDato();
					for (int j=0;j<filaauxiliar.size();j++) {
						if(m==filaauxiliar.get(j).getId()) {
							vista.mostrarmensaje("Es el padre raiz: "+filaauxiliar.get(j).toString());
							
						}
					
					}
					
					for (int k=0;k<filaauxiliar.size();k++) {
						if(m!=filaauxiliar.get(k).getId()) {
						int padre= vista.leerDato("Digite el id de su padre de: "+ filaauxiliar.get(k).getNombre());
						
					Filapersonas.nodoinsert(nodo, filaauxiliar.get(k).getId(), padre);
					
						
						
					}
					}
					Filapersonas.nodoinsert(nodo, 9 , 10);
					vista.mostrarmensaje("respuesta ");
				    vista.mostrarmensaje("datos : "+nodo.getDato());
				    Filapersonas.ver2(nodo);
		     
				
					break;
				case 5:
					int frutas=Integer.parseInt(vista.pedirdato("ingrese el numero de frutas"));
					recurs.recursivo(frutas);
					vista.mostrarmensaje(""+recurs.counter);
					break;
				case 6:
					
					return;
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				vista.mostrarmensaje("Ingrese los datos con el formato que se le pide");
			}
			
		}
	}
	
	
	public void mostrardatos() {
		String dat="";
		for(Persona pers:filaauxiliar) {
			dat += pers.getNombre()+" "+pers.getId()+" "+pers.getUnico()+"\n";
		}
		vista.mostrarmensaje(dat);
	}
	
	public String mostrarCrono(ArrayList<Persona> Lista) {
		String dat="";
		System.out.println("linea 54");
		Collections.sort(Lista,new Comparator<Persona>() {
			@Override public int compare(Persona p1, Persona p2) {
	            return p1.getUnico() - p2.getUnico(); // Ascending
	        }
		});
		for(Persona pers:Lista) {
			System.out.println(pers.getNombre()+" "+pers.getId()+" "+pers.getDate()+"\n");
			dat +=pers.getNombre()+" "+pers.getId()+" "+pers.getDate()+"\n";
			
		}
		System.out.println("esta es a res de 64 "+dat);
		
		return dat;
	}
	
	
	
	
	
}
