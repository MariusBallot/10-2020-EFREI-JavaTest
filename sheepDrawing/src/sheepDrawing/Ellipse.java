package sheepDrawing;

public class Ellipse extends GeomForm {
	
	private int air;
	private int radX;
	private int radY;


	Ellipse(int posX, int posY, double rot, double scaleX, double scaleY, int radX, int radY) {
		super(posX, posY, rot, scaleX, scaleY);
		this.radX=radX;
		this.radY=radY;
	}
	
	public double getAir() {
		return this.radX*this.radY*Math.PI;
	}
	
	public double getPerim() {
		return 2*Math.PI*Math.sqrt((Math.pow(radX, 2)+Math.pow(radY, 2))/2);
	}

}