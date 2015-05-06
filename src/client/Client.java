package client;

import java.rmi.RemoteException;
import java.util.Date;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class Client {
	public static void sayHello(String name){
		String url="http://localhost:8800/axis2_service/services/hello?wsdl";
		Service service=new Service();
		Call call=null;
		try {
			call=(Call) service.createCall();
			call.setTargetEndpointAddress(url);
			call.setOperationName(new QName("http://service","sayHello"));
			call.addParameter("name",XMLType.XSD_STRING,ParameterMode.IN);
			call.setReturnType(XMLType.XSD_STRING);
			try {
				String result=(String) call.invoke(new Object[]{name});
				System.out.println("what is result==="+result);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	public static void showTime(Date date){
		String url="http://localhost:8800/axis2_service/services/hello?wsdl";
		Service service=new Service();
		Call call=null;
		try {
			call=(Call) service.createCall();
			call.setTargetEndpointAddress(url);
			call.setOperationName(new QName("http://service","nowTime"));
			try {
				call.invoke(new Object[]{date});
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Date d=new Date();
		showTime(d);
		sayHello("Lovercy");
		System.out.println("success");
	}

}
