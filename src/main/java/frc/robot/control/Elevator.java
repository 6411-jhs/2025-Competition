package frc.robot.control;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Elevator {
   private static final int LEFT_VORTEX_ID = 5;
   private static final int RIGHT_VORTEX_ID = 6;
   private static final int RIGHT_NEO_ID = 7;

   private SparkFlex leftVortex;
   private SparkFlex rightVortex;
   private SparkMax rightNeo;

   public Elevator(){
      this.leftVortex = new SparkFlex(LEFT_VORTEX_ID, MotorType.kBrushless);
      this.rightVortex = new SparkFlex(RIGHT_VORTEX_ID, MotorType.kBrushless);
      this.rightNeo = new SparkMax(RIGHT_NEO_ID, MotorType.kBrushless);
      
      leftVortex.configure(
         new SparkFlexConfig()
            .inverted(true)
            .follow(rightVortex), 
         ResetMode.kNoResetSafeParameters, 
         PersistMode.kPersistParameters
      );
   }

   public void setVortex(double power){
      rightVortex.set(power);
   }

   public void setNeo(double power){
      rightNeo.set(power);
   }
}
