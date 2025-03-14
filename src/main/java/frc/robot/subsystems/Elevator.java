package frc.robot.subsystems;

import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkFlexConfig;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
   private static final int LEFT_VORTEX_ID = 5;
   private static final int RIGHT_VORTEX_ID = 6;
   private static final int RIGHT_NEO_ID = 7;

   private SparkFlex leftVortex;
   private SparkFlex rightVortex;
   private SparkMax rightNeo;

   private SparkAbsoluteEncoder leftVortexEncoder;
   private SparkAbsoluteEncoder rightVortexEncoder;
   private SparkAbsoluteEncoder rightNeoEncoder;

   public Elevator(){
      this.leftVortex = new SparkFlex(LEFT_VORTEX_ID, MotorType.kBrushless);
      this.rightVortex = new SparkFlex(RIGHT_VORTEX_ID, MotorType.kBrushless);
      this.rightNeo = new SparkMax(RIGHT_NEO_ID, MotorType.kBrushless);

      this.leftVortexEncoder = leftVortex.getAbsoluteEncoder();
      this.rightVortexEncoder = rightVortex.getAbsoluteEncoder();
      this.rightNeoEncoder = rightNeo.getAbsoluteEncoder();
      
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
      leftVortex.set(power);
   }

   public void setNeo(double power){
      rightNeo.set(power);
   }

   public void logVortexEncoders(){
      String result = "Left:  " + leftVortexEncoder.getPosition() + "  |  Right:  " + rightVortexEncoder.getPosition();
      System.out.println(result);
   }
   
   public void logNeoEncoder(){
      String result = "Neo:  " + rightNeoEncoder.getPosition();
      System.out.println(result);
   }
}
