package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.common.Hardware;

public class DriveTrain{
    public static DriveTrain instance;
    private Hardware robot;
    private Gamepad driver, operator;
    private DcMotor LF, RF, LB, RB;
    public DriveTrain(Hardware robot, Gamepad driver, Gamepad operator){
        this.robot = robot;
        this.driver = driver;
        this.operator = operator;
        this.LF = robot.LF;
        this.RF = robot.RF;
        this.LB = robot.LB;
        this.RB = robot.RB;
    }
}