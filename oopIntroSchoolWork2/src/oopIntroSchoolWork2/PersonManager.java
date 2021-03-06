package oopIntroSchoolWork2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonManager {

	public void createPerson(Person[] persons) {
		for (Person person : persons) {
			if (person.getClass().getSimpleName().contains("User")) {
				System.out.println(person.getName() + " " + person.getSurName() + " kullanıcısı oluşturuldu.");
			} else {
				System.out.println(person.getName() + " " + person.getSurName() + " eğitmeni oluşturuldu.");
			}
		}
	}
	public void addUserToCourse(Course[] courses, Person[] persons) {

		Scanner inputUserId = new Scanner(System.in);
		System.out.println("Hangi kullanıcıya eğitim atanıyor id' sini giriniz :");
		int userId = inputUserId.nextInt();

		Scanner inputId = new Scanner(System.in);
		System.out.println("Atamak istediğiniz kursların id' lerini giriniz");
		int courseId = inputId.nextInt();

		if (Controller.isExistUser(persons, userId) && Controller.isExistCourse(courses, courseId)) {
			for (Person person : persons) {
				if (person.getId() == userId) {
					User user = (User) person;
					for (Course course : courses) {
						if (course.getId() == courseId) {
							user.setCourse(course);
							return;
						}
					}
				}
			}
		} else {
			System.out.println("Girdiğiniz verilerde eksiklik yada yanlışlık var kontrol ediniz.");
		}

	}
	public void updatePercentToUserCourse(Person[] persons) {

		Scanner inputId = new Scanner(System.in);
		System.out.println("Kurs yüzdesi güncellenmesi istenilen kullanıcı id' sini giriniz :");
		int id = inputId.nextInt();

		Scanner inputYuzdeOrani = new Scanner(System.in);
		System.out.println("Kurs yüzdesini giriniz ");
		int yuzdeOran = inputYuzdeOrani.nextInt();

		if (Controller.isExistUser(persons, id)) {
			for (Person person : persons) {
				if (person.getClass().getSimpleName().equals("User") && person.getId() == id) {
					User user = (User) person;
					user.setKursBitirmeYuzdesi(yuzdeOran);
				}
			}
		} else {
			System.out.println("Girilen id' de kullanıcı bulunmuyor idyi kontrol ediniz.");
		}
	}	
}
