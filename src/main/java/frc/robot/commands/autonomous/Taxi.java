package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class Taxi extends Command {
   private DriveTrain driveTrain;

   private double driveDuration;
   private int executeCount = 0;

   public Taxi(DriveTrain driveTrain, double driveDuration){
      this.driveTrain = driveTrain;
      this.driveDuration = driveDuration;

      addRequirements(driveTrain);
   }

   @Override
   public void initialize() {
      driveTrain.driveCartesian(0, 0, 0);
   }

   @Override
   public void execute() {
      executeCount++;
      driveTrain.driveCartesian(0, -0.5, 0);
   }

   @Override
   public boolean isFinished() {
      return executeCount >= (int) (driveDuration / 0.02);
   }
}
