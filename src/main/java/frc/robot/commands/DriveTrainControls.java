package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj2.command.Command;

public class DriveTrainControls extends Command {
    private XboxController xbox;
    private DriveTrain driveTrain;

    private double maxSpeed = 0.8;

    public DriveTrainControls(XboxController xbox, DriveTrain driveTrain){
        this.xbox = xbox;
        this.driveTrain = driveTrain;

        addRequirements(driveTrain);

        driveTrain.driveCartesian(0, 0, 0);
    }

    @Override
    public void initialize() {
        driveTrain.driveCartesian(0, 0, 0);
    }

    @Override
    public void execute() {
        driveTrain.driveCartesian(
            xbox.getLeftX() * maxSpeed, 
            xbox.getLeftY() * maxSpeed, 
            xbox.getRightX() * maxSpeed
        );
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    public double getMaxSpeed(){
        return this.maxSpeed;
    }
    public void setMaxSpeed(double speed){
        this.maxSpeed = speed;
    }
}
