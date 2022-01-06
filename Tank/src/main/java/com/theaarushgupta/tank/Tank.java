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
    }

    public void start() {
        this.hardware.initializeAll();
    }
}
