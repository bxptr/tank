package com.theaarushgupta.tank;

import java.util.ArrayList;
import java.util.HashMap;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    public HashMap<String, DcMotor> left = new HashMap<String, DcMotor>();
    public HashMap<String, DcMotor> right = new HashMap<String, DcMotor>();
    public HashMap<String, DcMotor> regular = new HashMap<String, DcMotor>();
    public HashMap<String, Servo> servo = new HashMap<String, Servo>();

    public double countsPerRotation, gearRatio, wheelDiameter;
    public double tankWidth;

    public Hardware(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    public void addLeftMotor(String name) {
        left.put(name, this.hardwareMap.get(DcMotor.class, name));
    }

    public void addRightMotor(String name) {
        right.put(name, this.hardwareMap.get(DcMotor.class, name));
    }

    public void addMotor(String name) {
        regular.put(name, this.hardwareMap.get(DcMotor.class, name));
    }

    public void addServo(String name) {
        servo.put(name, this.hardwareMap.get(Servo.class, name));
    }

    private void initializeAll() {
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
        for (Servo servo : this.servo) {
            servo.setDirection(DcMotor.Direction.REVERSE);
            servo.setPosition(0);
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
