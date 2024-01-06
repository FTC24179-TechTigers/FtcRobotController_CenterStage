package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * This file creates a Tank Drive Mode for the Robot
 * In Tank Drive, the left joystick controls the left wheel, and the right
 * joystick controls the right wheel
 */

@TeleOp
public class competition extends LinearOpMode {

    // Declare Motors
    private DcMotor Motor0 = null;
    private DcMotor Motor1 = null;
    private DcMotor Motor2 = null;
    private DcMotor Motor3 = null;
    private DcMotor intake = null;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        Motor0 = hardwareMap.get(DcMotor.class, "Motor0");
        Motor1 = hardwareMap.get(DcMotor.class, "Motor1");
        Motor2 = hardwareMap.get(DcMotor.class, "Motor2");
        Motor3 = hardwareMap.get(DcMotor.class, "Motor3");
        intake = hardwareMap.get(DcMotor.class, "intake");

        Motor0.setDirection(DcMotorSimple.Direction.FORWARD);
        Motor1.setDirection(DcMotorSimple.Direction.FORWARD);
        Motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        Motor3.setDirection(DcMotorSimple.Direction.REVERSE);
        intake.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();

        while(opModeIsActive()){
            double leftPower = -gamepad1.left_stick_y;
            double rightPower = -gamepad1.right_stick_y;
            boolean aButtonPressed = gamepad2.a;
boolean yButtonPressed = gamepad2.y;
            Motor0.setPower(leftPower);
            Motor1.setPower(leftPower);
            Motor2.setPower(rightPower);
            Motor3.setPower(rightPower);
            if (aButtonPressed == true) {
                intake.setPower(0.25);
                telemetry.addData("button", " A");
            }   // If a button is pressed, set motor to half speed
            else {
                intake.setPower(0.0);
                telemetry.addData("button", " none");
            }


            if (yButtonPressed == true) {
                intake.setPower(-0.25); //outake.
                telemetry.addData("button", " y");
            }   // If a button is pressed, set motor to half speed
            else {
                intake.setPower(0.0);
                telemetry.addData("button", " none");
            }
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
