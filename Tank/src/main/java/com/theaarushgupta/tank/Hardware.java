package com.theaarushgupta.tank;

import java.util.ArrayList;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Hardware {
    public ArrayList<Object> left = new ArrayList<Object>();
    public ArrayList<Object> right = new ArrayList<Object>();

    public double countsPerRotation, gearRatio, wheelDiameter;

    public Hardware(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }

    public void addLeftMotor(String name) {
        left.add(this.hardwareMap.get(DcMotor.class, name));
    }

    public void addRightMotor(String name) {
        right.add(this.hardwareMap.get(DcMotor.class, name));
    }

    public void configureWheels(double countsPerRotation, double gearRatio, double wheelDiameter) {
        this.countsPerRotation = countsPerRotation;
        this.gearRatio = gearRatio;
        this.wheelDiameter = wheelDiameter;
    }
}
