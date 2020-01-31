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

public class runBallPath extends Command {
  private double pathVelocity, sendVelocity;

  public runBallPath() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis); 
    requires(Robot.BallPath);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    SmartDashboard.putNumber("Path Velocity", sendVelocity);
    SmartDashboard.putNumber("Send velocity", pathVelocity);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double m_pathVelocity = SmartDashboard.getNumber("Path Velocity", 0);
    double m_sendVelocity = SmartDashboard.getNumber("Send velocity", 0);
    // if velocity coefficients on SmartDashboard have changed, write new values to controller
    
    Robot.BallPath.setPathMotor(m_pathVelocity);
    Robot.BallPath.setSendingMotor(m_sendVelocity);
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
