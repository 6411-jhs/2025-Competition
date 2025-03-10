// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.control.DriveTrain;
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

   AbsolutePosition positionTracker;
   DriveTrain driveTrain;

   public RobotContainer() {
      joystick = new Joystick(0);

      this.driveTrain = new DriveTrain();
      this.positionTracker = new AbsolutePosition();
   }

   public void teleopPeriodic(){
      driveTrain.driveCartesian(joystick.getX() * 0.5, joystick.getY() * 0.5, joystick.getZ() * 0.5);
   }
}
