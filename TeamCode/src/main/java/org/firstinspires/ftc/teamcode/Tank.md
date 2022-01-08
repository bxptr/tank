<p align = "center">
    <img alt = "license" src = "https://img.shields.io/badge/License-AGPLv3-green.svg">
</p>

<h1 align = "center">Tank <code>v0.0.1</code></h1>
<h3 align = "center">a beginner-friendly, fast, and efficient FTC robot framework</h3>

# Overview

`tank` is a FTC robot framework designed to be beginner-friendly, fast, and efficient, allowing teams to focus on the actual design of their code rather than worrying about the robot APIs.

# Features
- [x] Hardware and Robot configuration API
- [x] Movement API for moving every part of the robot

# Downloading and Usage
`tank` can be used through Android Studio, where after cloning the codebase and writing code, the build and run feature will package the code along with the `tank` framework and push it to the robot.

## Example

Initialize the robot with `tank` and moving it in a square:

```java
/*
assumes (one can configure these values in the variables below):
    - filename: "TankIsKool.java"
    - left drive motor: "leftDrive"
    - right drive motor: "rightDrive"
    - counts per rotation: 28
    - gear ratio: 40
    - wheel diameter: 3.5 inches
    - bot width: 16 inches
*/

package org.firstinspires.ftc.teamcode;

import com.theaarushgupta.tank.Tank;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name = "Tank is Kool!", group = "Linear Opmode")
public class TankIsKool extends LinearOpMode {
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

# Copyright &copy; 2022 Aarush Gupta
The code under `Tank/` is copyrighted but licensed to the public under the GNU AGPLv3 license and any later versions.
Any other code is under the copyright of it's respective owners.
