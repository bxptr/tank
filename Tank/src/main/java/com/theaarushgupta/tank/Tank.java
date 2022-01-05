package com.theaarushgupta.tank;

import java.util.ArrayList;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Tank {
    private HardwareMap hardwareMap;

    public Hardware hardware = new Hardware(hardwareMap);
    public Movement movement = new Movement(hardware);

    public Tank(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap; // when user class extends LinearOpMode
        initializeMotors();
    }

    private void initializeMotors() {
        for (DcMotor motor : hardware.left) {
            motor.setDirection(DcMotor.Direction.FORWARD);
            motor.setPower(0);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        for (DcMotor motor : hardware.right) {
            motor.setDirection(DcMotor.Direction.REVERSE);
            motor.setPower(0);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }
}
