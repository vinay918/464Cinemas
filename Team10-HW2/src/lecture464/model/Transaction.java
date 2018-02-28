package lecture464.model;

public class Transaction {
	private String creditCardNumber;
	private String cardType;
	private String cvv;
	private String expirationDate;
	private double balance;
	private String name;
	private String address;
	
	public Transaction(String creditCardNumber, String cardType, String cvv, String expirationDate, double balance,
			String name, String address) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.cardType = cardType;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
		this.balance = balance;
		this.name = name;
		this.address = address;
	}
	
	public boolean ValidateTransaction(Transaction db, Transaction user) {
		boolean isValidate = true;
		if((!db.getAddress().equals(user.getAddress()))
			||(!db.getCreditCardNumber().equals(user.getCreditCardNumber()))
			||(!db.cvv.equals(user.cvv))
			||(!db.getExpirationDate().equals(user.getExpirationDate()))
			||(!db.getCardType().equals(user.getCardType()))
			||(!db.getName().equals(user.getName()))) {
			isValidate = false;
			System.out.println(db.getAddress().equals(user.getAddress()));
			System.out.println((db.getCreditCardNumber().equals(user.getCreditCardNumber())));
			System.out.println(db.cvv.equals(user.cvv));
			System.out.println(db.getExpirationDate().equals(user.getExpirationDate()));
			System.out.println(db.getCardType().equals(user.getCardType()));
			System.out.println(db.getCardType().equals(user.getCardType()));
			System.out.println(db.getName().equals(user.getName()));
			System.out.println("False at cond 1");
			System.out.println(db.getBalance()+", "+db.getCreditCardNumber()+", "+ db.getAddress()+", "+ db.getCvv()+", "+ db.getExpirationDate()+", "+ db.getName());
			System.out.println(user.getBalance()+", "+user.getCreditCardNumber()+", "+ user.getAddress()+", "+ user.getCvv()+", "+ user.getExpirationDate()+", "+ user.getName());
		}
		if(db.getBalance()<user.getBalance()) {
			isValidate = false;
			System.out.println("False at cond 2");
		}
		return isValidate;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Transaction() {
		super();
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
