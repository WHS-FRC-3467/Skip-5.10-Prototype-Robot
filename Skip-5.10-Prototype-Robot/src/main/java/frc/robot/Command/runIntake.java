/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Command;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class runIntake extends Command {
    private double sideVelocity, beltVelocity;


  public runIntake() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.CD7);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {  

    
    SmartDashboard.putNumber("Side Velocity", sideVelocity);
    SmartDashboard.putNumber("Belt velocity", beltVelocity);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      
    //get velocity from SmartDashboard
    double m_sideVelocity = SmartDashboard.getNumber("Side Velocity", 0);
    double m_beltVelocity = SmartDashboard.getNumber("Belt velocity", 0);
    // if velocity coefficients on SmartDashboard have changed, write new values to controller
    
    Robot.CD7.setSideMotor(m_sideVelocity);
    Robot.CD7.setBeltMotor(m_beltVelocity);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
