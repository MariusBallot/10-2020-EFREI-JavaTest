package sheepDrawing;

public class Line extends GeomForm implements Surfaceable{
	
	private int startX;
	private int startY;
	private int endX;
	private int endY;


	public Line(int startX, int startY,int endX, int endY) {
		super();
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		
	}
	
	public double getPerim() {
		return Math.sqrt((this.endX-super.transform.getPosX())*(this.endX-super.transform.getPosX()) + (this.endY-super.transform.getPosY())*(this.endY-super.transform.getPosY()));
	}
	
	public double getAir() {
		return 0;
	}

	@Override
	public String toString() {
		return "Line [startX=" + startX + ", startY=" + startY + ", endX=" + endX + ", endY=" + endY + "]";
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

}