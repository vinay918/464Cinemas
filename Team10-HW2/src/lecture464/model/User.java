package lecture464.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import lecture464.databaseAccessLayer.UserDB;

public class User {
	
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public User(int id, String userName, String password, String firstName, String lastName, String email,
			String phone) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() {
		super();
	}
	
	public void registerUser(User aUser) {
		UserDB dbInterface = new UserDB();
		dbInterface.addUser(aUser);
	}
	
	public Boolean validateUser(User currentUser){
		UserDB dbInterface = new UserDB();
		return dbInterface.userValid(currentUser);
	}
	
	public Boolean userRegistered(User currentUser){
		UserDB dbInterface = new UserDB();
		return dbInterface.existingUser(currentUser);		
	}
	
	public User completeUser(User currentUser){
		UserDB dbInterface = new UserDB();
		return dbInterface.buildUser(currentUser);	
	}
	
	//credit:https://stackoverflow.com/questions/26548059/sending-email-with-ssl-using-javax-mail
	public void sendEmail(User currentUser,String username,String subject, String content){	 
	      String password = "jiayehvinay";

	      Properties props = new Properties();
	      props.put("mail.transport.protocol", "smtp");

	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.socketFactory.port",465);
	      props.put("mail.smtp.socketFactory.class",
	                  "javax.net.ssl.SSLSocketFactory");

	      props.put("mail.smtp.auth", "true");

	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.port", 465);
	      props.put("mail.smtp.timeout", "10000");

	      props.put("mail.smtp.ssl.checkserveridentity", "false");
	      props.put("mail.smtp.ssl.trust", "*");
	      props.put("mail.smtp.connectiontimeout", "10000");

	      props.put("mail.smtp.debug", "true");
	      props.put("mail.smtp.socketFactory.fallback", "false");
	      Session session = Session.getInstance(props,
	              new javax.mail.Authenticator() {
	                  protected PasswordAuthentication getPasswordAuthentication() {
	                      return new PasswordAuthentication(username, password);
	                  }
	              });
	      session.setDebug(true);
	      try {

	          Message message = new MimeMessage(session);
	          message.setFrom(new InternetAddress(username));
	          message.setRecipients(Message.RecipientType.TO,
	                  InternetAddress.parse(currentUser.getEmail()));
	          message.setSubject(subject);
	          message.setText(content);
	          Transport transport = session.getTransport("smtp");
	          transport.send(message);
	          // Transport.send(message);

	      } catch (MessagingException e) {
	          // throw new RuntimeException(e);
	      }
	}	
	
	public Boolean validPhone(User currentUser){
		//taken from: https://stackoverflow.com/questions/5958665/validation-for-a-cell-number-in-android/5959341#5959341
		String regexStr = "^(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?$";
		if (currentUser.getPhone().matches(regexStr)){
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean validEmail(User currentUser){
		//taken from: https://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(currentUser.getEmail());
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
	}
	// removeUser
	
	
}
