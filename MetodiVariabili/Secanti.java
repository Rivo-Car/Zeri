package Metodi;


public class Secanti{


	/**
	* Metodo iterativo per il calcolo di zero di funzione tramite secanti.
	*
	* @param Fun funzione di cui si ricerca una approssimazione dello zero.
	* @param a primo punto di partenza.
	* @param b secondo punto di partenza.
	* @param toll_err tolleranza impostata dall'utente.
	* @param numero_max_iter numero massimo di iterazioni impostato dall'utente.
	* @return approsimazione dello zero dopo aver raggiunto il numero max di iterazioni possibili o dopo aver raggiunto la tolleranza impostata.
	*/


	public static double Secanti(Function Fun, double a, double b, double toll_err, int numero_max_iter) {

		double zero=0;
		double fx0, fx1, m, x2, x;
		int n = 0;  //contatore del numero di iterazioni.
		double error = 1;  //valore iniziale dell'errore.

		x = a; //imposta il valore x0 come punto corrente.

		while ((n <= numero_max_iter) && (error >= toll_err)){

			fx1 = Fun.Evaluate(b);
			fx0 = Fun.Evaluate(a);
			m = (fx1-fx0)/(b-a);

			if (fx1 == 0){  //perchè? non chiaro
				break;
			}

			x2 = a-(fx1/m);
			a = b;
			b = x2;
			error = Math.abs(b-a);
			n++;

			zero = m;
		}
		return zero;

	}
}
