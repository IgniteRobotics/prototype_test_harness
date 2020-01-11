/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class shoot extends CommandBase {

  private shooter shooter;

  /**
   * Creates a new shoot.
   */
  public shoot() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 

    /*
    if (NT.Motor1.Enabled)
      if NT.Motor1.Mode == PowerMode
        power = NT.Motor1.Value
        motor1.setPower(power)
      else
        velocity = NT.Motor1.Value
        motor1.setVelocity(velocity)
    else
      Motor1.stop()

    if (NT.Motor2.Enabled)
      if NT.Motor2.Mode == PowerMode
        power = NT.Motor2.Value
        motor2.setPower(power)
      else
        velocity = NT.Motor1.Value
        motor2.setVelocity(velocity)
    else
      Motor2.stop()

    */
    shooter.shoot(SmartDashboard.getNumber("velocity", 100));
  }

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
