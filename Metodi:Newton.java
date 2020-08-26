package Metodi;

/**
* Classe che implementa Metodo di Newton per gli oggetti Function
* */
public class Newton {
	
	/*Metodo per calcolare lo zero via Newton
	 * 
	 *  input: Funzione e sua derivata, nodo x0 reale, molteplicita dello zero, num max di iterazioni, tolleranza
	 * output: punto dello zero
	 * */ 
	public static double Newton(Function Fun, double x0, int mult, int iter, double error ) {
		
		int i = 0;
		while (Math.abs(Fun.Evaluate(x0)) >= error && i <= iter ) {		  
		  double  f = Fun.Evaluate(x0);
		  double df = Fun.EvaluateDerivata(x0);			 
		  double x = x0 - mult*(f/df);
		  i++;	
		  System.out.println(x - x0);
		  x0 = x;
		}
		return x0;
	}
	public static void main(String[] args) {
		
		Function f = new Function("log(x)","1/x");
		double res = Newton(f, 0.5, 1, 20, 0.0000000000001);
		System.out.println(res);
		System.out.println(f.Evaluate(res));
	}

}