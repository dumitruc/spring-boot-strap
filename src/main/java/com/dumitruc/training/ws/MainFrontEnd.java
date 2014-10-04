package com.dumitruc.training.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;


/**
 * Created with IntelliJ IDEA.
 * User: dumitruc
 * Date: 03/10/14
 * Time: 23:16
 * To change this template use File | Settings | File Templates.
 */

public class MainFrontEnd {


    public static void main(String[] args) throws Exception {

        ApplicationContext ctx = SpringApplication.run(SampleController.class);


        for (String names: ctx.getBeanDefinitionNames()){
            System.out.println("names = " + names);
        }


        Thread.sleep(60000);
        SpringApplication.exit(ctx, new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                System.out.println("60 sec timeout reached!");
                return 0;
            }
        });
    }
}
