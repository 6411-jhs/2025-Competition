package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import com.ctre.phoenix.motorcontrol.ControlMode;

// import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class DriveTrain extends SubsystemBase {
    //IDS and control mode for the motor controllers
    private static final int BACK_LEFT_ID = 0;
    private static final int FRONT_LEFT_ID = 2;
    private static final int BACK_RIGHT_ID = 3;
    private static final int FRONT_RIGHT_ID = 4;
    private static final ControlMode MOTOR_CONTROL_MODE = ControlMode.PercentOutput;

    private VictorSP backLeftMotor;
    private VictorSPX frontLeftMotor;
    private TalonSRX backRightMotor;
    private VictorSPX frontRightMotor;

    private MecanumDrive drive;

    public DriveTrain(){
        //Initializes motors with their respective CAN and PWM ids
        this.backLeftMotor = new VictorSP(BACK_LEFT_ID);
        this.frontLeftMotor = new VictorSPX(FRONT_LEFT_ID);
        this.backRightMotor = new TalonSRX(BACK_RIGHT_ID);
        this.frontRightMotor = new VictorSPX(FRONT_RIGHT_ID);

        //Inverts the right side motors
        frontRightMotor.setInverted(true);
        backRightMotor.setInverted(true);

        //Initializes the mecanum drive with the needed set methods
        this.drive = new MecanumDrive(
            (double power) -> frontLeftMotor.set(MOTOR_CONTROL_MODE, power),
            (double power) -> backLeftMotor.set(power), 
            (double power) -> frontRightMotor.set(MOTOR_CONTROL_MODE, power), 
            (double power) -> backRightMotor.set(MOTOR_CONTROL_MODE, power)
        );
    }

    /**
     * Operate the mecanum drive train with designated inputs.
     * @param xSpeed The speed it moves left to right (-1 for left, 1 for right)
     * @param ySpeed The speed it moves forward and back (-1 for back, 1 for forward)
     * @param zRotation The speed it rotates (-1 for counterclockwise, 1 for clockwise)
     */
    public void driveCartesian(double xSpeed, double ySpeed, double zRotation){
        drive.driveCartesian(-ySpeed, xSpeed, zRotation);
    }

    // public void drivePolar(double magnitude, Rotation2d angle, double zRotation){
    //     drive.drivePolar(magnitude, angle, zRotation);
    // }
}
