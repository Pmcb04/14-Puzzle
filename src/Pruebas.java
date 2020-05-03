import java.io.IOException;

public class Pruebas {
	
	private final int PUZZLES = 10;
	
	private static Log log;
	private static String[] solucion;
	
	Pruebas(){

		prueba("EscaladaSimple", "ES", "pruebas/escalada simple", 1000);
		prueba("EscaladaMaximaPendiente", "EMP", "pruebas/escalada maxima pendiente", 1000);
		prueba("ModificacionEscaladaMaximaPendiente", "MEMP", "pruebas/modificacion escalada maxima pendiente", 1000);
		prueba("AEstrella", "A*", "pruebas/A estrella", 100);
		System.out.println("------------------- PRUEBAS TERMINADAS -------------------");
	}
	
	
	/**
	 * metodo para hacer pruebas
	 * @param metodo metodo que vamos a hacer las pruebas
	 * @param abreviatura ebreviatura del metodo {ES, EMP, MEMP, A*}
	 * @param ruta ruta donde se van a situar los ficheros de prueba
	 */
	private void prueba(String metodo, String abreviatura, String ruta, int numPruebas) {
		
		int nodos = 0;
		double tiempo = 0;
		int movimientos = 0;
		
		int numResultos = 0;
		int numNoResueltos = 0;
		int numMovimientos = 0;
		int numNodos = 0;
		double tiempoTotal = 0;
		
		int puzzle = 1;
		int prueba = 1;
		GestorSolucion gs;
		boolean resuelto;
		
		while(puzzle <= PUZZLES) {
			
			try {log = new Log(ruta, "puzzle" + puzzle + metodo + ".txt");
			} catch (IOException e) {e.printStackTrace();}
			
			
			
			while(prueba <= numPruebas) {				
				
				gs = getPuzzle("puzzle" + puzzle);
				resuelto = getSolucion(gs, abreviatura);
				
				if(resuelto) numResultos++;
				else numNoResueltos++;
				
				nodos = gs.getNumNodos();
				numNodos += nodos;
				
				if(!abreviatura.equals("A*") && !abreviatura.equals("MEMP")) tiempo = gs.getTiempoEjecucion()*1000000;
				else tiempo = gs.getTiempoEjecucion();
				tiempoTotal += tiempo;
				
				trozearSolucion(gs);
				movimientos = solucion.length;
				numMovimientos += movimientos;
				
				printSolucion(tiempo, nodos, resuelto, puzzle, prueba, movimientos, (!abreviatura.equals("A*") && !abreviatura.equals("MEMP")) );
				
				prueba++;
			}
		
			
			log.print("\n");
			log.print("---------------------------------------------------------------------------------------------------------------------------------------------");
			if(!abreviatura.equals("A*") && !abreviatura.equals("MEMP")) log.print("Tiempo medio empleado: " + tiempoTotal/numPruebas + " ns \nNodos generados media: " + numNodos/numPruebas + " \nNumero movimientos media: " + numMovimientos/numPruebas + " \nNº resueltos: " + numResultos + " \nNº no resueltos: " + numNoResueltos);
			else log.print("Tiempo medio empleado: " + tiempoTotal/numPruebas + " ms \nNodos generados media: " + numNodos/numPruebas + " \nNumero movimientos media: " + numMovimientos/numPruebas + " \nNº resueltos: " + numResultos + " \nNº no resueltos: " + numNoResueltos);
			log.print("---------------------------------------------------------------------------------------------------------------------------------------------");

			
			log.closeFile();
			prueba = 1;
			tiempo = 0;
			nodos = 0;
			movimientos = 0;
			numMovimientos = 0;
			numResultos = 0;
			numNoResueltos = 0;
			puzzle++;
		}
		
	}
	
	  /**
	   * Devuelve si el String pasado por parametro es una direccion cardinal
	   * @param s string a inspeccionar si es una direccion cardinal
	   * @return true en caso de ser una direccion cardinal, false en caso contrario
	   */
	  private boolean isLetra(String s) {
		  if(s.equals("N") || s.equals("S") || s.equals("O") || s.equals("E")) return true;
		  else return false;
	  }
	
	
	  /**
	   * trozea la solucion y la divide en casillas donde cada casilla es el numero a mover y la direccion a la que mover
	   */
	  private void trozearSolucion(GestorSolucion gs) {
		  String[] s = gs.getSolucionFinal().replace(" ", "").split("");
		  int j = 0;
		  String palabra = "";
		  int cont = 0;

		  for (int i = 0; i < s.length; i++) {
			 if(isLetra(s[i])) {
				palabra += s[i];
				s[j] = palabra;
				j++;
				cont++;
				palabra = "";
			 }else {
				 palabra += s[i];

			 }
		  }

		  solucion = new String[cont];
		  for (int i = 0; i < cont; i++)
			  solucion[i] = s[i];

	  }
	
	
	/**
	   * Imprime la solucion si se a resuelto, o parte de ella si no
	   * @param puzzle puzzle que se a intentado resolver
	   * @param metodo metodo por el cual se a intentado resolver
	   * @param resuelto bandera que dice si se a resuelto o no
	   */
	  private void printSolucion(double tiempo, int nodos, boolean resuelto, int puzzle, int prueba, int numMovimientos, boolean medida) {
		  if(medida) log.print("Tiempo empleado: " + tiempo + " ns // Nodos Generados: " + nodos + " // Numero movimientos: " + numMovimientos + " // Resuelto: " + resuelto, prueba, puzzle);
		  else log.print("Tiempo empleado: " + tiempo + " ms // Nodos Generados: " + nodos + " // Numero movimientos: " + numMovimientos + " // Resuelto: " + resuelto, prueba, puzzle);
	  }
	  
	  
	    /**
	     * del puzzle seleccionado se carga del fichero y se almacena en un gestorSolucion
	     * @param puzzle puzzle seleccionado por el usuario
	     * @return GestorSolucion cargado con el puzzle seleccionado
	     */
	    private GestorSolucion getPuzzle(String puzzle){
	    	GestorSolucion g = new GestorSolucion();
	        new InitData(g, puzzle);
	        return g;
	    }
	    
	    
	    /**
	     * Devuelve la solucion al puzzle seleccionado por el usuario, por el metodo elegido
	     * @param g GestorSolucion con el puzzle elegido 
	     * @param algoritmo metodo a resolver el puzzle elegido
	     * @return true en caso de haber hallado una solucion al puzzle, false en caso contrario
	     */
	    private boolean getSolucion(GestorSolucion g, String algoritmo) {

	    	boolean fin = false;
	    	
	    	if(algoritmo.equals("ES")) fin = g.escaladaSimple();
	    	if(algoritmo.equals("EMP")) fin = g.escaladaMaximaPendiente();
	    	if(algoritmo.equals("MEMP")) fin = g.escaladaMaximaPendiente1();
	    	if(algoritmo.equals("A*")) fin = g.algoritmoA();
	    	
	    	return fin;

	    }

	
	
}
