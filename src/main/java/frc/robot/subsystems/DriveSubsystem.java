// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  PWMTalonSRX rightFrontMotor = new PWMTalonSRX(DriveConstants.kRightFrontMotor);
  WPI_VictorSPX rightRearMotor = new WPI_VictorSPX(DriveConstants.kRightRearMotor);

  PWMTalonSRX leftFrontMotor = new PWMTalonSRX(DriveConstants.kLeftFrontMotor);
  WPI_VictorSPX leftRearMotor = new WPI_VictorSPX(DriveConstants.kLeftRearMotor);

  MotorControllerGroup leftMotor = new MotorControllerGroup(leftFrontMotor, leftRearMotor);
  MotorControllerGroup rightMotor = new MotorControllerGroup(rightFrontMotor, rightRearMotor);

  DifferentialDrive m_drive = new DifferentialDrive(leftMotor, rightMotor);

  public DriveSubsystem() {}

  public void arcadeDrive(double xSpeed, double zRotation) {
    m_drive.arcadeDrive(xSpeed, zRotation);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
