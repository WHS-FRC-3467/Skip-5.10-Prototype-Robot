package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.RobotMap;
import frc.robot.Command.DriveBot;


public class Drivetrain extends Subsystem {

	// Motor controller objects and RobotDrive object
	private final TalonFX rightMotor1, rightMotor2, leftMotor1, leftMotor2;
	
	private final DifferentialDrive m_drive;
	private ControlMode 			m_talonControlMode;

	// Static subsystem reference
	private static Drivetrain dTInstance = new Drivetrain();

	public static Drivetrain getInstance() {
		return Drivetrain.dTInstance;
	}
	
	//Drivetrain class constructor
	public Drivetrain() {

		super();

		// Three motors per side -> three speed controllers per side
        leftMotor1 = new TalonFX(RobotMap.portRightMotor1);
        leftMotor2 = new TalonFX(RobotMap.portRightMotor2);
        rightMotor1 = new TalonFX(RobotMap.portLeftMotor1);
        rightMotor2 = new TalonFX(RobotMap.portLeftMotor2);

        
        leftMotor1.configFactoryDefault();
        leftMotor2.configFactoryDefault();
        rightMotor1.configFactoryDefault();
        rightMotor2.configFactoryDefault();

		// Slave the extra Talons on each side
        leftMotor2.follow(leftMotor1);
        rightMotor1.follow(rightMotor2);
		
		// Invert all motors? (invert for driving backward)
		boolean _inverted = false; 
		leftMotor1.setInverted(_inverted);
		leftMotor2.setInverted(_inverted);
		rightMotor1.setInverted(_inverted);
		rightMotor2.setInverted(_inverted);

		// Turn off Brake mode
		setTalonBrakes(false);
		
		// Set default control Modes for Master Talons
		
 		// Set encoders as feedback device
		leftMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		rightMotor2.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		
		// Instantiate DifferentialDrive
		m_drive = new DifferentialDrive(leftMotor1, rightMotor1);
		
        // DifferentialDrive Parameters
        m_drive.setDeadband(0.0); // we will add our own deadband as needed
		m_drive.setSafetyEnabled(true);
		m_drive.setExpiration(1.0);
		m_drive.setMaxOutput(1.0);

	}
    protected void initDefaultCommand() {
	
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveBot());
	
    }
    

	public TalonFX getLeftTalon() {
		return leftMotor1;
	}
	
	public TalonFX getRightTalon() {
		return rightMotor1;
	}
	
    
    // Use standard Tank Drive method
    public void driveTank(double leftSpeed, double rightSpeed)
    {
        m_drive.tankDrive(leftSpeed, rightSpeed, false);
    }

    // Use single-stick Arcade Drive method
    public void driveArcade(double move, double rotate)
    {
        m_drive.arcadeDrive(move, rotate, false);
    }

    // Use DifferentialDrive curvatureDrive() method
    public void drive(double outputMagnitude, double curve, boolean spin)
    {
        m_drive.curvatureDrive(outputMagnitude, curve, spin);
    }

    /**
     * @param controlMode Set the control mode of the left and right master WPI_TalonSRXs
     */

    /**
     * @return The current WPI_TalonSRX control mode
     */
    public ControlMode getTalonControlMode()
    {
        return m_talonControlMode;
    }

    /*
     * Sets the brake mode for ALL WPI_TalonSRXs
     * 
     * @param setBrake Enable brake mode?
     */
    public void setTalonBrakes(boolean setBrake)
    {

        NeutralMode nm = setBrake ? NeutralMode.Brake : NeutralMode.Coast;

        leftMotor1.setNeutralMode(nm);
        leftMotor2.setNeutralMode(nm);
        rightMotor1.setNeutralMode(nm);
        rightMotor2.setNeutralMode(nm);

        // On the Shuffleboard, show Red if brakes are set, Green if they are off
	}
}
