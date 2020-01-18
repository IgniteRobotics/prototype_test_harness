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
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.networktables.NetworkTableEntry;

public class velocitySet1 extends CommandBase {

  private final motor1 m_motor1;
  NetworkTableEntry toggle1  = (Shuffleboard.getTab("SmartDashboard").add("toggle1", true).withWidget("Toggle Button").getEntry());
  /**
   * Creates a new velocitySet.
   */
  public velocitySet1( motor1 motor1_) {
  m_motor1 = motor1_;
  addRequirements(motor1_);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  @Override
  public void initialize() {
    SmartDashboard.putNumber("velocity_1", 0);
    SmartDashboard.putNumber("power_1", 0);
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double Velocity = SmartDashboard.getNumber("velocity_1", 0);
    double power = SmartDashboard.getNumber("power_1", 0);
    boolean toggle_1 = toggle1.getBoolean(true);
    if (toggle_1){
      m_motor1.configuration();
      m_motor1.setVelocity(Velocity);
    }
    else{
      m_motor1.defaultConfig();
      m_motor1.setpower(power);
    }
    SmartDashboard.putNumber("velocity", m_motor1.getvelocity());
    System.out.println(m_motor1.getvelocity());
    
  }
  // Called when the command is initially scheduled.
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  
    

    return false;
  }
}
