class Employee{
    String name;
    double baseSalary;
    
    Employee(String name,double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }
    double calculateSalary(){
        return baseSalary + (5.0/100.0)*baseSalary;
    }
}
class Manager extends Employee{
    Manager(String name,double baseSalary){
        super(name,baseSalary);
    }
    @Override
    double calculateSalary() {
        return super.calculateSalary()+2000;
    }
}
class Executive extends Manager{
    Executive(String name,double baseSalary){
        super(name,baseSalary);
    }

    @Override
    double calculateSalary(){
        return super.calculateSalary() + (10.0/100.0)*baseSalary;
    }
}

public class multi_tier_payroll_system {
    public static void main(String[] args) {
        Employee a = new Employee("alice",10000.0);
        System.out.println(String.format("%.2f", a.calculateSalary()));
        Manager b = new Manager("bob",10000.0);
        System.out.println(String.format("%.2f", b.calculateSalary()));
        Executive c = new Executive("Charlie",10000.0);
        System.out.println(String.format("%.2f", c.calculateSalary()));
    }
}


