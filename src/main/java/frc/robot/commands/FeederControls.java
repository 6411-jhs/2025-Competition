package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Feeder;

public class FeederControls extends Command {
   private XboxController xbox;
   private Feeder feeder;

   private double speed = 0.5;

   public FeederControls(XboxController xbox, Feeder feeder){
      this.xbox = xbox;
      this.feeder = feeder;

      addRequirements(feeder);
   }

   @Override
   public void initialize() {
      feeder.set(0);
   }

   @Override
   public void execute() {
      if (xbox.getYButton()){
         feeder.set(speed);
      } else if (xbox.getAButton()){
         feeder.set(-speed);
      } else {
         feeder.set(0);
      }
   }

   @Override
   public boolean isFinished() {
      return false;
   }

   public double getSpeed(){
      return this.speed;
   }
   public void setSpeed(double speed){
      this.speed = speed;
   }
}
