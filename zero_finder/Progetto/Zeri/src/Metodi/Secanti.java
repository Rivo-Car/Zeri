package Metodi;


/**
* Classe che realizza il metodo delle secanti.
* */

public class Secanti {
	/**
	* Metodo iterativo per il calcolo di zero di funzione tramite secanti.
	* 
	* @param Fun funzione di cui si ricerca una approssimazione dello zero.
	* @param x0 primo punto di partenza.
	* @param x1 secondo punto di partenza.
	* @param toll_err tolleranza impostata dall'utente.
	* @param numero_max_iter numero massimo di iterazioni impostato dall'utente.
	* @return approsimazione dello zero dopo aver raggiunto il numero max di iterazioni possibili o dopo aver raggiunto la tolleranza impostata.
	*/
	
	
	public static double Secanti(Function Fun, double x0, double x1, double toll_err, int numero_max_iter) {
		
		
		double fx0, fx1, m, x2;  
		double zero = 0;
		int n = 1;  //contatore del numero di iterazioni.
		double error = 1;  //valore iniziale dell'errore.
		
		double x = x0; //imposta il valore x0 come punto corrente.
		
		fx1 = Fun.Evaluate(x1);
		fx0 = Fun.Evaluate(x0);
		
		if (fx0*fx1 > 0){
			System.err.println("Secondo il teorema di Bolzano, la funzione, nello specifico intervallo dato in input,"
			+ " non possiede zeri oppure ne possiede alcuni. Si consiglia di inserire altri punti di partenza.");
		}
		
		else if (fx0 == 0) {
			return x0;
		}
		
		else if (fx1 == 0){
			return x1;
		}
		
		
		while ((n <= numero_max_iter) && (error >= toll_err)){
				
			fx1 = Fun.Evaluate(x1);
			fx0 = Fun.Evaluate(x0);
				
			m = (fx1-fx0)/(x1-x0);
			
			if (fx1 == 0){  
				break;
			}
			
			x2 = x1-(fx1/m);
			x0 = x1;
			x1 = x2;
			error = Math.abs(x1-x0);
			n++;
			zero = x1;
			
		}
		System.out.println("Il numero di iterazioni eseguite e': " + n);
		return zero;
		
	}
}