package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.StageOne;

import edu.wpi.first.wpilibj2.command.Command;

public class StageOneControls extends Command {
   private XboxController xbox;
   private StageOne stageOne;

   private double maxSpeed = 0.3;

   public StageOneControls(XboxController xbox, StageOne stageOne){
      this.xbox = xbox;
      this.stageOne = stageOne;

      addRequirements(stageOne);
   }

   @Override
   public void initialize() {
      stageOne.set(0);
   }

   @Override
   public void execute() {
      if (xbox.getRightBumperButton() || xbox.getLeftBumperButton()){
         stageOne.setEnabled(!stageOne.getEnabled());
      }
      stageOne.set((xbox.getRightTriggerAxis() - xbox.getLeftTriggerAxis()) * maxSpeed);
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
