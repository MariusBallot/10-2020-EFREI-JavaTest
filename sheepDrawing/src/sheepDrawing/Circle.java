package sheepDrawing;

public class Circle extends GeomForm implements Surfaceable {
	
	private int rad;
	private int air;

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	Circle(int rad) {
		super();
		this.rad = rad;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + air;
		result = prime * result + rad;
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
		Circle other = (Circle) obj;
		if (air != other.air)
			return false;
		if (rad != other.rad)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Circle [rad=" + rad + ", air=" + air + "]";
	}

	public double getAir() {
		return Math.pow(rad, 2)*Math.PI;
	}
	public double getPerim() {
		return rad*2*Math.PI;
	}

}