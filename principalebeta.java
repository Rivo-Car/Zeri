
import java.util.Scanner;
import java.util.InputMismatchException;
import exp4j.*;
import Metodi.*;



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
public class principalebeta{

	private static Scanner tastiera = new Scanner(System.in);
	private static Scanner tastiera2= new Scanner(System.in);
	private static String fg;
	private static boolean acceso=true;
	private static String metodo;

	public static Function Fun;
	public static int numero_max_iter, grado, mult;
	public static double a,b,toll_err;
	//le chiamo così perchè  a seconda del caso saranno estremo destro e sinistro, o primo e secondo punto di applicazione dei metodi


	public static double zero;
	public static double resid;
	/**
	* Metodo main
	*/
	public static void main(String[] args){

	while(acceso){
		System.out.print("\n\n Benvenuto nel programma per la ricerca degli zeri di una funzione.\n Inserisci il nome del metodo che vuoi utilizzare per la ricerca degli zeri: \n - Bisezione\n - Punto fisso\n - Newton\n - Metodo delle secanti\n - Metodo delle corde\n\n\n - Chiudi\n");
		metodo=tastiera.nextLine();
		zero= Double.NaN;
		resid= Double.NaN;

		if(metodo.equals("bisezione")||metodo.equals("Bisezione")||metodo.equals("BISEZIONE")){
				input1();
				input2();
				input3();
				try{
				zero=Bisezione.Bisezione(Fun, a, b, toll_err, numero_max_iter);
				System.out.println("La funzione inserita vale zero per x = " + zero);
			} catch (Exception e){System.err.println("ERRORE: "+ e.getMessage());}
		}


			else if(metodo.equals("corde")||metodo.equals("Corde")||metodo.equals("CORDE")){     // metodo delle CORDE
				input1();
				input4();
				input3();
				try{
				zero=Corde.Corde(Fun,a,toll_err,numero_max_iter);
				System.out.println("La funzione inserita vale zero per x = " + zero);
			} catch (Exception e){System.err.println("ERRORE: "+ e.getMessage());}
				}


			else if(metodo.equals("newton")||metodo.equals("Newton")||metodo.equals("NEWTON")){
				input1();
				input4();
				input3();
				try{
				zero=Newton.Newton(Fun,a,toll_err,numero_max_iter);
				System.out.println("la funzione inserita vale zero per x = " + zero);
			}catch (Exception e){System.err.println("ERRORE: "+ e.getMessage());}
				}






			else if(metodo.equals("secanti")||metodo.equals("SECANT")||metodo.equals("Secanti")){
				input1();
				input2();
				input3();
				try{
				zero=Secanti.Secanti(Fun,a,b,toll_err,numero_max_iter);
				System.out.println("la funzione inserita vale zero per x = " + zero);
			} catch (Exception e){System.err.println("ERRORE: "+ e.getMessage());}
				;

				}










			else if(metodo.equals("Chiudi")||metodo.equals("chiudi")||metodo.equals("CHIUDI")){
				System.out.println("\nGrazie mille!\n Buona giornata\n\n");
				acceso = false;
				}
			else {
				System.out.println("\n Attenzione: il metodo selezionato non corrisponde a quelli disponibili, riprovare: ");
				}





		}
	}
	public static void input1(){
		try{
			System.out.println("Inserire la funzione di cui calcolare gli zeri: ");
			fg=tastiera2.nextLine();
			Fun = new Function(fg);
		} catch(InputMismatchException e ){ System.err.println("valori di input non validi ");}
	}
	public static void input2(){
		try{
			System.out.println("inserire l'estremo sinistro \n in caso si usi il metodo delle secanti, inserire il primo punto di partenza ");
			a=tastiera2.nextDouble();
			System.out.println("inserire l'estremo destro \n in caso si usi il metodo delle secanti, inserire il secondo punto di partenza ");
			b=tastiera2.nextDouble();
		}
			catch(InputMismatchException e ){ System.err.println("valori di input non validi ");}
		}
	public static void input3(){
		try {
			System.out.println("inserire la tolleranza desiderata ");
			toll_err=tastiera2.nextDouble();
			System.out.println("inserire il numero massimo di iterazioni ");
			numero_max_iter=tastiera2.nextInt();
			}
			catch(InputMismatchException e ){ System.err.println("valori di input non validi ");}
	}
	public static void input4(){
		try{
			System.out.println("Inserire il nodo di partenza ");
			a=tastiera2.nextInt();

		} catch(InputMismatchException e ){ System.err.println("valori di input non validi ");}

	}
	public static void input5(){
		try{
			System.out.println("inserire la molteplicità degli zeri da trovare ");
			mult=tastiera2.nextInt();
		} catch(InputMismatchException e ){System.err.println("valore in input non valido ");}
		}

	}
