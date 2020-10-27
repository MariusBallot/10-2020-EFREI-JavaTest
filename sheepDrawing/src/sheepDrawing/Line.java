package sheepDrawing;

public class Line extends GeomForm {
	
	private int endX;
	private int endY;


	public Line(int posX, int posY, double rot, double scaleX, double scaleY, int endX, int endY) {
		super(posX, posY, rot, scaleX, scaleY);
		
		this.endX = endX;
		this.endY = endY;
		
	}
	
	public double getPerim() {
		return Math.sqrt((this.endX-super.transform.getPosX())*(this.endX-super.transform.getPosX()) + (this.endY-super.transform.getPosY())*(this.endY-super.transform.getPosY()));
	}
	
	public double getAir() {
		return 0;
	}

}