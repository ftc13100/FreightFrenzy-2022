package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LiftPIDSubsystem;

public class ArmCommand extends CommandBase {
    private final ArmPIDSubsystem subsystem;
    private int level;

    public ArmCommand(ArmPIDSubsystem subsystem) {
        level = 0;
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.setTargetPosition(1500);
        subsystem.setMotorPosition(1500);
        subsystem.moveToPosition();
    }

    @Override
    public boolean isFinished() {
        return subsystem.getCurrentPosition() == subsystem.getTargetPosition();
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stopMotor();
    }
}