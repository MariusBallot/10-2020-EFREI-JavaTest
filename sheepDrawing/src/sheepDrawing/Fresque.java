package sheepDrawing;

import java.util.ArrayList;

public class Fresque {
	
	private ArrayList<Dessin> dessins= new ArrayList<Dessin>(); 
	
	Fresque(){
		Transform transform = new Transform();
	}
	
	void addDessin(Dessin obj){
		dessins.add(obj);
	}

}
