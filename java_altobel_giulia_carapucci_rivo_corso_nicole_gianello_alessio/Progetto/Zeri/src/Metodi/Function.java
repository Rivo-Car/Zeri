package Metodi;
import java.util.*;
import net.objecthunter.exp4j.*;
import net.objecthunter.exp4j.tokenizer.*;

/**
* Classe che implementa l'oggetto funzione, la sua derivata e il loro valore nei nodi.
**/

public class Function {
	
	Scanner sc = new Scanner(System.in);
	
    Expression Fun, DFun;     // la funzione e la sua derivata come espressioni.
	String     fun, dfun;	  // la funzione e la sua derivata come stringhe.
	
	
	/* Metodo costruttore per la funzione e la sua derivata.
	 * 
	 * Input: stringa rappresentativa della funzione e stringa rappresentativa della derivata.
	 * Output: funzione e derivata.
	 * Catch: funzione scritta non correttamente ,stringa vuota in input, scorretto utilizzo delle parentesi.
	 * */
	
	
	public Function(String new_fun, String new_dfun)         // Costruttore di funzione e derivata.
	{
	   this.fun     = new_fun;
	   this.dfun    = new_dfun;
	   
	   try{
        
        Fun = new ExpressionBuilder(fun)
				      .variable("x")
				      .build();
					  
	    DFun = new ExpressionBuilder(dfun)
		              .variable("x")
		              .build();
	   }	   
	   catch (UnknownFunctionOrVariableException e) {
			
			  System.out.println("Attenzione! L'espressione inserita non e' una funzione o la variabile utilizzata non puo' essere accettata (la variabile deve essere x).");
			  throw e;
		}
	   catch (IllegalArgumentException e) { 
			
			   System.out.println("Attenzione! La funzione non e' stata inserita. Si prega di riprovare e inserire una funzione.");
			   throw e;
		}	
	   catch (EmptyStackException e){  
			
			   System.out.println("Attenzione! La funzione non e' stata scritta correttamente. Verificare il corretto utilizzo delle parentesi.");
				throw e;
		} 
	}
	
	
	
	
	/* Metodo costruttore per la funzione.
	 * 
	 * Input: stringa rappresentativa della funzione.
	 * Output: funzione.
	 * Catch: funzione scritta non correttamente ,stringa vuota in input, scorretto utilizzo delle parentesi.
	 * */
	
	
	public Function(String new_fun)                      // Costruttore di funzione (senza derivata). 
	{
	   this.fun = new_fun;
	   
	   try{
		   
	       Fun = new ExpressionBuilder(fun)
					      .variable("x")
					      .build();
		   }	   
	   catch (UnknownFunctionOrVariableException e) {
				
				System.out.println("Attenzione! L'espressione inserita non e' una funzione o la variabile utilizzata non puo' essere accettata (la variabile deve essere x).");
				throw e;
			}
	   catch (IllegalArgumentException e) {
				
				System.out.println("Attenzione! La funzione non e' stata inserita. Si prega di riprovare e inserire una funzione.");
				throw e;
			}     
	   catch (EmptyStackException e){
				
				System.out.println("Attenzione! La funzione non e' stata scritta correttamente. Verificare il corretto utilizzo delle parentesi.");
				throw e;
			
			}     
	}
	
	/* Metodo per calcolare il valore della funzione iniziale in un determinato punto.
	 * 
	 * Input: nodo reale x.
	 * Output: valore di f(x).
	 * Catch: divisione per 0, funzione o derivata scorrette.
	 * */
	public double Evaluate(double valore) 
	{
		 Fun.setVariable("x", valore);
		 try {
			 return Fun.evaluate();
			 }
		 catch (ArithmeticException e) {				
			    System.out.println("Attenzione! La divisione per 0 non e' possibile.");
				return Double.NaN;
		 }  
		 catch (NullPointerException e) {
			    System.out.println("Attenzione! La funzione o la sua derivata non sono definite correttamente.");
			    return Double.NaN;
		 }
	}
	
	/* Metodo per calcolare il valore della derivata della funzione in un determinato punto.
	 * 
	 * Input: nodo reale x.
	 * Output: valore di f'(x).
	 * Catch: divisione per 0, funzione o derivata scorrette.
	 * */
	 
	public double EvaluateDerivata(double valore)
	{
		 DFun.setVariable("x", valore);
		 try {
			 return DFun.evaluate();
			 }
		 catch (ArithmeticException e) {				
				System.out.println("Attenzione! La divisione per 0 non e' possibile.");
				return Double.NaN;
		 } 
		 catch (NullPointerException e) {
			    System.out.println("Attenzione! La funzione o la sua derivata non sono definite correttamente.");
			    return Double.NaN;
		 }
	}

}