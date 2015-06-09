import java.io.IOException;
import java.util.*;
public class DiGraph {
	
	//An Edge class that consists of vertices (nodes). We map each vertex to an edge below based on the
	//adjacency list 
	public static class Edge implements Comparable<Edge>{
		
		
        private Vertex node;
        

        public Edge(Vertex v){
            node = v;
        }

        public Vertex getVertex() {
            return node;
        }

		@Override
		public int compareTo(Edge e) {
			int cmp = this.node.getValue() > e.node.getValue() ? +1 : this.node.getValue() < e.node.getValue() ? -1 : 0;
			return cmp;
		}



	}

//a private hashmap adjacent_vertices consists of Vertex objects mapped to a List of edges that are adjacent to it. Edges have vertex in them

	private Map<Vertex, List<Edge>> neighbors = new HashMap<Vertex, List<Edge>>();
	
	

	  public void add(Vertex node) {
	        if (!neighbors.containsKey(node)){
	        neighbors.put(node, new ArrayList<Edge>());
	        }
	    }

	  
	  //method check if graph contains vertex, returns true 
	  public boolean contains(Vertex node) {
	        return neighbors.containsKey(node);
	    }
	  
	  
	  
	    /**
	     * Add an edge to the graph; if either vertex does not exist we double check in the add whether it already exists to not add it again
	     * and only then it's added. If its already there we just add it as a neighbor. 
	     * This implementation allows the creation of multi-edges and self-loops.
	     */
	    public void add(Vertex from, Vertex to) {
	        this.add(from);
	        this.add(to);
	        neighbors.get(from).add(new Edge(to));
	    }

	  //returns a graph by reversing the vertices 
	    public DiGraph reverse() {
	        DiGraph R = new DiGraph();
	        for (Vertex v : neighbors.keySet()) {
	            for (Edge e : neighbors.get(v)) {
	                R.add(e.getVertex(), v);
	            }
	        }
	        return R;
	    }
	    
	    //iterator to return vertices for other classes from the graph 
	    public Iterable<Vertex> getVertices() {
			return neighbors.keySet();
		}
	    
	    
	    //iterator to return the adjacent vertices
	    public Iterable<Edge> getNeighbors(Vertex v ) {
			if (!neighbors.containsKey(v)) return null;
			List<Edge> list_edges = neighbors.get(v);
			Collections.sort(list_edges);
			return list_edges;
		}
	    
	    public List<Edge> get_adj(Vertex v){
	    	List<Edge> list_edges = neighbors.get(v);
			Collections.sort(list_edges);
			return list_edges;
	    }
	    
	    
	    public String toString() {
	        StringBuffer s = new StringBuffer();
	        for (Vertex v : neighbors.keySet()){
	        	for (Edge e : neighbors.get(v)) {
	        		 s.append("\n    " + v.getValue() + " -> " + e.getVertex().getValue());
	            }
	        }
	           
	        return s.toString();
	    }

}

