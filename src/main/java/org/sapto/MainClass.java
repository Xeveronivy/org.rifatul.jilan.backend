package org.sapto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainClass {
    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);


        /*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(configsm.class);
        ctx.refresh();
        BukuService bs = ctx.getBean(BukuService.class);
        Buku bukuHasil = bs.getDataBukuAll();
        System.out.println("===>" + bukuHasil.getJudulBuku());
    }*/
    }
}