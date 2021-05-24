package com.springrest.MilkDistAPI;

import com.springrest.MilkDistAPI.Dao.DailyDistDao;
import com.springrest.MilkDistAPI.Dao.DistReqDao;
import com.springrest.MilkDistAPI.entities.DailyDist;
import com.springrest.MilkDistAPI.entities.DistReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MilkDistApiApplication {




	public static void main(String[] args) {
		SpringApplication.run(MilkDistApiApplication.class, args);

	}




}
