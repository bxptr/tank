# tank
a beginner-friendly, fast, and efficient FTC robot framework

tank is a FTC robot framework designed to be beginner-friendly, fast, and efficient, allowing teams to focus on the actual design of their code rather than worrying about the robot APIs.

- [x] Hardware and Robot configuration API
- [x] Movement API for moving every part of the robot

example: initialize the robot move it in a square:

```java
package org.firstinspires.ftc.teamcode;

import com.theaarushgupta.tank.Tank; // for those wondering, theaarushgupta.com -> aarushgupta.com

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name = "example", group = "Linear Opmode")
public class Example extends LinearOpMode {
    private Tank tank = new Tank(hardwareMap);
    
    static final double countsPerRotation = 28;
    static final double gearRatio = 40;
    static final double wheelDiameter = 3.5;
    static final double botWidth = 16;

    @Override
    public void runOpMode() {
        waitForStart();
        while (opModeIsActive()) {
            // give tank the bot's configuration
            tank.configureWheels(countsPerRotation, gearRatio, wheelDiameter);
            tank.hardware.configureTank(botWidth);
            // add motors to tank
            tank.hardware.addLeftMotor("leftDrive");
            tank.hardware.addRightMotor("rightDrive");
            // setup all motors
            tank.hardware.initializeAll();
            // move!
            for (int side = 0; side < 5; side++) {
                tank.movement.drive(10.0); // goes forward 10 inches
                tank.movement.turn(90.0); // turns 90 degrees to the right
            }
        }
    }
}
```
