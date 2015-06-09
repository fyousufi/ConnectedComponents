import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;




public class DFS_first {
   
private Stack<Vertex> postorder;
private Queue<Vertex> finish_time_q = new LinkedList<Vertex>();
private ArrayList<Vertex> timeslist = new ArrayList<Vertex>();
//Last in, first out for the G transpose decreasing finish time
//private Queue<Vertex> reverse_postorder; to be implemented in the main Strong CC class 
//Will allow for implementing increasing finish times
									
public static int time; 

    public DFS_first(DiGraph G) {
        postorder = new Stack<Vertex>();
        
        
        for (Vertex v : G.getVertices()){
        	v.setColor("WHITE");
        	v.setParent(null);
        }
        time = 0; 
        for (Vertex v : G.getVertices()){
        	if(v.getColor().equals("WHITE")){
        		DFS_Visit(G, v);
        	}
        	
        }
    }

	private void DFS_Visit(DiGraph g, Vertex v) {
		time = time + 1; 
		v.setDiscovery_time(time);
		v.setColor("GRAY");
		
		for(DiGraph.Edge u: g.get_adj(v)){
			if (u.getVertex().getColor().equals("WHITE")){
				u.getVertex().setParent(v);
				DFS_Visit(g,u.getVertex());
			}
		}
		v.setColor("BLACK");
		time= time+1; 
		v.setFinish_time(time);	
		timeslist.add(v);
		
	}
	
	   public Iterable<Vertex> decreasingfinishtime() {
	        postorder = new Stack<Vertex>();
	        for (int i = timeslist.size()-1; i >=0; i--){
	            postorder.push(timeslist.get(i));
	        }    
	        return postorder;
	    }
	 public Iterable<Vertex> post() {
	        return postorder;
	    }
	 
	 public Iterable<Vertex> finishtimedec(){
		 return finish_time_q;
	 }
	 public Iterable<Vertex> returnlist(){
		 return timeslist;
	 }

}
