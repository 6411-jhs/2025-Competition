package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.StageTwoLatch;

import edu.wpi.first.wpilibj2.command.Command;

public class StageTwoLatchControl extends Command {
   private static final double RESET_DEGREE = 0;
   private static final double DEPLOY_DEGREE = 90;

   private XboxController xbox;
   private StageTwoLatch stageTwoLatch;

   private boolean deploy = false;

   public StageTwoLatchControl(XboxController xbox, StageTwoLatch stageTwoLatch){
      this.xbox = xbox;
      this.stageTwoLatch = stageTwoLatch;

      addRequirements(stageTwoLatch);
   }

   @Override
   public void initialize() {
      stageTwoLatch.setLeftServo(RESET_DEGREE);
      stageTwoLatch.setRightServo(RESET_DEGREE);
   }

   @Override
   public void execute() {
      if (xbox.getBButtonPressed()){
         deploy = !deploy;
      }

      if (deploy){
         stageTwoLatch.setLeftServo(DEPLOY_DEGREE);
         stageTwoLatch.setRightServo(DEPLOY_DEGREE);
      } else {
         stageTwoLatch.setLeftServo(RESET_DEGREE);
         stageTwoLatch.setRightServo(RESET_DEGREE);
      }
   }

   @Override
   public boolean isFinished() {
      return false;
   }
}
