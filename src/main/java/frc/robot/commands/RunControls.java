package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;

//todo - Add power limiter

public class RunControls extends Command {
   DriveTrain driveTrain;

   private XboxController xboxController;
   private Joystick joystick;

   private ControlMode driveTrainControlMode;
   private double driveTrainSpeedLimit = 1.0;

   public RunControls(DriveTrain driveTrain){
      super();
      this.driveTrain = driveTrain;

      addRequirements(driveTrain);
   }

   /**
    * Sets the control mode to operate the DriveTrain. Ensure whatever control mode you are using that the interface is connected to port 0.
    * Meaning that if you are using an xbox controller for example, check the Driver Station and make sure it shows up on port 0.
    * @param controlMode The control interface you want the drive train to utilize.
    */
   public void setDriveTrainControl(ControlMode controlMode){
      driveTrainControlMode = controlMode;
      if (controlMode == ControlMode.XboxController){
         this.xboxController = new XboxController(0);
         this.joystick = new Joystick(1);
      } else {
         this.xboxController = new XboxController(1);
         this.joystick = new Joystick(0);
      }
   }

   /**Gets the current drive train speed limiter */
   public double getDriveTrainLimit(){
      return this.driveTrainSpeedLimit;
   }
   /**
    * Sets the drive train speed limit. All speed values for the drive train input will be mutliplied by this number to limit the speed.
    * For example, if you want the speed to be 60% capacity, you would set the parameter to 0.6.
    * It would then multiply all speed input values from the driver by 0.6 to limit the drive train.
    * @param speedMultiplier The speed multiplier that follows [0,1] interval.
    */
   public void setDriveTrainLimit(double speedMultiplier){
      this.driveTrainSpeedLimit = Math.min(Math.max(0.0, speedMultiplier), 1.0);
   }


   @Override
   public void execute() {
      if (driveTrainControlMode == ControlMode.XboxController){
         driveTrain.driveCartesian(xboxController.getLeftX() * driveTrainSpeedLimit, xboxController.getLeftY() * driveTrainSpeedLimit, xboxController.getRightX() * driveTrainSpeedLimit);
      } else {
         driveTrain.driveCartesian(joystick.getX() * driveTrainSpeedLimit, joystick.getY() * driveTrainSpeedLimit, joystick.getZ() * driveTrainSpeedLimit);
      }
   }

   @Override
   public boolean isFinished() {
      return false;
   }
}

enum ControlMode {
   XboxController,
   Joystick
}
