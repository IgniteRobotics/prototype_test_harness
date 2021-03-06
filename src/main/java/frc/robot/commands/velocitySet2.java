/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.motor2;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.networktables.NetworkTableEntry;

public class velocitySet2 extends CommandBase {

  private final motor2 m_motor2;
  NetworkTableEntry toggle2  = (Shuffleboard.getTab("Toggleboard").add("velocitytoggle2", true).withWidget("Toggle Button").getEntry());
  /**
   * Creates a new velocitySet.
   */
  public velocitySet2( motor2 motor2_) {
  m_motor2 = motor2_;
  addRequirements(motor2_);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  @Override
  public void initialize() {
    SmartDashboard.putNumber("velocity_2", 0);
    SmartDashboard.putNumber("power_2", 0);
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double Velocity = SmartDashboard.getNumber("velocity_2", 0);
    double power = SmartDashboard.getNumber("power_2", 0);
    boolean toggle_2 = toggle2.getBoolean(true);
    if (toggle_2){
      m_motor2.configuration();
      m_motor2.setVelocity(Velocity);
    }
    else{
      m_motor2.defaultConfig();
      m_motor2.setpower(power);
    }
    SmartDashboard.putNumber("velocity2", m_motor2.getvelocity());
    System.out.println(m_motor2.getvelocity());
    
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
