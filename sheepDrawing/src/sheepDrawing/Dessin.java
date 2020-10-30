package sheepDrawing;

import java.util.ArrayList;

public class Dessin implements Surfaceable {

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

	@Override
	public String toString() {
		return " \n" +Utils.insSpace(1)+ "Dessin" + images;
	}

	public double getAir() {
		double sum = 0;

		for (int i = 0; i < images.size(); i++) {
			sum += images.get(i).getAir();
		}

		return sum;
	}

	public double getPerim() {
		double sum = 0;

		for (int i = 0; i < images.size(); i++) {
			sum += images.get(i).getPerim();
		}

		return sum;
	}

}
