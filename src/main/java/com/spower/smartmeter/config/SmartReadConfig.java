package com.spower.smartmeter.config;

import com.spower.smartmeter.api.SmartReadResource;
import com.spower.smartmeter.dao.SmartReadDao;
import com.spower.smartmeter.model.RawSmartReading;
import com.spower.smartmeter.service.SmartReadService;
import com.spower.smartmeter.service.SmartReadServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
public class SmartReadConfig {

    @Bean
    public SmartReadService smartReadService(SmartReadDao smartReadDao) {
        return new SmartReadServiceImpl(smartReadDao);

    }

    @Bean
    public SmartReadDao smartReadDao() {
        Map<String, RawSmartReading> smartReadingMap = new HashMap<>();
        smartReadingMap.put("dual1", new RawSmartReading("dual1", UUID.randomUUID().toString(), UUID.randomUUID().toString(), 12345, 54231));
        smartReadingMap.put("gas1", new RawSmartReading("gas1", UUID.randomUUID().toString(), null, 5213, 0));
        smartReadingMap.put("elec1", new RawSmartReading("elec1", null, UUID.randomUUID().toString(), 0, 123));
        smartReadingMap.put("dual2", new RawSmartReading("dual2", UUID.randomUUID().toString(), UUID.randomUUID().toString(), 626, 123));
        return new SmartReadDao(smartReadingMap);
    }

    @Bean
    public SmartReadResource smartReadResource(SmartReadService smartReadService) {
        return new SmartReadResource(smartReadService);
    }


}
