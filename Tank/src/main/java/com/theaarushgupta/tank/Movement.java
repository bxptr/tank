package com.theaarushgupta.tank;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Movement {
    private Hardware hardware;

    private static final double ticksPerInch = (((hardware.countsPerRotation * hardware.gearRatio) / (hardware.wheelDiameter * Math.PI)) / 12) * (10 / 3);

    public Movement(Hardware hardware) {
        this.hardware = hardware;
    }

    public void drive(double inches) {
        double ticks = inches * this.ticksPerInch;
        for (DcMotor motor : hardware.left) {
            motor.setVelocity((int)(ticks * -1));
        }
        for (DcMotor motor : hardware.right) {
            motor.setVelocity((int)(ticks * -1));
        }
        runtime.reset();
        double seconds;
        if (inches <= 33) {
            seconds = 1.0;
        } else {
            seconds = inches / 33;
        }
        while (opModeIsActive() && (runtime.seconds() < seconds)) {}
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }
}
