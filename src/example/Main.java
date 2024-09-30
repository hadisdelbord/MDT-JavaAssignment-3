package example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

class Engine {

	protected String model;

	public Engine(String model) {
		this.setModel(model);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}

class CombustionEngine extends Engine {

	private String fuelType;

	public CombustionEngine(String model, String fuelType) {
		super(model);
		this.setFuelType(fuelType);
	}

	@Override
	public String toString() {
		return "CombustionEngine [fuelType=" + fuelType + ", model=" + model + "]";
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
}

class ElectricEngine extends Engine {

	@Override
	public String toString() {
		return "ElectricEngine [batteryCapacity=" + batteryCapacity + ", model=" + model + "]";
	}

	private int batteryCapacity;

	public ElectricEngine(String model, int batteryCapacity) {
		super(model);
		this.setBatteryCapacity(batteryCapacity);
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
}

class HybridEngine extends Engine {

	@Override
	public String toString() {
		return "HybridEgine [combustionEngine=" + combustionEngine + ", electricEngine=" + electricEngine + ", model="
				+ model + "]";
	}

	private CombustionEngine combustionEngine;
	private ElectricEngine electricEngine;

	public HybridEngine(String model, CombustionEngine combustionEngine, ElectricEngine electricEngine) {
		super(model);
		this.setCombustionEngine(combustionEngine);
		this.setElectricEngine(electricEngine);
	}

	public CombustionEngine getCombustionEngine() {
		return combustionEngine;
	}

	public void setCombustionEngine(CombustionEngine combustionEngine) {
		this.combustionEngine = combustionEngine;
	}

	public ElectricEngine getElectricEngine() {
		return electricEngine;
	}

	public void setElectricEngine(ElectricEngine electricEngine) {
		this.electricEngine = electricEngine;
	}
}

class Manufacture {

	@Override
	public String toString() {
		return "Manufacture [name=" + name + "]";
	}

	private String name;

	public Manufacture(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

abstract class Vehicle {
	public Vehicle(int id, Manufacture manufacture, int yearOfManufacture, Engine engine, double price, String color,
			int registerationNumber) {
		super();
		this.id = id;
		this.manufacture = manufacture;
		this.yearOfManufacture = yearOfManufacture;
		this.engine = engine;
		this.price = price;
		this.color = color;
		this.registerationNumber = registerationNumber;
	}

	public int getId() {
		return id;
	}

	public Manufacture getManufacture() {
		return manufacture;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public Engine getEngine() {
		return engine;
	}

	public double getPrice() {
		return price;
	}

	public String getColor() {
		return color;
	}

	public int getRegisterationNumber() {
		return registerationNumber;
	}

	protected int id;
	protected Manufacture manufacture;
	protected int yearOfManufacture;

	protected Engine engine;
	protected double price;
	protected String color;
	protected int registerationNumber;

	abstract String ShowCharacterstics();
}

class ICEV extends Vehicle {

	@Override
	public String toString() {
		return "ICEV [id=" + id + ", manufacture=" + manufacture + ", yearOfManufacture=" + yearOfManufacture
				+ ", engine=" + engine + ", price=" + price + ", color=" + color + ", registerationNumber="
				+ registerationNumber + "]";
	}

	public ICEV(int id, Manufacture manufacture, int yearOfManufacture, CombustionEngine engine, double price,
			String color, int registerationNumber) {
		super(id, manufacture, yearOfManufacture, engine, price, color, registerationNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ShowCharacterstics() {
		// TODO Auto-generated method stub
		return this.toString();
	}

}

class BEV extends Vehicle {

	@Override
	public String toString() {
		return "BEV [id=" + id + ", manufacture=" + manufacture + ", yearOfManufacture=" + yearOfManufacture
				+ ", engine=" + engine + ", price=" + price + ", color=" + color + ", registerationNumber="
				+ registerationNumber + "]";
	}

	public BEV(int id, Manufacture manufacture, int yearOfManufacture, ElectricEngine engine, double price,
			String color, int registerationNumber) {
		super(id, manufacture, yearOfManufacture, engine, price, color, registerationNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	String ShowCharacterstics() {
		// TODO Auto-generated method stub
		return this.toString();
	}

}

class HybridV extends Vehicle {

	public HybridV(int id, Manufacture manufacture, int yearOfManufacture, HybridEngine engine1, double price,
			String color, int registerationNumber) {
		super(id, manufacture, yearOfManufacture, engine1, price, color, registerationNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	String ShowCharacterstics() {
		// TODO Auto-generated method stub
		return this.toString();
	}

	@Override
	public String toString() {
		return "HybridV [id=" + id + ", manufacture=" + manufacture + ", yearOfManufacture=" + yearOfManufacture
				+ ", engine=" + engine + ", price=" + price + ", color=" + color + ", registerationNumber="
				+ registerationNumber + "]";
	}

}

public class Main {

	static void SaveToFile(String str) {
		String FilePath = "./output.txt";

		try {
			FileWriter fileWriter = new FileWriter(FilePath);

			BufferedWriter bw = new BufferedWriter(fileWriter);

			bw.write(str);

			bw.close();

			System.out.println("Data saved to " + FilePath);
		} catch (IOException e) {
			System.out.println("An error occurred while writing to the file.");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Manufacture toyota = new Manufacture("Toyota");
		Manufacture tesla = new Manufacture("Tesla");
		Manufacture ford = new Manufacture("Ford");
		Manufacture nissan = new Manufacture("Nissan");
		Manufacture chevrolet = new Manufacture("Chevrolet");
		Manufacture bmw = new Manufacture("BMW");
		Manufacture audi = new Manufacture("Audi");

		CombustionEngine iceEngine = new CombustionEngine("V8", "Gasoline");
		CombustionEngine hybridICEEngine = new CombustionEngine("V6", "Hybrid Fuel");
		ElectricEngine engine1 = new ElectricEngine("Model S Motor", 400); // 100 kWh battery
		ElectricEngine engine2 = new ElectricEngine("Leaf Motor", 150); // 62 kWh battery
		ElectricEngine engine3 = new ElectricEngine("Bolt EV Motor", 200); // 66 kWh battery
		ElectricEngine engine4 = new ElectricEngine("i3 Motor", 170); // 42 kWh battery
		ElectricEngine engine5 = new ElectricEngine("e-tron Motor", 355); // 95 kWh battery
		HybridEngine hengine1 = new HybridEngine("Prius Engine", iceEngine, engine3);
		HybridEngine hengine2 = new HybridEngine("Accord Hybrid Engine", hybridICEEngine, engine2);
		HybridEngine hengine3 = new HybridEngine("Fusion Hybrid Engine", iceEngine, engine5);

		ICEV icev = new ICEV(101, toyota, 2022, iceEngine, 30000.0, "Red", 123456);

		BEV bev1 = new BEV(301, tesla, 2023, engine1, 85000.0, "White", 789123);
		BEV bev2 = new BEV(302, nissan, 2022, engine2, 32000.0, "Silver", 456789);
		BEV bev3 = new BEV(303, chevrolet, 2023, engine3, 37000.0, "Red", 123789);
		BEV bev4 = new BEV(304, bmw, 2021, engine4, 44000.0, "Black", 987654);
		BEV bev5 = new BEV(305, audi, 2024, engine5, 90000.0, "Blue", 852963);

		HybridV hybrid1 = new HybridV(401, toyota, 2022, hengine1, 27000.0, "Green", 321654);
		HybridV hybrid2 = new HybridV(402, nissan, 2023, hengine2, 35000.0, "Black", 654987);
		HybridV hybrid3 = new HybridV(403, ford, 2021, hengine3, 32000.0, "White", 987321);

		Vehicle vehicles[] = { icev, bev1, bev2, bev3, bev4, bev5, hybrid1, hybrid2, hybrid3 };

		Set<String> validInputs = Set.of("a", "b", "c", "e");
		Scanner scanner = new Scanner(System.in);

		System.out.println("" + "a) a list of cars of a given brand \n"
				+ "b) a list of cars of a given model that have been in use for more than n years \n"
				+ "c) a list of cars of a given year of manufacture, the price of which is higher than the specified one \n"
				+ "e) Exit\n" + "Select one filtering:");

		String FilterType = scanner.nextLine();
		String ListOutput = "";

		do {

			if (FilterType.equalsIgnoreCase("a")) {

				System.out.print("name of brand: ");
				String inputText = scanner.nextLine();
				for (Vehicle c : vehicles) {
					if (c.getManufacture().getName().equalsIgnoreCase(inputText)) {
						ListOutput += c.toString() + '\n';
					}
				}
				break;

			} else if (FilterType.equalsIgnoreCase("b")) {

				System.out.print("Enter the model: ");
				String ModelInput = scanner.nextLine();
				System.out.print("Minimum Years of use: ");
				String MinUseYears = scanner.nextLine();

				for (Vehicle c : vehicles) {
					if (c.getEngine().getModel().equalsIgnoreCase(ModelInput)
							&& (2025 - c.getYearOfManufacture()) >= Integer.valueOf(MinUseYears)) {
						ListOutput = ListOutput + c.toString() + '\n';
					}
				}
				break;

			} else if (FilterType.equalsIgnoreCase("c")) {

				System.out.print("Enter the year of manufacture: ");
				String YearOfManufactureInpute = scanner.nextLine();
				System.out.print("Minimum price: ");
				String MinPrice = scanner.nextLine();

				for (Vehicle c : vehicles) {
					if (c.getYearOfManufacture() == Integer.valueOf(YearOfManufactureInpute)
							&& c.getPrice() > Integer.valueOf(MinPrice)) {
						ListOutput = ListOutput + c.toString() + '\n';
					}
				}
				break;

			} else if (FilterType.equalsIgnoreCase("e")) {

				System.out.println("GoodBye!");
				System.exit(0);
			} else {
				System.out.println("[ERROR] Please choose right filtering!");
			}

			System.out.println("" + "a) a list of cars of a given brand \n"
					+ "b) a list of cars of a given model that have been in use for more than n years \n"
					+ "c) a list of cars of a given year of manufacture, the price of which is higher than the specified one \n"
					+ "e) Exit \n" + "Select one filtering ? ");

			FilterType = scanner.nextLine();

		} while (true);

		if (!ListOutput.equals("")) {
			SaveToFile(ListOutput);
		} else {
			System.out.println("There is not any Cars with the properties");
		}
	}

}
