package org.firstinspires.ftc.teamcode.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.common.Hardware;

@Autonomous(name = "CloseAutoOp")
public class CloseAutoOp extends LinearOpMode {
    Hardware robot = Hardware.hardware_instance();
    private ElapsedTime timer = new ElapsedTime();

    private double runtime_1 = 2.0;
    private double runtime_2 = 0.25;

    private DcMotor LF, RF, LB, RB;

    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        LF = robot.LF;
        RF = robot.RF;
        LB = robot.LB;
        RB = robot.RB;
        waitForStart();
        timer.reset();
        while (opModeIsActive() && timer.seconds() < runtime_1){
            LF.setPower(1.0);
            RF.setPower(1.0);
            LB.setPower(1.0);
            RB.setPower(1.0);
        }
        timer.reset();
        while (timer.seconds()< runtime_2){
            LF.setPower(1.0);
            RF.setPower(-1.0);
            LB.setPower(-1.0);
            RB.setPower(1.0);
        }

    }
}
