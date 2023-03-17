// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ArmCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.IntakeAngleCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.TurretCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.TurretSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  public Joystick m_driverController = new Joystick(0); //F310
  public Joystick m_operatorController = new Joystick(1); // Panel
  
  public final DriveSubsystem m_robotDrive = new DriveSubsystem();
  public final ArmSubsystem m_arm = new ArmSubsystem();
  public final ElevatorSubsystem m_elevator = new ElevatorSubsystem();
  public final IntakeSubsystem m_intake = new IntakeSubsystem();
  public final TurretSubsystem m_turret = new TurretSubsystem();
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  //private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    m_robotDrive.setDefaultCommand(new DriveCommand(m_robotDrive,() -> -m_driverController.getRawAxis(1),() -> m_driverController.getRawAxis(4)));
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    new JoystickButton(m_driverController, 0).whileTrue(new ArmCommand(m_arm, 1));
    new JoystickButton(m_driverController, 0).whileTrue(new ArmCommand(m_arm, -1));
    new JoystickButton(m_driverController, 0).whileTrue(new ElevatorCommand(m_elevator, 1));
    new JoystickButton(m_driverController, 0).whileTrue(new ElevatorCommand(m_elevator, -1));
    new JoystickButton(m_driverController, 0).whileTrue(new IntakeCommand(m_intake, 1));
    new JoystickButton(m_driverController, 0).whileTrue(new IntakeCommand(m_intake, -1));
    new JoystickButton(m_driverController, 0).whileTrue(new IntakeAngleCommand(m_intake, 1));
    new JoystickButton(m_driverController, 0).whileTrue(new IntakeAngleCommand(m_intake, -1));
    new JoystickButton(m_driverController, 0).whileTrue(new TurretCommand(m_turret, 1));
    new JoystickButton(m_driverController, 0).whileTrue(new TurretCommand(m_turret, -1));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
