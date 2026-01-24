package org.firstinspires.ftc.teamcode;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.common.Hardware;

@TeleOp(name="TeleOp")
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

    // gamepad
    GamepadEx driver, operator;


    @Override
    public void initialize(){
            driver = new GamepadEx(gamepad1);
            operator = new GamepadEx(gamepad2);

            // Intake

            operator.getGamepadButton(GamepadKeys.Button.A).whenPressed(() -> schedule(new InstantCommand(() -> intake.setPower(intake_power))));
            operator.getGamepadButton(GamepadKeys.Button.B).whenPressed(() -> schedule(new InstantCommand(() -> intake.setPower(-intake_power))));

            // TODO
            // Configure the transfer system in such a way that the trigger pads' analogue values
            // can be read to change power to the motor.
            // reason is because the transfer is a bit odd currently, and this is a temp solution.


    }
    @Override
    public void run(){
        // full Mecanum drive system
        double y = -driver.getLeftY();
        double x = driver.getLeftX();
        double rx = driver.getRightX();
        double correction = Math.max(Math.abs(y)+Math.abs(x)+Math.abs(rx),1);

        LF.setPower((y + x + rx)/correction);
        LB.setPower((y - x + rx)/correction);
        RF.setPower((y - x - rx)/correction);
        RB.setPower((y + x - rx)/correction);
    }
}
