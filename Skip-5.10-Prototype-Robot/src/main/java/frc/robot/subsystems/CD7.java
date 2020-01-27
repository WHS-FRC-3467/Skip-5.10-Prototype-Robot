
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Command.ShootBall;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * An example subsystem. You can replace with me with your own subsystem.
 */
public class CD7 extends Subsystem {
  private TalonSRX sideMotor = new TalonSRX(RobotMap.portSideMotor);
  private TalonSRX beltMotor = new TalonSRX(RobotMap.portBeltMotor);

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new ShootBall());
  }
  
  public void setSideMotor (double speed){
    sideMotor.set(ControlMode.PercentOutput, speed);
  }
  public void setBeltMotor (double speed){
    beltMotor.set(ControlMode.PercentOutput, speed);

  }
}
