package Metodi;


public class Newton{
	
	
	/**
	* Metodo iterativo per il calcolo di zero di funzione tramite tangenti.
	* 
	* @param Fun funzione di cui si ricerca una approssimazione dello zero.
	* @param Fun_D derivata della funzione di cui si ricerca una approssimazione dello zero.
	* @param x0 punto di partenza.
	* @param toll_err tolleranza impostata dall'utente.
	* @param numero_max_iter numero massimo di iterazioni impostato dall'utente.
	* @return approsimazione dello zero dopo aver raggiunto il numero max di iterazioni possibili o dopo aver raggiunto la tolleranza impostata.
	*/
	
	
	public static double Newton(Function Fun, double x0, double toll_err, int numero_max_iter) {
		
		double x, x1, fx, d_fx;  //x è il punto corrente.
		double zero = 0;
		int n = 0;  //contatore del numero di iterazioni.
		double error = 1;  //valore iniziale dell'errore, che verrà poi aggiornato a ogni iterazione del ciclo.
		
		x = x0; //imposta il valore x0 come punto corrente.
		
		while ((n <= numero_max_iter) && (error >= toll_err)){
			fx = Fun.Evaluate(x);
			d_fx = Fun.EvaluateDerivata(x);	
			
			if (Math.abs(d_fx) == 0){ //ho dubbi su questo pezzo e se si può effettivamente usare il break qua 
				System.err.println("Attenzione! Poichè non è possibile dividere per zero, l'iterazione successiva non può essere calcolata.");
				break; 
			}
			
			x1 = x-(fx/d_fx);
			error = Math.abs(x1-x);
			x = x1;
			n++;	
			zero = x;
		}
		
		return zero;
		
	}
}
