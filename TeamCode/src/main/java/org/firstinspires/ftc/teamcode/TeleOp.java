package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.common.Hardware;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="TeleOp")
public class TeleOp extends LinearOpMode {
    Hardware robot = new Hardware();
    DcMotor LF = robot.LF;
    DcMotor RF = robot.RF;
    DcMotor RB = robot.RB;
    DcMotor LB = robot.LB;

    // Rising edge detection system
    Gamepad driver, operator = new Gamepad();
    Gamepad prev_driver, prev_operator = new Gamepad();

    @Override
    public void runOpMode(){
        while (opModeIsActive()){
            prev_driver.copy(driver);
            prev_operator.copy(operator);

            driver.copy(gamepad1);
            operator.copy(gamepad2);

        }

    }
}
