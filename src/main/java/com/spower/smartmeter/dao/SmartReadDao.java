package com.spower.smartmeter.dao;

import com.spower.smartmeter.model.RawSmartReading;
import com.spower.smartmeter.service.SmartReadException;

import java.util.Map;

public class SmartReadDao {

    private final Map<String, RawSmartReading> smartReadingMap;

    public SmartReadDao(Map<String, RawSmartReading> smartReadingMap) {
        this.smartReadingMap = smartReadingMap;
    }

    public RawSmartReading findSmartMeterReading(final String accountNumber) throws SmartReadException {
        RawSmartReading reading = smartReadingMap.get(accountNumber);
        if(reading != null) {
            return reading;
        }
        throw new SmartReadException(String.format("Account with number %s was not found", accountNumber));
    }
}
