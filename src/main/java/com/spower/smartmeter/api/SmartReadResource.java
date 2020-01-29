package com.spower.smartmeter.api;

import com.spower.smartmeter.model.RawSmartReading;
import com.spower.smartmeter.model.SmartReading;
import com.spower.smartmeter.service.SmartReadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("smart")
public class SmartReadResource {

    private static final Logger LOG = LoggerFactory.getLogger(SmartReadResource.class);

    private final SmartReadService smartReadService;

    public SmartReadResource(SmartReadService smartReadService) {
        this.smartReadService = smartReadService;
    }

    @GetMapping(value = "/reads/{accountNumber}", produces = "application/json")
    public SmartReading readAccount(@PathVariable("accountNumber") String accountNumber) {
        return smartReadService.readSmartMeter(accountNumber);
    }

}
