package testcases;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import utility.MonitoringMail;
import utility.TestConfig;

public class SendMail {

	public static void main(String[] args) throws AddressException, MessagingException {
		MonitoringMail mail = new MonitoringMail();
		mail.sendMail(TestConfig.server,TestConfig.from, TestConfig.to, TestConfig.subject, 
				TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
		

	}

}
