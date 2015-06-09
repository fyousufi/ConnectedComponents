import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/* Code written by M Farjad Yousufi for Analysis of Algorithms for Boston University MET*/
public class Driver {

	public static void main(String[] args) throws IOException {
		
		//String output_filename = args[1];
		FileOutputStream foutputstream = new FileOutputStream("C:\\Users\\fyousufi\\Desktop\\p3_out.txt");
		//FileOutputStream foutputstream = new FileOutputStream(output_filename);
		PrintStream outputfile = new PrintStream(foutputstream);
	    outputfile.printf("Connected Component|"+""+"Vertex|FinishingTime");
	    outputfile.println();
	    System.out.print("Connected Component|"+"Vertex|FinishingTime");
	    System.out.println();
	    DiGraph graph = new DiGraph();
	
	    
	  
	
		
		
		//String input_filename = args[0];
		String input_filename = "C:\\Users\\fyousufi\\Desktop\\p3_input.txt";
		int count_lines =0;
		 try
	        {
	            
	            Scanner inputStream = new Scanner(new BufferedReader(new FileReader(input_filename)));
	            // Read the header line
	            //String line = inputStream.nextLine();
	            // Read the rest of the file line by line
	            while(inputStream.hasNextLine()){
	            	
	            	
	            	count_lines++; 
	            	
	            }
	            inputStream.close( );
	            //System.out.println(count_lines);
	            Scanner inputStream_re = new Scanner(new BufferedReader(new FileReader(input_filename)));
	        	Vertex[] vertices = new Vertex[count_lines];
	        	int n=0;
	            while (inputStream_re.hasNextLine())
	            {
	            	//Integer n;
					String line = inputStream_re.nextLine();
					//System.out.println(line);
					String[] data = line.split(":");
					int node_value = Integer.parseInt(data[0]);
					//create a vertex class by adding node_value to the Digraph class
					//Vertex v = new Vertex(node_value); 
					vertices[n] = new Vertex(node_value);
					
					graph.add(vertices[n]);
					

					n++;
	            }
	            inputStream_re.close( );
	            Scanner inputStream_re_two = new Scanner(new BufferedReader(new FileReader(input_filename)));
	            int o =0; 
	            while (inputStream_re_two.hasNextLine())
	            {
	            	
					String line = inputStream_re_two.nextLine();
					String[] data = line.split(":");
					String[] adj_nodes = data[1].split(",");
					for(int i=0; i< adj_nodes.length; i++){
						//System.out.println("Size in adj nodes are"+adj_nodes.length);
					}
					Vertex[] adj_vertex_nodes = new Vertex[adj_nodes.length];
					
				
					for( int i=0; i < adj_nodes.length; i++){
						 //add adj_nodes to the hashmap and mapping it to the node value vertex (after calling the vertex)
						int adj_node_int = Integer.parseInt(adj_nodes[i]);
						adj_vertex_nodes[i]= new Vertex(adj_node_int);
					}
					for( int i=0; i < adj_vertex_nodes.length; i++){
						
						graph.add(vertices[o],vertices[(adj_vertex_nodes[i].getValue())-1]);
						
						
					}
					o++;
	            }
	            //System.out.println();
	            inputStream_re_two.close( );
	       
	            StrongCC connectedcom = new StrongCC(graph);
	            for(Vertex x : connectedcom.reverse_order()){
	            	System.out.println(x.getComponent()+ "|"+ x.getValue()+ "|" + x.getFinish_time());
	            	 outputfile.printf(x.getComponent()+ "|"+ x.getValue()+ "|" + x.getFinish_time());
	            	 outputfile.println();
	            }
	           
	          
	        }
	       catch(FileNotFoundException e)
	        {
	            System.out.println("Cannot find file " + input_filename);
	        }
	       
		 outputfile.close();
	}

}
