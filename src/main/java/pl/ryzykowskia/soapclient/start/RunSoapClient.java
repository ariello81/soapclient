package pl.ryzykowskia.soapclient.start;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.concretepage.wsdl.GetStudentResponse;

import pl.ryzykowskia.soapclient.client.StudentClient;
import pl.ryzykowskia.soapclient.config.ClientAppConfig;

public class RunSoapClient {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	    ctx.register(ClientAppConfig.class);
	    ctx.refresh();
	    
		StudentClient studentClient = ctx.getBean(StudentClient.class);
		System.out.println("For Student Id: 1");
		GetStudentResponse response = studentClient.getStudentById(1);
		System.out.println("Name:"+response.getStudent().getName());
		System.out.println("Age:"+response.getStudent().getAge());
		System.out.println("Class:"+response.getStudent().getClazz());
	}
} 
