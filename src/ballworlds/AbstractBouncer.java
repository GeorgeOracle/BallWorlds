package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * A ball that bounces off the walls.
 * 
 * @author Curt Clifton. Created Jan 22, 2011.
 */
public abstract class AbstractBouncer extends Ball {
	// nothing here... yet

	/**
	 * Constructs a abstract bouncer in the given world.
	 * 
	 * @param world
	 */
	protected Random randomizer;
	protected double diameter;

	public AbstractBouncer(BallEnvironment world) {
		super(world);
		randomizer = new Random();
		double worldWidth = this.getWorld().getSize().getWidth();
		double worldHeight = this.getWorld().getSize().getHeight();
		this.setCenterPoint(new Point2D.Double(worldWidth / 2, worldHeight / 2));
		this.diameter = randomizer.nextDouble() * 10 + 10;
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
		
		if (this.getCenterPoint().getX() <= 0 || this.getCenterPoint().getX() >= this.getWorld().getSize().getWidth()) {
			this.speedx = -this.speedx;
		}
		if (this.getCenterPoint().getY() <= 0 || this.getCenterPoint().getY() >= this.getWorld().getSize().getHeight()) {
			this.speedy = -this.speedy;
		}
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
