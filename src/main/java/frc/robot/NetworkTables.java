package frc.robot;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.DoubleTopic;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableValue;
import edu.wpi.first.networktables.PubSubOption;
import edu.wpi.first.networktables.Publisher;
import edu.wpi.first.networktables.StringPublisher;
import edu.wpi.first.networktables.StringSubscriber;

public class NetworkTables {
    static NetworkTableInstance inst = NetworkTableInstance.getDefault();
    final static NetworkTable stateTable = inst.getTable("States");

    final static NetworkTable controller_selector = inst.getTable("ControllerSelector");
    static StringPublisher controllerPublisher = controller_selector.getStringTopic("Controller").publish();
    static StringSubscriber controllerSubscriber = controller_selector.getStringTopic("Controller").subscribe("default");

    static StringPublisher intakeStatePublisher = stateTable.getStringTopic("Intake").publish();
    static StringPublisher shooterStatePublisher = stateTable.getStringTopic("Shooter").publish();
    static StringPublisher armStatePublisher = stateTable.getStringTopic("Arm").publish();
    static StringPublisher wristStatePublisher = stateTable.getStringTopic("Wrist").publish();

    public NetworkTables() {

    }

    public static String getControllerMode() {
        return controllerSubscriber.get();
    }

    public static void updateState(String name, String state) {

        switch (name) {

            case "Intake":
                intakeStatePublisher.set(state);
                break;

            case "Shooter":
                shooterStatePublisher.set(state);
                break;

            case "Wrist":
                wristStatePublisher.set(state);
                break;

            case "Arm":
                armStatePublisher.set(state);
                break;

            default:
                System.out.print("Check the name of" + name);
        }

        
    }

}