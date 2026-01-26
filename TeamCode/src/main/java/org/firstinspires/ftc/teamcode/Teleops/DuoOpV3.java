package org.firstinspires.ftc.teamcode.Teleops;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.common.Hardware;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;

@TeleOp(name="DuoOpV3", group="Final")
public class DuoOpV3 extends LinearOpMode {

    // hardware
    Hardware robot = Hardware.hardware_instance();

    // movement
//    DcMotor LF = robot.LF;
//    DcMotor RF = robot.RF;
//    DcMotor RB = robot.RB;
//    DcMotor LB = robot.LB;

    DriveTrain driveTrain = DriveTrain.DriveTrainInstance();

    // intake
    DcMotor intake = robot.in;
    double intake_power = 1.0;

    // transfer

    DcMotor transfer = robot.transfer;
    double transfer_power = 1;

    // gamepad

    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        driveTrain.DriveTrainInit(robot, gamepad1, gamepad2);
        waitForStart();
        while(opModeIsActive()){

            driveTrain.driveTrainControl();

            double[] powers = driveTrain.returnPower();
            // Telemetery
            telemetry.addLine("Driver");
            telemetry.addData("Left Front Model", powers[0]);
            telemetry.addData("Left Back Model", powers[1]);
            telemetry.addData("Right Front Model", powers[2]);
            telemetry.addData("Right Back Model", powers[3]);

            // Button Checking
            telemetry.addLine("Operator");
            telemetry.addData("Intake", gamepad2.a);
            telemetry.addData("Expel", gamepad2.b);
            telemetry.addData("Transfer", gamepad2.x);
            telemetry.addData("Temp-Outtake", gamepad2.y);

            if (gamepad2.a){
                intake.setPower(intake_power);
            } else {
                intake.setPower(0);
            }

            if (gamepad2.b){
                intake.setPower(-intake_power)
                ;
            } else {
                intake.setPower(0);
            }

            if (gamepad2.x){
                transfer.setPower(transfer_power);
            } else {
                transfer.setPower(0);
            }

            if (gamepad2.y){
                transfer.setPower(-transfer_power*0.5);
            } else {
                transfer.setPower(0);
            }




            telemetry.update();

        }
    }

}
