/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.motor1;
import frc.robot.subsystems.motor2;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private motor1 motor1_ = new motor1();
  private motor2 motor2_ = new motor2();
  double Velocity1 = SmartDashboard.getNumber("velocity_1", 0);
  double power1 = SmartDashboard.getNumber("percent_Power_1", 0);
  boolean toggle1 = SmartDashboard.getBoolean("toggle_1", true);
  double Velocity2 = SmartDashboard.getNumber("velocity_2", 0);
  double power2 = SmartDashboard.getNumber("percent_Power_2", 0);
  boolean toggle2 = SmartDashboard.getBoolean("toggle_2", true);
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    motor1_.setDefaultCommand(new ConditionalCommand(new InstantCommand(() -> motor1_.setVelocity(Velocity1), motor1_),new InstantCommand(() -> motor1_.setpower(power1), motor1_), () -> toggle1));
    motor2_.setDefaultCommand(new ConditionalCommand(new InstantCommand(() -> motor2_.setVelocity(Velocity1), motor2_),new InstantCommand(() -> motor2_.setpower(power1), motor2_), () -> toggle2));

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
