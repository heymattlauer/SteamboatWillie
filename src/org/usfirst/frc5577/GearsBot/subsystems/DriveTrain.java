// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5577.GearsBot.subsystems;

import org.usfirst.frc5577.GearsBot.Robot;
import org.usfirst.frc5577.GearsBot.RobotMap;
import org.usfirst.frc5577.GearsBot.commands.*;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController rightMotor = RobotMap.driveTrainRightMotor;
    SpeedController leftMotor = RobotMap.driveTrainLeftMotor;
    RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    
    //controls speed of chassis and the Value of the Decimal is a percentage ex. 0.5 = 50%
    double drivetainSpeed = 1.0;

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
        
        //robotDrive.setLeftRightMotorOutputs(0.5, 0.5);
    }
    
    /*
    public void arcadeDrive(Joystick stick){
    	robotDrive.arcadeDrive(stick);
    }*/
    
    public void driveTrainFoward(double speed) {
//    	robotDrive.tankDrive(speed, speed);
    	Timer.delay(0.005);
    	robotDrive.arcadeDrive(speed, 0); 
    }
    public void driveTrainBackward(double speed) {
//    	robotDrive.tankDrive(-speed, -speed);
    	Timer.delay(0.005);
    	robotDrive.arcadeDrive(-speed, 0); 
    }

    
    
    public void turn(double rotateValue) {
    	robotDrive.arcadeDrive(0, rotateValue);
    	Timer.delay(0.005);
    }
    
    public void takeJoystickInputs(Joystick xBoxCont) {
    	robotDrive.setSafetyEnabled(true);
    	
    	/* The two options for driving are tank drive and arcade mode. 
    	 * To choose tank you comment arcade out (i.e. //robotDrive.arcadeDrive...)
    	 * To choose arcade you comment tank out (i.e. //robotDrive.tankDrive...)
    	 * 
    	 */
//    	robotDrive.arcadeDrive(xBoxCont);
    	
    	robotDrive.arcadeDrive(-xBoxCont.getRawAxis(Robot.oi.LEFT_AXIS_Y)*drivetainSpeed, -xBoxCont.getRawAxis(Robot.oi.LEFT_AXIS_X)*drivetainSpeed, true);  
    	Timer.delay(0.005);
    }
    
    public void stop() {
    	robotDrive.drive(0, 0);
    }
    
}

