package com.theaarushgupta.tank;

import java.util.ArrayList;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Hardware {
    public ArrayList<Object> left = new ArrayList<Object>();
    public ArrayList<Object> right = new ArrayList<Object>();

    public double countsPerRotation, gearRatio, wheelDiameter;
    public double tankWidth;

    public Hardware(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    public void addLeftMotor(String name) {
        left.add(this.hardwareMap.get(DcMotor.class, name));
    }

    public void addRightMotor(String name) {
        right.add(this.hardwareMap.get(DcMotor.class, name));
    }

    private void initializeMotors() {
        for (DcMotor motor : this.left) {
            motor.setDirection(DcMotor.Direction.FORWARD);
            motor.setPower(0);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        for (DcMotor motor : this.right) {
            motor.setDirection(DcMotor.Direction.REVERSE);
            motor.setPower(0);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }

    public void configureWheels(double countsPerRotation, double gearRatio, double wheelDiameter) {
        this.countsPerRotation = countsPerRotation;
        this.gearRatio = gearRatio;
        this.wheelDiameter = wheelDiameter;
    }

    public void configureTank(double tankWidth) {
        this.tankWidth = tankWidth;
    }
}
