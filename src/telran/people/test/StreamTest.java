package telran.people.test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import telran.people.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StreamTest {

	private static final long ID = 123;
	private static final String NAME = "Vasya";
	private static final String DEPARTMENT = "QA";
	private static final int SALARY = 10000;
	private static final String EMPLOYEES_FILE = "employees.data";

	@Test
	@Order(1)
	void writeEmployee() throws Exception {
		EmployeeTest empl = new EmployeeTest(ID, NAME, DEPARTMENT, SALARY);
		empl.employee = empl;
		try (ObjectOutputStream output = new ObjectOutputStream(
				new FileOutputStream(EMPLOYEES_FILE))){
			output.writeObject(empl);
		}
	}
	@Test
	@Order(2)
	void readEmployee() throws Exception {
		EmployeeTest empl = null;
		EmployeeTest expected = new EmployeeTest(ID, NAME, DEPARTMENT, SALARY);
		try (ObjectInputStream input =
				new ObjectInputStream(new FileInputStream(EMPLOYEES_FILE))) {
			empl = (EmployeeTest) input.readObject();
		}
		assertEquals(expected, empl.employee);
		new File(EMPLOYEES_FILE).delete();
	}
	@Test
	@Order(10)
	void companyTest() throws Exception {
		Employee empl1 = new Employee(123, NAME, DEPARTMENT, 20000);
		Employee empl2 = new Employee(124, "Sara", DEPARTMENT, 23000);
		Employee empl3 = new Employee(125, NAME, "Java", SALARY);
		Employee empl4 = new Employee(126, "David", "Java", SALARY);
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(empl1);
		employees.add(empl2);
		employees.add(empl3);
		employees.add(empl4);
		List<Employee> emplDepartment = new ArrayList<Employee>();
		emplDepartment.add(empl3);
		emplDepartment.add(empl4);
		List<Employee> emplSalary = new ArrayList<Employee>();
		emplSalary.add(empl1);
		emplSalary.add(empl2);
		
		Company company = CompanyImpl.createCompany("CompanyTest.data");
		company.addEmployee(empl1);
		company.addEmployee(empl2);
		company.addEmployee(empl3);
		company.addEmployee(empl4);
		company.save("CompanyTest.data");
		
		Company company2 = CompanyImpl.createCompany("CompanyTest.data");
		company2.save("CompanyTest.data");
		assertEquals(empl1, company2.getEmployee(123));
		assertEquals(empl2, company2.getEmployee(124));
		assertEquals(empl3, company2.getEmployee(125));
		assertEquals(empl4, company2.getEmployee(126));
		
		Company company3 = CompanyImpl.createCompany("CompanyTest.data");		
		company3.save("SaveCompany.data");
		assertEquals(empl1, company3.getEmployee(123));
		assertEquals(empl2, company3.getEmployee(124));
		assertEquals(empl3, company3.getEmployee(125));
		assertEquals(empl4, company3.getEmployee(126));
		
		
		assertEquals(employees, company.getAllEmployees());
		assertEquals(emplDepartment, company.getEmployeesDepartment("Java"));
		assertEquals(emplSalary, company.getEmployeesSalary(15000, 25000));

		new File("CompanyTest.data").delete();
		new File("SaveCompany.data").delete();
	}

}
