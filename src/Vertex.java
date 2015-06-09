
 /* Class Vertex by M Farjad Yousufi CS566 MET Boston University*/
public class Vertex        
 {
     
     private int value;
     private int discovery_time, finish_time;
     private Vertex parent; 
     private String color = "WHITE"; 
     private int component;
 
     /* Constructor */
     public Vertex(int n)
     {
         
         setValue(n);
     }  
     
    

	public int getDiscovery_time() {
		return discovery_time;
	}

	public void setDiscovery_time(int discovery_time) {
		this.discovery_time = discovery_time;
	}



	public int getFinish_time() {
		return finish_time;
	}



	public void setFinish_time(int finish_time) {
		this.finish_time = finish_time;
	}



	public Vertex getParent() {
		return parent;
	}



	public void setParent(Vertex parent) {
		this.parent = parent;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public int getValue() {
		return value;
	}



	public void setValue(int value) {
		this.value = value;
	}



	public int getComponent() {
		return component;
	}



	public void setComponent(int component) {
		this.component = component;
	}
     
 }
