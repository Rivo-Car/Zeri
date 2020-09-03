import net.objecthunter.exp4j.*;
import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException;

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
		
		System.out.print("\n\n Benvenuto nel programma per la ricerca degli zeri di una funzione.\n"
				+ " Inserisci il nome del metodo che vuoi utilizzare per la ricerca degli zeri: \n "
				+ "- Bisezione\n "
				+ "- Newton\n "
				+ "- Secanti\n "
				+ "- Corde\n\n "
				+ "- Chiudi\n");
		
		metodo=tastiera.nextLine();
		zero= Double.NaN;

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


			else if(metodo.equals("secanti")||metodo.equals("SECANTI")||metodo.equals("Secanti")){
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




			else if(metodo.equals("Chiudi")||metodo.equals("chiudi")||metodo.equals("CHIUDI")){
				System.out.println("\nGrazie mille!\nBuona giornata.\n\n");
				acceso = false;
				}
			else {
				System.out.println("\n Attenzione: il metodo selezionato non corrisponde a nessuno di quelli disponibili, riprovare: ");
				}

    }
	
	tastiera.close();
	tastiera2.close();
	tastiera3.close();
	}
	
	public static void input1(){
		
	  do
	    try{
			System.out.println("Inserire la funzione di cui si vogliono calcolare gli zeri: ");
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
	
	public static void input2(){
	
		do 
			try {
				
			System.out.println(" inserire l'estremo sinistro \n in caso si usi il metodo delle secanti, inserire il primo punto di partenza ");
			a=tastiera2.nextDouble();
			
			System.out.println(" inserire l'estremo destro \n in caso si usi il metodo delle secanti, inserire il secondo punto di partenza ");
			b=tastiera2.nextDouble();
			
			caso_errore = false;
			
		    }
			catch(InputMismatchException e ){ System.err.println("Valori di input non validi, riprovare: "); tastiera2.next();}
		
        while (caso_errore != false);
		
		caso_errore = true;
	}
	
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
	
	public static void input4(){
		do
	    	try{
	    		
			System.out.println("Inserire il nodo di partenza: ");
			a=tastiera2.nextDouble();
			
			caso_errore = false;
			
		  } catch(InputMismatchException e ){ System.err.println("Valori di input non validi, riprovare: "); tastiera2.next(); }
		
		while (caso_errore);

		caso_errore = true;
	}
	
	public static void input5(){
		do
	    	try{
	    		
			System.out.println("Inserire la molteplicità degli zeri da trovare: ");
			mult=tastiera2.nextInt();
			
			caso_errore = false;
			
		  } catch(InputMismatchException e ){System.err.println("Valore in input non valido "); tastiera2.next(); }
		
		while (caso_errore);

		caso_errore = true;
	}
	
	public static boolean ripassafunzione() {
		
		System.out.println("Se vuoi procedere con il metodo appena utilizzato e con l'inserimento quindi di un'altra funzione, scrivi Yes o yes, altrimenti scrivi qualcos'altro o premi Enter");
		
		String risposta = tastiera3.nextLine();
		 
		if (risposta.equals("yes") || risposta.equals("Yes")) { 

			    return true;
	    }
		
		else {
			    return false;
	    }
	}
  }
