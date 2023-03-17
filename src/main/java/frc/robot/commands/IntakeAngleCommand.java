// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeAngleCommand extends CommandBase {
  /** Creates a new IntakeAngleCommand. */
  IntakeSubsystem intake;
  double intakeAngleSpeed;
  public IntakeAngleCommand(IntakeSubsystem m_intake, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intake = m_intake;
    this.intakeAngleSpeed = speed;
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("IntakeAngleCmd started!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.intakAngleSpeed(intakeAngleSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("IntakeAngleCmd ended!");
    intake.intakeSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
