package sheepDrawing;

public class MatrixTransform {
	private int posX = 0;
	private int posY = 0;
	private double rot = 0;
	private double scale = 0;

	private Object targetObj;

	MatrixTransform() {

	}

	MatrixTransform(int posX, int posY, double rot, double scale) {
		this.posX = posX;
		this.posY = posY;
		this.rot = rot;
		this.scale = scale;

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

	public double getScale() {
		return scale;
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
			for (int i = 0; i < ((Polygon) targetObj).vertices.size(); i++) {
				int vx = ((Polygon) targetObj).vertices.get(i).get(0);
				int vy = ((Polygon) targetObj).vertices.get(i).get(1);

				((Polygon) targetObj).vertices.get(i).set(0, vx + this.posX);
				((Polygon) targetObj).vertices.get(i).set(1, vy + this.posY);
			}
		}
		
		if (this.targetObj instanceof Circle) {
			((Circle) targetObj).setOx(((Circle) targetObj).getOx() + this.posX);
			((Circle) targetObj).setOy(((Circle) targetObj).getOy() + this.posY);
		}
		
		if (this.targetObj instanceof Ellipse) {
			((Ellipse) targetObj).setOx(((Ellipse) targetObj).getOx() + this.posX);
			((Ellipse) targetObj).setOy(((Ellipse) targetObj).getOy() + this.posY);
		}
		
		if (this.targetObj instanceof Image) {
			for(int i = 0; i <((Image) targetObj).getGeomForms().size(); i++) {
				((Image) targetObj).getGeomForms().get(i).transform.translate(x, y);
			}
		}
		
		if (this.targetObj instanceof Dessin) {
			for(int i = 0; i <((Dessin) targetObj).getImages().size(); i++) {
				((Dessin) targetObj).getImages().get(i).transform.translate(x, y);
			}
		}

	}

	private int[] computeScale(int x, int y, int ox, int oy, int f) {
		int nR[];
		nR = new int[2];

		double nx = f * (x - ox);
		double ny = f * (y - oy);

		nR[0] = (int) nx;
		nR[1] = (int) ny;

		return nR;
	}

	public void scale(int f) {

		if (this.targetObj instanceof Line) {
			int sx = ((Line) targetObj).getStartX();
			int sy = ((Line) targetObj).getStartY();
			int ex = ((Line) targetObj).getEndX();
			int ey = ((Line) targetObj).getEndY();

			((Line) targetObj).setStartX(computeScale(sx, sy, this.posX, this.posY, f)[0]);
			((Line) targetObj).setStartY(computeScale(sx, sy, this.posX, this.posY, f)[1]);
			((Line) targetObj).setEndX(computeScale(ex, ey, this.posX, this.posY, f)[0]);
			((Line) targetObj).setEndY(computeScale(ex, ey, this.posX, this.posY, f)[1]);

			((Line) targetObj).setWidth(((Line) targetObj).getWidth() * f);

		}

		if (this.targetObj instanceof Polygon) {
			for (int i = 0; i < ((Polygon) targetObj).vertices.size(); i++) {
				int vx = ((Polygon) targetObj).vertices.get(i).get(0);
				int vy = ((Polygon) targetObj).vertices.get(i).get(1);

				((Polygon) targetObj).vertices.get(i).set(0, computeScale(vx, vy, this.posX, this.posY, f)[0]);
				((Polygon) targetObj).vertices.get(i).set(1, computeScale(vx, vy, this.posX, this.posY, f)[1]);
			}
		}
		if (this.targetObj instanceof Circle) {
			((Circle) targetObj).setOx(computeScale(((Circle) targetObj).getOx(), ((Circle) targetObj).getOy(),
					this.posX, this.posY, f)[0]);
			((Circle) targetObj).setOy(computeScale(((Circle) targetObj).getOx(), ((Circle) targetObj).getOy(),
					this.posX, this.posY, f)[1]);
			((Circle) targetObj).setRad(((Circle) targetObj).getRad() * f);
		}

		if (this.targetObj instanceof Ellipse) {
			((Ellipse) targetObj).setOx(computeScale(((Ellipse) targetObj).getOx(), ((Ellipse) targetObj).getOy(),
					this.posX, this.posY, f)[0]);
			((Ellipse) targetObj).setOy(computeScale(((Ellipse) targetObj).getOx(), ((Ellipse) targetObj).getOy(),
					this.posX, this.posY, f)[1]);
			((Ellipse) targetObj).setRadX(((Ellipse) targetObj).getRadX() * f);
			((Ellipse) targetObj).setRadY(((Ellipse) targetObj).getRadY() * f);
		}
		if (this.targetObj instanceof Image) {
			for(int i = 0; i <((Image) targetObj).getGeomForms().size(); i++) {
				((Image) targetObj).getGeomForms().get(i).transform.scale(f);
			}
		}
		if (this.targetObj instanceof Dessin) {
			for(int i = 0; i <((Dessin) targetObj).getImages().size(); i++) {
				((Dessin) targetObj).getImages().get(i).transform.scale(f);
			}
		}

	}

	private int[] computeRotation(int x, int y, int ox, int oy, double r) {
		int nR[];
		nR = new int[2];

		double nx = (x - ox) * Math.cos(r) - (y - oy) * Math.sin(r) + ox;
		double ny = (x - oy) * Math.sin(r) + (y - oy) * Math.cos(r) + oy;

		nR[0] = (int) nx;
		nR[1] = (int) ny;

		return nR;
	}

	public void rotate(double r) {

		if (this.targetObj instanceof Line) {
			int sx = ((Line) targetObj).getStartX();
			int sy = ((Line) targetObj).getStartY();
			int ex = ((Line) targetObj).getEndX();
			int ey = ((Line) targetObj).getEndY();

			((Line) targetObj).setStartX(computeRotation(sx, sy, this.posX, this.posY, r)[0]);
			((Line) targetObj).setStartY(computeRotation(sx, sy, this.posX, this.posY, r)[1]);
			((Line) targetObj).setEndX(computeRotation(ex, ey, this.posX, this.posY, r)[0]);
			((Line) targetObj).setEndY(computeRotation(ex, ey, this.posX, this.posY, r)[1]);
		}
		if (this.targetObj instanceof Polygon) {
			for (int i = 0; i < ((Polygon) targetObj).vertices.size(); i++) {
				int vx = ((Polygon) targetObj).vertices.get(i).get(0);
				int vy = ((Polygon) targetObj).vertices.get(i).get(1);

				((Polygon) targetObj).vertices.get(i).set(0, computeRotation(vx, vy, this.posX, this.posY, r)[0]);
				((Polygon) targetObj).vertices.get(i).set(1, computeRotation(vx, vy, this.posX, this.posY, r)[1]);
			}
		}

		if (this.targetObj instanceof Circle) {
			((Circle) targetObj).setOx(computeRotation(((Circle) targetObj).getOx(), ((Circle) targetObj).getOy(),
					this.posX, this.posY, r)[0]);
			((Circle) targetObj).setOy(computeRotation(((Circle) targetObj).getOx(), ((Circle) targetObj).getOy(),
					this.posX, this.posY, r)[1]);
		}
		if (this.targetObj instanceof Ellipse) {
			((Ellipse) targetObj).setOx(computeRotation(((Ellipse) targetObj).getOx(), ((Ellipse) targetObj).getOy(),
					this.posX, this.posY, r)[0]);
			((Ellipse) targetObj).setOy(computeRotation(((Ellipse) targetObj).getOx(), ((Ellipse) targetObj).getOy(),
					this.posX, this.posY, r)[1]);
		}
		if (this.targetObj instanceof Image) {
			for(int i = 0; i <((Image) targetObj).getGeomForms().size(); i++) {
				((Image) targetObj).getGeomForms().get(i).transform.rotate(r);
			}
		}
		if (this.targetObj instanceof Dessin) {
			for(int i = 0; i <((Dessin) targetObj).getImages().size(); i++) {
				((Dessin) targetObj).getImages().get(i).transform.rotate(r);
			}
		}

	}

	private int[] computePointSymmetry(int x, int y, int sx, int sy) {
		int[] nP = new int[2];

		int nx = (sx - x) * 2;
		int ny = (sy - y) * 2;

		nP[0] = nx;
		nP[1] = ny;
		return nP;
	}

	public void pointSymmetry(int x, int y) {
		if (this.targetObj instanceof Line) {
			int sx = ((Line) targetObj).getStartX();
			int sy = ((Line) targetObj).getStartY();
			int ex = ((Line) targetObj).getEndX();
			int ey = ((Line) targetObj).getEndY();

			((Line) targetObj).setStartX(computePointSymmetry(sx, sy, x, y)[0]);
			((Line) targetObj).setStartY(computePointSymmetry(sx, sy, x, y)[1]);
			((Line) targetObj).setEndX(computePointSymmetry(ex, ey, x, y)[0]);
			((Line) targetObj).setEndY(computePointSymmetry(ex, ey, x, y)[1]);
		}
		if (this.targetObj instanceof Polygon) {
			for (int i = 0; i < ((Polygon) targetObj).vertices.size(); i++) {
				int vx = ((Polygon) targetObj).vertices.get(i).get(0);
				int vy = ((Polygon) targetObj).vertices.get(i).get(1);

				((Polygon) targetObj).vertices.get(i).set(0, computePointSymmetry(vx, vy, x, y)[0]);
				((Polygon) targetObj).vertices.get(i).set(1, computePointSymmetry(vx, vy, x, y)[0]);
			}
		}
		if (this.targetObj instanceof Circle) {
			((Circle) targetObj).setOx(computePointSymmetry(((Circle) targetObj).getOx(), ((Circle) targetObj).getOy(),
					x, y)[0]);
			((Circle) targetObj).setOy(computePointSymmetry(((Circle) targetObj).getOx(), ((Circle) targetObj).getOy(),
					x, y)[1]);
		}
		if (this.targetObj instanceof Ellipse) {
			((Ellipse) targetObj).setOx(computePointSymmetry(((Ellipse) targetObj).getOx(), ((Ellipse) targetObj).getOy(),
					x, y)[0]);
			((Ellipse) targetObj).setOy(computePointSymmetry(((Ellipse) targetObj).getOx(), ((Ellipse) targetObj).getOy(),
					x, y)[1]);
		}
		
		if (this.targetObj instanceof Image) {
			for(int i = 0; i <((Image) targetObj).getGeomForms().size(); i++) {
				((Image) targetObj).getGeomForms().get(i).transform.pointSymmetry(x, y);
			}
		}
		
		if (this.targetObj instanceof Dessin) {
			for(int i = 0; i <((Dessin) targetObj).getImages().size(); i++) {
				((Dessin) targetObj).getImages().get(i).transform.pointSymmetry(x, y);
			}
		}
		
	}

	
	private int[] computeAxisSymmetry(int x, int y, int ax, int ay, int bx, int by) {
		int[] nP = new int[2];
//
//		int nx = (sx - x) * 2;
//		int ny = (sy - y) * 2;
//
//		nP[0] = nx;
//		nP[1] = ny;
		return nP;
	}

	
}
