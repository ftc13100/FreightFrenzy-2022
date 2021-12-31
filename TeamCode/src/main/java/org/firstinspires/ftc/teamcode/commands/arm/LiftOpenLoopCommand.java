package org.firstinspires.ftc.teamcode.commands.arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

public class LiftOpenLoopCommand extends CommandBase {
    private LiftSubsystem armSubsystem;
    private double power;

    public LiftOpenLoopCommand(LiftSubsystem lift, double power) {
        this.armSubsystem = lift;
        this.power = power;
    }

    @Override
    public void execute() {
        this.armSubsystem.setPower(power);
    }

}