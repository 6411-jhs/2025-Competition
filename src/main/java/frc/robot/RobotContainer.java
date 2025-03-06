// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.control.DriveTrain;
import frc.robot.control.Elevator;
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
   Elevator elevator;

   public RobotContainer() {
      // joystick = new Joystick(0);
      this.xbox = new XboxController(0);

      this.driveTrain = new DriveTrain();
      this.elevator = new Elevator();
      // this.positionTracker = new AbsolutePosition();
   }

   public void teleopPeriodic(){
      // driveTrain.driveCartesian(joystick.getX() * 0.5, joystick.getY() * 0.5, joystick.getZ() * 0.5);
      if (xbox.getAButton()){
         elevator.setVortex(0.1);
         // elevator.setNeo(0.1);
      } else {
         elevator.setVortex(0);
         // elevator.setNeo(0);
      }
   }
}
