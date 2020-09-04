package Metodi;


public class Corde{
	
	
	/**
	* Metodo iterativo per il calcolo di zero di funzione tramite corde.
	* 
	* @param Fun funzione di cui si ricerca una approssimazione dello zero.
	* @param Fun_D derivata della funzione di cui si ricerca una approssimazione dello zero.
	* @param x0 punto di partenza.
	* @param toll_err tolleranza impostata dall'utente.
	* @param numero_max_iter numero massimo di iterazioni impostato dall'utente.
	* @return approsimazione dello zero dopo aver raggiunto il numero max di iterazioni possibili o dopo aver raggiunto la tolleranza impostata.
	*/
	
	
	public static double Corde(Function Fun, double x0, double toll_err, int numero_max_iter) {
		
		double x;  //x è il punto corrente.
		double x1, fx; 
		double zero = 0;
		double m = Fun.EvaluateDerivata(x0); //derivata della funzione calcolata nel punto iniziale.
		int n = 0;  //contatore del numero di iterazioni.
		double error = 1;  //valore iniziale dell'errore, che verrà poi aggiornato a ogni iterazione del ciclo.
		
		x = x0; //imposta il valore x0 come punto corrente.
		
		
		
		while ((n < numero_max_iter) && (error >= toll_err)){
			fx = Fun.Evaluate(x);
			x1 = x-(fx/m);
			error = Math.abs(x-x1); //errore dell'output
			x = x1;
			n++;
			zero = x;
			
			if (Math.abs(m) == 0){
			System.err.println("Attenzione! Poichè non è possibile dividere per zero, l'iterazione successiva non può essere calcolata.");
			break;
		}
		}
		
		return zero;	
		
	}
}
