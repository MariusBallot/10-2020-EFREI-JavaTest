package sheepDrawing;

public class Circle extends GeomForm implements Surfaceable {
	
	private int ox;
	private int oy;
	private int rad;
	private int air;

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	Circle(int x, int y, int rad) {
		super();
		this.ox = x;
		this.ox = y;
		this.rad = rad;
		
		super.transform.setObjType(this);
	}
	
	public int getOx() {
		return ox;
	}

	public void setOx(int ox) {
		this.ox = ox;
	}

	public int getOy() {
		return oy;
	}

	public void setOy(int oy) {
		this.oy = oy;
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
		return "\n"+Utils.insSpace(3)+"Circle\n"+Utils.insSpace(4)+"rad:" + rad+", ox: "+ox+", oy: "+oy;
	}

	public double getAir() {
		return Math.pow(rad, 2)*Math.PI;
	}
	public double getPerim() {
		return rad*2*Math.PI;
	}

}