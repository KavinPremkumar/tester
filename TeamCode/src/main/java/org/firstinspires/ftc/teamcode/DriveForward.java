package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class DriveForward extends LinearOpMode {

    DcMotorEx leftFrontDrive = null;
    DcMotorEx leftBackDrive = null;
    DcMotorEx rightFrontDrive = null;
    DcMotorEx rightBackDrive = null;
    @Override
    public void runOpMode() throws InterruptedException {
        leftFrontDrive  = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftBackDrive  = hardwareMap.get(DcMotorEx.class, "leftBack");
        rightFrontDrive = hardwareMap.get(DcMotorEx.class, "rightFront");
        rightBackDrive = hardwareMap.get(DcMotorEx.class, "rightBack");

        leftFrontDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        leftBackDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        while(opModeIsActive()){

            if(gamepad1.right_stick_y!=0){
                rightBackDrive.setPower(gamepad1.right_stick_y);
                rightFrontDrive.setPower(gamepad1.right_stick_y);
            } else if (gamepad1.left_stick_y!=0) {
                leftBackDrive.setPower(gamepad1.left_stick_y);
                leftFrontDrive.setPower(gamepad1.left_stick_y);
            } else {
                rightBackDrive.setPower(0);
                rightFrontDrive.setPower(0);
                leftBackDrive.setPower(0);
                leftFrontDrive.setPower(0);
            }
        }
    }
}
