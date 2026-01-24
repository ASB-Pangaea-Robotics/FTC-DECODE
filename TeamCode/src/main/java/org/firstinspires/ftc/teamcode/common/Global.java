package org.firstinspires.ftc.teamcode.common;

public class Global {
    private static Global instance;

    public static Global global_instance(){
        if (instance == null)
            instance = new Global();
        return instance;
    }


}
