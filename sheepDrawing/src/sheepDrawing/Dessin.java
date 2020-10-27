package sheepDrawing;

import java.util.ArrayList;

public class Dessin {

	private ArrayList<Image> images = new ArrayList<Image>();

	Dessin() {
		Transform transform = new Transform();
	}

	void addImage(Image obj) {
		Boolean exists = false;

		for (int i = 0; i < images.size(); i++) {
			exists = obj.equals(images.get(i));
		}

		if (exists == true) {
			System.out.println(obj + "This image already exists");
			return;
		}

		images.add(obj);

	}
}
