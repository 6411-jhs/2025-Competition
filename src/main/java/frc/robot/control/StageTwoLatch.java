package frc.robot.control;

import edu.wpi.first.wpilibj.Servo;

public class StageTwoLatch {
   private static final int SERVO_PWM_ID = 0;

   private Servo mainServo;

   public StageTwoLatch(){
      this.mainServo = new Servo(SERVO_PWM_ID);
   }

   public void setServo(double degree){
      mainServo.setAngle(degree);;
   }
   public void logServoDegree(){
      System.out.println(mainServo.getAngle());
   }
}
