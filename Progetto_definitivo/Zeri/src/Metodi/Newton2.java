package Metodi;

public class Newton2 {
	
public static double Newton(Function Fun, double x0,int mult, double toll_err, int numero_max_iter) {
		
		double x, x1, fx, d_fx;  //x è il punto corrente.
		double zero = 0;
		int n = 0;  //contatore del numero di iterazioni.
		double error = 1;  //valore iniziale dell'errore, che verrà poi aggiornato a ogni iterazione del ciclo.
		
		x = x0; //imposta il valore x0 come punto corrente.
		
		while ((n < numero_max_iter) && (error >= toll_err)){
			fx = Fun.Evaluate(x);
			d_fx = Fun.EvaluateDerivata(x);	
			
			if (Math.abs(d_fx) == 0){ //ho dubbi su questo pezzo e se si può effettivamente usare il break qua 
				System.err.println("Attenzione! Poichè non è possibile dividere per zero, l'iterazione successiva non può essere calcolata.");
				break; 
			}
			
			x1 = x-mult*(fx/d_fx);
			error = Math.abs(x1-x);
			x = x1;
			n++;	
			zero = x;
		}

		return zero;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function Fun = new Function("cos(x)","-sin(x)");
		long m = System.currentTimeMillis();
		for(int i = 0; i<=100;i++) {
		
		double res = Newton.Newton(Fun, 0.5, 1, 20, 0.0000000000001);
		;}
		 double a = (double)(System.currentTimeMillis()- m);
		 double n = System.currentTimeMillis();
		 for(int i = 0; i<=100;i++) {
				
				double res = Newton(Fun, 0.5,2, 0.0000000000001, 20);
				;}
		 double b = (double)(System.currentTimeMillis()- n);
		System.out.println(a/100);
		System.out.println(b/100);
	}

}