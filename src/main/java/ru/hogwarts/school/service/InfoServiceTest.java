package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class InfoServiceTest implements InfoService{

    Logger logger = LoggerFactory.getLogger(InfoServiceTest.class);

    @Value("${server.port}")
    private String port;

    public String getPort() {
        logger.debug("Вызван метод getPort");
        return port;
    }
}
