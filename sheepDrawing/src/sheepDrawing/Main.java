package sheepDrawing;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Polygon p = new Polygon(10, 10, 1, 10, 10);
		
		p.addPoint(0, 0);
		p.addPoint(30, 0);
		p.addPoint(30, 30);
		p.addPoint(0, 30);


		System.out.print(p.getAir());

	}

}