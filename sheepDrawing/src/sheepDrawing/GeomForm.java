package sheepDrawing;

public class GeomForm implements Surfaceable {

	public Transform transform;

	GeomForm() {
		transform = new Transform();

	}

	public double getAir() {
		return 0;
	}

	public double getPerim() {
		return 0;
	}

}