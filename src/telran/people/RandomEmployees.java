package telran.people;

import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

public class RandomEmployees {

	public static void main(String[] args) throws Exception {
		if(args.length < 2) {
			throw new Exception("No arguments found");
		}
		FileReader reader = new FileReader(args[0]);
		Properties props = new Properties();
		props.load(reader);
		Company company = CompanyImpl.createCompany(args[1]);
		createRandomEmployees(props, company);
		company.save(args[1]);
	}

	private static void createRandomEmployees(Properties props, Company company) throws Exception {
		int N_Employees = Integer.parseInt(props.getProperty("N_Employees"));
		int minSalary = Integer.parseInt(props.getProperty("MinSalary"));
		int maxSalary = Integer.parseInt(props.getProperty("MaxSalary"));
		String[] departments = props.getProperty("Departments").split(",");
		
		for(int i = 0; i < N_Employees; i++) {
			Employee empl = new Employee(i, "name".concat(Integer.toString(i)),
					getDepartment(departments), getSalary(minSalary, maxSalary));
			company.addEmployee(empl);		
		}	
	}

	private static int getSalary(int minSalary, int maxSalary) {
		int index = (new Random().nextInt(minSalary, maxSalary)/100) * 100;
		return index;
	}

	private static String getDepartment(String[] departments) {
		int index = new Random().nextInt(departments.length);
		return departments[index];
	}

}