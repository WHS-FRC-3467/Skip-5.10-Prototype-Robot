/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Command;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class DriveBot extends Command {
  public DriveBot() {
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    final double speed = joyXValue1() * 0.6;
    final double curve = joyYValue4() * 0.3;
    final double left = speed + curve;
    final double right = -(speed - curve);
    
    Robot.drivetrain.setRightMotors(left);
    Robot.drivetrain.setLeftMotors(right);
    
  }
  private double joyXValue1(){
    if (Math.abs(OI.getDriverController().getRawAxis(1)) < 0.1){
        return 0;
    }
    else{
        return OI.getDriverController().getRawAxis(1);
    } 
  }
  private double joyYValue4(){
    if (Math.abs(OI.getDriverController().getRawAxis(4)) < 0.1){
        return 0;
    }
    else{
        return OI.getDriverController().getRawAxis(4);
    }
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
