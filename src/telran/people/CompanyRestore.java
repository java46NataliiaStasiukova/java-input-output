package telran.people;
import java.util.stream.*;
public class CompanyRestore {

	public static void main(String[] args) throws Exception {
		if(args.length < 1) {
			throw new Exception("Arguments not found");
		}
		try {
			Company company = CompanyImpl.createCompany(args[0]);
			String department = getDepartment(company);
			printDepartment(department, company);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printDepartment(String department, Company company) {
		for(Employee e: company.getEmployeesDepartment(department)) {
			System.out.println(e.toString());
		}
		
	}

	private static String getDepartment(Company company) {
		String res = StreamSupport.stream(company.getAllEmployees().spliterator(), false)
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)))
				.entrySet().stream().sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue())).findFirst()
				.orElse(null).getKey();

		return res;
	}

}
