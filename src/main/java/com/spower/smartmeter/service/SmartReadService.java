package com.spower.smartmeter.service;

import com.spower.smartmeter.model.SmartReading;

public interface SmartReadService {

    SmartReading readSmartMeter(String accountNumber) throws SmartReadException;
}
