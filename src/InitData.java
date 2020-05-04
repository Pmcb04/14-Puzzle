import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Clase InitData
 * @author Pedro Miguel Carmona, Ruben Marin Lucas
 *
 */
public class InitData {
	
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * Constructor de la clase InitData
	 * @param g gestor solucion a utilizar
	 * @param puzzle nombre del puzzle elegido para resolver
	 */
	InitData(GestorSolucion g, String puzzle) {
	
		String s = puzzle;
		String ss[];
		ss = s.split(" ");
		s = "ficherosPuzzle/" + ss[0].toLowerCase() + ss[1] + ".txt";
		FileReader file;
		try {
			file = new FileReader(s);
		
		sc = new Scanner(file);
		String vS[];
		
		int i = 0;
		while(sc.hasNext()) {
			vS = sc.nextLine().split(",");
			for (int j = 0; j < vS.length; j++) {
				int k = Integer.parseInt(vS[j]);
				g.setValor(k, i, j);
				if(k == 0) {
					g.setNulo(i, j);
				}
			}
			i++;
		}
		
		g.setTamTablero(i);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	

	
}
