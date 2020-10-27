package sheepDrawing;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fresque f = new Fresque();
		Dessin d = new Dessin();
		Image i = new Image();
		Image i2 = new Image();

		
		Polygon g = new Polygon();
		Polygon g2 = new Polygon();
		
		g.addPoint(10,20);
		g.addPoint(20,20);
		g.addPoint(200,20);
		
		g2.addPoint(10,20);
		g2.addPoint(20,10);
		g2.addPoint(200,20);

		
		i.addGeomFrom(g);
		i2.addGeomFrom(g);

		d.addImage(i);
		d.addImage(i2);

		f.addDessin(d);
		

	}

}
