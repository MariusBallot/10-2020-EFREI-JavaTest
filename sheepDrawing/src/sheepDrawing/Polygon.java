package sheepDrawing;

import java.util.ArrayList;

public class Polygon extends GeomForm implements Surfaceable {

	ArrayList<ArrayList<Integer>> vertices = new ArrayList<ArrayList<Integer>>();

	Polygon() {
		super();
	}

	public void addPoint(int x, int y) {
		ArrayList<Integer> vertex = new ArrayList<Integer>(2);
		vertex.add(x);
		vertex.add(y);

		this.vertices.add(vertex);
		super.transform.setObjType(this);

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

	@Override
	public double getAir() {
		double area = 0;

		if (vertices.size() == 3) {
			area = (vertices.get(0).get(0) * (vertices.get(1).get(1) - vertices.get(2).get(1))
					+ vertices.get(1).get(0) * (vertices.get(2).get(1) - vertices.get(0).get(1))
					+ vertices.get(2).get(0) * (vertices.get(0).get(1) - vertices.get(1).get(1))) / 2.0;
			area = Math.abs(area);
		} else {
			double sum = 0;
			for (int i = 0; i < vertices.size(); i++) {
				if (i == 0) {
					sum += vertices.get(i).get(0)
							* (vertices.get(i + 1).get(1) - vertices.get(this.vertices.size() - 1).get(1));
				} else if (i == vertices.size() - 1) {
					sum += vertices.get(i).get(0) * (vertices.get(i).get(1) - vertices.get(i - 1).get(1));
				} else {
					sum += vertices.get(i).get(0) * (vertices.get(i + 1).get(1) - vertices.get(i - 1).get(1));
				}
			}

			area = 0.5 * Math.abs(sum);
		}

		return area;

	}

	@Override
	public double getPerim() {
		double distance = 0;
		for (int i = 0; i < vertices.size(); i++) {
			int x1 = vertices.get(0).get(0);
			int y1 = vertices.get(0).get(1);
			int x2 = vertices.get((i + 1) % vertices.size()).get(0);
			int y2 = vertices.get((i + 1) % vertices.size()).get(1);
			distance += Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		}
		return distance;
	}
	
	
	@Override
	public String toString() {
		return "\n"+Utils.insSpace(3)+"Polygon\n"+Utils.insSpace(4)+"vertices:" + vertices;
	}


}