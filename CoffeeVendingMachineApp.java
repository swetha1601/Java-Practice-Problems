import java.util.*;

// 1. State Pattern
interface VendingMachineState {
    void insertCoin();
    void selectCoffee(String coffeeType);
    void brewCoffee();
    void dispenseCoffee();
}

class IdleState implements VendingMachineState {
    private CoffeeVendingMachine machine;

    public IdleState(CoffeeVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted. Please select your coffee.");
        machine.setState(machine.getWaitingState());
    }

    @Override
    public void selectCoffee(String coffeeType) {
        System.out.println("Please insert a coin first.");
    }

    @Override
    public void brewCoffee() {
        System.out.println("Insert a coin and select coffee first.");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("No coffee selected.");
    }
}

class WaitingState implements VendingMachineState {
    private CoffeeVendingMachine machine;

    public WaitingState(CoffeeVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted. Please select your coffee.");
    }

    @Override
    public void selectCoffee(String coffeeType) {
        System.out.println("Coffee selected: " + coffeeType);
        machine.setCoffeeType(coffeeType);
        machine.setState(machine.getBrewingState());
    }

    @Override
    public void brewCoffee() {
        System.out.println("Please select a coffee first.");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Please select a coffee first.");
    }
}

class BrewingState implements VendingMachineState {
    private CoffeeVendingMachine machine;

    public BrewingState(CoffeeVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Already brewing coffee. Please wait.");
    }

    @Override
    public void selectCoffee(String coffeeType) {
        System.out.println("Already brewing selected coffee.");
    }

    @Override
    public void brewCoffee() {
        System.out.println("Brewing the " + machine.getCoffeeType() + "...");
        machine.setState(machine.getDispensingState());
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Cannot dispense yet. Coffee is brewing.");
    }
}

class DispensingState implements VendingMachineState {
    private CoffeeVendingMachine machine;

    public DispensingState(CoffeeVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coffee is being dispensed. Please wait.");
    }

    @Override
    public void selectCoffee(String coffeeType) {
        System.out.println("Coffee is being dispensed. Please wait.");
    }

    @Override
    public void brewCoffee() {
        System.out.println("Coffee is already brewed.");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Dispensing " + machine.getCoffeeType() + "...");
        machine.setState(machine.getIdleState());
    }
}

// 2. Factory Method Pattern
interface Coffee {
    void prepare();
    double getPrice();
}

class Espresso implements Coffee {
    @Override
    public void prepare() {
        System.out.println("Brewing Espresso...");
    }

    @Override
    public double getPrice() {
        return 70; // Price of Espresso
    }
}

class Cappuccino implements Coffee {
    @Override
    public void prepare() {
        System.out.println("Brewing Cappuccino...");
    }

    @Override
    public double getPrice() {
        return 50; // Price of Cappuccino
    }
}

class CoffeeFactory {
    public static Coffee createCoffee(String type) {
        if (type.equalsIgnoreCase("Espresso")) {
            return new Espresso();
        } else if (type.equalsIgnoreCase("Cappuccino")) {
            return new Cappuccino();
        } else {
            throw new IllegalArgumentException("Unknown coffee type");
        }
    }
}

// 3. Observer Pattern
interface Observer {
    void update(String message);
}

class MaintenanceTeam implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Maintenance team notified: " + message);
    }
}

class CoffeeVendingMachine {
    private VendingMachineState idleState;
    private VendingMachineState waitingState;
    private VendingMachineState brewingState;
    private VendingMachineState dispensingState;
    private VendingMachineState currentState;
    
    private String coffeeType;
    private List<Observer> observers = new ArrayList<>();
    private Coffee coffee;

    public CoffeeVendingMachine() {
        idleState = new IdleState(this);
        waitingState = new WaitingState(this);
        brewingState = new BrewingState(this);
        dispensingState = new DispensingState(this);
        currentState = idleState;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void selectCoffee(String coffeeType) {
        currentState.selectCoffee(coffeeType);
    }

    public void brewCoffee() {
        currentState.brewCoffee();
    }

    public void dispenseCoffee() {
        currentState.dispenseCoffee();
    }

    public void setState(VendingMachineState state) {
        currentState = state;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getWaitingState() {
        return waitingState;
    }

    public VendingMachineState getBrewingState() {
        return brewingState;
    }

    public VendingMachineState getDispensingState() {
        return dispensingState;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // 4. Command Pattern (used internally for actions)
    public void placeOrder(String coffeeType) {
        insertCoin();
        selectCoffee(coffeeType);
        brewCoffee();
        dispenseCoffee();
    }

    // 5. QR Code Pattern (simulating QR code generation)
    public void generateQRCode() {
        System.out.println("Generating QR code for your order...");
        // Simulate generating a QR code (usually involves an external library)
        System.out.println("QR Code: [OrderID1234]");
    }

    // Set the coffee object after selection
    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public Coffee getCoffee() {
        return coffee;
    }
}

public class CoffeeVendingMachineApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeVendingMachine machine = new CoffeeVendingMachine();
        
        // Registering an observer (Maintenance team)
        Observer maintenance = new MaintenanceTeam();
        machine.addObserver(maintenance);

        // Welcome message and available coffee options
        System.out.println("Welcome to the Coffee Vending Machine!");
        System.out.println("Please select your coffee type:");
        System.out.println("1. Espresso - 70/-");
        System.out.println("2. Cappuccino - 50/-");

        // Get user's choice
        int choice = scanner.nextInt();
        String selectedCoffee = "";
        double price = 0;

        switch (choice) {
            case 1:
                selectedCoffee = "Espresso";
                price = 70;  // Price of Espresso
                break;
            case 2:
                selectedCoffee = "Cappuccino";
                price = 50;  // Price of Cappuccino
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        // Simulate generating QR code for payment immediately after selection
        machine.generateQRCode();
        System.out.println("Please pay the amount: $" + price);

        // Simulate payment process (For simplicity, we proceed after QR code generation)

        // Set the selected coffee and proceed
        Coffee coffee = CoffeeFactory.createCoffee(selectedCoffee);
        machine.setCoffee(coffee);

        // Simulating interaction with the machine
        machine.insertCoin();
        machine.selectCoffee(selectedCoffee);
        machine.brewCoffee();
        machine.dispenseCoffee();

        // Coffee preparation
        coffee.prepare();

        // No repeated output for maintenance notification (only print once after process)
        machine.notifyObservers("Low on milk!");

        // Command pattern - executing a sequence of actions
       // machine.placeOrder(selectedCoffee);
    }
}

