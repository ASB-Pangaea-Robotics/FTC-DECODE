package org.firstinspires.ftc.teamcode.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.common.Hardware;

@Autonomous(name="Simple Auto")
public class DumbAuto extends LinearOpMode {
    private ElapsedTime timer = new ElapsedTime();

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
        timer.reset();
        while(opModeIsActive() && timer.seconds() < time){
            telemetry.addLine("Running");
            LF.setPower(1.0);
            RF.setPower(1.0);
            RB.setPower(1.0);
            LB.setPower(1.0);
            telemetry.update();
        }
        telemetry.addLine("Finished");
        LF.setPower(0.0);
        RF.setPower(0.0);
        RB.setPower(0.0);
        LB.setPower(0.0);
    }
}
