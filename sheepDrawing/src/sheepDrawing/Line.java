package sheepDrawing;


public class Line extends GeomForm implements Surfaceable {

	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private int width;

	private double d;

	public Line(int startX, int startY, int endX, int endY, int width) {
		super();
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.width = width;

		d = Math.sqrt(
				(this.endX - this.startX) * (this.endX - this.startX) + (this.endY - startY) * (this.endY - startY));
		
		super.transform.setObjType(this);
			
	}

	public double getPerim() {
		return d + width * 2;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}

	public double getAir() {
		return d * width;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endX;
		result = prime * result + endY;
		result = prime * result + startX;
		result = prime * result + startY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (endX != other.endX)
			return false;
		if (endY != other.endY)
			return false;
		if (startX != other.startX)
			return false;
		if (startY != other.startY)
			return false;
		return true;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void updateMatrix() {
		this.startX += super.transform.getPosX();
		this.startY += super.transform.getPosY();
		
		
	}

	@Override
	public String toString() {
		return "\n" + Utils.insSpace(3) + "Line\n" + Utils.insSpace(4) + "startX:" + startX + ", startY:" + startY
				+ ", endX:" + endX + ", endY:" + endY + ", Length:" + d;
	}

}