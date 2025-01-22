// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
//Subsystems
import frc.robot.subsystems.DriveTrain;

//Commands
import frc.robot.commands.RunControls;
import frc.robot.commands.RunControls.ControlMode;
//Other
import frc.robot.utilites.AbsolutePosition;

public class RobotContainer {
   //Subsystems
   DriveTrain driveTrain;

   //Commands
   RunControls runControls;

   //Other
   AbsolutePosition positionTracker;

   //Interrupters
   private boolean teleopEnded;

   public RobotContainer() {
      this.driveTrain = new DriveTrain();

      this.runControls = new RunControls(driveTrain);
      runControls.setDriveTrainControl(ControlMode.Joystick);

      this.positionTracker = new AbsolutePosition();
   }

   /**Schedules the necessary commands to be ran during teleop*/
   public void startTeleop(){
      //Resets the interrupting condition
      teleopEnded = false;
      //Combines all needed commands into a single composite
      Command mainCommand = Commands.parallel(
         runControls
      );
      //Sets an interruption function. If teleopEnded gets set to true, mainCommand will stop running.
      mainCommand.until(() -> teleopEnded);

      CommandScheduler.getInstance().schedule(mainCommand);
   }
   /**Stops the commands that are running in teleop */
   public void endTeleop(){
      teleopEnded = true;
   }
}
