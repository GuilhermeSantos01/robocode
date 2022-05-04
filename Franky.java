package Franky;
import robocode.*;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;

public class Franky extends Robot{
	boolean gs; 
	double sunny; 

	public void run() {

	setBodyColor(Color.gray);
	setScanColor(Color.yellow);
	setScanColor(Color.green);
	setGunColor(Color.red);

	sunny = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
	gs = false;

	turnLeft(getHeading() % 90);
	ahead(sunny);
	gs = true;

	turnGunRight(90);
	turnRight(90);

	while(true) {

		gs = true;
		ahead(sunny);
		gs = false;
		turnRight(90);
	}
}

	public void onHitRobot(HitRobotEvent e) {
		
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			back(120);
		} 
		else {
			ahead(100);
		}
	}	public void onScannedRobot(ScannedRobotEvent e) {
		fire(3);
		if (gs) {
			scan();
		}
	}
}


