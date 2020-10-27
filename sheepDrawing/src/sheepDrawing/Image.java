package sheepDrawing;

import java.util.ArrayList;

public class Image {

	public Transform transform;
	private ArrayList<GeomForm> geomForms = new ArrayList<GeomForm>();

	Image() {
		transform = new Transform();
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
		result = prime * result + ((transform == null) ? 0 : transform.hashCode());
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
		if (transform == null) {
			if (other.transform != null)
				return false;
		} else if (!transform.equals(other.transform))
			return false;
		return true;
	}

}
