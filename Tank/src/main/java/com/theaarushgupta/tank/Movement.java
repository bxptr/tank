package com.theaarushgupta.tank;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Movement {
    private Hardware hardware;

    private static final double ticksPerInch = (((hardware.countsPerRotation * hardware.gearRatio) / (hardware.wheelDiameter * Math.PI)) / 12) * (10 / 3);

    public Movement(Hardware hardware) {
        this.hardware = hardware;
    }

    public void forward(double inches) {
        double seconds;
        if (inches <= 33) {
            seconds = 1.0;
        } else {
            seconds = inches / 33;
        }
        double ticks = inches * this.ticksPerInch;
        for (DcMotor motor : this.hardware.left.values()) {
            motor.setVelocity((int)(ticks * -1));
        }
        for (DcMotor motor : this.hardware.right.values()) {
            motor.setVelocity((int)(ticks * -1));
        }
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < seconds)) {}
        for (DcMotor motor : this.hardware.left.values()) {
            motor.setVelocity(0);
        }
        for (DcMotor motor : this.hardware.right.values()) {
            motor.setVelocity(0);
        }
        sleep(this.wait);
    }

    public void backward(double inches) {
        this.forward(inches * -1);
    }

    public void right(double degrees) {
        double ticks = ((this.hardware.botWidth * Math.PI) * (degrees / 360)) * this.ticksPerInch;
        robot.leftDrive.setVelocity((int)Math.abs(ticks));
        robot.rightDrive.setVelocity(-1 * (int)Math.abs(ticks));
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {}
        for (DcMotor motor : this.hardware.left.values()) {
            motor.setVelocity(0);
        }
        for (DcMotor motor : this.hardware.right.values()) {
            motor.setVelocity(0);
        }
        sleep(this.wait);
    }

    public void left(double degrees) {
        double ticks = ((this.hardware.botWidth * Math.PI) * (degrees / 360)) * this.ticksPerInch;
        robot.leftDrive.setVelocity(-1 * (int)Math.abs(ticks));
        robot.rightDrive.setVelocity((int)Math.abs(ticks));
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {}
        for (DcMotor motor : this.hardware.left.values()) {
            motor.setVelocity(0);
        }
        for (DcMotor motor : this.hardware.right.values()) {
            motor.setVelocity(0);
        }
        sleep(this.wait);
    }

    public void moveServo(String name, double degrees) {
        Servo servo = hardware.servo.get(name);
        if (degrees <= 180) {
            servo.setPosition(Math.abs(degrees / 180));
        } else {
            int rotations = Math.floor(degrees / 180);
            double remaining = (degrees % 180) / 180;
            for (int index = 0; index < rotations + 1; index++) {
                servo.setPosition(1);
            }
            servo.setPosition(remaining);
        }
    }
}
