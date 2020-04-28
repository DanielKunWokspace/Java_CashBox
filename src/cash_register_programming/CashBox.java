package cash_register_programming;

import java.util.ArrayList;

public class CashBox {
	private ArrayList<Integer> bankNotes;
	private ArrayList<Integer> bankNotePieces;
	private double random;

	public CashBox() {
		bankNotes = new ArrayList<Integer>();
		bankNotePieces = new ArrayList<Integer>();

		bankNotes.add(20000);
		bankNotePieces.add(1);

		bankNotes.add(10000);
		bankNotePieces.add(2);

		bankNotes.add(5000);
		bankNotePieces.add(3);

		bankNotes.add(2000);
		bankNotePieces.add(4);

		bankNotes.add(1000);
		bankNotePieces.add(5);

		bankNotes.add(500);
		bankNotePieces.add(6);

		bankNotes.add(200);
		bankNotePieces.add(6);

		bankNotes.add(100);
		bankNotePieces.add(5);

		bankNotes.add(50);
		bankNotePieces.add(4);

		bankNotes.add(20);
		bankNotePieces.add(3);

		bankNotes.add(10);
		bankNotePieces.add(2);

		bankNotes.add(5);
		bankNotePieces.add(1);

		cashBoxContent();
		System.out.println();

		// ...

	}

	public void cashBoxContent() {
		for (int i = 0; i < bankNotes.size(); i++) {
			System.out.println((bankNotes.get(i) + (" ") + (bankNotePieces.get(i))));
		}
	}

	public int cashBoxMoneyContent() {
		int retVal = 0;
		for (int i = 0; i < bankNotes.size(); i++) {
			retVal += bankNotes.get(i) * bankNotePieces.get(i);
		}

		return retVal;
	}

	public int randomShopping() {
		random = Math.random() * 20000;
		int retVal = (int) random;
		return retVal;

	}

	public int payForShopping() {
		random = Math.random() * 20000;
		int retVal = (int) random;

		return retVal;
	}

	public void putPayable(int payable) {
		for (int i = 0; i < bankNotes.size(); i++) {
			while (payable >= 0) {
				if (payable >= bankNotes.get(i)) {
					payable -= bankNotes.get(i);
					bankNotePieces.set(i, bankNotePieces.get(i) + 1);
					System.out.println(("Your ") + (bankNotes.get(i)) + ("$ added to Cashbox."));
					System.out.println();
				} else {
					break;
				}
			}
		}
	}

	public void giveMoneyBackFromCashBox() {

		int givedBackMoney = 0;

		int payable = randomShopping();
		System.out.println(("The buying will cost: ") + (payable) + ("$"));
		System.out.println();

		int receivedMoney = payForShopping();
		System.out.println(("You gave: ") + (receivedMoney) + ("$"));
		System.out.println();
		if (receivedMoney < cashBoxMoneyContent()) {

			if (receivedMoney >= payable) {

				int moneyBack = receivedMoney - payable;
				System.out.println(("You will have: ") + (moneyBack) + ("$"));
				System.out.println();
				putPayable(receivedMoney);

				for (int i = 0; i < bankNotes.size(); i++) {

					while (moneyBack >= bankNotes.get(i)) {

						if (bankNotePieces.get(i) > 0) {
							moneyBack -= bankNotes.get(i);
							givedBackMoney += bankNotes.get(i);
							bankNotePieces.set(i, bankNotePieces.get(i) - 1);
							System.out.println(bankNotes.get(i) + ("$ -back"));
						} else {
							break;
						}

					}

				}

				System.out.println();
				System.out.println(("Total money back: ") + (givedBackMoney));
				System.out.println();
				cashBoxContent();

			} else {
				System.out.println("You dont have enough money...");
				System.out.println();
			}

		} else {
			System.out.println("Sorry we dont have enough Backmoney");
		}

	}

}
