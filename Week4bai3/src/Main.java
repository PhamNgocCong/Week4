import java.util.Scanner;

interface IWorkable {
    void work();
}

abstract class Employee implements IWorkable{
    String id;
    String name;
    double baseSalary;
    public Employee(String id, String name, double baseSalary) {
        this.id=id;
        this.name=name;
        this.baseSalary=baseSalary;
    }
public abstract double calculatePay();
    public String getName(){
        return name;
    }
}


class OfficeWorker extends Employee {
    public OfficeWorker(String id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    public double calculatePay() {
        return baseSalary;
    }

    public void work() {
        System.out.println("Soạn thảo văn bản");
    }
}


class Technician extends Employee {
    private int overtimeHours;

    public Technician(String id, String name, double baseSalary, int overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    public double calculatePay() {
        return baseSalary + overtimeHours * 20000.0;
    }

    public void work() {
        System.out.println("Lắp đặt thiết bị");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Employee[] employeeList = new Employee[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String id = scanner.next();
            String name = scanner.next();
            double baseSalary = scanner.nextDouble();

            if (type.equals("O")) {
                employeeList[i]=new OfficeWorker(id,name,baseSalary);
            } else if (type.equals("T")) {
                int overtimeHours = scanner.nextInt();
                employeeList[i]=new Technician(id,name,baseSalary,overtimeHours);
            }
        }
        scanner.close();

        double totalPay = 0;
        for (Employee emp : employeeList) {
            double pay = emp.calculatePay();
            totalPay += pay;

            System.out.println(emp.getName() + " - Pay: " + pay);
            emp.work();
        }

        System.out.println("Total Pay = " + totalPay);
    }
}
