import java.util.*;

/**
 * Clase Tablero
 * @author Pedro Miguel Carmona & Ruben Marin Lucas
 *
 */
public class Tablero {
	
	private final int MAX_TAM = 8;//tam de matriz
	private final int MAX_MOVIMIENTOS = 4;
  	private Tablero padre;//para unir los tableros que probablemente formen parte de la solucion
	private int matrizTablero[][];
	private int tamTablero;//tamReal del tablero
	private ArrayList<Nulo> nulos; //para saber la posicion de todos los 0 en cualquier momento
	private String movimiento;
	private int coste;
	private int h;
	private int funcion;
	
	
	 /**
     * Constructor por defecto de objetos de tipo Tablero
     */
	public Tablero() {
		
		padre = null;
		coste = 0;
		nulos = new ArrayList<Nulo>();
		matrizTablero = new int[MAX_TAM][MAX_TAM];
		movimiento = " ";
		
		for(int i = 0; i < tamTablero; i++) 
			for(int j = 0; j < tamTablero; j++) 
				matrizTablero[i][j] = -1;

	}

	/**
	 * Añadir el valor en la pos i, j de la matriz
	 */
	public void setValor(int valor, int i, int j) {
		matrizTablero[i][j] = valor;
	}
	
	/**
	 * El puntero "padre" del tablero pasa a apuntar al tablero t
	 */
	public void setPadre(Tablero t) {
		padre = t;
	}
	
	/**
     * El tamaño del tablero pasa a valer tamTablero
     */
	public void setTamTablero(int tamTablero) {
		this.tamTablero = tamTablero;
	}
	
	/**
     * Añadimos un nuevo nulo en nuestro arraylist con las posiciones i, j que ocupa en 
     */
	public void setNulo(int i, int j) {
		Nulo n = new Nulo();
		n.i = i;
		n.j = j;
		nulos.add(n);
	}
	
	public void setMovimiento(String s) {
		movimiento = s;
	}
	
	public void setHeuristica(int heuristica) {
		h = heuristica;
	}
	
	public void setCoste(int coste) {
		this.coste = coste;
	}
	
		public void setFuncion(int heuristica, int coste) {
			funcion = (int) (1.6*heuristica + 0.4*coste);
		}
		
	
	/**
     * Obtener el valor de la casilla con pos i, j
     */
	public int getValor(int i, int j) {
		return matrizTablero[i][j];
	}
	
	/**
     * Obtiene el tamaño real del tablero
     */
	public int getTamTablero() {
		return tamTablero;
	}
	
	public Nulo getNulo(int pos) {
		Nulo n = nulos.get(pos);
		return n;
	}
	
	public Tablero getPadre() {
		return padre;
	}

	public String getMovimiento() {
		return movimiento;
	}
	
	public int getHeuristica() {
		return h;
	}
	
	public int getCoste() {
		return coste;
	}
	
	public int getFuncion() {
		return funcion;
	}
	

	
	/**
     * Constructor por defecto de objetos de tipo Tablero
     */
	public Nulo elegirNulo() {
		Random r = new Random();
		Nulo n = nulos.get(r.nextInt(nulos.size()));
		return n;
	}
	
	/**
     * Elige un movimiento aleatorio
     */
	public int elegirMovimiento(Nulo n) {
		Random r = new Random();
		return r.nextInt(MAX_MOVIMIENTOS);
	}
	
	/**
     * Intercambia 0 por su casilla norte y viceversa
     * La casilla que está al norte del Nulo n es movida al sur 
     * @return true si el movimiento se a producido y false en caso contrario
     */
	public boolean moverNorte(Nulo n) {
		
		boolean movimiento = false; int aux;
		if(n.i != 0 && matrizTablero[n.i-1][n.j] > 0) {
			movimiento = true;
			this.movimiento = matrizTablero[n.i-1][n.j] + "S";
			aux = matrizTablero[n.i][n.j];
			matrizTablero[n.i][n.j] = matrizTablero[n.i-1][n.j];
			matrizTablero[n.i-1][n.j] = aux;
			n.i = n.i-1;
			
		}
		
		return movimiento;
		
	}
	
	
	/**
     * Intercambia 0 por su casilla este y viceversa
     * La casilla que esta al este del Nulo n es movida al oeste
     * @return true si el movimiento se a producido y false en caso contrario     
     */
	public boolean moverEste(Nulo n) {
		
		boolean movimiento = false; int aux;
		
		if(n.j != tamTablero-1 && matrizTablero[n.i][n.j+1] > 0) {
			movimiento = true;
			this.movimiento = matrizTablero[n.i][n.j+1] + "O";
			aux = matrizTablero[n.i][n.j];
			matrizTablero[n.i][n.j] = matrizTablero[n.i][n.j+1];
			matrizTablero[n.i][n.j+1] = aux;
			n.j = n.j+1;
			
		}
		
		return movimiento;
		
	}
	
	/**
     * Intercambia 0 por su casilla sur y viceversa
     * La casilla que esta al sur del Nulo n es movida al Norte
     * @return true si el movimiento se a producido y false en caso contrario     
     */
	public boolean moverSur(Nulo n) {
		
		boolean movimiento = false; int aux;
		
		if(n.i != tamTablero-1 && matrizTablero[n.i+1][n.j] > 0) {
			movimiento = true;
			this.movimiento = matrizTablero[n.i+1][n.j] + "N";
			aux = matrizTablero[n.i][n.j];
			matrizTablero[n.i][n.j] = matrizTablero[n.i+1][n.j];
			matrizTablero[n.i+1][n.j] = aux;
			n.i = n.i+1;
			
		}
		
		return movimiento;
		
	}
	
	
	/**
     * Intercambia 0 por su casilla oeste y viceversa
     * La casilla que esta al oeste (siempre que no sea 0) del Nulo n es movida al este
     * @return true si el movimiento se a producido y false en caso contrario     
     */
	public boolean moverOeste(Nulo n) {
		
		boolean movimiento = false; int aux;
		
		if(n.j != 0 && matrizTablero[n.i][n.j-1] > 0) {
			movimiento = true;
			this.movimiento = matrizTablero[n.i][n.j-1] + "E";
			aux = matrizTablero[n.i][n.j];
			matrizTablero[n.i][n.j] = matrizTablero[n.i][n.j-1];
			matrizTablero[n.i][n.j-1] = aux; 
			n.j = n.j-1;
			
		}
		
		return movimiento;
		
	}
	
	/**
     * A partir del numero hallar su posicion i
     */
	public int posi(int num) {
		int i = num/tamTablero;
		if(num % tamTablero == 0) {
			i--;
		}
		return  i;
	}
	
	
	/**
     * A partir del numero y su posicion i hallar su posicion j 
     */
	public int posj(int num, int posi) {
		return  (num-tamTablero*posi-1);
	}
	
	
	/**
     * Halla la distancia que hay desde la posicion adecuada a la posicion real
     * 1 -> pos adecuada , 2 -> pos real
     * @return distancia entre pos adecuada y pos real
     */
	public int Hallardistancia(int i1, int j1, int i2, int j2) {
		return Math.abs(i1-i2) + Math.abs(j1-j2);
		
	}
	
	/**
     * Se suman todas las distancias a la que se encuentran cada num a su casilla
     * mejor h' cuando h' = 0
     * @return h' del tablero en funcion de las distancias de las casillas a su sitio
     */
	public int FuncionHeuristica1() {
		
		int fila = 0, columna = 0, cont = 0;
	
		for(int i = 0; i < tamTablero; i++) 
			for(int j = 0; j < tamTablero; j++) 
				if(matrizTablero[i][j] != 0) {
					fila = posi(matrizTablero[i][j]);
					columna = posj(matrizTablero[i][j], fila);
					cont += Hallardistancia(fila, columna, i, j);	
				}
		
		return cont;
		
	}
	
	
	/**
     * Se suma 1 por cada num que coincida en su casilla
     * mejor h' cuando h' = tamTablero*tamTablero
     * @return h' del tablero en funcion a las casillas que se encuentren en su sitio
     */
	public int FuncionHeuristica2() {
		
		int cont = 0;
		
		for(int i = 0; i < tamTablero; i++) 	
			for(int j = 0; j < tamTablero; j++) 
				if(matrizTablero[i][j] != 0) {
					int posi = posi(matrizTablero[i][j]);
					if(i == posi && j == posj(matrizTablero[i][j], posi)) 
						cont++;
					
				}
				
		return cont;
		
	}
	
	
	public void print() {
		
		for(int i = 0; i < tamTablero; i++) {
			for(int j = 0; j < tamTablero; j++) 
				System.out.print(matrizTablero[i][j] + " ");
			System.out.println();
		}
		
		Iterator<Nulo> it = nulos.iterator();
		while(it.hasNext()) {
			Nulo n = it.next();
			String s = "i: " + n.i + " " + "j: " + n.j + "\n";
			System.out.printf(s);
		}

	}
	
	/*public void imprimirMovimiento() {
		System.out.printf(movimiento + " ");
	}*/
	
	/**
	 * Constructor por copia
	 * @param t tablero al que copiar
	 * @return tablero copiado del original
	 */
	public Tablero copy(Tablero t) {
		
		t.setTamTablero(tamTablero);
		t.setMovimiento(movimiento);
		for(int i = 0; i < t.tamTablero; i++) 
			for(int j = 0; j < t.tamTablero; j++) 
				t.setValor(matrizTablero[i][j], i, j);

		if(!t.nulos.isEmpty()) 
			t.nulos.clear();
		
		
		Iterator<Nulo> it = nulos.iterator();
		while (it.hasNext()) {
			Nulo n = new Nulo();
			Nulo n1 = it.next();
			n.i = n1.i;
			n.j = n1.j;
			t.nulos.add(n);
		}
	
		return t;
		
	}
	
	
	/*public boolean comprobarMatriz(Tablero t) {//Si las dos matrices(la actual y la de t) son iguales devuelve true
			
		boolean enc = true; int i = 0, j = 0;
			
		while(i < tamTablero && enc) {
			while(j < tamTablero && enc) {
				if(t.getValor(i, j) != matrizTablero[i][j]) 
					enc = false;
				j++;	
			}	
			i++;
		}
			
		return enc;
			
	}*/
		
		
	/*public boolean Pertenece (ArrayList<Tablero> cjto) {//Comprueba si este tablero esta incluido en el conjunto, devuelve true en este caso
			
		boolean enc = false;
			
		if(!cjto.isEmpty()) {
			Iterator<Tablero> it = cjto.iterator();
			while(it.hasNext() && !enc) {
				Tablero t = it.next();
				enc = comprobarMatriz(t);	
			}
		}
			
		return enc;
	}*/
		
	/**
	 * Genera una secuencia aleatoria de los movimientos para mover el tablero
	 * 0 -> Norte N
	 * 1 -> Este E
	 * 2 -> Oeste 0
	 * 3 -> Sur S
	 * @return ArrayList lista con la secuencia de movimientos
	 */
	public ArrayList<Integer> generarMovimientos() {
		ArrayList <Integer> movimientos = new ArrayList<Integer>();
		Integer i = 0;
		while(i<4) {
			movimientos.add(i);
			i++;
		}
		Collections.shuffle(movimientos);
		return movimientos;
	}
	
	/**
	 * Genera una secuencia aleatoria de los indices de la lista de nulos de cada tablero
	 * @return Arraylist lista con la secuencia de indices de nulos
	 */
	public ArrayList<Integer> generarMovNulos(){
		ArrayList <Integer> random = new ArrayList<Integer>();
		Integer i = 0;
		while(i< nulos.size()) {
			random.add(i);
			i++;
		}
		Collections.shuffle(random);
		return random;
		
	}
	
	/**
	 * Genera el mejorMovimiento en cada paso de la escalada simple, como es escalada simple, 
	 * en cuanto gener uno mejor del anterior, devuelve ese tablero
	 * @param mejor tablero mejor hasta el momento
	 * @param g gestorSolucion para almacenar el numero de nodos generado
	 * @return Tablero el primer mejor tablero encontrado con respecto al anterior
	 */
	public Tablero MejorMovimientoES(Tablero mejor, GestorSolucion g) {
		Tablero aux = new Tablero(); 
		copy(aux); 
	    boolean enc = false;
	    int mejorh = this.FuncionHeuristica1();
	    
		ArrayList <Integer> nulo = generarMovNulos(); //Array con numeors que representan los nulos
		
		while(!nulo.isEmpty() && !enc) {
			
			ArrayList <Integer> mov = generarMovimientos(); //Array con todos los movimientos aleatorios
			Integer num = nulo.get(0);
			
			while(!mov.isEmpty() && !enc) {
				
				Integer movimiento = mov.get(0);
				Nulo n = aux.getNulo(num);
				
				switch(movimiento) {
					case 0:
						if(aux.moverNorte(n)) g.addNodos();
						break;
						
					case 1:
						if(aux.moverEste(n)) g.addNodos();
						break;
						
					case 2:
						if(aux.moverOeste(n)) g.addNodos();
						break;
					
					case 3:
						if(aux.moverSur(n)) g.addNodos();
						break;
			
				}
				
				int h = aux.FuncionHeuristica1();
				
				if(h < mejorh) {
					enc = true;
					aux.copy(mejor);
				}
				
				mov.remove(0);
				copy(aux);
				
		    }
			
			nulo.remove(0);
			copy(aux);
			
		}
		
		if(!enc) mejor =  null;
		
		return mejor;
	}
	
	/**
	 * Genera el mejorMovimiento en cada paso de la escalada maxima pendiente, 
	 * como es escalada maxima pendiente tiene que ver todos los movimientos posibles y elegir el mejor de todos
	 * @param mejor tablero mejor hasta el momento
	 * @param g gestorSolucion para almacenar el numero de nodos generado
	 * @return Tablero el mejor tablero encontrado con respecto al anterior
	 */
	public Tablero MejorMovimientoEMP(Tablero mejor, GestorSolucion g) {
		Tablero aux = new Tablero(); 
		copy(aux); 
	    boolean enc = false; 
	    int mejorh = this.FuncionHeuristica1();
	    
		ArrayList <Integer> nulo = generarMovNulos(); //Array con numeros que representan los nulos
		
		while(!nulo.isEmpty()) {
			
			ArrayList <Integer> mov = generarMovimientos(); //Array con todos los movimientos aleatorios
			Integer num = nulo.get(0);
			
			while(!mov.isEmpty()) {
				
				Integer movimiento = mov.get(0);
				Nulo n = aux.getNulo(num);
				
				switch(movimiento) {
					case 0:
						if(aux.moverNorte(n)) g.addNodos();
						break;
						
					case 1:
						if(aux.moverEste(n)) g.addNodos();
						break;
						
					case 2:
						if(aux.moverOeste(n)) g.addNodos();
						break;
					
					case 3:
						if(aux.moverSur(n)) g.addNodos();
						break;
			
				}
				
				int h = aux.FuncionHeuristica1();
				
				if(h < mejorh) {
					mejorh = h;
					enc = true;
					aux.copy(mejor);
				}
				
				mov.remove(0);
				copy(aux);
				
		    }
			
			nulo.remove(0);
			copy(aux);
			
		}
		
		if(!enc) mejor =  null;
		
		return mejor;
	}
	
	public void GenerarMovimientosA1(GestorSolucion g, int coste) {//A*con atajos
		Tablero aux = new Tablero(); 
		copy(aux); // copiamos el tablero actual
		boolean fin = false;  boolean b0, b1; Tablero t; 
		int k;
		
		ArrayList<Tablero> repetidos = new ArrayList<Tablero>();
		
		ArrayList <Integer> nulo = generarMovNulos(); //Array con numeros que representan los nulos
		while(!nulo.isEmpty() && !fin) {
			
			ArrayList <Integer> mov = generarMovimientos(); //Array con todos los movimientos aleatorios
			Integer num = nulo.get(0);
			
			while(!mov.isEmpty() && !fin) {
				
				Integer movimiento = mov.get(0);
				Nulo n = aux.getNulo(num);
				
				switch(movimiento) {
					case 0:
						if(aux.moverNorte(n)) {
							b0 = g.isCerrado(aux); b1 = g.isAbierto(aux);
							
							aux.setHeuristica(aux.FuncionHeuristica1());
							aux.setCoste(coste);
							aux.setFuncion(aux.getHeuristica(), coste);
							
							if(!b0 &&  !b1){
								aux.setPadre(this);
								g.addNodos();
								g.addAbierto(aux);
								if(aux.getHeuristica() == 0) fin = true;
								aux = new Tablero();
							}else{
								
								if(b1) {//si el tablero está en abiertos, no puede tener hijos, porque no se ha llegado a expandir
									t = g.getRepetidoAbiertos(aux);
									if(aux.getFuncion() < t.getFuncion()) {
										g.addNodos();
										t.setHeuristica(aux.getHeuristica());
										t.setCoste(coste);
										t.setFuncion(aux.getHeuristica(), coste);
										t.setPadre(this); 
										g.sortAbiertos();
									}
								}else {
									t = g.getRepetidoCerrados(aux);
									if(aux.getFuncion() < t.getFuncion()) {
										g.addNodos();
										t.setHeuristica(aux.getHeuristica());
										t.setCoste(coste);
										t.setFuncion(aux.getHeuristica(), coste);
										t.setPadre(this);
										g.addHijo(t, repetidos);
										k = repetidos.size();
										while(k > 0) {
											repetidos = g.Busqueda(repetidos);
											k = repetidos.size();
										}
									}	
							   }
						    }
						}
						break;
						
					case 1:
						if(aux.moverEste(n)) {
							b0 = g.isCerrado(aux); b1 = g.isAbierto(aux);
							
							aux.setHeuristica(aux.FuncionHeuristica1());
							aux.setCoste(coste);
							aux.setFuncion(aux.getHeuristica(), coste);
							
							if(!b0 &&  !b1){
								aux.setPadre(this);
								g.addNodos();
								g.addAbierto(aux);
								if(aux.getHeuristica() == 0) fin = true;
								aux = new Tablero();
							}else{
								
								if(b1) {
									t = g.getRepetidoAbiertos(aux);
									if(aux.getFuncion() < t.getFuncion()) {
										g.addNodos();
										t.setHeuristica(aux.getHeuristica());
										t.setCoste(coste);
										t.setFuncion(aux.getHeuristica(), coste);
										t.setPadre(this); 
										g.sortAbiertos();
									}
								}else {
									t = g.getRepetidoCerrados(aux);
									if(aux.getFuncion() < t.getFuncion()) {
										g.addNodos();
										t.setHeuristica(aux.getHeuristica());
										t.setCoste(coste);
										t.setFuncion(aux.getHeuristica(), coste);
										t.setPadre(this);
										g.addHijo(t, repetidos);
										k = repetidos.size();
										while(k > 0) {
											repetidos = g.Busqueda(repetidos);
											k = repetidos.size();
										}
									}	
							   }
						    }
						}
						break;
						
					case 2:
						if(aux.moverOeste(n)) {
							b0 = g.isCerrado(aux); b1 = g.isAbierto(aux);
							
							aux.setHeuristica(aux.FuncionHeuristica1());
							aux.setCoste(coste);
							aux.setFuncion(aux.getHeuristica(), coste);
							
							if(!b0 &&  !b1){
								aux.setPadre(this);
								g.addNodos();
								g.addAbierto(aux);
								if(aux.getHeuristica() == 0) fin = true;
								aux = new Tablero();
							}else{
								
								if(b1) {
									t = g.getRepetidoAbiertos(aux);
									if(aux.getFuncion() < t.getFuncion()) {
										g.addNodos();
										t.setHeuristica(aux.getHeuristica());
										t.setCoste(coste);
										t.setFuncion(aux.getHeuristica(), coste);
										t.setPadre(this); 
										g.sortAbiertos();
									}
								}else {
									t = g.getRepetidoCerrados(aux);
									if(aux.getFuncion() < t.getFuncion()) {
										g.addNodos();
										t.setHeuristica(aux.getHeuristica());
										t.setCoste(coste);
										t.setFuncion(aux.getHeuristica(), coste);
										t.setPadre(this);
										g.addHijo(t, repetidos);
										k = repetidos.size();
										while(k > 0) {
											repetidos = g.Busqueda(repetidos);
											k = repetidos.size();
										}
									}	
							   }
						    }
						}
						break;
					
					case 3:
						if(aux.moverSur(n)) {
							b0 = g.isCerrado(aux); b1 = g.isAbierto(aux);
							
							aux.setHeuristica(aux.FuncionHeuristica1());
							aux.setCoste(coste);
							aux.setFuncion(aux.getHeuristica(), coste);
							
							if(!b0 &&  !b1){
								aux.setPadre(this);
								g.addNodos();
								g.addAbierto(aux);
								if(aux.getHeuristica() == 0) fin = true;
								aux = new Tablero();
							}else{
								
								if(b1) {
									t = g.getRepetidoAbiertos(aux);
									if(aux.getFuncion() < t.getFuncion()) {
										g.addNodos();
										t.setHeuristica(aux.getHeuristica());
										t.setCoste(coste);
										t.setFuncion(aux.getHeuristica(), coste);
										t.setPadre(this); 
										g.sortAbiertos();
									}
								}else {
									t = g.getRepetidoCerrados(aux);
									if(aux.getFuncion() < t.getFuncion()) {
										g.addNodos();
										t.setHeuristica(aux.getHeuristica());
										t.setCoste(coste);
										t.setFuncion(aux.getHeuristica(), coste);
										t.setPadre(this);
										g.addHijo(t, repetidos);
										k = repetidos.size();
										while(k > 0) {
											repetidos = g.Busqueda(repetidos);
											k = repetidos.size();
										}
									}	
							   }
						    }
						}
						break;
			
				}
				 
				mov.remove(0);
				copy(aux);
				
		    }
			
			nulo.remove(0);
			copy(aux);
			
		}
	}
	
	/**
	 * Genera el mejorMovimiento en cada paso del algoritmo de A*, 
	 * como es algoritmo A*, tiene que coger el que que menos f'(n) nos de
	 * @param g gestorSolucion para almacenar el numero de nodos generado
	 */
	public void GenerarMovimientosA(GestorSolucion g, int coste) {
		Tablero aux = new Tablero(); 
		copy(aux); // copiamos el tablero actual
		
		ArrayList <Integer> nulo = generarMovNulos(); //Array con numeros que representan los nulos
		while(!nulo.isEmpty()) {
			
			ArrayList <Integer> mov = generarMovimientos(); //Array con todos los movimientos aleatorios
			Integer num = nulo.get(0);
			
			while(!mov.isEmpty()) {
				
				Integer movimiento = mov.get(0);
				Nulo n = aux.getNulo(num);
				
				switch(movimiento) {
					case 0:
						if(aux.moverNorte(n)){
							if((!g.isCerrado(aux) &&  !g.isAbierto(aux))) {
								aux.setPadre(this);
								aux.setHeuristica(aux.FuncionHeuristica1());
								aux.setCoste(coste);
								aux.setFuncion(aux.getHeuristica(), coste);
								g.addNodos();
								g.addAbierto(aux);		
								aux = new Tablero();
							}
						}
								
						break;
						
					case 1:
						if(aux.moverEste(n)) {
							if((!g.isCerrado(aux) &&  !g.isAbierto(aux))) {	
								aux.setPadre(this);
								aux.setHeuristica(aux.FuncionHeuristica1());
								aux.setCoste(coste);
								aux.setFuncion(aux.getHeuristica(), coste);
								g.addNodos();
								g.addAbierto(aux);
								aux = new Tablero();
							}
						}
						break;
						
					case 2:
						if(aux.moverOeste(n)) {
							if((!g.isCerrado(aux) &&  !g.isAbierto(aux))) {	
								aux.setPadre(this);
								aux.setHeuristica(aux.FuncionHeuristica1());
								aux.setCoste(coste);
								aux.setFuncion(aux.getHeuristica(), coste);
								g.addNodos();
								g.addAbierto(aux);
								aux = new Tablero();
							}
						}
						break;
					
					case 3:
						if(aux.moverSur(n)) {
							if((!g.isCerrado(aux) &&  !g.isAbierto(aux))) {
								aux.setPadre(this);
								aux.setHeuristica(aux.FuncionHeuristica1());
								aux.setCoste(coste);
								aux.setFuncion(aux.getHeuristica(), coste);
								g.addNodos();
								g.addAbierto(aux);
								aux = new Tablero();
							}
						}
						break;
			
				}
				 
				mov.remove(0);
				copy(aux);
				
		    }
			
			nulo.remove(0);
			//copy(aux);
			
		}
	}
	
}
