// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorCommand extends CommandBase {
  /** Creates a new ElevatorCommand. */
  ElevatorSubsystem elevator;
  double elevatorSpeed;
  public ElevatorCommand(ElevatorSubsystem m_elevator, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.elevator = m_elevator;
    this.elevatorSpeed = speed;
    addRequirements(elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("ElevatorCmd started!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevator.elevatorSpeed(elevatorSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("ElevatorCmd ended!");
    elevator.elevatorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
