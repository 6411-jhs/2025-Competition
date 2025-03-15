package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.SparkAbsoluteEncoder;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class StageOne extends SubsystemBase {
   private static final int LEFT_VORTEX_ID = 6;
   private static final int RIGHT_VORTEX_ID = 7;

   private SparkFlex leftVortex;
   private SparkFlex rightVortex;

   private SparkAbsoluteEncoder leftVortexEncoder;
   private SparkAbsoluteEncoder rightVortexEncoder;

   private boolean enabled = false;

   public StageOne(){
      this.leftVortex = new SparkFlex(LEFT_VORTEX_ID, MotorType.kBrushless);
      this.rightVortex = new SparkFlex(RIGHT_VORTEX_ID, MotorType.kBrushless);

      this.leftVortexEncoder = leftVortex.getAbsoluteEncoder();
      this.rightVortexEncoder = rightVortex.getAbsoluteEncoder();
      
      leftVortex.configure(
         new SparkFlexConfig()
            .inverted(true)
            .follow(rightVortex), 
         ResetMode.kNoResetSafeParameters, 
         PersistMode.kPersistParameters
      );
   }

   public void set(double power){
      if (enabled){
         rightVortex.set(power);
      }
   }

   public double getLeftEncoder(){
      return leftVortexEncoder.getPosition();
   }

   public double getRightEncoder(){
      return rightVortexEncoder.getPosition();
   }

   public boolean getEnabled(){
      return this.enabled;
   }
   public void setEnabled(boolean enabled){
      this.enabled = enabled;
   }
}
