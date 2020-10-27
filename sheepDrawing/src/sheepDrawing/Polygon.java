package sheepDrawing;

import java.util.ArrayList;

public class Polygon extends GeomForm {

	ArrayList<int[]> vertices = new ArrayList<int[]>();

	Polygon(int posX, int posY, double rot, double scaleX, double scaleY) {
		super(posX, posY, rot, scaleX, scaleY);
	}

	public void addPoint(int x, int y) {
		int[] vertex = new int[2];
		vertex[0] = x;
		vertex[1] = y;


		this.vertices.add(vertex);
		

	}

	public double getAir() {

		double sum = 0;

		for (int i = 0; i < this.vertices.size()-1; i++) {
			if (i == 0)
				sum += this.vertices.get(i)[0] * (this.vertices.get(i + 1)[1] - this.vertices.get(this.vertices.size() - 1)[1]);
			else
				sum += this.vertices.get(i)[0] * (this.vertices.get(i + 1)[1] - this.vertices.get(i - 1)[1]);
			

		}
		return 0.5 * Math.abs(sum);
	}

}