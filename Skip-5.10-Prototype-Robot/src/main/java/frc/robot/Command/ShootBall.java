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

public class ShootBall extends Command {
    private double velocity, intakeVelocity;


  public ShootBall() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.shooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {  

    
    SmartDashboard.putNumber("Velocity", velocity);
    SmartDashboard.putNumber("intake velocity", intakeVelocity);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      
    //get velocity from SmartDashboard
    double m_velocity = SmartDashboard.getNumber("Velocity", 0);
    double m_intakeVelocity = SmartDashboard.getNumber("Velocity", 0);
    // if velocity coefficients on SmartDashboard have changed, write new values to controller
    
    Robot.shooter.setShooterMotors(m_velocity);
    Robot.shooter.setIntake(m_intakeVelocity);
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
