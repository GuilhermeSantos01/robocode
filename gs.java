package GS;


import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.RateControlRobot;
import robocode.ScannedRobotEvent;
import java.awt.*;

public class GS extends RateControlRobot {

	int sanji;
	
	public void run() {
		
		setBodyColor(Color.gray);
		setGunColor(Color.red);
		setRadarColor(Color.yellow);	
		setScanColor(Color.green);
	
		sanji = 0;
		setGunRotationRate(15);
		
		while (true) {
			if (sanji % 65 == 0) {
				setTurnRate(0);
				setVelocityRate(4);
			}
			if (sanji % 60 == 32) {
				setVelocityRate(-6);
			}
			sanji++;
			execute();
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		fire(3);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		setTurnRate(5);
	}
	
	public void onHitWall(HitWallEvent e) {
		
		setVelocityRate(-3 * getVelocityRate());
	}
}
