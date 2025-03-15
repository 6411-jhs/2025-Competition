// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.commands.autonomous.*;
import edu.wpi.first.wpilibj2.command.Command;

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
   private XboxController xbox;

   private DriveTrain driveTrain;
   private DriveTrainControls driveTrainControls;

   private Taxi taxiAuto;

   private static final int XBOX_PORT = 0;

   public RobotContainer() {
      this.xbox = new XboxController(XBOX_PORT);

      this.driveTrain = new DriveTrain();
      this.driveTrainControls = new DriveTrainControls(xbox, driveTrain);

      this.taxiAuto = new Taxi(driveTrain, 0.6);

      driveTrain.setDefaultCommand(driveTrainControls);
   }

   public void startTeleop() {
      driveTrain.setDefaultCommand(driveTrainControls);
   }

   public Command getAutonomousCommand() {
      return taxiAuto;
   }
}
