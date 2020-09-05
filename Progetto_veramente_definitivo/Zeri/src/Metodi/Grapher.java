package Metodi;

import ac.essex.graphing.plotting.*; 
import ac.essex.graphing.swing.*; 
import java.awt.*; 
/** 
 * Demonstrates how to display a graph using JavaPlot. 
 * 
 * <p> 
 * This program is free software; you can redistribute it and/or 
 * modify it under the terms of the GNU General Public License 
 * as published by the Free Software Foundation; either version 2 
 * of the License, or (at your option) any later version, 
 * provided that any use properly credits the author. 
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU General Public License for more details at http://www.gnu.org 
 * </p> 
 * 
 @author Olly Oechsle, University of Essex 
 @version 1.0 
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