package frc.robot.control;

import edu.wpi.first.wpilibj.Servo;

public class StageThreeLatch {
   private static final int LEFT_SERVO_PWM_ID = 1;
   private static final int RIGHT_SERVO_PWM_ID = 1;

   private Servo leftServo;
   private Servo rightServo;

   public StageThreeLatch(){
      this.leftServo = new Servo(LEFT_SERVO_PWM_ID);
      this.rightServo = new Servo(RIGHT_SERVO_PWM_ID);
   }

   public void setLeftServo(double degree){
      leftServo.setAngle(degree);
   }
   public void logLeftServoDegree(){
      System.out.println(leftServo.getAngle());
   }

   public void setRightServo(double degree){
      rightServo.setAngle(degree);
   }
   public void logRightServoDegree(){
      System.out.println(rightServo.getAngle());
   }
}
