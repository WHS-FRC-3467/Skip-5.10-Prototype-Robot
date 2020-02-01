/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final WPI_TalonFX m_leftTalon1 = new WPI_TalonFX(RobotMap.portLeftMotor1);
  private final WPI_TalonFX m_leftTalon2 = new WPI_TalonFX(RobotMap.portLeftMotor2);
  private final WPI_TalonFX m_rightTalon1 = new WPI_TalonFX(RobotMap.portRightMotor1);
  private final WPI_TalonFX m_rightTalon2 = new WPI_TalonFX(RobotMap.portRightMotor2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void setLeftMotors (double speed) {
    m_leftTalon1.set(speed);
    m_leftTalon2.set(speed);
    
  }  
  public void setRightMotors (double speed){
    m_rightTalon1.set(speed);
    m_rightTalon2.set(speed);
 
  }
}
