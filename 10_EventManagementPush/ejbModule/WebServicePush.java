
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;




@WebService(serviceName = "EventManagementPush")
@Stateless
public class WebServicePush {

	@WebMethod(operationName = "sendPush")
	public Integer sendPush(@WebParam(name = "msg") String msg) {

		Push.send();
		// defaultPushSender.send(message);

		return 200;
	}

}
