package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class DriveTrain {
    private static final int BACK_LEFT_ID = 0;
    private static final int FRONT_LEFT_ID = 1;
    private static final int BACK_RIGHT_ID = 2;
    private static final int FRONT_RIGHT_ID = 3;

    private SparkMax backLeftMotor;
    private VictorSPX frontLeftMotor;
    private TalonSRX backRightMotor;
    private VictorSPX frontRightMotor;

    public DriveTrain(){
        this.backLeftMotor = new SparkMax(BACK_LEFT_ID, MotorType.kBrushed);
        this.frontLeftMotor = new VictorSPX(FRONT_LEFT_ID);
        this.backRightMotor = new TalonSRX(BACK_RIGHT_ID);
        this.frontRightMotor = new VictorSPX(FRONT_RIGHT_ID);
    }
}
