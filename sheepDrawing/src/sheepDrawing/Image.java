package sheepDrawing;

import java.util.ArrayList;

public class Image implements Surfaceable {

	public MatrixTransform transform;
	private ArrayList<GeomForm> geomForms = new ArrayList<GeomForm>();

	Image() {
		transform = new MatrixTransform();
		
		transform.setObjType(this);
	}

	void addGeomFrom(GeomForm obj) {
		Boolean exists = false;

		for (int i = 0; i < geomForms.size(); i++) {
			exists = obj.equals(geomForms.get(i));
		}

		if (exists == true) {
			System.out.println(obj + "This geometric form already exists");
			return;
		}

		geomForms.add(obj);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geomForms == null) ? 0 : geomForms.hashCode());
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
		Image other = (Image) obj;
		if (geomForms == null) {
			if (other.geomForms != null)
				return false;
		} else if (!geomForms.equals(other.geomForms))
			return false;
		return true;
	}

	public ArrayList<GeomForm> getGeomForms() {
		return geomForms;
	}

	public double getAir() {
		double sum = 0;

		for (int i = 0; i < geomForms.size(); i++) {
			sum += geomForms.get(i).getAir();
		}
		return sum;
	}

	public double getPerim() {
		double sum = 0;

		for (int i = 0; i < geomForms.size(); i++) {
			sum += geomForms.get(i).getPerim();
		}
		return sum;
	}

	@Override
	public String toString() {
		return "\n"+Utils.insSpace(2)+"Image" + geomForms;
	}

}
