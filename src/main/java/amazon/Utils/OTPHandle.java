package amazon.Utils;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public class OTPHandle {

	public static final String ACCOUNT_SID = "AC5567dd38d7d406ab1467e82d93c05ef6";
	public static final String AUTH_TOKEN = "11bc017126e380986448a4a663ba8544";

	public static String getMessage() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
				.filter(m -> m.getTo().equals("+16672205141")).map(Message::getBody).findFirst()
				.orElseThrow(IllegalStateException::new);
	}

	private static Stream<Message> getMessages() {
		ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
		return StreamSupport.stream(messages.spliterator(), false);
	}
}
