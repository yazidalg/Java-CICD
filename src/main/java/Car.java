/**
 * Car class with multiple code smells:
 * - God class (too many responsibilities)
 * - Long methods
 * - Duplicate code
 * - Primitive obsession
 * - Feature envy
 * - Magic numbers
 * - Inappropriate intimacy
 */
public class Car {
    // Primitive obsession - using primitive types instead of proper value objects
    public String brand;
    public String model;
    public int year;
    public int mileage;
    public String color;
    public double fuelLevel;
    public int maxFuel;
    public double engineTemperature;
    public boolean isEngineOn;
    public boolean headlightsOn;
    public boolean windowsOpen;
    public boolean doorsLocked;
    public String vinNumber;
    public String licensePlate;
    public String ownerName;
    public String ownerAddress;
    public String ownerPhone;
    public String serviceHistory;
    public int serviceCount;
    
    // Bad constructor with too many parameters
    public Car(String brand, String model, int year, int mileage, String color, 
               double fuelLevel, int maxFuel, String vinNumber, String licensePlate,
               String ownerName, String ownerAddress, String ownerPhone) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.color = color;
        this.fuelLevel = fuelLevel;
        this.maxFuel = maxFuel;
        this.engineTemperature = 0.0;
        this.isEngineOn = false;
        this.headlightsOn = false;
        this.windowsOpen = false;
        this.doorsLocked = true;
        this.vinNumber = vinNumber;
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.ownerPhone = ownerPhone;
        this.serviceHistory = "";
        this.serviceCount = 0;
    }
    
    // Long method with multiple responsibilities and duplicate code
    public void startEngine() {
        // Magic numbers
        if (fuelLevel < 1.5) {
            System.out.println("Not enough fuel to start the engine!");
            return;
        }
        
        System.out.println("Starting the engine...");
        isEngineOn = true;
        
        // Complex conditional nesting
        if (year < 2000) {
            if (engineTemperature < 20) {
                System.out.println("Cold start on old car, warming up...");
                for (int i = 0; i < 5; i++) {
                    engineTemperature += 10;
                    System.out.println("Engine temperature: " + engineTemperature);
                    fuelLevel -= 0.2; // Magic number
                }
            } else {
                System.out.println("Warm start on old car");
                engineTemperature += 15;
                fuelLevel -= 0.1; // Magic number
            }
        } else {
            if (engineTemperature < 20) {
                System.out.println("Cold start on modern car, warming up...");
                for (int i = 0; i < 3; i++) {
                    engineTemperature += 15;
                    System.out.println("Engine temperature: " + engineTemperature);
                    fuelLevel -= 0.1; // Magic number
                }
            } else {
                System.out.println("Warm start on modern car");
                engineTemperature += 10;
                fuelLevel -= 0.05; // Magic number
            }
        }
        
        // Feature envy - car is too concerned with calculating dates
        String currentDate = java.time.LocalDate.now().toString();
        serviceHistory += currentDate + ": Engine started at mileage " + mileage + "\n";
    }
    
    // Duplicate code - similar to startEngine
    public void stopEngine() {
        if (!isEngineOn) {
            System.out.println("Engine is already off!");
            return;
        }
        
        System.out.println("Stopping the engine...");
        isEngineOn = false;
        
        // Almost identical to code in startEngine
        if (year < 2000) {
            if (engineTemperature > 80) {
                System.out.println("Cooling down old car engine...");
                for (int i = 0; i < 5; i++) {
                    engineTemperature -= 10;
                    System.out.println("Engine temperature: " + engineTemperature);
                }
            } else {
                System.out.println("Engine temperature normal for old car");
                engineTemperature -= 15;
            }
        } else {
            if (engineTemperature > 90) {
                System.out.println("Cooling down modern car engine...");
                for (int i = 0; i < 3; i++) {
                    engineTemperature -= 15;
                    System.out.println("Engine temperature: " + engineTemperature);
                }
            } else {
                System.out.println("Engine temperature normal for modern car");
                engineTemperature -= 10;
            }
        }
        
        // Feature envy - car is too concerned with calculating dates
        String currentDate = java.time.LocalDate.now().toString();
        serviceHistory += currentDate + ": Engine stopped at mileage " + mileage + "\n";
    }
    
    // God class - too many unrelated methods
    public void changeOwnerDetails(String name, String address, String phone) {
        ownerName = name;
        ownerAddress = address;
        ownerPhone = phone;
        System.out.println("Owner details updated for " + licensePlate);
        
        // Database logic mixed with business logic
        System.out.println("Updating owner details in database...");
        System.out.println("Connecting to DMV database...");
        System.out.println("Sending notification to old owner...");
        System.out.println("Sending notification to new owner...");
        System.out.println("Updating insurance records...");
    }
    
    // Switch statement smell
    public double calculateFuelEfficiency() {
        double efficiency = 0;
        
        switch(brand.toLowerCase()) {
            case "toyota":
                efficiency = 30.5;
                break;
            case "honda":
                efficiency = 31.2;
                break;
            case "ford":
                efficiency = 28.7;
                break;
            case "chevrolet":
                efficiency = 27.5;
                break;
            case "bmw":
                efficiency = 25.0;
                break;
            case "mercedes":
                efficiency = 24.5;
                break;
            case "audi":
                efficiency = 26.0;
                break;
            case "volkswagen":
                efficiency = 29.0;
                break;
            case "hyundai":
                efficiency = 32.5;
                break;
            case "kia":
                efficiency = 33.0;
                break;
            default:
                efficiency = 25.0; // Magic number
        }
        
        // More magic numbers and complex calculation
        if (year < 1990) {
            efficiency *= 0.7;
        } else if (year < 2000) {
            efficiency *= 0.8;
        } else if (year < 2010) {
            efficiency *= 0.9;
        } else if (year < 2015) {
            efficiency *= 0.95;
        } else if (year >= 2020) {
            efficiency *= 1.1;
        }
        
        // Considers mileage
        if (mileage > 200000) {
            efficiency *= 0.75;
        } else if (mileage > 100000) {
            efficiency *= 0.85;
        } else if (mileage > 50000) {
            efficiency *= 0.95;
        }
        
        return efficiency;
    }
    
    // Method with side effects
    public String getCarInfo() {
        mileage += 5; // Side effect: why is getting info changing the mileage?
        return brand + " " + model + " (" + year + "), " + color + ", " + mileage + " miles";
    }
} 