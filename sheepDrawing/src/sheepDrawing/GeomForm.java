package sheepDrawing;

public class GeomForm implements Surfaceable {

	public MatrixTransform transform;

	GeomForm() {
		transform = new MatrixTransform();

	}

	public double getAir() {
		return 0;
	}

	public double getPerim() {
		return 0;
	}

}