package org.firstinspires.ftc.teamcode.opModes.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.arm.ArmCommand;
import org.firstinspires.ftc.teamcode.commands.arm.MaintainHeightCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LiftPIDSubsystem;
import org.firstinspires.ftc.teamcode.util.RevTouchSensor;

@TeleOp(group = "tests")
public class ArmPIDTest extends CommandOpMode {
    private RevTouchSensor limit;
    private int level = 0;

    //motors
    private Motor armMotor;

    //subsystems
    private ArmPIDSubsystem armSubsystem;

    //commands
    private ArmCommand command;

    //gamepads
    private GamepadEx driver;

    @Override
    public void initialize() {
        this.armMotor = new Motor(hardwareMap, "arm");
        this.limit = new RevTouchSensor(hardwareMap, "limit");
        this.armSubsystem = new ArmPIDSubsystem(armMotor, limit);

        this.command = new ArmCommand(armSubsystem);
        this.driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(command);

    }
}