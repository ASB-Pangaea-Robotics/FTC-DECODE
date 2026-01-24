package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.common.Hardware;

public class DriveTrain extends CommandBase {
    private Hardware robot;
    private GamepadEx driver;

    private Telemetry tel;

    public DriveTrain(Hardware robot, GamepadEx driver, Telemetry telemetry){
        this.robot = robot;
        this.driver = driver;
        this.tel = telemetry;
    }

    @Override
    public void execute(){
        // full Mecanum drive system: pasted from DuoOp.java
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

        tel.addData("Left Front Model", lf_power);
        tel.addData("Left Back Model", lb_power);
        tel.addData("Right Front Model", rf_power);
        tel.addData("Right Back Model", rb_power);

    }
}
