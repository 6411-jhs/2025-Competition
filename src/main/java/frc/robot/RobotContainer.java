// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.DriveTrain;

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
   // The robot's subsystems and commands are defined here...jj
   /**
    * The container for the robot. Contains subsystems, OI devices, and commands.
    */
   AbsolutePosition positionTracker;
   DriveTrain driveTrain;

   public RobotContainer() {
      this.driveTrain = new DriveTrain();
      this.positionTracker = new AbsolutePosition();
   }

   public void teleopPeriodic(){
      positionTracker.updateXPos();
      System.out.println(positionTracker.getXPosition());
   }
}
