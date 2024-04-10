//package com.example.payroll.config;
//
//import com.example.payroll.entities.EmployeeEntity;
//import com.example.payroll.repostories.EmployeeRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import static com.example.payroll.enums.EmployeeStatus.NOT_PAID;
//
//
//@Configuration
//public class LoadDatabase {
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//    @Bean
//    CommandLineRunner initDataBase(EmployeeRepository employeeRepository){
//        return args -> {
//            log.info("Preloading " + employeeRepository.save(new EmployeeEntity(1L,"Omar", "Engineer",
//                    3500, NOT_PAID)));
//            log.info("Preloading " + employeeRepository.save(new EmployeeEntity(2L,"Mohammed", "Software Engineer",
//                    6000, NOT_PAID)));
//            log.info("Preloading " + employeeRepository.save(new EmployeeEntity(3L,"Jack", "UI/UX",
//                    4000, NOT_PAID)));
//        };
//    }
//
//}
