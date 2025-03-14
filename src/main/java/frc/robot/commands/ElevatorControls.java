package frc.robot.commands;

import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class ElevatorControls extends Command {
    Elevator elevatorSubsystem;
    XboxController xbox;

    public ElevatorControls(Elevator elevatorSubsystem, XboxController xbox) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.xbox = xbox;
    }

    @Override
    public void execute() {
        
    }    
}
