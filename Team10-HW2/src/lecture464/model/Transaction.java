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
		if((!db.address.equals(user.address))
			||(db.creditCardNumber!=user.creditCardNumber)
			||(!db.cvv.equals(user.cvv))
			||(!db.expirationDate.equals(user.expirationDate))
			||(!db.cardType.equals(user.cardType))
			||(!db.name.equals(user.name))) {
			isValidate = false;
		}
		if(db.balance<user.balance) {
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
