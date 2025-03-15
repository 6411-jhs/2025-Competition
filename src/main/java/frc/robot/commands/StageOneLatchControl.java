package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.StageOneLatch;

import edu.wpi.first.wpilibj2.command.Command;

public class StageOneLatchControl extends Command {
   private static final double RESET_DEGREE = 0;
   private static final double DEPLOY_DEGREE = 90;

   private XboxController xbox;
   private StageOneLatch stageOneLatch;

   private boolean deploy = false;

   public StageOneLatchControl(XboxController xbox, StageOneLatch stageOneLatch){
      this.xbox = xbox;
      this.stageOneLatch = stageOneLatch;

      addRequirements(stageOneLatch);
   }

   @Override
   public void initialize() {
      stageOneLatch.setServo(RESET_DEGREE);
   }

   @Override
   public void execute() {
      if (xbox.getXButtonPressed()){
         deploy = !deploy;
      }

      if (deploy){
         stageOneLatch.setServo(DEPLOY_DEGREE);
      } else {
         stageOneLatch.setServo(RESET_DEGREE);
      }
   }

   @Override
   public boolean isFinished() {
      return false;
   }
}
