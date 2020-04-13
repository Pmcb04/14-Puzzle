import java.util.*;
/**
 * Clase FuncionComparator
 * 
 * @author Pedro Miguel Carmona Broncano & Ruben Marin Lucas
 */
class FuncionComparator implements Comparator<Tablero>
{
    public int compare(Tablero t1, Tablero t2){
       
    	return Integer.compare(t1.getFuncion(), t2.getFuncion());
    }

}