/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 *
 * @author DELL
 */
public class TestJDBC {
    public static void main(String[] args) {
       ApplicationContext context=new ClassPathXmlApplicationContext("resources/ConnectDB.xml");
       Database database=(Database) context.getBean("database");
       database.getListProduct();
    }
}
