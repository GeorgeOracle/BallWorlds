package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.Random;

public class Mover extends Ball {

	private Random randomizer;
	private double diameter;

	public Mover(BallEnvironment world) {
		super(world);
		randomizer = new Random();
		this.setCenterPoint(world.getCenterPoint());
		this.color = this.color.YELLOW;
		this.diameter = randomizer.nextDouble() * 25 + 25;
		this.speedx = (2 * randomizer.nextDouble() - 1);
		this.speedy = (2 * randomizer.nextDouble() - 1);
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
	}

	@Override
	public void updateSize() {
	}

	@Override
	public void updateColor() {
	}

	@Override
	public double getDiameter() {
		return this.diameter;
	}

}
