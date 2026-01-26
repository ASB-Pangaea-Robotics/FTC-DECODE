package org.firstinspires.ftc.teamcode.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.common.Hardware;

@Autonomous(name="Simple AutoV2")
public class FarAutoV2 extends LinearOpMode {


    Hardware robot = Hardware.hardware_instance();

    DcMotor LF = robot.LF;
    DcMotor RF = robot.RF;
    DcMotor RB = robot.RB;
    DcMotor LB = robot.LB;


    double time = 2.0;
    @Override
    public void runOpMode() throws InterruptedException {


        robot.init(hardwareMap);
        waitForStart();
        while(opModeIsActive()){
            telemetry.addLine("Running");
           setDrive(0.5);
           sleep(1000);
           setDrive(0);
            telemetry.update();
        }
        telemetry.addLine("Finished");
    }
    public void setDrive(double pow){
        LF.setPower(pow);
        RF.setPower(pow);
        RB.setPower(pow);
        LB.setPower(pow);
    }
}
