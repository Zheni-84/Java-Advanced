package SetsAndMapsLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> guest = new TreeSet<>();

		String reservationNumber = sc.nextLine();
		while (!reservationNumber.equals("PARTY")) {
			guest.add(reservationNumber);
			reservationNumber = sc.nextLine();
		}
		String guestReservation = sc.nextLine();
		while (!guestReservation.equals("END")) {
			guest.remove(guestReservation);

			guestReservation = sc.nextLine();
		}
		System.out.println(guest.size());
		System.out.println(String.join(System.lineSeparator(), guest));
	}

}
