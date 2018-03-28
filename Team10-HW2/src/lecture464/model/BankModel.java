package lecture464.model;

public class BankModel {
	private String creditCardNumber;
	private String cardType;
	private String cvv;
	private String expirationDate;
	private double balance;
	private String name;
	private String address;
	
	public BankModel(String creditCardNumber, String cardType, String cvv, String expirationDate, double balance,
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
	
	public boolean ValidateTransaction(BankModel db, BankModel user) {
		boolean isValidate = true;
		if((!db.getAddress().equals(user.getAddress()))
			||(!db.getCreditCardNumber().equals(user.getCreditCardNumber()))
			||(!db.cvv.equals(user.cvv))
			||(!db.getExpirationDate().equals(user.getExpirationDate()))
			||(!db.getCardType().equals(user.getCardType()))
			||(!db.getName().equals(user.getName()))) {
			isValidate = false;

		}
		if(db.getBalance()<user.getBalance()) {
			isValidate = false;
		}
		return isValidate;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BankModel() {
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
