package puck;

import robocode.AdvancedRobot;
import robocode.HitRobotEvent;
import robocode.ScannedRobotEvent;

import java.awt.*;

public class puck extends AdvancedRobot {

	public void run() {
		setBodyColor(Color.gray);
		setGunColor(Color.red);
		setRadarColor(Color.yellow);
		setScanColor(Color.green);

		while (true) {
			setTurnRight(1000);
			setMaxVelocity(5);
			ahead(1000);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		fire(3);
	}
	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() > -10 && e.getBearing() < 10) {
			fire(3);
		}
		if (e.isMyFault()) {
			turnRight(15);
		}
	}
}
