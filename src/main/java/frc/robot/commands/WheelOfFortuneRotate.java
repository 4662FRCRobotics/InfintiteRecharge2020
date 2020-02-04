/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ContestantConstants;
import frc.robot.subsystems.WheelOfFortuneRotator;

public class WheelOfFortuneRotate extends CommandBase {
  /**
   * Creates a new WheelOfFortuneRotate.
   */
  private WheelOfFortuneRotator m_contestant;
  private ContestantConstants.Direction m_direction;
  private double m_speed;

  public WheelOfFortuneRotate(WheelOfFortuneRotator contestant, ContestantConstants.Direction direction) {
    m_contestant = contestant;
    m_direction = direction;

    switch (direction){
      case CCW:
        m_speed = ContestantConstants.kOVERRIDE_SPEED;
        break;
      case CW:
        m_speed = -ContestantConstants.kOVERRIDE_SPEED;
        break;
    }
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_contestant.setColorWheelMotor(m_speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_contestant.setColorWheelMotor(ContestantConstants.kZERO_SPEED);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
