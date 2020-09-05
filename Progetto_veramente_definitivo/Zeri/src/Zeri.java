import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException;

import java.util.*;

import Metodi.*;



/**
* Classe che contiene il <i>main</i> del programma.
* <br>
* Le sue funzioni sono quella di gestione dell'iterazione con l'utente e di collegamento tra le varie classi del pacchetto.
* <br>
* Questo programma fa uso della libreria <a href="http://www.....">jep-2.4.1</a>
* <br>
* I metodi disponibili all'utente sono: 
* <ol>
* <li>bisezione;
* <li>Newton;
* <li>corde;
* <li>secanti.
* </ol>
*
* @author Altobel Giulia, Carapucci Rivo, Corso Nicole, Gianello Alessio.
* @version 3.0
*/



public class Zeri {
	private static Scanner tastiera = new Scanner(System.in);
	private static Scanner tastiera2= new Scanner(System.in);
	private static Scanner tastiera3= new Scanner(System.in);
	private static String fg, dfg;
	private static boolean acceso=true;
	private static String metodo;

	public static Function Fun;
	public static int numero_max_iter, mult;
	public static double a,b,toll_err;
	//le chiamo così perchè  a seconda del caso saranno estremo destro e sinistro, o primo e secondo punto di applicazione dei metodi

	public static double zero = 0;
	public static boolean caso_errore = true;
	
	/**
	* Metodo main
	*/
	public static void main(String[] args){

	while(acceso){
		
		System.out.print("\n\n Benvenuto nel programma! \n\n Di seguito avrai la possibilita' di scegliere ed utilizzare uno qualsiasi dei metodi disponibili per il calcolo degli zeri di una funzione.\n\n"
				+ " Inserisci il nome del metodo che vuoi utilizzare: \n\n "
				+ "- Bisezione;\n "
				+ "- Newton;\n "
				+ "- Secanti;\n "
				+ "- Corde;\n\n "
				+ "- Chiudi.\n");
		
		metodo=tastiera.nextLine();
		zero= Double.NaN;
		
	
		// Applicazione del metodo di bisezione. 
		
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
	
		// Applicazione del metodo delle corde.

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
		   
		  //Applicazione del metodo di Newton.
		
			else if(metodo.equals("newton")||metodo.equals("Newton")||metodo.equals("NEWTON")){
			 do {	
					input1();
					input4();
					input3();
					input5();
					
		      try{
				 
		    	 zero=Newton2.Newton(Fun,a,mult,toll_err,numero_max_iter);
				 System.out.println("La funzione inserita vale zero per x = " + zero);
			 }
		      
		      catch (Exception e){
		    	  System.err.println("ERRORE: "+ e.getMessage());
		        }
		       }
			 
		    while(ripassafunzione());  
			 
			   } 

			//Applicazione del metodo delle secanti. 
			
			else if(metodo.equals("secanti")||metodo.equals("SECANT")||metodo.equals("Secanti")){
			 do{
				
				   inputf();
				   input2();
				   input3();
				
			   try{
				zero = Secanti.Secanti(Fun,a,b,toll_err,numero_max_iter);
				System.out.println("La funzione inserita vale zero per x = " + zero);
			   } 
			   
			   catch (Exception e){
				System.err.println("ERRORE: "+ e.getMessage());
				}
			 }
			 
			 while(ripassafunzione()); 
				}


			//Uscita dal programma.

			else if(metodo.equals("Chiudi")||metodo.equals("chiudi")||metodo.equals("CHIUDI")){
				System.out.println("\nGrazie mille!\nBuona giornata.\n\n");
				acceso = false;
				}
				
			//Caso in cui il metodo digitato dall'utente non sia disponibile.
			
			else {
				System.out.println("\n Attenzione: il metodo selezionato non corrisponde a nessuno di quelli disponibili. Si prega di riprovare: ");
				}

    }
	
	tastiera.close();
	tastiera2.close();
	tastiera3.close();
	}
	
	
	
	
	 /**
	* Metodo per ricevere in input la funzione di cui si vuole calcolare lo zero e la sua derivata.
	*/
	
	public static void input1(){
		
	  do
	    try{
			System.out.println("Inserire la funzione di cui calcolare gli zeri: ");
			fg=tastiera.nextLine();
			System.out.println("Inserire la derivata: ");
			dfg=tastiera.nextLine();
	        Fun = new Function(fg,dfg);
	        caso_errore = false;
			
		} catch (UnknownFunctionOrVariableException e) {
			
		    System.out.println("Riprovare: ");  
		}
	      catch (IllegalArgumentException e) {
			
	    	System.out.println("Riprovare: "); 
		}	
	  while(caso_errore);
	  
	  caso_errore = true;
	  
   }
   
   /**
	* Metodo per ricevere in input la stringa passata dall'utente, che sarà usata come funzione.
	*/
	
	public static void inputf(){
		
	 do	
	    try{
	    	
		    System.out.println("Inserire la funzione di cui si vogliono calcolare gli zeri: ");
		    fg=tastiera.nextLine();
		    Fun = new Function(fg);
		    caso_errore = false;
		
	  } catch (UnknownFunctionOrVariableException e) {
		
		   System.out.println("Riprovare: ");
	}
	    catch (IllegalArgumentException e) {
			
	    	System.out.println("Riprovare: "); 
	}	
	
	while(caso_errore);
	
	caso_errore = true;
   }
   
   
     /**
	* Metodo per ricevere in input gli estremi dell'intervallo di ricerca.
	*/
	
	public static void input2(){
	
		do 
			try {
				
			System.out.println(" Inserire l'estremo sinistro: \n in caso si usi il metodo delle secanti, inserire il primo punto di partenza ");
			a=tastiera2.nextDouble();
			
			System.out.println(" Inserire l'estremo destro: \n in caso si usi il metodo delle secanti, inserire il secondo punto di partenza ");
			b=tastiera2.nextDouble();
			
			caso_errore = false;
			
		    }
			catch(InputMismatchException e ){ System.err.println("Valori di input non validi: "); tastiera2.next();}
		
        while (caso_errore != false);
		
		caso_errore = true;
	}
	
	/**
	* Metodo per ricevere in input la tolleranza desiderata e il massimo numero di iterazioni consentito.
	*/
	
	public static void input3(){

		do 
			try {
			System.out.println("Inserire la tolleranza desiderata: ");
			toll_err=tastiera2.nextDouble();
			
			System.out.println("Inserire il numero massimo di iterazioni: ");
			numero_max_iter=tastiera2.nextInt();
			
			caso_errore = false;
			}
			catch(InputMismatchException e ){ System.err.println("Valori di input non validi, riprovare: "); tastiera2.next();}
		
		while (caso_errore);
		
		caso_errore = true;
	}
	
	
	
	/**
	* Metodo per ricevere in input il nodo da cui si intende far partire la ricerca dello zero.
	*/
	
	public static void input4(){
		do
	    	try{
	    		
			System.out.println("Inserire il nodo di partenza: ");
			a=tastiera2.nextDouble();
			
			caso_errore = false;
			
		  } catch(InputMismatchException e ){ System.err.println("Valori di input non validi. "); tastiera2.next(); }
		
		while (caso_errore);

		caso_errore = true;
		
	}
	
	
	
	/**
	* Metodo per ricevere in input la molteplicità degli zeri da trovare nel caso del metodo di Newton.
	*/
	
	public static void input5(){
		do
	    	try{
	    		
			System.out.println("Inserire la molteplicità degli zeri da trovare: ");
			mult=tastiera2.nextInt();
			
			caso_errore = false;
			
		  } catch(InputMismatchException e ){System.err.println("Valore in input non valido. "); tastiera2.next(); }
		
		while (caso_errore);

		caso_errore = true;
	}
	
	
	
	
	/**
	* Metodo per ricevere in input una nuova funzione su cui avviare la ricerca dello zero.
	*/
	
	public static boolean ripassafunzione() {
		
		System.out.println("Se vuoi passare un altra funzione, scrivi Yes o yes, altrimenti scrivi qualcos'altro o premi Enter.");
		
		String risposta = tastiera3.nextLine();
		 
		if (risposta.equals("yes") || risposta.equals("Yes")) { 

			    return true;
	    }
		
		else {
			    return false;
	    }
	}
  }