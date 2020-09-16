package Metodi;

import ac.essex.graphing.plotting.*; 
import ac.essex.graphing.swing.*; 
import java.awt.*; 


/** 
 * Classe che permette di disegnare un grafico di funzione usando JavaPlot.
 * 
 * @author Olly Oechsle, University of Essex 
 * @version 1.0 
 */ 

public class Grapher{ 
 
    public static Graph getGraph(String function) { 
    	
    	Function f = new Function(function);
    	
        PlotSettings p = new PlotSettings(-5, 5, -5, 5); 
        p.setPlotColor(Color.RED); 
        p.setGridSpacingX(1); 
        p.setGridSpacingY(1); 
        Graph graph = new Graph(p); 
        graph.functions.add(new Build(f)); 
        p.setTitle(f.fun);
        
        return graph; 
    } 
 
} 