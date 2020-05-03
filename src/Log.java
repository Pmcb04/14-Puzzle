import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/***
 * Class FileBarcos
 * @author Pedro Miguel Carmona Broncano
 *
 */
public class Log {
	
	private static FileWriter log;
	private static String name;
	
	
	/***
	 * Contructor por defecto de la clase Log, imprime un mensaje como que se a creado
	 * @param ruta ruta del fichero
	 * @param name nombre del fichero
	 * @throws IOException
	 */
	Log(String ruta, String name) throws IOException{
		Log.name = name;
		log = new FileWriter(new File(ruta, name));
		System.out.println("Fichero " + name + " creado...");
	}
	
	/***
	 * Metodo que escribe en el fichero log, tambien imprime por pantalla la prueba realizada para el puzzle en cuestion
	 * @param s string a escribir en el fichero
	 * @param numPrueba numero de prueba a realizar
	 * @param puzzle puzzle a realizar la prueba
	 */
	public void  print(String s, int numPrueba, int puzzle) {
		try{
			System.out.println("Realizando prueba " + numPrueba + " del puzzle " + puzzle);
			log.write("[" + "prueba " + numPrueba + " puzzle " + puzzle + "] " + s + "\n");
		}catch(IOException e) {
			System.out.println("++++++++++++++++EXCEPTION FILE++++++++++++++++");
		};
		
	}
	
	/***
	 * Metodo que escribe en el fichero log
	 * @param s string a escribir en el fichero
	 */
	public void  print(String s) {
		try{
			log.write(s + "\n");
		}catch(IOException e) {
			System.out.println("++++++++++++++++EXCEPTION FILE++++++++++++++++");
		};
		
	}
	
	/***
	 * Metodo para cerrar el fichero, imprime un mensaje como que se a terminado de cerrar
	 */
	public void closeFile() {
		try {
			log.close();
			System.out.println("Fichero " + name + " completado !!!");
		} catch (Exception e) {System.out.println("++++++++++++++++EXCEPTION CLOSE FILE++++++++++++++++");}
	}

}
