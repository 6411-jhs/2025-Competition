package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    //IDS and control mode for the motor controllers
    private static final int BACK_LEFT_ID = 1;
    private static final int FRONT_LEFT_ID = 2;
    private static final int BACK_RIGHT_ID = 3;
    private static final int FRONT_RIGHT_ID = 4;

    private SparkMax backLeftMotor;
    private SparkMax frontLeftMotor;
    private SparkMax backRightMotor;
    private SparkMax frontRightMotor;

    private SparkMaxConfig invertedConfig;

    private MecanumDrive drive;

    public DriveTrain(){
        //Initializes motors with their respective CAN and PWM ids
        this.backLeftMotor = new SparkMax(BACK_LEFT_ID, MotorType.kBrushless);
        this.frontLeftMotor = new SparkMax(FRONT_LEFT_ID, MotorType.kBrushless);
        this.backRightMotor = new SparkMax(BACK_RIGHT_ID, MotorType.kBrushless);
        this.frontRightMotor = new SparkMax(FRONT_RIGHT_ID, MotorType.kBrushless);

        invertedConfig = new SparkMaxConfig();
        invertedConfig.inverted(true);

        //Inverts the right side motors
        frontRightMotor.configure(invertedConfig, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);
        backRightMotor.configure(invertedConfig, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);

        //Initializes the mecanum drive with the needed set methods
         this.drive = new MecanumDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
    }

    public void driveCartesian(double xSpeed, double ySpeed, double zRotation){
        drive.driveCartesian(-ySpeed, xSpeed, zRotation);
    }
}
