/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.motor1;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class powerSet1 extends CommandBase {

  private final motor1 m_motor1;
  double Velocity1 = SmartDashboard.getNumber("velocity_1", 0);
  double power1 = SmartDashboard.getNumber("percent_Power_1", 0);
  boolean toggle1 = SmartDashboard.getBoolean("toggle_1", true);
  double Velocity2 = SmartDashboard.getNumber("velocity_2", 0);
  double power2 = SmartDashboard.getNumber("percent_Power_2", 0);
  boolean toggle2 = SmartDashboard.getBoolean("toggle_2", true);
  /**
   * Creates a new velocitySet.
   */
  public powerSet1( motor1 motor1_) {
  m_motor1 = motor1_;
  addRequirements(motor1_);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  @Override
  public void initialize() {
    
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double power1 = SmartDashboard.getNumber("percent_Power_1", 0);
    m_motor1.setVelocity(power1);

    
  }
  // Called when the command is initially scheduled.
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  
    

    return true;
  }
}
