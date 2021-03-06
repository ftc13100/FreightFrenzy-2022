package org.firstinspires.ftc.teamcode.commands.auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

public class AutoRoutine extends SequentialCommandGroup {
    public AutoRoutine(MecanumDriveSubsystem dt, LiftSubsystem arm, CommandOpMode opMode) {
        addCommands(
                new WaitUntilCommand(opMode::isStarted),
                new InstantCommand(() -> arm.motorDown()),
                new WaitCommand(3000),
                new InstantCommand(() -> arm.motorStop()),
                new InstantCommand(() -> dt.setDrivePower(new Pose2d(0, 0.5, 0))),
                new WaitCommand(1350),
                new InstantCommand(() -> dt.setDrivePower(new Pose2d(-0.5, 0, 0))),
                new WaitCommand(6500),
                new InstantCommand(() -> dt.setDrivePower(new Pose2d(0, 0, 0)))
        );
    }
}
