package com.temelt.issuemanagement;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

import javax.validation.ConstraintViolationException;

@SpringBootApplication
@Slf4j
public class IssueManagementApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(IssueManagementApplication.class, args);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            log.error("Data zaten var");
        } catch (Exception ex) {
            log.error("Data zaten var 2");
        }
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

//    @Bean
//    public Jackson2RepositoryPopulatorFactoryBean repositoryPopulatorFactoryBean()  {
//
//            Jackson2RepositoryPopulatorFactoryBean factoryBean = new Jackson2RepositoryPopulatorFactoryBean();
//            factoryBean.setResources(new Resource[]{new ClassPathResource("projects.json")});
//            return factoryBean;
//    }
}
