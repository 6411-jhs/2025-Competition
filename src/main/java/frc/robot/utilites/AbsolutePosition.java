package frc.robot.utilites;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;

public class AbsolutePosition {
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
      dt = timer.get();
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
      xVelocity = calcaulateXVelocity();
   }
   public double getXPosition(){
      return xPosition;
   }
   private double calculateXPosition(){
      double acc = accelerometer.getX();
      return (acc * Math.pow(dt,2) + (xVelocity * dt) + xPosition);
   }
   private double calcaulateXVelocity(){
      double acc = accelerometer.getX();
      return (acc * dt) + xVelocity;
   }
}
