package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class StageOneLatch extends SubsystemBase {
   private static final int SERVO_PWM_ID = 0;

   private Servo mainServo;

   public StageOneLatch(){
      this.mainServo = new Servo(SERVO_PWM_ID);
   }

   public void setServo(double degree){
      mainServo.setAngle(degree);;
   }
   public double getServo(){
      return mainServo.getAngle();
   }
}
