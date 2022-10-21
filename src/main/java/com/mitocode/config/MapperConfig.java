package com.mitocode.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("estudianteMapper")
    public ModelMapper categoryMapper(){
        return new ModelMapper();
    }

    @Bean("cursoMapper")
    public ModelMapper roleMapper(){
        return new ModelMapper();
    }

    @Bean("matriculaMapper")
    public ModelMapper clientMapper(){
        return new ModelMapper();
    }

    @Bean("providerMapper")
    public ModelMapper providerMapper(){
        return new ModelMapper();
    }

    @Bean("userMapper")
    public ModelMapper userMapper() {
        return new ModelMapper();
    }

    @Bean("saleMapper")
    public ModelMapper saleMapper() {
        ModelMapper mapper = new ModelMapper();
        //mapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));
        return mapper;
    }

}
