package sheepDrawing;

import java.util.ArrayList;

public class Fresque {
	
	private ArrayList<Dessin> dessins= new ArrayList<Dessin>(); 
	
	Fresque(){
		MatrixTransform transform = new MatrixTransform();
	}
	
	void addDessin(Dessin obj){
		dessins.add(obj);
	}

	@Override
	public String toString() {
		return "Fresque" + dessins.toString().replace("[", "").replace("]", "");
	}

}
