package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.Department;
import entites.HourContract;
import entites.Worker;
import entites.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.print("Enter department's name: ");
		String department=sc.nextLine();
		System.out.println("Enter Work data:");
		System.out.print("Name: ");
		String name=sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base Salary:");
		double baseSalary=sc.nextDouble();
		Worker worker = new Worker(name,WorkerLevel.valueOf(level),baseSalary,new Department(department));
		
		System.out.println("How many contracts to this worker?");
		int contracts=sc.nextInt();
		
		for (int i=1; i<=contracts; i++) {
			System.out.println("Enter contract "+i+"# data: ");
			System.out.print("Date (DD/MM/yyyy): ");
			Date date=sdf.parse(sc.next());
			System.out.print("Value Per Hour: ");
			double valuePerHour=sc.nextDouble();
			System.out.print("Duration (Hours): ");
			int hours = sc.nextInt();
			
			HourContract hourcontract = new HourContract(date,valuePerHour,hours);
			
		}
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthandyear=sc.next();
		int month = Integer.parseInt(monthandyear.substring(0, 2));
		int year = Integer.parseInt(monthandyear.substring(3));
		System.out.println("Name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		System.out.println("Income for"+monthandyear+" : "+worker.income(year, month));
		
		
	}

}
