package egonet;

import java.util.*;


public class Influence {
	// place your code here
	private TreeSet<influencer> set;
	// the nested class used to define a influencer
	public static class influencer implements Comparable<influencer>{
		int source; // the influencer
		double power; // the impact of this influencer

		influencer(int i, double p) {
			source = i;
			power = p;
		}

		int getSource() {
			return source;
		}

		double getPower() {
			return power;
		}
		@Override public int compareTo(influencer that) {
			if(this.getPower() > that.getPower()) {return -1;}
			else if(this.getSource() == that.getSource()) {return 0;}
			else {return 1;}
		}
	}
	
	private double calcPower(int v, Graph g) {
		double count = 0;
		double influence = 0;
		
		List<Integer> level = new ArrayList<Integer>();//list to hold next level vertices
		Queue<Integer> q = new LinkedList<Integer>();//queue to hold unvisted vertices
		Set<Integer> visited = new HashSet<Integer>();//set to mark if vertex is visted 
		
		visited.add(v);
		q.add(v);
		
		while(!q.isEmpty()) {
			int current = q.poll();
			for(int neighbor : g.adj(current)) {//traversing all neighbors of current vertex
				if(!visited.contains(neighbor)) {
					level.add(neighbor); //adding to list of vertices in level to be added later for sake of distance counter
					visited.add(neighbor); //adding to set of visited vertices
					influence += Math.pow(2, count); //adding to the influence by the distance from source 
				}
			}
			if(q.isEmpty()) {//if the entire level has been traversed
				count--;//changing the counter
				q.addAll(level);//adding all vertices of next level to queue
				level.clear();//clearning list which holds vertices of next level
			}
		}
		return influence;
	}
	

	public Influence(Graph g) {
		set = new TreeSet<influencer>(); //set to keep all influencers ordered
		for(int element : g.getVertices()) {//iterating over all vertices to get data for influencers
			double temp = calcPower(element, g); //getting power of influencer
			influencer foo = new influencer(element, temp);
			set.add(foo);
		}
		// place your code here
	}

	public List<influencer> top(int k) {
		List<influencer> l = new ArrayList<influencer>();                      
		Iterator<influencer> setIterator = this.set.iterator();
		for(int i = 0;i < k;i++) {                                         
			if(setIterator.hasNext()) {  
				l.add(setIterator.next());                                 
			}                                                              
		}                                                                  
		                                                                   
		// place your code here
		return l;
	}

}
