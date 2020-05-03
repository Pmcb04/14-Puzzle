import java.io.IOException;

public class Pruebas {
	
	final int PRUEBAS = 100;
	final int PUZZLES = 10;
	
	private static Log log;
	
	Pruebas(){

		prueba("EscaladaSimple", "ES", "pruebas/escalada simple");
		prueba("EscaladaMaximaPendiente", "EMP", "pruebas/escalada maxima pendiente");
		prueba("ModificacionEscaladaMaximaPendiente", "MEMP", "pruebas/modificacion escalada maxima pendiente");
		prueba("AEstrella", "A*", "pruebas/A estrella");
		System.out.println("------------------- PRUEBAS TERMINADAS -------------------");
	}
	
	
	/**
	 * metodo para hacer pruebas
	 * @param metodo metodo que vamos a hacer las pruebas
	 * @param abreviatura ebreviatura del metodo {ES, EMP, MEMP, A*}
	 * @param ruta ruta donde se van a situar los ficheros de prueba
	 */
	private void prueba(String metodo, String abreviatura, String ruta) {
		
		int nodos = 0;
		double tiempo = 0;
		int numResultos = 0;
		int numNoResueltos = 0;
		int puzzle = 1;
		int prueba = 1;
		GestorSolucion gs;
		boolean resuelto;
		
		while(puzzle <= PUZZLES) {
			
			try {log = new Log(ruta, "puzzle" + puzzle + metodo + ".txt");
			} catch (IOException e) {e.printStackTrace();}
			
			
			
			while(prueba <= PRUEBAS) {				
				
				gs = getPuzzle("puzzle" + puzzle);
				resuelto = getSolucion(gs, abreviatura);
				
				if(resuelto) numResultos++;
				else numNoResueltos++;
				
				tiempo += gs.getTiempoEjecucion();
				nodos += gs.getNumNodos();
				
				printSolucion(gs.getTiempoEjecucion(), gs.getNumNodos(), resuelto, puzzle, prueba);
				prueba++;
			}
		
			log.print("Tiempo medio empleado: " + tiempo/PRUEBAS + " ms // Nodos generados media: " + nodos/PRUEBAS + " // Nº resueltos: " + numResultos + " // Nº no resueltos: " + numNoResueltos);
			log.closeFile();
			prueba = 1;
			tiempo = 0;
			nodos = 0;
			numResultos = 0;
			numNoResueltos = 0;
			puzzle++;
		}
		
	}
	
	
	/**
	   * Imprime la solucion si se a resuelto, o parte de ella si no
	   * @param puzzle puzzle que se a intentado resolver
	   * @param metodo metodo por el cual se a intentado resolver
	   * @param resuelto bandera que dice si se a resuelto o no
	   */
	  private void printSolucion(double tiempo, int nodos, boolean resuelto, int puzzle, int prueba) {
		  log.print("Tiempo empleado: " + tiempo + " ms // Nodos Generados: " + nodos + " // Resuelto: " + resuelto, prueba, puzzle);

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
