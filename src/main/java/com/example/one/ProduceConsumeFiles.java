package com.example.one;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ProduceConsumeFiles {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the file path: ");
		final String filePath = scanner.nextLine();
//		F:\Training\UseCase\signUp\cricketPlayerRegistration.json
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() {
				from("direct:start").process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						try {
							Path file = Paths.get(filePath);
							String str = new String(Files.readAllBytes(file));
							exchange.getMessage().setBody(exchange.getMessage().getBody() + str);
							
						} catch (NoSuchFileException e) {
							exchange.getMessage().setBody("File not found: " + filePath);
						}
					}
				}).to("seda:end");
			}
		});
		context.start();
		ProducerTemplate template = context.createProducerTemplate();
		template.sendBody("direct:start", "\nYour file data: \n");

		ConsumerTemplate consumerTemplate = context.createConsumerTemplate();
		String message = consumerTemplate.receiveBody("seda:end", String.class);
		System.out.println(message);
	}
}
