package telran.people;
import java.util.*;
public class CompanyImpl implements Company {

	private static final long serialVersionUID = 1L;

	private HashMap<Long, Employee> employees = new HashMap<>();
	private TreeMap<Integer, List<Employee>> employeesSalary = new TreeMap<>();
	private HashMap<String, List<Employee>> employeesDepartment = new HashMap<>();
	//try to use streams
	private CompanyImpl() {
		
	}
	public static Company CreateCompany(String fileName) throws Exception{
		//TODO
		return null;
	}
	@Override
	public Iterable<Employee> getAllEmployees() {
		// TODO 
		//if file exists it restore Company from file, otherWise returns empty CompanyImpl object
		return null;
	}

	@Override
	public void addEmployee(Employee empl) throws Exception {
		// TODO 

	}

	@Override
	public void save(String filePath) throws Exception {
		// TODO 

	}

	@Override
	public Iterable<Employee> getEmployeesDepartment(String department) {
		// TODO 
		return null;
	}

	@Override
	public Iterable<Employee> getEmployeesSalary(int salaryFrom, int salaryTo) {
		// TODO 
		return null;
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO 
		return null;
	}

}
