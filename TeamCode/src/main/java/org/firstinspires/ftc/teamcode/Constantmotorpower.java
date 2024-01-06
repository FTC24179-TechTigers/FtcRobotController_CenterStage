package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Motor OpMode", group="Linear OpMode")

public class Constantmotorpower extends LinearOpMode {
    private DcMotor myMotor = null;

    @Override
    public void runOpMode() {
        telemetry.addData("status", "initialized");

        telemetry.update();
        myMotor = hardwareMap.get(DcMotor.class, "myMotor");
        myMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        waitForStart();



        while (opModeIsActive()) {
            boolean aButtonPressed = gamepad1.a;
            boolean bButtonPressed = gamepad1.b;
            boolean xButtonPressed = gamepad1.x;
            boolean yButtonPressed = gamepad1.y;

            if (aButtonPressed == true) {
                myMotor.setPower(0.25);
                telemetry.addData("button", " A");
            }   // If a button is pressed, set motor to half speed
            else {
                myMotor.setPower(0.0);
                telemetry.addData("button", " none");
            }


            telemetry.addData("A Button", aButtonPressed);
           // telemetry.addData("B Button", bButtonPressed);
            telemetry.update();
        }
    }
}