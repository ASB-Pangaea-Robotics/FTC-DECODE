package org.firstinspires.ftc.teamcode.learning.aryaman;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.common.Hardware;

import java.lang.annotation.Annotation;

@TeleOp(name="motor_test",group="TeleOpTests")
public class motor_test extends LinearOpMode {
    Hardware robot = Hardware.hardware_instance();

    GamepadEx gamepad;

    private DcMotor LF, LB, RF, RB;

    private ElapsedTime time = new ElapsedTime();

    @Override
    public void runOpMode(){
        telemetry.addData("STATUS", "Init");
        telemetry.update();

        LF = robot.LF;
        LB = robot.LB;
        RF = robot.RF;
        RB = robot.RB;

        // Waits for START on the Driver Station
        waitForStart();
        time.reset();

        while(opModeIsActive()){
            telemetry.addData("Time",time.toString());
            LF.setPower(1.0);
            telemetry.update();
        }
    }
}
