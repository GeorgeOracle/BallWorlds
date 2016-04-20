package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.Random;

public class Pulsar extends Ball {
	private Random randomizer;
	private boolean isWhitetoBlack = true;
	private double diameter;

	public Pulsar(BallEnvironment world) {
		super(world);
		randomizer = new Random();
		this.setCenterPoint(RandomStaringPoint());
		this.color = new Color(255, 255, 255);
		this.diameter = randomizer.nextDouble() * 25 + 25;
		this.speedx = 0;
		this.speedy = 0;
	}

	/**
	 * Generate a random starting point for constructor
	 * 
	 * @return Random Starting Point
	 */
	private Point2D RandomStaringPoint() {
		double worldWidth = this.getWorld().getSize().getWidth();
		double worldHeight = this.getWorld().getSize().getHeight();
		Point2D startingPoint = new Point2D.Double(this.randomizer.nextDouble() * worldWidth,
				this.randomizer.nextDouble() * worldHeight);
		return startingPoint;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void updatePosition() {
		Point2D newPoint = new Point2D.Double(this.getCenterPoint().getX() + speedx,
				this.getCenterPoint().getY() + speedy);
		this.setCenterPoint(newPoint);
		if (! this.getWorld().isInsideWorld(this.getCenterPoint())) {
			this.setCenterPoint(this.RandomStaringPoint());
		}
	}

	@Override
	public void updateSize() {
	}

	@Override
	public void updateColor() {
		int currentRGBs = this.getColor().getBlue();
		if (currentRGBs == 255) {
			this.isWhitetoBlack = true;
		}
		if (currentRGBs == 0) {
			this.isWhitetoBlack = false;
		}

		if (isWhitetoBlack) {
			this.color = new Color(currentRGBs - 1, currentRGBs - 1, currentRGBs - 1);
		} else {
			this.color = new Color(currentRGBs + 1, currentRGBs + 1, currentRGBs + 1);
		}
	}

	@Override
	public double getDiameter() {
		return this.diameter;
	}

}
