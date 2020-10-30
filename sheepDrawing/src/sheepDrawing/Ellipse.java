package sheepDrawing;

public class Ellipse extends GeomForm implements Surfaceable{
	
	private int air;
	private int radX;
	private int radY;


	Ellipse(int radX, int radY) {
		super();
		this.radX=radX;
		this.radY=radY;
		super.transform.setObjType(this);

	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + air;
		result = prime * result + radX;
		result = prime * result + radY;
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
		Ellipse other = (Ellipse) obj;
		if (air != other.air)
			return false;
		if (radX != other.radX)
			return false;
		if (radY != other.radY)
			return false;
		return true;
	}

	public double getAir() {
		return this.radX*this.radY*Math.PI;
	}
	
	public double getPerim() {
		return 2*Math.PI*Math.sqrt((Math.pow(radX, 2)+Math.pow(radY, 2))/2);
	}
	
	
	@Override
	public String toString() {
		return "\n"+Utils.insSpace(3)+"Ellipse\n"+Utils.insSpace(4)+"radX:" + radX + ", radY:" + radY;
	}

}