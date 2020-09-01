import net.objecthunter.exp4j.*;
import java.util.*;

import Metodi.*;
public class Zeri {
	private static Scanner tastiera = new Scanner(System.in);
	private static Scanner tastiera2= new Scanner(System.in);
	private static Scanner tastiera3= new Scanner(System.in);
	private static String fg, dfg;
	private static boolean acceso=true;
	private static String metodo;

	public static Function Fun;
	public static int numero_max_iter, grado, mult;
	public static double a,b,toll_err;
	//le chiamo così perchè  a seconda del caso saranno estremo destro e sinistro, o primo e secondo punto di applicazione dei metodi

	public static double zero = 0;
	public static double resid;
	
	/**
	* Metodo main
	*/
	public static void main(String[] args){

	while(acceso){
		
		System.out.print("\n\n Benvenuto nel programma per la ricerca degli zeri di una funzione.\n"
				+ " Inserisci il nome del metodo che vuoi utilizzare per la ricerca degli zeri: \n "
				+ "- Bisezione\n "
				+ "- Newton\n "
				+ "- Secanti\n "
				+ "- Corde\n\n "
				+ "- Chiudi\n");
		
		metodo=tastiera.nextLine();
		zero= Double.NaN;
		resid= Double.NaN;

		if(metodo.equals("bisezione")||metodo.equals("Bisezione")||metodo.equals("BISEZIONE")){
			 do {
				   inputf();
				   input2();
				   input3();
						 
			  try{			  
				  zero=Bisezione.Bisezione(Fun, a, b, toll_err, numero_max_iter);
				  System.out.println("La funzione inserita vale zero per x = " + zero);
				
			  } 
			  catch (Exception e){System.err.println("ERRORE: "+ e.getMessage());}
		}
			 
		    while(ripassafunzione()); 
	}

			else if(metodo.equals("corde")||metodo.equals("Corde")||metodo.equals("CORDE")){     // metodo delle CORDE
				
			 do {	
				    input1();
				    input4();
				    input3();
				
			  try{
				  zero=Corde.Corde(Fun, a,toll_err,numero_max_iter);
				  System.out.println("La funzione inserita vale zero per x = " + zero);
			  } 
			  catch (Exception e){
				  System.err.println("ERRORE: "+ e.getMessage());
				  }
				}
			
		     while(ripassafunzione());  
		   }
		
			else if(metodo.equals("newton")||metodo.equals("Newton")||metodo.equals("NEWTON")){
			 do {	
					input1();
					input4();
					input3();
					
		      try{
				 
		    	 zero=Newton2.Newton(Fun,a,1,toll_err,numero_max_iter);
				 System.out.println("la funzione inserita vale zero per x = " + zero);
			 }
		      
		      catch (Exception e){
		    	  System.err.println("ERRORE: "+ e.getMessage());
		        }
		       }
			 
		    while(ripassafunzione());  
			 
			   } 


			else if(metodo.equals("secanti")||metodo.equals("SECANT")||metodo.equals("Secanti")){
			 do{
				
				   inputf();
				   input2();
				   input3();
				
			   try{
				zero = Secanti.Secanti(Fun,a,b,toll_err,numero_max_iter);
				System.out.println("la funzione inserita vale zero per x = " + zero);
			   } 
			   
			   catch (Exception e){
				System.err.println("ERRORE: "+ e.getMessage());
				}
			 }
			 
			 while(ripassafunzione()); 
				}




			else if(metodo.equals("Chiudi")||metodo.equals("chiudi")||metodo.equals("CHIUDI")){
				System.out.println("\nGrazie mille!\nBuona giornata\n\n");
				acceso = false;
				}
			else {
				System.out.println("\n Attenzione: il metodo selezionato non corrisponde a quelli disponibili, riprovare: ");
				}



		}
	tastiera.close();
	tastiera2.close();
	tastiera3.close();
	}
	
	public static void input1(){
	try{
			System.out.println("Inserire la funzione di cui calcolare gli zeri: ");
			fg=tastiera.nextLine();
			System.out.println("Inserire la derivata: ");
			dfg=tastiera.nextLine();
	        Fun = new Function(fg,dfg);
		} catch(InputMismatchException e ){ System.err.println("valori di input non validi ");}
		
	}
	
	public static void inputf(){
	try{	
		System.out.println("Inserire la funzione di cui calcolare gli zeri: ");
		fg=tastiera.nextLine();
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
			a=tastiera2.nextDouble();

		} catch(InputMismatchException e ){ System.err.println("valori di input non validi ");}

	}
	
	public static void input5(){
		try{
			System.out.println("inserire la molteplicità degli zeri da trovare ");
			mult=tastiera2.nextInt();
		} catch(InputMismatchException e ){System.err.println("valore in input non valido ");}
		}
	
	public static boolean ripassafunzione() {
		
		System.out.println("Se vuoi passare un altra funzione, scrivi Yes o yes, altrimenti scrivi qualcos'altro");
		
		String risposta = tastiera3.nextLine();
		 
		if (risposta.equals("yes") || risposta.equals("Yes")) { 

			    return true;
	    }
		
		else {
			    return false;
	    }
	}
  }