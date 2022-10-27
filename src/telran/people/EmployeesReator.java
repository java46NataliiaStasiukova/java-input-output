package telran.people;

import java.util.List;

public class EmployeesReator {

	public static void main(String[] args) throws Exception {
		if(args.length < 1) {
			throw new Exception("No arguments found");
		}
		Company company = CompanyImpl.createCompany(args[0]);
		List<Employee> department = getDepartment(company);
		printDepartment(department);
	}

	private static void printDepartment(List<Employee> department) {
		// TODO
		
	}

	private static List<Employee> getDepartment(Company company) {
		//TODO
		
		return null;
	}

}
