// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.control.DriveTrain;
import frc.robot.control.StageThreeLatch;
import frc.robot.control.StageTwoLatch;
import frc.robot.utilites.AbsolutePosition;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
   Joystick joystick;
   XboxController xbox;

   AbsolutePosition positionTracker;
   DriveTrain driveTrain;

   StageTwoLatch stageTwoLatch;
   StageThreeLatch stageThreeLatch;

   public RobotContainer() {
      // joystick = new Joystick(0);
      this.xbox = new XboxController(0);

      this.driveTrain = new DriveTrain();
      // this.positionTracker = new AbsolutePosition();
      this.stageTwoLatch = new StageTwoLatch();
      this.stageThreeLatch = new StageThreeLatch();
   }

   public void teleopPeriodic(){
      // driveTrain.driveCartesian(joystick.getX() * 0.5, joystick.getY() * 0.5, joystick.getZ() * 0.5);
      if (xbox.getAButton()){
         stageTwoLatch.setServo(90);
         // stageThreeLatch.setLeftServo(90);
         // stageThreeLatch.setRightServo(90);
      } else {
         stageTwoLatch.setServo(0);
         // stageThreeLatch.setLeftServo(0);
         // stageThreeLatch.setRightServo(0);
      }
   }
}
