package org.firstinspires.ftc.teamcode.common;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * This is the <b>Hardware</b> class which will be how we access all the motors, sensors, etc.
 * All new devices must be initialized in this class and fetched from this class.
 */
public class Hardware {
    private static Hardware instance;

    /**
     * Returns the Hardware instance. To figure out why this is the way it is, search up <b>Singletons</b> in <i>Java</i>.
     * @return instance: returns the instance
     */
    public static Hardware hardware_instance(){
        if (instance == null)
            instance = new Hardware();
        return instance;
    }

    //TODO: See if these need to be renamed for clarity or if the team gets it.

    // Drivetrain
    // TODO: Double check with build team about what type of motors we have, and also what type of variable this needs to be.
    public DcMotor LF, RF, LB, RB;

    // Outake
    public Servo aim, launch;

    // Intake
    public DcMotor in;
    public DcMotor transfer;

    // Examples

    public DcMotor example;

    /**
     * Initializes all variables. Hence, all initializations must be done <b>here</b>.
     * @param map The <b>HardwareMap</b> is required to be passed in here, and basically is what lets us use the various pieces of hardware.
     */
    public void init(HardwareMap map){
        //TODO: Check what directions are needed and what directions need to be set.

        // Drivetrain
        LF = map.get(DcMotor.class, "lf");
        RF = map.get(DcMotor.class, "rf");
        LB = map.get(DcMotor.class, "lb");
        RB = map.get(DcMotor.class, "rb");

        // Outake
        aim = map.get(Servo.class, "aim");
        launch = map.get(Servo.class, "launch");

        // Intake
        in = map.get(DcMotor.class, "intake");
        in.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        transfer = map.get(DcMotor.class, "transfer");


    }
}
