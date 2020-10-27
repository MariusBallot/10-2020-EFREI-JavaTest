package sheepDrawing;

public class GeomForm {
	
	public Transform transform;
	
	GeomForm(int posX, int posY, double rot, double scaleX, double scaleY){
		transform = new Transform(posX,  posY,  rot,  scaleX,  scaleY);
	}
	

}