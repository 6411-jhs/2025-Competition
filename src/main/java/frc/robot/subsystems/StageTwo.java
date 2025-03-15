package frc.robot.subsystems;

import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class StageTwo extends SubsystemBase {
   private static final int NEO_ID = 8;

   private SparkMax neo;
   private SparkAbsoluteEncoder neoEncoder;

   private boolean enabled = false;

   public StageTwo(){
      this.neo = new SparkMax(NEO_ID, MotorType.kBrushless);
      this.neoEncoder = neo.getAbsoluteEncoder();
   }

   public void set(double speed){
      if (enabled){
         neo.set(speed);
      }
   }

   public double getEncoder(){
      return neoEncoder.getPosition();
   }

   public boolean getEnabled(){
      return this.enabled;
   }
   public void setEnabled(boolean enabled){
      this.enabled = enabled;
   }
}
