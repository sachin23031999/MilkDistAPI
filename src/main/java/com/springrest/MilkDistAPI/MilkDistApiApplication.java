package com.springrest.MilkDistAPI;

import com.springrest.MilkDistAPI.Dao.DistReqDao;
import com.springrest.MilkDistAPI.entities.DistReq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MilkDistApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(MilkDistApiApplication.class, args);
	}

}
