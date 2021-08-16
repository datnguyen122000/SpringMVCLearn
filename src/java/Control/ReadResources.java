/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DELL
 */
@Controller
public class ReadResources {
    @RequestMapping("/resource")
    public String readResources(ModelMap mm){
        ApplicationContext context=new ClassPathXmlApplicationContext();
        /*ĐỌC DỮ LIỆU TỪ FILE TRONG FOLDER RESOURCE*/
        //resource luôn trả về 1 cái InputStream
        Resource resource=context.getResource("classpath:resources/data.txt");
        try {
            InputStream inputStream=resource.getInputStream();
            //inputStreamReader để đọc đc dữ liệu của thằng inputStream
            InputStreamReader reader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String line="";//để nhận dữ liệu từng dòng của thằng buferedReader
            StringBuilder stringBuilder=new StringBuilder();
            while((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line+"\n");
            }
            bufferedReader.close();
            reader.close();
            inputStream.close();
            mm.addAttribute("data1", stringBuilder.toString());
            
        } catch (IOException ex) {
            Logger.getLogger(ReadResources.class.getName()).log(Level.SEVERE, null, ex);
        }
         /*ĐỌC DỮ LIỆU TỪ FILE TRONG FOLDER RESOURCE*/
         
         
        /*ĐỌC DỮ LIỆU  1 FILE TRONG Ổ ĐĨA  */
        //resource luôn trả về 1 cái InputStream
        ApplicationContext context2=new ClassPathXmlApplicationContext();
        Resource resource2=context2.getResource("file:/D:/data.txt");//thêm file:/ vào đầu
        try {
            InputStream inputStream2=resource2.getInputStream();
            //inputStreamReader để đọc đc dữ liệu của thằng inputStream2
            InputStreamReader reader2=new InputStreamReader(inputStream2);
            BufferedReader bufferedReader2=new BufferedReader(reader2);
            String line="";//để nhận dữ liệu từng dòng của thằng buferedReader2
            StringBuilder stringBuilder2=new StringBuilder();
            while((line=bufferedReader2.readLine())!=null){
                stringBuilder2.append(line+"\n");
            }
            bufferedReader2.close();
            reader2.close();
            inputStream2.close();
            mm.addAttribute("data2", stringBuilder2.toString());
        } catch (IOException ex) {
            Logger.getLogger(ReadResources.class.getName()).log(Level.SEVERE, null, ex);
        }
          /*ĐỌC DỮ LIỆU  1 FILE TRONG Ổ ĐĨA */
        return "ReadResource";
    }
}
