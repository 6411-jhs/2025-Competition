package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.StageTwo;

public class StageTwoControls extends Command {
   private XboxController xbox;
   private StageTwo stageTwo;

   private double maxSpeed = 0.3;

   public StageTwoControls(XboxController xbox, StageTwo stageTwo){
      this.xbox = xbox;
      this.stageTwo = stageTwo;

      addRequirements(stageTwo);
   }

   @Override
   public void initialize() {
      stageTwo.set(0);
   }

   @Override
   public void execute() {
      if (xbox.getRightBumperButton() || xbox.getLeftBumperButton()){
         stageTwo.setEnabled(!stageTwo.getEnabled());
      }
      stageTwo.set((xbox.getRightTriggerAxis() - xbox.getLeftTriggerAxis()) * maxSpeed);
   }

   @Override
   public boolean isFinished() {
      return false;
   }

   public double getMaxSpeed(){
      return this.maxSpeed;
   }
   public void setMaxSpeed(double maxSpeed){
      this.maxSpeed = maxSpeed;
   }
}
