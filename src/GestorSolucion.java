import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase GestorSolucion
 * @author Pedro Miguel Carmona & Ruben Marin Lucas
 *
 */
public class GestorSolucion {
	private Tablero t;//Tablero del que partimos
	private int numNodos;//Numero de nodos generados
	private double tiempoEjecucion;//tiempo de ejcucion del algoritmo
	private String solucionFinal;//guarda los movimientos que se realizan 
	private List<Tablero> abiertos; // lista de nodos abiertos
	private List<Tablero> cerrados; // lista de nodos cerrados
	private int nodoIgual;
	private int nodoPeor;
	
	
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
	 * Introduce el tramaño del tablero en el GestoSolucion
	 * @param tamtablero tamaño del tablero a tratar
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
	 * Introduce un nuevo numero de nodos en el GestorSolucion
	 * @param numNodos Nuevo numero de nodos para el GestorSolucion
	 */
	public void setNumNodos(int numNodos) {
		this.numNodos = numNodos;
	}
	
	/***
	 * Introduce un nuevo tiempo de ejecucion en el GestorSolucion
	 * @param teimpoEjecucion Nuevo tiempo de ejecucion para el GestorSolucion
	 */
	public void setTiempoEjecucion(double tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}
	
	/***
	 * Introduce un nuevo tablero para el GestorSolucion
	 * @param solucionFinal Nueva solucion para el GestorSolucion 
	 */
	public void setSolucionFinal(String solucionFinal) {
		this.solucionFinal = solucionFinal;
	}
	
	public void setNodoIgual(int n) {
		nodoIgual = n;
	}
	
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
	 * Retorna el tamaño del tablero t
	 * @return tamaño del tablero
	 */
	public int getTamTablero() {
		return this.t.getTamTablero(); 
	}
	
	/***
	 * Devuelve el valor de la casilla (i,j) en el tablero t
	 * @param i fila a devolver el valor
	 * @param j columna a devolver el valor
	 */
	public int getValor(int i, int j) {
		return t.getValor(i, j);  
	}
	
	
	/***
	 * Retorna el numero de nodos generados
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
	
	public int getNodoIgual() {
		return nodoIgual;
	}
	
	public int getNodoPeor() {
		return nodoPeor;
	}
	
	/***
	 * Incrementa la cifra de numero de nodos generados en uno
	 */
	public void addNodos() {
		numNodos++;
	}
	
	public void addNodoIgual() {
		nodoIgual++;
	}
	
	public void addNodoPeor() {
		nodoPeor++;
	}
	
	/**
	 * Mete t en la lista de abiertos
	 * @param t tablero a añadir en la lista abiertos
	 */
	public void addAbierto(Tablero t) {
		abiertos.add(t);
	}
	
	/**
	 * Mete t en la lista de los cerrados
	 * @param t tablero a añadir en la lista cerrados
	 */
	public void addCerrado(Tablero t) {
		cerrados.add(t);
	}
	
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
	 * Ordena la lista de abiertos
	 */
	public void sortAbiertos(){
		Collections.sort(abiertos, new FuncionComparator());
	}
	
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
	
		//Devuelve el tablero repetido
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
	
	//Numero de nodos en abiertos y cerrados que tienen como padre a t
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
	
	
	
	
	
	public ArrayList<Tablero> addHijo(Tablero t, ArrayList<Tablero> hijos){
		hijos.add(t);
		return hijos;
	}
	
	/***
	 * Realiza el algoritmo de escalada de escalada de maxima pendiente y si resuelve el puzzle retorna true
	 */
	public void escaladaSimple() {
		
		long initTime = System.nanoTime();//Tiempo inicial
		boolean fin = false; 
		Tablero nuevo = new Tablero(); 
		Tablero actual = t;
		
		while(nuevo != null && !fin) {
			
			nuevo = new Tablero();
			nuevo = actual.MejorMovimientoES(nuevo, this);
			
			if(nuevo != null) {
				
				nuevo.setPadre(actual);
				actual = nuevo;
				solucionFinal += actual.getMovimiento() + " ";
				
				if(actual.FuncionHeuristica1() == 0) fin = true;
				
			}
		}
		
		long endTime = System.nanoTime();//Tiempo final, ya tenemos hemos dejado de generar nodos
		long tiempo = endTime - initTime;//Tiempo que se tarda en eejcutar el algoritmo
		
		setTiempoEjecucion(tiempo);
		
	}
	
	/***
	 * Realiza el algoritmo de escalada de escalada de maxima pendiente y si resuelve el puzzle retorna true
	 */
	public void escaladaMaximaPendiente() {
		
		long initTime = System.nanoTime();//Tiempo inicial
		
		boolean fin = false;
		Tablero nuevo = new Tablero();
		Tablero actual = t;
		
		while(nuevo != null && !fin) {
			
			nuevo = new Tablero();
			nuevo = actual.MejorMovimientoEMP(nuevo, this);
			
			if(nuevo != null) {
				
				nuevo.setPadre(actual);
				actual = nuevo;
				solucionFinal += actual.getMovimiento() + " ";
				
				if(actual.FuncionHeuristica1() == 0) fin = true;
				
			}
		}
		
		long endTime = System.nanoTime();//Tiempo final, ya tenemos hemos dejado de generar nodos
		long tiempo = endTime - initTime;//Tiempo que se tarda en eejcutar el algoritmo
		setTiempoEjecucion(tiempo);
	
		
	}
	
	
	/***
	 * Realiza el algoritmo de escalada de escalada de maxima pendiente y si resuelve el puzzle retorna true
	 * @return fin
	 */
	public boolean escaladaMaximaPendiente1() {
		
		long initTime = System.nanoTime();//Tiempo inicial
		
		boolean fin = false; solucionFinal = "";
		Tablero nuevo = new Tablero(); Tablero actual = t;
		nodoIgual = 0; nodoPeor = 0;
		
		cerrados = new ArrayList<Tablero>();
		
		while(nuevo != null && nodoIgual < 80 && nodoPeor < 50 && !fin) {
			
			nuevo = new Tablero();
			nuevo = actual.MejorMovimientoEMP1(nuevo, this);
			
			if(nuevo != null) {
				
				nuevo.setPadre(actual);
				actual = nuevo;
				//tfinal = actual;
				solucionFinal += actual.getMovimiento() + " ";
				
				if(actual.FuncionHeuristica1() == 0) fin = true;//TODO porque termina? No entiendo
				
			}
		}
		
		long endTime = System.nanoTime();//Tiempo final, ya tenemos hemos dejado de generar nodos
		long tiempo = endTime - initTime;//Tiempo que se tarda en eejcutar el algoritmo
		setTiempoEjecucion(tiempo);
		
		return fin;
		
	}
	
	
	public void algoritmoA(){
		long initTime = System.nanoTime();//Tiempo inicial
		
		abiertos = new ArrayList<Tablero>();
		cerrados = new ArrayList<Tablero>();
		
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
			actual.GenerarMovimientosA(this, actual.getCoste()+1);
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
		
				
		long endTime = System.nanoTime();//Tiempo final, ya tenemos hemos dejado de generar nodos
		long tiempo = endTime - initTime;//Tiempo que se tarda en eejcutar el algoritmo
		setTiempoEjecucion(tiempo);
	}
	
}
