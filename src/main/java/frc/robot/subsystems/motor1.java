/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.VelocityPeriod;
import com.ctre.phoenix.motorcontrol.*;

public class motor1 extends SubsystemBase {
  
  private WPI_TalonSRX motor;
  /**
   * Creates a new motor1.
   */
  public motor1() {
    motor = new WPI_TalonSRX(8);
    motor.configFactoryDefault();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setVelocity(double Velocity){

    motor.set(ControlMode.Velocity, Velocity);
    


  }
  public void setpower(double power){

    motor.set(ControlMode.PercentOutput, power);

  }
  

  public void configuration(){
    int kSlotIdx = 0;
    int kPIDLoopIdx = 0;
    int kTimeoutMs = 30;
    double kP = .25;
    double kI = 0;
    double kD = 0;
    double kF = 1023.0/7200.0;


    /* Config sensor used for Primary PID [Velocity] */
    motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,kPIDLoopIdx, kTimeoutMs);
    
    
    
		/* Config the peak and nominal outputs */
		motor.configNominalOutputForward(0, kTimeoutMs);
		motor.configNominalOutputReverse(0, kTimeoutMs);
		motor.configPeakOutputForward(1, kTimeoutMs);
    motor.configPeakOutputReverse(-1, kTimeoutMs);

    
		/* Config the Velocity closed loop gains in slot0 */
		motor.config_kF(kPIDLoopIdx, kF, kTimeoutMs);
	  motor.config_kP(kPIDLoopIdx, kP, kTimeoutMs);
		motor.config_kI(kPIDLoopIdx, kI, kTimeoutMs);
    motor.config_kD(kPIDLoopIdx, kD, kTimeoutMs);
  }

  public void defaultConfig(){
    motor.configFactoryDefault();
  }

  public int getvelocity(){
   return(motor.getSelectedSensorVelocity());
  }
}
