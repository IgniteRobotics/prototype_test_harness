/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
    //public final static Gains kGains_Velocit = new Gains( 0.25, 0.001, 20, 1023.0/7200.0,  300,  1.00);

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.VelocityPeriod;
import com.ctre.phoenix.motorcontrol.*;

public class shooter extends SubsystemBase {

  private WPI_TalonSRX motor1;
  private WPI_TalonSRX motor2;
  /**
   * Creates a new shooter.
   */
  public shooter() {
    motor1 = new WPI_TalonSRX(0);
    motor2 = new WPI_TalonSRX(1);
    motor1.configFactoryDefault();
    motor2.configFactoryDefault();
    int kSlotIdx = 0;
    int kPIDLoopIdx = 0;
    int kTimeoutMs = 30;
    double kP = .25;
    double kI = 0;
    double kD = 0;
    double kF = 1023.0/7200.0;


    /* Config sensor used for Primary PID [Velocity] */
    motor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,kPIDLoopIdx, kTimeoutMs);
    motor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,kPIDLoopIdx, kTimeoutMs);
    
    
		/* Config the peak and nominal outputs */
		motor1.configNominalOutputForward(0, kTimeoutMs);
		motor1.configNominalOutputReverse(0, kTimeoutMs);
		motor1.configPeakOutputForward(1, kTimeoutMs);
    motor1.configPeakOutputReverse(-1, kTimeoutMs);
    
    motor2.configNominalOutputForward(0, kTimeoutMs);
		motor2.configNominalOutputReverse(0, kTimeoutMs);
		motor2.configPeakOutputForward(1, kTimeoutMs);
		motor2.configPeakOutputReverse(-1, kTimeoutMs);

    
		/* Config the Velocity closed loop gains in slot0 */
		motor1.config_kF(kPIDLoopIdx, kF, kTimeoutMs);
	  motor1.config_kP(kPIDLoopIdx, kP, kTimeoutMs);
		motor1.config_kI(kPIDLoopIdx, kI, kTimeoutMs);
    motor1.config_kD(kPIDLoopIdx, kD, kTimeoutMs);
    motor2.config_kF(kPIDLoopIdx, kF, kTimeoutMs);
	  motor2.config_kP(kPIDLoopIdx, kP, kTimeoutMs);
		motor2.config_kI(kPIDLoopIdx, kI, kTimeoutMs);
		motor2.config_kD(kPIDLoopIdx, kD, kTimeoutMs);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot(double Velocity){

    motor1.set(ControlMode.Velocity, Velocity);
    motor1.set(ControlMode.Velocity, Velocity);

  }
}
