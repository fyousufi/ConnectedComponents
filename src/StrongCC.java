import java.util.LinkedList;
import java.util.Queue;

public class StrongCC {
	//will utilize the dfs and the stack on the dfs to process vertices 
	//will output vertices for each component based on a queue where u.f is run on transpose of G
	private Queue<Vertex> reverse_order;//outputs the components in increasing time with an iterator 
	public static int time; 
    private int count;            // number of strongly-connected components- only incremented if new component found 

    //this should be called on the digraph 
    public StrongCC(DiGraph G) {
    	reverse_order = new LinkedList<Vertex>();
        // compute first depth first search on the graph 
        DFS_first dfs = new DFS_first(G);
        
        //runs the second DFS on the graph and calculates the components and modifies the vertex component
        // run DFS on transpose of G, using post order to get the nodes and then do the first DFS using the iterator post
        G = G.reverse();
        
      
            
            for (Vertex v : dfs.decreasingfinishtime()){
            	//System.out.println(v.getValue()+"and finish time was"+ v.getFinish_time());
            	v.setColor("WHITE");
            	v.setParent(null);
            }
            time = 0; 
            for (Vertex v : dfs.decreasingfinishtime()){
            	if(v.getColor().equals("WHITE")){
            		DFS_Visit_Second(G,v);
            		count++;
            	}
            	
            }
        }
        
    private void DFS_Visit_Second(DiGraph G, Vertex v){ //still running this on transpose
    	v.setComponent(count); //sets the component of the vertex 
    	time = time + 1; 
    	v.setDiscovery_time(time);
    	v.setColor("GRAY");
    	for(DiGraph.Edge u: G.get_adj(v)){
			if (u.getVertex().getColor().equals("WHITE")){
				u.getVertex().setParent(v);
				//System.out.println(u.getVertex().getValue());
				DFS_Visit_Second(G,u.getVertex());
				
			}
		}
		v.setColor("BLACK");
		time= time+1; 
		v.setFinish_time(time);	
		reverse_order.add(v);
    }
    
    public Iterable<Vertex> reverse_order() {
        return reverse_order;
    }
}
