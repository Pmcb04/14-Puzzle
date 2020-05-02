import java.util.*;
/**
 * Clase FuncionComparator
 * 
 * @author Pedro Miguel Carmona Broncano, Ruben Marin Lucas
 */
class FuncionComparator implements Comparator<Tablero>
{
	/**
	 * metodo que compara los dos tablero por su funcion
	 * @param t1 tablero 1 para comparar
	 * @param t2 tablero 2 para comparar
	 */
    public int compare(Tablero t1, Tablero t2){
       
    	return Integer.compare(t1.getFuncion(), t2.getFuncion());
    }

}