
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Command.runIntake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * An example subsystem. You can replace with me with your own subsystem.
 */
public class Intake extends Subsystem {
  private TalonSRX intakeMotor = new TalonSRX(RobotMap.portIntakeMotor);

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new runIntake());
  }

  public void setIntakeRoller (double speed)
  {
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }
}
