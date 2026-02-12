package org.firstinspires.ftc.teamcode.Teleops;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.common.Hardware;

@TeleOp(name="DuoOp", group="Final")
public class DuoOp extends CommandOpMode {

    // hardware
    Hardware robot = new Hardware();

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
    double transfer_power = 1.0;

    // gamepad
    GamepadEx driver, operator;


    @Override
    public void initialize(){
            driver = new GamepadEx(gamepad1);
            operator = new GamepadEx(gamepad2);

            // Intake

//            operator.getGamepadButton(GamepadKeys.Button.A).whenPressed(() -> schedule(new InstantCommand(() -> intake.setPower(intake_power))));
//            operator.getGamepadButton(GamepadKeys.Button.B).whenPressed(() -> schedule(new InstantCommand(() -> intake.setPower(-intake_power))));

            operator.getGamepadButton(GamepadKeys.Button.A).whenPressed(() -> schedule(new InstantCommand(() -> telemetry.addData("Key","A"))));
            operator.getGamepadButton(GamepadKeys.Button.B).whenPressed(() -> schedule(new InstantCommand(() -> telemetry.addData("Key", "B"))));

            // Transfer

            operator.getGamepadButton(GamepadKeys.Button.X).whenPressed(()-> schedule(new InstantCommand(() -> telemetry.addData("Key","X" ))));
            operator.getGamepadButton(GamepadKeys.Button.Y).whenPressed(()-> schedule(new InstantCommand(() -> telemetry.addData("Key","Y" ))));

            // Configure the transfer system in such a way that the trigger pads' analogue values
            // can be read to change power to the motor.
            // reason is because the transfer is a bit odd currently, and this is a temp solution.
            telemetry.setMsTransmissionInterval(1000);


    }
    @Override
    public void run(){
        super.run();
        // full Mecanum drive system
        double y = -driver.getLeftY();
        double x = driver.getLeftX();
        double rx = driver.getRightX();
        double correction = Math.max(Math.abs(y)+Math.abs(x)+Math.abs(rx),1);

        double lf_power = (y + x + rx)/correction;
        double lb_power = (y - x + rx)/correction;
        double rf_power = (y - x - rx)/correction;
        double rb_power = (y + x - rx)/correction;
//        LF.setPower(lf_power);
//        LB.setPower(lb_power);
//        RF.setPower(rf_power);
//        RB.setPower(rb_power);

        // Telemetery
        telemetry.addData("Left Front Model", lf_power);
        telemetry.addData("Left Back Model", lb_power);
        telemetry.addData("Right Front Model", rf_power);
        telemetry.addData("Right Back Model", rb_power);

        telemetry.update();




    }
}
