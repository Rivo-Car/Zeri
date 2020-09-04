import java.util.Scanner;
import java.util.InputMismatchException;



//   javac -classpath .:lib/jep-2.4.1.jar:progettoInfo.jar principale.java
//   java -classpath .:lib/jep-2.4.1.jar:progettoInfo.jar principale


//   javadoc *.java -d documentazione/ -private -classpath .:lib/jep-2.4.1.jar -link https://docs.oracle.com/javase/8/docs/api/
//   javadoc *.java -d documentazione/ -classpath .:lib/jep-2.4.1.jar -link https://docs.oracle.com/javase/8/docs/api/
//   javadoc progettoInfo/*.java -d documentazione/ -classpath .:lib/jep-2.4.1.jar -link https://docs.oracle.com/javase/8/docs/api/



//    jar cf progettoInfo.jar progettoInfo/*.class





/**
* classe contenente il main del programma.
* <br>
* Il programma e' stato sviluppato per essere interattivo con l'utente, con l'obiettivo di risolvere
* delle equazioni del tipo f(x)=..., trovando una x' tale che f(x')~=0.
* <br>
* Questo programma fa uso della libreria <a href="http://www.singularsys.com/jep/download-trial.php">jep-2.4.1</a>, in particolare sfrutta gli oggetti della classe <a href="http://www.singularsys.com/jep/doc/javadoc/index.html">JEP</a> e della classe DJep.
* <br>
* I metodi disponibili sono: bisezione, Newton, corde, secanti, Laguerre, punto fisso.
* <br>
* <b> NB:</b> in Laguerre bisogna inserire un polinomio
* <br>
* <b> NB:</b> in punto fisso bisogna inserire la g(x) tale che f(x')~=0 se g(x')~=x'
*
* @author Alessandro Reami
* @version 3.0
*/
public class iftest{

	private static Scanner tastiera = new Scanner(System.in);
	private static Scanner tastiera2= new Scanner(System.in);
	private static String funz;
	private static boolean rimanere=true;
	private static String azione;


	public static int iter, grado;
	public static double sx_x0,dx_x1,toll_ass;
	//le chiamo così perchè  a seconda del caso saranno estremo destro e sinistro, o primo e secondo punto di applicazione dei metodi


	public static double risultato;
	public static double resid;
	/**
	* Metodo main
	*/
	public static void main(String[] args){

	while(rimanere){
		System.out.print("\n\n Benvenuto nel programma per la ricerca degli zeri di una funzione.\n Inserisci il nome del metodo che vuoi utilizzare per la ricerca degli zeri: \n - Bisezione\n - Punto fisso\n - Newton\n - Metodo delle secanti\n - Metodo delle corde\n\n\n - Chiudi\n");
		azione=tastiera.nextLine();
		risultato= Double.NaN;
		resid= Double.NaN;

		if(azione.equals("bisezione")||azione==("Bisezione")||azione.equals("BISEZIONE")){

				System.out.println("BELLA, BISEZ ");

				}


			else if(azione.equals("punto fisso")||azione==("Punto fisso")||azione==("PUNTO FISSO")){     // punto fisso

				System.out.println("PUNTO FISSO BROOOH");

				}


			else if(azione.equals("newton")||azione.equals("Newton")||azione.equals("NEWTON")){

				System.out.println("NEWTON VECIOOOH");

				}



			else if(azione.equals("secanti")||azione.equals("SECANT")||azione==("Secanti")){


				System.out.println("secanti dbbb");

				}










			else if(azione.equals("Chiudi")||azione.equals("chiudi")||azione.equals("CHIUDI")){
				System.out.println("\nGrazie mille!\n Buona giornata\n\n");
				rimanere = false;
				}
			else {
				System.out.println("\n Attenzione: il metodo selezionato non corrisponde a quelli disponibili, riprovare: ");
				}


		}
	}
}
