package DefiningClasses.CompanyRoster;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int countOfEmployee = Integer.parseInt(sc.nextLine());
		Map<String, Department> departmentMap = new HashMap<>();

		for (int i = 0; i < countOfEmployee; i++) {
			String[] employeeInfo = sc.nextLine().split(" ");
			String name = employeeInfo[0];
			double salary = Double.parseDouble(employeeInfo[1]);
			String position = employeeInfo[2];
			String department = employeeInfo[3];
			Employee employee = null;
			switch (employeeInfo.length) {
				case 4:
					employee = new Employee(name, salary, position, department);
					break;
				case 5:
					if (employeeInfo[4].matches("\\d+")) {
						int age = Integer.parseInt(employeeInfo[4]);
						employee = new Employee(name, salary, position, department, age);
					} else {
						String email = employeeInfo[4];
						employee = new Employee(name, salary, position, department, email);
					}
					break;
				case 6:
					String email = employeeInfo[4];
					int age = Integer.parseInt(employeeInfo[5]);
					employee = new Employee(name, salary, position, department, email, age);
					break;
			}
			departmentMap.putIfAbsent(department, new Department(department));
			departmentMap.get(department).getEmployees().add(employee);
		}
		Optional<Map.Entry<String, Department>> departmentEntry = departmentMap.entrySet().stream()
				.max(Comparator.comparingDouble(e -> e.getValue().calculateAverageSalary()));
		Department highestPaidDepartment = null;
		if (departmentEntry.isPresent()) {
			highestPaidDepartment = departmentEntry.get().getValue();
			System.out.println("Highest Average Salary: " + highestPaidDepartment.getName());

			highestPaidDepartment.getEmployees().stream()
					.sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
					//.sorted((e1, e2) -> Double.(e2.getSalary() - e1.getSalary()))
					.forEach(System.out::println);
		}
	}

}
