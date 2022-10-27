package telran.people;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CompanyImpl implements Company {

	private HashMap<Long, Employee> employees = new HashMap<>();
	private TreeMap<Integer, List<Employee>> employeesSalary = new TreeMap<>();
	private HashMap<String, List<Employee>> employeesDepartment = new HashMap<>();
	private static final long serialVersionUID = 1L;
	
	private CompanyImpl() {
		
	}
	public static Company createCompany(String fileName) throws Exception {
		//if file exists it restore Company from file, otherwise returns empty CompanyImpl object
		CompanyImpl company = new CompanyImpl();	
		if(new File(fileName).exists()) {
			try(ObjectInputStream input = new ObjectInputStream(
					new FileInputStream(fileName))){
				company = (CompanyImpl) input.readObject();
			}
		} 
		return company;
	}

	@Override
	public Iterable<Employee> getAllEmployees() {
		
		return new ArrayList<Employee>(employees.values());
	}


	@Override
	public void addEmployee(Employee empl) throws Exception {
		if(employees.putIfAbsent(empl.getId(), empl) != null) {
			throw new Exception("Employee already exist");
		}
		employees.put(empl.getId(), empl);
		employeesSalary.computeIfAbsent(empl.getSalary(), k -> new ArrayList<Employee>()).add(empl);
		employeesDepartment.computeIfAbsent(empl.getDepartment(), k -> new ArrayList<Employee>()).add(empl);
	}

	@Override
	public void save(String filePath) throws Exception {
		try(ObjectOutputStream output = new ObjectOutputStream(
				new FileOutputStream(filePath))){
			output.writeObject(this);
		}
	}

	@Override
	public Iterable<Employee> getEmployeesDepartment(String department) {
	
		return new ArrayList<Employee>(employeesDepartment.get(department));
	}

	@Override
	public Iterable<Employee> getEmployeesSalary(int salaryFrom, int salaryTo) {
		
		return employeesSalary.subMap(salaryFrom, salaryTo)
		.entrySet()
		.stream().flatMap(x -> x.getValue().stream())
		.collect(Collectors.toList());
	}

	@Override
	public Employee getEmployee(long id) {
		
		return employees.get(id);
	}
	

			

}
