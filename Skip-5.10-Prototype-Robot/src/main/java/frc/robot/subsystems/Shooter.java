
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Command.ShootBall;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * An example subsystem. You can replace with me with your own subsystem.
 */
public class Shooter extends Subsystem {
  private PWMSparkMax leftMotorShooter = new PWMSparkMax(RobotMap.portShooterLeft);
  private PWMSparkMax rightMotorShooter = new PWMSparkMax(RobotMap.portShooterRight);
  private TalonSRX intakeMotor = new TalonSRX(RobotMap.portShooterIntake);

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new ShootBall());
  }

  public void setShooterMotors (double speed){
    rightMotorShooter.set(speed);
    leftMotorShooter.set(speed);
  }

  public void setIntake (double speed)
  {
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }
}
