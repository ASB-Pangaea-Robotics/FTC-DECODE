package org.firstinspires.ftc.teamcode.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.common.Hardware;

@Autonomous(name="Simple Auto")
public class FarAuto extends LinearOpMode {
    private ElapsedTime timer = new ElapsedTime();

    Hardware robot = Hardware.hardware_instance();

    DcMotor LF = robot.LF;
    DcMotor RF = robot.RF;
    DcMotor RB = robot.RB;
    DcMotor LB = robot.LB;


    double time = 0.5;
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        timer.reset();
        while(opModeIsActive() && timer.seconds() < time){
            telemetry.addLine("Running");

            telemetry.update();
        }
        telemetry.addLine("Finished");

    }


}
