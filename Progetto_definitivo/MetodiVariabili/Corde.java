package Metodi;


public class Corde{


	/**
	* Metodo iterativo per il calcolo di zero di funzione tramite corde.
	*
	* @param Fun funzione di cui si ricerca una approssimazione dello zero.
	* @param Fun_D derivata della funzione di cui si ricerca una approssimazione dello zero.
	* @param a punto di partenza.
	* @param toll_err tolleranza impostata dall'utente.
	* @param numero_max_iter numero massimo di iterazioni impostato dall'utente.
	* @return approsimazione dello zero dopo aver raggiunto il numero max di iterazioni possibili o dopo aver raggiunto la tolleranza impostata.
	*/


	public static double Corde(Function Fun, double a, double toll_err, int numero_max_iter) {

		boolean t=true;
		double x, x1, fx;  //x è il punto corrente.
		double zero = 0;
		double m = Fun.EvaluateDerivata(a); //derivata della funzione calcolata nel punto iniziale.
		int n = 0;  //contatore del numero di iterazioni.
		double error = 1;  //valore iniziale dell'errore, che verrà poi aggiornato a ogni iterazione del ciclo.

		x = a; //imposta il valore x0 come punto corrente.

		if (Math.abs(m) == 0){
			System.err.println("Attenzione! Poichè non è possibile dividere per zero, l'iterazione successiva non può essere calcolata.");
			t=false;
		}

		while ((n <= numero_max_iter) && (error >= toll_err) && t){
			fx = Fun.Evaluate(x);
			x1 = x-(fx/m);
			error = Math.abs(x1-x);
			x = x1;
			n++;
			zero = x;
		}

		return zero;

	}
}
