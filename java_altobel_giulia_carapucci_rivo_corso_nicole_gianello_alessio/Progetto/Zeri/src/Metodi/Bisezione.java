package Metodi;


/**
* Classe che realizza il metodo di bisezione.
* */

public class Bisezione {

		
		
		/**
		* Metodo iterativo per il calcolo di zero di funzione tramite bisezione.
		* 
		* @param Fun funzione di cui si ricerca una approssimazione dello zero.
		* @param a estremo sinistro dell'intervallo di ricerca.
		* @param b estremo destro dell'intervallo di ricerca.
		* @param toll_err tolleranza impostata dall'utente.
		* @param numero_max_iter numero massimo di iterazioni impostato dall'utente.
		* @return approsimazione dello zero dopo aver raggiunto il numero max di iterazioni possibili o dopo aver raggiunto la tolleranza impostata.
		*/
		
		
		public static double Bisezione(Function Fun, double a, double b, double toll_err, int numero_max_iter) {
			
			double zero = 0;
			double m = (a+b)/2;
			int n = 1;  //contatore del n. di iterazioni del ciclo while per evitare loop infiniti
			
			double fa = Fun.Evaluate(a);  //metodo della classe funzione che valuta la funzione in un punto dato come argomento
			double fb = Fun.Evaluate(b);
			double fm = Fun.Evaluate(m);
			
			if (fa*fb > 0){
				System.err.println("Secondo il teorema di Bolzano, la funzione, nello specifico intervallo dato in input,"
						+ " non possiede zeri oppure ne possiede alcuni. Si consiglia di inserire altri estremi dell'intervallo.");
			}
			
			else if (fa == 0){
				return a;
			}
			
			else if (fb == 0){
				return b;
			}
			
			else {
				while (Math.abs(fm) >= toll_err && n < numero_max_iter){  //2 condizioni di arresto del ciclo while
					n++;	
					if (fm == 0){
						zero = m;
					}
					
					else if (fa*fm < 0){ //lo zero si trova nell'intervallo [a,m]
						b = m;
						fb = fm;
					}
					else{ //lo zero si trova nell'intervallo [m,b] 
						a = m;
						fa = fm;
					}
			
					m = (a+b)/2;
					fm = Fun.Evaluate(m);
				}
				zero = m;
				
			}
			
			
			if (n == numero_max_iter){
						 
					 System.err.println("Attenzione! Il numero massimo di iterazioni è stato raggiunto. Non è possibile garantire che l'approssimazione restituita sia sufficientemente precisa.");
			}
			System.out.println("Il numero di iterazioni eseguite e': " + n);
			return zero;
		}

}
