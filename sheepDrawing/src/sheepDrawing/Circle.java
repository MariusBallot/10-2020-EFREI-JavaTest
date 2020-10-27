package sheepDrawing;

public class Circle extends GeomForm {
	
	private int rad;
	private int air;

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	Circle(int posX, int posY, double rot, double scaleX, double scaleY, int rad) {
		super(posX, posY, rot, scaleX, scaleY);
		this.rad = rad;
	}
	
	public double getAir() {
		return Math.pow(rad, 2)*Math.PI;
	}
	public double getPerim() {
		return rad*2*Math.PI;
	}

}