package org.firstinspires.ftc.teamcode.Teleops;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.common.Hardware;

@TeleOp(name="DuoOpV2", group="Final")
public class DuoOpV2 extends LinearOpMode {

    // hardware
    Hardware robot = Hardware.hardware_instance();

    // movement
    DcMotor LF = robot.LF;
    DcMotor RF = robot.RF;
    DcMotor RB = robot.RB;
    DcMotor LB = robot.LB;

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
        waitForStart();
        while(opModeIsActive()){
            // full Mecanum drive system
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
//            x = 0;
            double rx = gamepad1.right_stick_x;
            double correction = Math.max(Math.abs(y)+Math.abs(x)+Math.abs(rx),1);
//            correction = 1;
            double power_adjuster = gamepad1.right_trigger;
            double lf_power = -(y + x + rx)/correction * power_adjuster;
            double lb_power = (y - x + rx)/correction * power_adjuster;
            double rf_power = (y - x - rx)/correction * power_adjuster;
            double rb_power = (y + x - rx)/correction * power_adjuster;
            LF.setPower(lf_power);
            LB.setPower(lb_power);
            RF.setPower(rf_power);
            RB.setPower(rb_power);

            // Telemetery
            telemetry.addLine("Driver");
            telemetry.addData("Left Front Model", lf_power);
            telemetry.addData("Left Back Model", lb_power);
            telemetry.addData("Right Front Model", rf_power);
            telemetry.addData("Right Back Model", rb_power);

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
