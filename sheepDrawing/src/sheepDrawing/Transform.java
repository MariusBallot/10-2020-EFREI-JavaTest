package sheepDrawing;

public class Transform {
	private int posX=0;
	private int posY=0;
	private double rot=0;
	private double scaleX = 1;
	private double scaleY = 1;
	
	Transform() {

	}

	Transform(int posX, int posY, double rot, double scaleX, double scaleY) {
		this.posX = posX;
		this.posY = posY;
		this.rot = rot;
		this.scaleX = scaleX;
		this.scaleY = scaleY;

	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public double getRot() {
		return rot;
	}

	public void setRot(double rot) {
		this.rot = rot;
	}

	public double getScaleX() {
		return scaleX;
	}

	public void setScaleX(double scaleX) {
		this.scaleX = scaleX;
	}

	public double getScaleY() {
		return scaleY;
	}

	public void setScaleY(double scaleY) {
		this.scaleY = scaleY;
	}

}
