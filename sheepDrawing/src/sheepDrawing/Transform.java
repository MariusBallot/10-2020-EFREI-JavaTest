package sheepDrawing;

public class Transform {
	private int posX = 0;
	private int posY = 0;
	private double rot = 0;
	private double scaleX = 1;
	private double scaleY = 1;

	private Object targetObj;

	Transform() {

	}

	Transform(int posX, int posY, double rot, double scaleX, double scaleY) {
		this.posX = posX;
		this.posY = posY;
		this.rot = rot;
		this.scaleX = scaleX;
		this.scaleY = scaleY;

	}

	public void setObjType(Object obj) {
		targetObj = obj;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public double getRot() {
		return rot;
	}

	public double getScaleX() {
		return scaleX;
	}

	public double getScaleY() {
		return scaleY;
	}

	public void translate(int x, int y) {
		this.posX += x;
		this.posY += y;
		if (this.targetObj instanceof Line) {
			((Line) targetObj).setStartX(((Line) targetObj).getStartX() + this.posX);
			((Line) targetObj).setStartY(((Line) targetObj).getStartY() + this.posY);
			
			((Line) targetObj).setEndX(((Line) targetObj).getEndX() + this.posX);
			((Line) targetObj).setEndY(((Line) targetObj).getEndY() + this.posY);
		}
		
		if (this.targetObj instanceof Polygon) {
			for(int i = 0; i < ((Polygon) targetObj).vertices.size(); i++){
				int vx = ((Polygon) targetObj).vertices.get(i).get(0);
				int vy = ((Polygon) targetObj).vertices.get(i).get(1);
				
				((Polygon) targetObj).vertices.get(i).set(0, vx+this.posX);
				((Polygon) targetObj).vertices.get(i).set(1, vy+this.posY);
			}
		}
		if (this.targetObj instanceof Circle) {
			((Circle) targetObj).setStartX(((Circle) targetObj).getStartX() + this.posX);
			((Circle) targetObj).setStartY(((Circle) targetObj).getStartY() + this.posY);
		}
		

	}

	private int[] computeScale(int x, int y, int ox, int oy, int f) {
		int nR[];
		nR = new int[2];

		double nx = f*(x-ox);
		double ny = f*(y-oy);
		
		nR[0]=(int)nx;
		nR[1]=(int)ny;

		return nR;
	}
	public void scale(int f) {

		if (this.targetObj instanceof Line) {
			int sx = ((Line) targetObj).getStartX();
			int sy = ((Line) targetObj).getStartY();
			int ex = ((Line) targetObj).getEndX();
			int ey = ((Line) targetObj).getEndY();
			

			((Line) targetObj).setStartX(computeScale(sx,sy, this.posX, this.posY, f)[0]);
			((Line) targetObj).setStartY(computeScale(sx,sy, this.posX, this.posY, f)[1]);
			((Line) targetObj).setEndX(computeScale(ex,ey, this.posX, this.posY, f)[0]);
			((Line) targetObj).setEndY(computeScale(ex,ey, this.posX, this.posY, f)[1]);
		
			((Line) targetObj).setWidth(((Line) targetObj).getWidth()*f);

		}
		
		if (this.targetObj instanceof Polygon) {
			for(int i = 0; i < ((Polygon) targetObj).vertices.size(); i++){
				int vx = ((Polygon) targetObj).vertices.get(i).get(0);
				int vy = ((Polygon) targetObj).vertices.get(i).get(1);
				
				((Polygon) targetObj).vertices.get(i).set(0, computeScale(vx,vy, this.posX, this.posY, f)[0]);
				((Polygon) targetObj).vertices.get(i).set(1, computeScale(vx,vy, this.posX, this.posY, f)[1]);
			}
		}

	}

	private int[] computeRotation(int x, int y, int ox, int oy, double r) {
		int nR[];
		nR = new int[2];

		double nx = (x - ox) * Math.cos(r) - (y - oy) * Math.sin(r) + ox;
		double ny = (x - oy) * Math.sin(r) + (y - oy) * Math.cos(r) + oy;
		
		nR[0]=(int)nx;
		nR[1]=(int)ny;

		return nR;
	}

	public void rotate(double r) {

		if (this.targetObj instanceof Line) {
			int sx = ((Line) targetObj).getStartX();
			int sy = ((Line) targetObj).getStartY();
			int ex = ((Line) targetObj).getEndX();
			int ey = ((Line) targetObj).getEndY();
			

			((Line) targetObj).setStartX(computeRotation(sx,sy, this.posX, this.posY, r)[0]);
			((Line) targetObj).setStartY(computeRotation(sx,sy, this.posX, this.posY, r)[1]);
			((Line) targetObj).setEndX(computeRotation(ex,ey, this.posX, this.posY, r)[0]);
			((Line) targetObj).setEndY(computeRotation(ex,ey, this.posX, this.posY, r)[1]);
		}
		if (this.targetObj instanceof Polygon) {
			for(int i = 0; i < ((Polygon) targetObj).vertices.size(); i++){
				int vx = ((Polygon) targetObj).vertices.get(i).get(0);
				int vy = ((Polygon) targetObj).vertices.get(i).get(1);
				
				((Polygon) targetObj).vertices.get(i).set(0, computeRotation(vx,vy, this.posX, this.posY, r)[0]);
				((Polygon) targetObj).vertices.get(i).set(1, computeRotation(vx,vy, this.posX, this.posY, r)[1]);
			}
		}

	}

}
