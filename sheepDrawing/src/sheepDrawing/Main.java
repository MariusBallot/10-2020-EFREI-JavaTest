package sheepDrawing;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// FRESQUE EXAMPLE
		// FRESQUE EXAMPLE
		// FRESQUE EXAMPLE
		Fresque f = new Fresque();
		Dessin d = new Dessin();
		Image i = new Image();
		Image i2 = new Image();

		// adding a polygon
		Polygon g = new Polygon();
		g.addPoint(0, 0);
		g.addPoint(0, 20);
		g.addPoint(20, 20);
		i.addGeomFrom(g);
		
		// adding a circle
		Circle c = new Circle(10,10,100);
		i.addGeomFrom(c);
		System.out.println(c);

		// adding a line
		Line l = new Line(10, 0, 20, 0, 1);
		i.addGeomFrom(l);


		// adding an Ellipse
		i.addGeomFrom(new Ellipse(10, 200));

		// adding an Ellipse
		i2.addGeomFrom(new Ellipse(100, 200));

		d.addImage(i);
		d.addImage(i2);

		f.addDessin(d);

		//System.out.println(f);

	}

}