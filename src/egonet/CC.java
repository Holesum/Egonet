package egonet;

import java.util.*;


public class CC {
	TreeSet<cc> communities;
	int sum;
	// the nested class used to define a connected component
	public static class cc implements Comparable<cc>{
		int id; // the id of the component
		int size; // the size of the component

		cc(int i, int s) {
			id = i;
			size = s;
		}

		int getId() {
			return id;
		}

		int getSize() {
			return size;
		}
		@Override public int compareTo(cc that){
			if(this.getSize() > that.getSize()) {return -1;}
			else if(this.getId() == that.getId()) {return 0;}
			else {return 1;}
		}
	}

	public int getCount(int v, Graph g, Set<Integer> marked) {
		marked.add(v);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int neighbor : g.adj(curr)) {
				if(!marked.contains(neighbor)) {
					q.add(neighbor);
					marked.add(neighbor);
					sum += 1;
				}
			}
		}
		return sum;
	}
	
	public CC(Graph g) {
		int name = 1;
		communities = new TreeSet<cc>();
		Set<Integer> marked = new HashSet<Integer>();
		for(int element : g.getVertices()) {
			if(!marked.contains(element)) {
				sum = 1;
				int temp = getCount(element, g, marked);
				cc foo = new cc(name, temp);
				name++;
				communities.add(foo);
			}
		}
	}

	
	public int count() {
		return communities.size();
	}

	public List<cc> top(int k) {
		List<cc> l = new ArrayList<cc>();                      
		Iterator<cc> setIterator = this.communities.iterator();
		for(int i = 0;i < k;i++) {                                         
			if(setIterator.hasNext()) {  
				l.add(setIterator.next());                                 
			}                                                              
		}                                                                  
		                                                                   
	
		return l;
	}
}
