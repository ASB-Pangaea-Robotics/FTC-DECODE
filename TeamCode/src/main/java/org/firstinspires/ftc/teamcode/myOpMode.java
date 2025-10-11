package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.common.Hardware;

@TeleOp(name="myOpMode", group="TestOps")
// Leave until needed
@Disabled
public class myOpMode extends LinearOpMode {
    // Makes and initializes the 'robot' object, which is just a Hardware object. This will let us access and use our devices.
    Hardware robot = Hardware.hardware_instance();

    // Gamepad object which lets us access the gamepad inputs. This is the FTCLib version.
    GamepadEx gamepad;

    // THIS IS THE SIMPLE VERSION FOR TEACHING PURPOSES. I AM STILL RESEARCHING THE FTCLib ONES.

    private DcMotor LF, LB, RF, RB;

    private ElapsedTime time = new ElapsedTime();

    @Override
    public void runOpMode(){
        // Adds telemetry (data) to the console (on the Driver Station)
        telemetry.addData("STATUS", "Init");
        telemetry.update();

        LF = robot.LF;
        LB = robot.LB;
        RF = robot.RF;
        RB = robot.RB;

        // Waits for START on the Driver Station
        waitForStart();

        time.reset();

        while(opModeIsActive()){
            telemetry.addData("Time",time.toString());
            telemetry.update();
        }

    }



}
