import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


interface WifiConfigurable {
    void setupWifi();
}


abstract class Device {
    protected String id;
    protected String name;
    protected boolean status;

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
        this.status = true;
    }

    public void turnOff() {
        this.status = false;
    }

    public void turnOn() {
        this.status = true;
    }

    public String getName() {
        return name;
    }
}


class SmartLight extends Device {
    public SmartLight(String id, String name) {
        super(id, name);
    }
}


class AirConditioner extends Device implements WifiConfigurable {
    public AirConditioner(String id, String name) {
        super(id, name);
    }

    public void setupWifi() {
    }
}


class SmartSpeaker extends Device implements WifiConfigurable {
    public SmartSpeaker(String id, String name) {
        super(id, name);
    }


    public void setupWifi() {
    }
}

class WindowCurtain extends Device {
    public WindowCurtain(String id, String name) {
        super(id, name);
    }
}


public class SmartHomeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = Integer.parseInt(scanner.nextLine());
        List<Device> devices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");

            String type = parts[0];
            String id = parts[1];
            String name = parts[2];

            switch (type) {
                case "L":
                    devices.add(new SmartLight(id, name));
                    break;
                case "AC":
                    devices.add(new AirConditioner(id, name));
                    break;
                case "S":
                    devices.add(new SmartSpeaker(id, name));
                    break;
                case "C":
                    devices.add(new WindowCurtain(id, name));
                    break;
            }
        }


        System.out.println("Turn Off All Devices:");
        for (Device d : devices) {
            d.turnOff();
            System.out.println(d.getName() + " turned off");
        }


        System.out.println("\nSetup Wifi:");
        for (Device d : devices) {
            if (d instanceof WifiConfigurable) {
                ((WifiConfigurable) d).setupWifi();
                System.out.println(d.getName() + " connected to wifi");
            }
        }
    }
}
