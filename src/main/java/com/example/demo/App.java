package com.example.demo;

import java.security.Permission;

public class App {
    public static void main(String[] args) {
        String abc = "ddddaaaa.lllll";
        System.out.println("sa " + abc);
    }
}
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException; 
// import jenkins.model.*
// import hudson.security.*
// import jenkins.*
// import hudson.*

// def defaultPassword = "12345678x@X"
// def line = ""; 
// def splitBy = ",";  
// def instance = Jenkins.getInstance()
// AuthorizationStrategy strategy = Jenkins.get().getAuthorizationStrategy();
// def hudsonRealm = new HudsonPrivateSecurityRealm(false)

// //parsing a CSV file into BufferedReader class constructor  
// BufferedReader br = new BufferedReader(new FileReader("D:\\Book1.csv"));  

// while ((line = br.readLine()) != null)   //returns a Boolean value  
// {  
// 	String[] authorizations = line.split(splitBy); // use comma as separator
	
// 	//create user
// 	user = authorizations[0]
// 	hudsonRealm.createAccount(user,defaultPassword)
// 	instance.setSecurityRealm(hudsonRealm)
// 	instance.save()
	
//     for(int i = 1; i < authorizations.length; i++) {
//        switch(authorizations[i]) {
// 		   case "ADMINISTER": 
// 				strategy.add(Jenkins.ADMINISTER, user);
// 				break;
// 		   case "Overall - Read":  
// 				strategy.add(hudson.model.Hudson.READ, user);
// 				break;
// 		   case "Credentials - Create": 
// 				strategy.add(com.cloudbees.plugins.credentials.CredentialsProvider.CREATE, user);
// 				break;
// 		   default:
// 				break;
// 		}
// 	}
// 	instance.setAuthorizationStrategy(strategy)
// 	instance.save()
// } 

