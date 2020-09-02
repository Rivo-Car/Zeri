package Metodi;
import java.util.*;
import net.objecthunter.exp4j.*;
import net.objecthunter.exp4j.tokenizer.*;

/**
* Classe che implementa funzione(come oggetto), sua derivata e valore nei nodi
**/

public class Function {
	
	Scanner sc = new Scanner(System.in);
	
    Expression Fun, DFun;     //funzione e sua derivata come espressioni
	String     fun, dfun;	  //funzione e sua derivata come stringhe
	
	public Function(String new_fun, String new_dfun)         //Constructor
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
			
			  System.out.println("Variabile deve essere x");
			  throw e;
		}
	   catch (IllegalArgumentException e) {
			
			   System.out.println("Funzione scritta male: " + e.getMessage());
			   throw e;
		}	
	   catch (EmptyStackException e){
			
			   System.out.println("Funzione scritta male, guardate parentesi");
		} 
	}
	
	public Function(String new_fun)                      //Constructor without derivate
	{
	   this.fun = new_fun;
	   
	   try{
		   
	       Fun = new ExpressionBuilder(fun)
					      .variable("x")
					      .build();
		   }	   
	   catch (UnknownFunctionOrVariableException e) {
				
				System.out.println("Variabile deve essere x");
				throw e;
			}
	   catch (IllegalArgumentException e) {
				
				System.out.println("Funzione scritta male: " + e.getMessage());
			}     
	   catch (EmptyStackException e){
				
				System.out.println("Funzione scritta male, guardate parentesi");
			}     
	}
	
	/*Metodo per calcolare valore della funzione iniziale nel punto
	 * 
	 *  input: nodo x' reale
	 * output: valore di f(x')
	 * catch: divisione per 0, funzioni scorrette
	 * */
	public double Evaluate(double valore) 
	{
		 Fun.setVariable("x", valore);
		 try {
			 return Fun.evaluate();
			 }
		 catch (ArithmeticException e) {				
			    System.out.println("Divisione per 0 non adatta");
				return Double.NaN;
		 }  
		 catch (NullPointerException e) {
			    System.out.println("Funzione o sua derivata non e' definita correttamente");
			    return Double.NaN;
		 }
	}
	
	/*Metodo per calcolare valore della derivata nel punto
	 * 
	 *  input: nodo x' reale
	 * output: valore di f'(x')
	 * catch: divisione per 0, funzioni scorrette
	 * */
	public double EvaluateDerivata(double valore)
	{
		 DFun.setVariable("x", valore);
		 try {
			 return DFun.evaluate();
			 }
		 catch (ArithmeticException e) {				
				System.out.println("Divisione per 0 non adatta");
				return Double.NaN;
		 } 
		 catch (NullPointerException e) {
			    System.out.println("Funzione o sua derivata non e' definita correttamente");
			    return Double.NaN;
		 }
	}

	public static void main(String[] args) 
	{		
			Function f = new Function("cos/x", "0");
			/*double res = f.Evaluate(0);
			
			if(Double.isFinite(res)) {           //controllo se risultato sia finito
				System.out.println(res);
				System.out.println(f.EvaluateDerivata(6));
				}
			
			else {
				System.out.println("Il prog non e' andato a buon fine, ci dispiace");
				}	*/		
    }

}