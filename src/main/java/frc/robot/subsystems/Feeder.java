package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase {
   private static final int MINI_NEO_ID = 9;

   private SparkMax miniNeo;
   private SparkAbsoluteEncoder encoder;

   private double maxSpeed = 0.8;

   public Feeder(){
      this.miniNeo = new SparkMax(MINI_NEO_ID, MotorType.kBrushless);
      this.encoder = miniNeo.getAbsoluteEncoder();
   }

   public void set(double speed){
      miniNeo.set(speed);
   }

   public double getEncoder(){
      return encoder.getPosition();
   }

   public double getMaxSpeed(){
      return this.maxSpeed;
   }
   public void setMaxSpeed(double maxSpeed){
      this.maxSpeed = maxSpeed;
   }
}
