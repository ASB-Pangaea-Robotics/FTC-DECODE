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
    Hardware robot = new Hardware();
    DcMotor LF = robot.LF;
    DcMotor RF = robot.RF;
    DcMotor RB = robot.RB;
    DcMotor LB = robot.LB;

    DcMotor intake = robot.in;
    double intake_power = 1.0;

    // Rising edge detection system
    GamepadEx driver, operator;


    @Override
    public void initialize(){
            driver = new GamepadEx(gamepad1);
            operator = new GamepadEx(gamepad2);

            // Intake

            driver.getGamepadButton(GamepadKeys.Button.A).whenPressed(() -> schedule(new InstantCommand(() -> intake.setPower(intake_power))));



    }
    @Override
    public void run(){
        // Movement
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
