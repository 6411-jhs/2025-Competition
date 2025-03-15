// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

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
   // private Joystick joystick;

   private DriveTrain driveTrain;
   private DriveTrainControls driveTrainControls;

   private static final int XBOX_PORT = 0;
   // private static final int JOYSTICK_PORT = 0;

   public RobotContainer() {
      this.xbox = new XboxController(XBOX_PORT);
      // this.joystick = new Joystick(JOYSTICK_PORT);

      this.driveTrain = new DriveTrain();

      this.driveTrainControls = new DriveTrainControls(xbox, driveTrain);

      driveTrain.setDefaultCommand(driveTrainControls);
      // CommandScheduler.getInstance().setDefaultCommand(driveTrain,
      // driveTrainControls);
   }

   public void startTeleop() {
      // driveTrain.setDefaultCommand(driveTrainControls);
      // CommandScheduler.getInstance().setDefaultCommand(driveTrain,
      // driveTrainControls);
   }

   public Command getAutonomousCommand() {
      Command autoCommand = new RunCommand(() -> driveTrain.driveCartesian(0, -0.5, 0), driveTrain).withTimeout(.6);
      return autoCommand;
   }
}
