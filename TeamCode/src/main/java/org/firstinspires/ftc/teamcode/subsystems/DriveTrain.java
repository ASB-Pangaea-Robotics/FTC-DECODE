package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.common.Hardware;

public class DriveTrain{
    // TODO: Make sure to measure the robot's acceleration and velocity to get a very rudimentary distance calculation function (if odometery is not fixed)
    public static DriveTrain instance;
    private Gamepad driver, operator;
    private DcMotor LF, RF, LB, RB;

    private double lf_power, rf_power, lb_power, rb_power;
//    public DriveTrain(Hardware robot, Gamepad driver, Gamepad operator){
//        this.driver = driver;
//        this.operator = operator;
//        this.LF = robot.LF;
//        this.RF = robot.RF;
//        this.LB = robot.LB;
//        this.RB = robot.RB;
//    }

    public static DriveTrain DriveTrainInstance(){
        if (instance == null)
            instance = new DriveTrain();
        return instance;
    }

    public void DriveTrainInit(Hardware robot, Gamepad driver, Gamepad operator){
        this.driver = driver;
        this.operator = operator;
        this.LF = robot.LF;
        this.RF = robot.RF;
        this.LB = robot.LB;
        this.RB = robot.RB;
    }

    // +Ve = Forward, -Ve = Backward
    public void YDrive(double power){
        LF.setPower(-power);
        RF.setPower(power);
        LB.setPower(power);
        RB.setPower(power);
    }

    // +Ve = Right, -Ve = Left
    public void XDrive(double power){
        LF.setPower(-power);
        RF.setPower(-power);
        LB.setPower(power);
        RB.setPower(-power);
    }

    // +Ve = Right Rotation, -Ve = Left Rotation
    public void RDrive(double power){
        LF.setPower(-power);
        RF.setPower(-power);
        LB.setPower(power);
        RB.setPower(-power);
    }

    // +Ve = Top Left, -Ve = Bottom Right
    public void D1Drive(double power){
        RF.setPower(power);
        LB.setPower(power);
    }
    // +Ve = Top Right, -Ve = Bottom Left
    public void D2Drive(double power){
        LF.setPower(-power);
        RB.setPower(power);
    }

    public void driveTrainControl(){
        if(!operator.left_bumper){
            double y = -driver.left_stick_y;
            double x = driver.left_stick_x;
            double rx = driver.right_stick_x;
            double correction = Math.max(Math.abs(y)+Math.abs(x)+Math.abs(rx),1);
            double power_adjuster = driver.right_trigger;
            lf_power = -(y + x + rx)/correction * power_adjuster;
            lb_power = (y - x + rx)/correction * power_adjuster;
            rf_power = (y - x - rx)/correction * power_adjuster;
            rb_power = (y + x - rx)/correction * power_adjuster;
            LF.setPower(lf_power);
            LB.setPower(lb_power);
            RF.setPower(rf_power);
            RB.setPower(rb_power);
        }
    }

    public double[] returnPower(){
       double[] powers = {lf_power, lb_power, rf_power, rb_power};
       return powers;
    }
}