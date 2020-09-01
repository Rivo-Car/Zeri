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
		double x = 0;
		while (Math.abs(Math.abs(x-x0)) >= error && i < iter ) {		  
		  double  f = Fun.Evaluate(x0);
		  double df = Fun.EvaluateDerivata(x0);			 
		  x = x0 - mult*(f/df);
		  i++;	
		  System.out.println(i);
		  x0 = x;
		}
		if (i == iter) System.out.println("Numero massimo iterazioni raggiunto, approssimazione puo risultare scarsa");
		System.out.println(i);
		return x0;
	}
	public static void main(String[] args) {
		
		Function Fun = new Function("sin(x)-x","cos(x) - 1");
		double res1 = 0,res2 = 0;
		/*long m = System.currentTimeMillis();
	    for(int i = 0; i<=1999;i++) {
		
		 res1 = Newton(Fun, 0, 1, 20, 0.0000000000001);
		}
		double a = (double)(System.currentTimeMillis()- m);
	    double n = System.currentTimeMillis();
	    for(int i = 0; i<=1999;i++) {
				
		 res2 = Newton2.Newton(Fun, 0, 1, 0.0000000000001, 20);
		}
		double b = (double)(System.currentTimeMillis()- n);
		System.out.println(a/2000);
		System.out.println(b/2000);*/
		res1 = Newton(Fun, 0.1, 1, 20, 0.0000000000001);
		res2 = Newton2.Newton(Fun, 0.1, 1, 0.0000000000001, 20);
		System.out.println(res1-res2);
		System.out.println(res1);
	}

}