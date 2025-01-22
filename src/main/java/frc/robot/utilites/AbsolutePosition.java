package frc.robot.utilites;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;

public class AbsolutePosition {
   private static double roundToTens(double number){
      int rounded = (int) (number * 10);
      return rounded * 0.1;
   }
   private static double roundToHundreds(double number){
      int rounded = (int) (number * 100);
      return rounded * 0.01;
   }
   private static double roundToThousands(double number){
      int rounded = (int) (number * 10000);
      return rounded * 0.0001;
   }

   BuiltInAccelerometer accelerometer;
   Timer timer;

   double xPosition = 0;
   double yPosition = 0;
   double zPosition = 0;

   double xVelocity = 0;
   double yVelocity = 0;
   double zVelocity = 0;

   double dt = 0;
   
   public AbsolutePosition(){
      this.accelerometer = new BuiltInAccelerometer();
      this.timer = new Timer();
      this.timer.start();
   }

   public void setInitialPositions(double x, double y, double z){
      this.xPosition = x;
      this.yPosition = y;
      this.xPosition = z;
   }

   public void updateTimer(){
      dt = roundToThousands(timer.get());
      timer.reset();
   }
   public double getTimerValue(){
      return timer.get();
   }
   public void resetTimer(){
      timer.reset();
   }

   public void updateXPos(){
      updateTimer();
      xPosition = calculateXPosition();
      xVelocity = calculateXVelocity();
   }
   public double getXPosition(){
      return xPosition;
   }
   private double calculateXPosition(){
      double acc = roundToTens(accelerometer.getX());
      return (acc * Math.pow(dt,2) + (xVelocity * dt) + xPosition);
   }
   private double calculateXVelocity(){
      double acc = roundToTens(accelerometer.getX());
      // System.out.println(acc);
      return (acc * dt) + xVelocity;
   }

   public void test(){
      // System.out.println(accelerometer.getX() + " " + accelerometer.getY() + " " + accelerometer.getZ());
      updateTimer();
      xVelocity = calculateXVelocity();
      // System.out.println(dt);
         System.out.println(roundToTens(accelerometer.getX()));
   }

}
