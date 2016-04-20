package ballworlds;

import java.awt.geom.Point2D;

public class Exploder extends AbstractBouncer {
	private double explosionDiameter;
	private double growSpeed;

	public Exploder(BallEnvironment world) {
		super(world);
		this.color = this.color.MAGENTA;
		// We believe that 2-8 times the original size is too big so we changed
		// it to 2-5
		this.explosionDiameter = (this.randomizer.nextInt(3) + 2) * this.diameter;
		this.growSpeed = (this.explosionDiameter - this.diameter) / 300.0;
	}

	public Exploder(BallEnvironment world, Point2D pointDied) {
		super(world);
		this.color = this.color.MAGENTA;
		this.explosionDiameter = (this.randomizer.nextInt(8) + 2) * this.diameter;
		this.growSpeed = (this.explosionDiameter - this.diameter) / 1000.0;
		this.setCenterPoint(pointDied);
	}

	@Override
	public void updateSize() {
		this.diameter += this.growSpeed;
		if (this.diameter > this.explosionDiameter) {
			this.getWorld().addBall(new Exploder(this.getWorld(), this.getCenterPoint()));
			this.getWorld().addBall(new Exploder(this.getWorld(), this.getCenterPoint()));
			this.getWorld().removeBall(this);
		}
	}
}
