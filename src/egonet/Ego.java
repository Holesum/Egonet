package egonet;
import java.util.*;
import java.lang.Comparable;

public class Ego {
	// place your code here
	private TreeSet<egonet> set;
	// the nested class used to define a egonet
	public static class egonet implements Comparable<egonet>{ 
		int center; // center of the egonet
		Graph G; // subgraph that represents the egonet

		public egonet(int c, Graph g) {
			center = c;
			G = g;
		}

		int getCenter() {
			return center;
		}

		Graph getG() {
			return G;
		}

		@Override public int compareTo(egonet that) {//overriding compare function for the treeset to use
			if(this.getG().getE() > that.getG().getE()) {return -1;} 
			else if(this.getCenter() == that.getCenter()){return 0;}
			else{return 1;}
		}
	}
	public Ego(Graph g) {
		set = new TreeSet<egonet>();
		load(g);
	}

		// place your code here
	private void load(Graph g) {
		for(int curr : g.getVertices()) {//iterating over all vertices in graph
			Graph egoGraph = new Graph();//creating subgraph of egonet
			egoGraph.addVertex(curr);
			
			for(int neighbor : g.adj(curr)) {
				egoGraph.addVertex(neighbor); //adding vertex to graph
				egoGraph.addEdge(curr, neighbor); egoGraph.addEdge(neighbor, curr);//adding edges from both vertices back to each other
				
				for(int neighbor2 : g.adj(neighbor)) {
					if(g.adj(curr).contains(neighbor2)) {//if vertex is in the graph(connected to first vertex)
						egoGraph.addEdge(neighbor, neighbor2); egoGraph.addEdge(neighbor2, neighbor);//adding edges from both vertices back to each other
					}
				}
			}
			egonet ego = new egonet(curr, egoGraph);
			set.add(ego);
		}
	}
	

	public List<egonet> top(int k) {
		List<egonet> l = new ArrayList<egonet>();                      
		Iterator<egonet> setIterator = this.set.iterator();
		for(int i = 0;i < k;i++) {                                         
			if(setIterator.hasNext()) {  
				l.add(setIterator.next());                                 
			}                                                              
		}                                                                  
		                                                                   
		// place your code here
		return l;
	}
}
