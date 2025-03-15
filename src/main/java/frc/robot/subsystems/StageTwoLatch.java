package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class StageTwoLatch extends SubsystemBase  {
   private static final int LEFT_SERVO_PWM_ID = 1;
   private static final int RIGHT_SERVO_PWM_ID = 2;

   private Servo leftServo;
   private Servo rightServo;

   public StageTwoLatch(){
      this.leftServo = new Servo(LEFT_SERVO_PWM_ID);
      this.rightServo = new Servo(RIGHT_SERVO_PWM_ID);
   }

   public void setLeftServo(double degree){
      leftServo.setAngle(degree);
   }
   public double getLeftServo(){
      return leftServo.getAngle();
   }

   public void setRightServo(double degree){
      rightServo.setAngle(degree);
   }
   public double getRightServo(){
      return rightServo.getAngle();
   }
}
