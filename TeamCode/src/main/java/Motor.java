import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class Motor extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotorEx d1 = null;

        d1 = hardwareMap.get(DcMotorEx.class, "motor");
        d1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        d1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        while(opModeIsActive()) {
            if (gamepad1.a) {
                d1.setPower(1);
            } else if (gamepad1.b) {
                d1.setPower(-1);
            } else {
                d1.setPower(0);
            }
        }
    }
}
