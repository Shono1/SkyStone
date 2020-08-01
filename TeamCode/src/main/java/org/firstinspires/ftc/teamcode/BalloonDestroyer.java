package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorREVColorDistance;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class BalloonDestroyer extends LinearOpMode {
    private DcMotor frontLeft, backLeft, frontRight, backRight;
    private DistanceSensor distance; // Add in with distance sensor step
    private ColorSensor color; // Add in with color sensor step

    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "fl");
        backLeft = hardwareMap.get(DcMotor.class, "bl");
        frontRight = hardwareMap.get(DcMotor.class, "fr");
        backRight = hardwareMap.get(DcMotor.class, "br");

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        distance = hardwareMap.get(DistanceSensor.class, "color"); // Add in with distance sensor step
        color = hardwareMap.get(ColorSensor.class, "color"); // Add in with color sensor step

        waitForStart();

        // Spin one motor for test
        frontRight.setPower(1);

        // Spin one motor for a designated time
        frontRight.setPower(1);
        sleep(5000);
        frontRight.setPower(0);

        // Drive in a straight line
        frontLeft.setPower(1);
        backLeft.setPower(1);
        frontRight.setPower(1);
        backRight.setPower(1);

        // Drive in a straight line for specified distance/time SEE METHOD
        driveStraight(5000);

        // Drive until a distance SEE METHOD
        driveDistance(10);

        // Drive until a distance and read a color
        driveDistance(10);
        if(color.green() > 175) { // This method needs calibration

        }
    }

    private void driveStraight(int time) {
        frontLeft.setPower(1);
        backLeft.setPower(1);
        frontRight.setPower(1);
        backRight.setPower(1);

        sleep(time);

        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    private void driveDistance(int dist) {
        frontLeft.setPower(1);
        backLeft.setPower(1);
        frontRight.setPower(1);
        backRight.setPower(1);

        while(distance.getDistance(DistanceUnit.CM) > dist) {
            idle();
        }

        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }
}
