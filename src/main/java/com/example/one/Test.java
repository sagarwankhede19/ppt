package com.example.one;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Test {

	public static void main(String[] args) {
		CamelContext con= new DefaultCamelContext();
		ConnectionFactory connectionFactory= new ConnectionFactory() {
			
			@Override
			public JMSContext createContext(String userName, String password, int sessionMode) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public JMSContext createContext(String userName, String password) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public JMSContext createContext(int sessionMode) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public JMSContext createContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Connection createConnection(String userName, String password) throws JMSException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Connection createConnection() throws JMSException {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
}
