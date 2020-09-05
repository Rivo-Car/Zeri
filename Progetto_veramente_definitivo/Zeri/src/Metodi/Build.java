package Metodi;

import ac.essex.graphing.plotting.ContinuousFunctionPlotter;

/**
* Classe che realizza funzione per disegnarla
* */
class Build extends ContinuousFunctionPlotter { 
	 
    public Function Fun;
 
    public Build(Function fun) { 
 
        this.Fun  = fun;
    } 
 
    public double getY(double x) { 
     
        return Fun.Evaluate(x); 
    } 
 
    public String getName() { 
    	
        return Fun.fun; 
    } 
 
}  