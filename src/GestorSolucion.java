import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase GestorSolucion: 
 * 		Sirve de nexo entre la clase Tablero y la interfaz gr�fica
 * 
 * @author Pedro Miguel Carmona & Ruben Marin Lucas
 *
 */
public class GestorSolucion {
	private Tablero t;//Tablero del que partimos
	private int numNodos;//Numero de nodos generados
	private double tiempoEjecucion;//tiempo de ejcucion del algoritmo
	private String solucionFinal;//guarda los movimientos que se realizan 
	private List<Tablero> abiertos;// lista de nodos abiertos
	private List<Tablero> cerrados; // lista de nodos cerrados
	private int nodoIgual; //uso en la modificacion de escalada max pendiente
	private int nodoPeor; //uso en la modificacion de escalada max pendiente
	
	
	/***
	 * Constructor por defecto para objetos de la clase GestorSolucion
	 */
	public GestorSolucion(){
		t = new Tablero();
		numNodos = 0;
		tiempoEjecucion = 0;
		solucionFinal = "";
	}
	
	
	/***
	 * Introduce un nuevo tablero en el GestorSolucion
	 * @param t Nuevo tablero para el GestorSolucion
	 */
	public void setT(Tablero t) {
		this.t = t;
	}
	
	/***
	 * Introduce el tama�o del tablero en el GestoSolucion
	 * @param tamTablero tama�o del tablero a tratar
	 */
	public void setTamTablero(int tamTablero) {
		this.t.setTamTablero(tamTablero); 
	}
	
	/***
	 * Establece el valor de la casilla (i,j) en el tablero t
	 * @param valor valor a poner
	 * @param i fila a poner el valor
	 * @param j columna a poner el valor
	 */
	public void setValor(int valor, int i, int j) {
		t.setValor(valor, i, j);  
	}
	
	/***
	 * Pone un nulo en el tablero t
	 * @param i fila que indica la posicion del nulo
	 * @param j colummna que indica la posicion del nulo
	 */
	public void setNulo(int i, int j) {
		t.setNulo(i, j);
	}
	
	/***
	 * Introduce un nuevo n�mero de nodos en el GestorSolucion
	 * @param numNodos Nuevo n�mero de nodos para el GestorSolucion
	 */
	public void setNumNodos(int numNodos) {
		this.numNodos = numNodos;
	}
	
	/***
	 * Introduce un nuevo tiempo de ejecuci�n en el GestorSolucion
	 * @param tiempoEjecucion Nuevo tiempo de ejecuci�n para el GestorSolucion
	 */
	public void setTiempoEjecucion(double tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}
	
	/***
	 * Introduce una nueva cadena que contiene los movimientos de la soluci�n
	 * @param solucionFinal Nueva cadena para el GestorSolucion 
	 */
	public void setSolucionFinal(String solucionFinal) {
		this.solucionFinal = solucionFinal;
	}
	
	
	/***
	 * Introduce un nuevo valor para el numero de nodos iguales -nodoIgual-
	 * @param n Nuevo n�mero de de nodos iguales
	 */
	public void setNodoIgual(int n) {
		nodoIgual = n;
	}
	
	/***
	 * Introduce un nuevo valor para el n�mero de nodos peores -nodoPeor-
	 * @param solucionFinal Nuevo n�mero de nodos peores
	 */
	public void setNodoPeor(int n) {
		nodoPeor = n;
	}
	
	/***
	 * Retorna el tablero t
	 * @return t
	 */
	public Tablero getT() {
		return t;
	}
	
	/***
	 * Retorna el tama�o del tablero t
	 * @return tama�o del tablero
	 */
	public int getTamTablero() {
		return this.t.getTamTablero(); 
	}
	
	/***
	 * Devuelve el valor de la casilla (i,j) en el tablero t
	 * @param i fila a devolver el valor
	 * @param j columna a devolver el valor
	 * @return valor de la casilla seleccionada
	 */
	public int getValor(int i, int j) {
		return t.getValor(i, j);  
	}
	
	
	/***
	 * Retorna el n�mero de nodos generados
	 * @return numNodos
	 */
	public int getNumNodos() {
		return numNodos;
	}
	
	/***
	 * Retorna el tiempo de ejecucicon empleado 
	 * @return tiempoEjecucion
	 */
	public double getTiempoEjecucion() {
		return tiempoEjecucion;
	}
	
	/***
	 * Retorna el tiempo de ejecucicon empleado
	 * @return solucionFinal
	 */
	public String getSolucionFinal() {
		return solucionFinal;
	}
	
	/**
	 * Retorna el numero de nodos iguales
	 * @return nodoigual numero de nodos iguales
	 */
	public int getNodoIgual() {
		return nodoIgual;
	}
	
	/***
	 * Retorna el numero de nodos peores
	 * @return nodoPeor numero de nodos peores
	 */
	public int getNodoPeor() {
		return nodoPeor;
	}
	
	/***
	 * Incrementa la cifra de n�mero de nodos generados en uno
	 */
	public void addNodos() {
		numNodos++;
	}
	
	/**
	 * Incrementa la cifra de n�mero de nodos iguales en uno
	 */
	public void addNodoIgual() {
		nodoIgual++;
	}
	
	/**
	 * Incrementa la cifra de n�mero de nodos peores en uno
	 */
	public void addNodoPeor() {
		nodoPeor++;
	}
	
	/**
	 * Mete t en la lista de abiertos
	 * @param t tablero a a�adir en la lista abiertos
	 */
	public void addAbierto(Tablero t) {
		abiertos.add(t);
	}
	
	/**
	 * Mete t en la lista de los cerrados
	 * @param t tablero a a�adir en la lista cerrados
	 */
	public void addCerrado(Tablero t) {
		cerrados.add(t);
	}
	
	/**
	 * Devuelve el tablero que esta en primera posici�n de la lista abiertos
	 * @return Tablero en primera posici�n de la lista abiertos
	 */
	public Tablero primerAbierto() {
		return abiertos.get(0);

	}
	
	/**
	 * Elimina el primer elemento de la lista abiertos
	 */
	public void removeAbierto() {
		abiertos.remove(0);
	}
	
	
	/**
	 * Ordena la lista de abiertos, siguiendo el citerio definido en la clase FunctionComparator
	 */
	public void sortAbiertos(){
		Collections.sort(abiertos, new FuncionComparator());
	}
	
	/**
	 * Comprueba si el tablero pasado por par�metro se encuentra en la lista cerrados
	 * @param t tablero a comprobar si esta en la lista cerrados
	 * @return true en caso de que se encuentre en la lista, false en caso contrario
	 */
	public boolean isCerrado(Tablero t) {
		
		int i = 0;
		int j = 0;
		int k = 0;
		Tablero aux;
		boolean diferente = false;
		boolean iguales = false;
		
		while(k < cerrados.size() && !iguales) {
			aux = cerrados.get(k);
			while(i < t.getTamTablero() && !diferente && !iguales) {
				while(j < t.getTamTablero() && !diferente) {
					if(t.getValor(i, j) != aux.getValor(i, j) ) diferente = true;
					j++;
				}
				i++;
				j = 0;
			}
			k++;
			i = 0;
			if(!diferente) iguales = true;
			diferente = false;
		}
	
		return iguales;
		
	}
	
	/**
	 * Comprueba si el tablero pasado por par�metro se encuentra en la lista abiertos
	 * @param t tablero a comprobar si esta en la lista abiertos
	 * @return true en caso que se encuentre en la lista, false en caso contrario
	 */
	public boolean isAbierto(Tablero t) {
		
		int i = 0;
		int j = 0;
		int k = 0;
		Tablero aux;
		boolean diferente = false;
		boolean iguales = false;
		
		while(k < abiertos.size() && !iguales) {
			aux = abiertos.get(k);
			while(i < t.getTamTablero() && !diferente && !iguales) {
				while(j < t.getTamTablero() && !diferente) {
					if(t.getValor(i, j) != aux.getValor(i, j) ) diferente = true;
					j++;
				}
				i++;
				j = 0;
			}
			k++;
			i = 0;
			if(!diferente) iguales = true;
			diferente = false;
		}
		
		return iguales;
		
	}
	
	/**
	 * Devuelve el tablero repetido en la lista de abiertos
	 * @param t tablero a comprobar el repetido
	 * @return Tablero repetido en la lista abiertos
	 */
	public Tablero getRepetidoAbiertos(Tablero t) {
		
		int i = 0;
		int j = 0;
		int k = 0;
		Tablero aux = null;
		boolean diferente = false;
		boolean iguales = false;
		
		while(k < abiertos.size() && !iguales) {
			aux = abiertos.get(k);
			while(i < t.getTamTablero() && !diferente && !iguales) {
				while(j < t.getTamTablero() && !diferente) {
					if(t.getValor(i, j) != aux.getValor(i, j) ) diferente = true;
					j++;
				}
				i++;
				j = 0;
			}
			k++;
			i = 0;
			if(!diferente) iguales = true;
			diferente = false;
		}
		
		return aux;	
	}
	
	/**
	 * Devuelve el tablero repetido en la lista de abiertos
	 * @param t tablero a comprobar el repetido
	 * @return Tablero repetido en la lista cerrados
	 */
	public Tablero getRepetidoCerrados(Tablero t) {
		
		int i = 0;
		int j = 0;
		int k = 0;
		Tablero aux = null;
		boolean diferente = false;
		boolean iguales = false;
		
		while(k < cerrados.size() && !iguales) {
			aux = cerrados.get(k);
			while(i < t.getTamTablero() && !diferente && !iguales) {
				while(j < t.getTamTablero() && !diferente) {
					if(t.getValor(i, j) != aux.getValor(i, j) ) diferente = true;
					j++;
				}
				i++;
				j = 0;
			}
			k++;
			i = 0;
			if(!diferente) iguales = true;
			diferente = false;
		}
		
		return aux;	
	}
	
	/**
	 * Devuelve el n�mero de hijos que tiene el tablero parado por par�metro
	 * @param t tablero a saber cuantos hijos tiene
	 * @return numHijos del tablero 
	 */
	public int numHijos(Tablero t) {
		int num = 0;
		int i = 0; Tablero aux;
		while(i < abiertos.size()) {
			aux = abiertos.get(i);
			if(aux.getPadre() == t) num++;
		  i++;
		}
		
		return num;
	}
	
	/**
	 * El objetivo de ese metodo es hallar todos los hijos del tablero que se encuentra en primera posicion de ese conjunto
	 * @param hijos ArrayList con los hijos a modificar 
	 * @return ArrayList hijos con los hijos del primer tablero del conjunto, en el caso de que tuviera
	 */
	 public ArrayList<Tablero> Busqueda(ArrayList<Tablero> hijos){
		Tablero t = hijos.get(0);
		hijos.remove(0);
		
		Tablero aux;
		int i = 0; 
		while(i < cerrados.size()) {
			aux = cerrados.get(i);
			if(aux.getPadre() == t) {
				aux.setCoste(t.getCoste()+1);
				aux.setHeuristica(aux.FuncionHeuristica1());
				aux.setFuncion(aux.getHeuristica(), aux.getCoste());
				hijos.add(aux);
			}
		  i++;
		}
		
		i = 0; int cont = 0;
		while(i < abiertos.size()) {
			aux = abiertos.get(i);
			if(aux.getPadre() == t) {
				aux.setCoste(t.getCoste()+1);
				aux.setHeuristica(aux.FuncionHeuristica1());
				aux.setFuncion(aux.getHeuristica(), aux.getCoste());
				hijos.add(aux);
				cont++;
			}
		  i++;
		}
		if(cont > 0) sortAbiertos();
		
	 return hijos;
   }
	
	/**
	 * A�ade el tablero pasado por parametro a la lista hijos
	 * @param t tablero a a�adir a la lista hijos
	 * @param hijos lista para a�adir
	 * @return lista con el tablero a�adido 
	 */
	public ArrayList<Tablero> addHijo(Tablero t, ArrayList<Tablero> hijos){
		hijos.add(t);
		return hijos;
	}
	
	/**
	 *  Realiza el algoritmo de escalada de escalada de maxima pendiente
	 * @return fin, true en caso de haber encontrado una solucion, false en caso contrario
	 */
	public boolean escaladaSimple() {
		
		long initTime = System.currentTimeMillis();//Tiempo inicial
		boolean fin = false; 
		Tablero nuevo = new Tablero(); 
		Tablero actual = t; 
		actual.setHeuristica(actual.FuncionHeuristica1());
		
		while(nuevo != null && !fin) {
			
			nuevo = new Tablero();
			nuevo = actual.MejorMovimientoES(nuevo, this);
			
			if(nuevo != null) {
				
				nuevo.setPadre(actual);
				actual = nuevo;
				solucionFinal += actual.getMovimiento() + " ";
				if(actual.getHeuristica() == 0) fin = true;
			}
			
			
		}
		
		long endTime = System.currentTimeMillis();//Tiempo final, ya tenemos hemos dejado de generar nodos
		long tiempo = endTime - initTime;//Tiempo que se tarda en ejcutar el algoritmo
		
		setTiempoEjecucion(tiempo);
		
		return fin;
		
	}
	
	/***
	 * Realiza el algoritmo de escalada de escalada de maxima pendiente 
	 * @return fin, true en caso de haber encontrado una solucion, false en caso contrario
	 */
	public boolean escaladaMaximaPendiente() {
		
		long initTime = System.currentTimeMillis();//Tiempo inicial
		
		boolean fin = false;
		Tablero nuevo = new Tablero();
		Tablero actual = t;
		actual.setHeuristica(actual.FuncionHeuristica1());
		
		while(nuevo != null && !fin) {
			
			nuevo = new Tablero();
			nuevo = actual.MejorMovimientoEMP(nuevo, this);
			
			if(nuevo != null) {
				
				nuevo.setPadre(actual);
				actual = nuevo;
				solucionFinal += actual.getMovimiento() + " ";
				
				if(actual.getHeuristica() == 0) fin = true;
				
			}
		}
		
		long endTime = System.currentTimeMillis();//Tiempo final, ya tenemos hemos dejado de generar nodos
		long tiempo = endTime - initTime;//Tiempo que se tarda en eejcutar el algoritmo
		setTiempoEjecucion(tiempo);
		
		return fin;
	
		
	}
	
	
	/***
	 * Realiza una modificacion del algoritmo de escalada de escalada de maxima pendiente
	 * @return fin, true en caso de haber encontrado una solucion, false en caso contrario
	 */
	public boolean escaladaMaximaPendiente1() {
		
		long initTime = System.currentTimeMillis();//Tiempo inicial
		
		boolean fin = false; solucionFinal = "";
		Tablero nuevo = new Tablero(); Tablero actual = t;
		actual.setHeuristica(actual.FuncionHeuristica1());
		
		cerrados = new ArrayList<Tablero>();
		
		while(nuevo != null && !fin) {
			
			nuevo = new Tablero();
			nuevo = actual.MejorMovimientoEMP1(nuevo, this);
			
			if(nuevo != null) {
				
				nuevo.setPadre(actual);
				actual = nuevo;
				solucionFinal += actual.getMovimiento() + " ";
				
				if(actual.getHeuristica() == 0) fin = true;
				
			}
		}
		
		long endTime = System.currentTimeMillis();//Tiempo final, ya tenemos hemos dejado de generar nodos
		long tiempo = endTime - initTime;//Tiempo que se tarda en eejcutar el algoritmo
		setTiempoEjecucion(tiempo);
		
		return fin;
		
	}
	
	/***
	 * Realiza el algoritmo de A*
	 * @return fin, true en caso de haber encontrado una solucion, false en caso contrario
	 */
	public boolean algoritmoA(double pesoHeuristica, double pesoCoste){
		long initTime = System.currentTimeMillis();//Tiempo inicial
		
		abiertos = new ArrayList<Tablero>();
		cerrados = new ArrayList<Tablero>();
		
		t.setPesoHeuristica(pesoHeuristica);
		t.setPesoCoste(pesoCoste);
		
		boolean fin = false;
		Tablero actual = new Tablero();
		actual = t;
		actual.setHeuristica(actual.FuncionHeuristica1());
		actual.setCoste(0);
		actual.setFuncion(actual.getHeuristica(), actual.getCoste());
		addNodos();
		addAbierto(actual);

		while(!fin) {
			actual = primerAbierto();
			removeAbierto();
			addCerrado(actual);
			if(actual.FuncionHeuristica1() == 0) fin = true;
			actual.GenerarMovimientosA1(this, actual.getCoste()+1,pesoHeuristica, pesoCoste);
			sortAbiertos();				
		}
		
		int i = 0;
		int index = cerrados.size();
		String[] solucion = new String[index];
		Tablero t = cerrados.get(index-1);
		
		while(t != null) {
			solucion[index-i-1] = t.getMovimiento();
			t = t.getPadre();
			i++;
		}
		
		for (String s : solucion) {
			if(s != null)
				solucionFinal += s + " ";
		}
		
				
		long endTime = System.currentTimeMillis();//Tiempo final, ya tenemos hemos dejado de generar nodos
		long tiempo = endTime - initTime;//Tiempo que se tarda en eejcutar el algoritmo
		setTiempoEjecucion(tiempo);
		
		return fin;
	}
	
}
