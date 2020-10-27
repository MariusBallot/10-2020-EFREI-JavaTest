package sheepDrawing;

import java.util.ArrayList;

public class Polygon extends GeomForm implements Surfaceable {

	@Override
	public String toString() {
		return "Polygon [vertices=" + vertices + "]";
	}

	ArrayList<ArrayList<Integer>> vertices = new ArrayList<ArrayList<Integer>>();

	Polygon() {
		super();
	}

	public void addPoint(int x, int y) {
		ArrayList<Integer> vertex = new ArrayList<Integer>(2);
		vertex.add(x);
		vertex.add(y);

		this.vertices.add(vertex);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertices == null) ? 0 : vertices.hashCode());
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
		Polygon other = (Polygon) obj;
		if (vertices == null) {
			if (other.vertices != null)
				return false;
		} else if (!vertices.equals(other.vertices))
			return false;
		return true;
	}

	public double getAir() {

		double sum = 0;

		for (int i = 0; i < this.vertices.size() - 1; i++) {
			if (i == 0)
				sum += this.vertices.get(i).get(0)
						* (this.vertices.get(i + 1).get(1) - this.vertices.get(this.vertices.size() - 1).get(1));
			else
				sum += this.vertices.get(i).get(0)
						* (this.vertices.get(i + 1).get(1) - this.vertices.get(i - 1).get(1));

		}
		return 0.5 * Math.abs(sum);
	}

	public double getPerim() {
		return 0.0;
	}

}