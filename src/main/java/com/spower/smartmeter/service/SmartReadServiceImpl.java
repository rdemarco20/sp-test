package com.spower.smartmeter.service;

import com.spower.smartmeter.dao.SmartReadDao;
import com.spower.smartmeter.model.RawSmartReading;
import com.spower.smartmeter.model.SmartReading;
import org.springframework.util.StringUtils;

public class SmartReadServiceImpl implements SmartReadService {

    private final SmartReadDao smartReadDao;

    public SmartReadServiceImpl(final SmartReadDao smartReadDao) {
        this.smartReadDao = smartReadDao;
    }

    @Override
    public SmartReading readSmartMeter(String accountNumber) throws SmartReadException {
        if(StringUtils.isEmpty(accountNumber)) {
            throw new SmartReadException("No account number specified for read");
        }

        RawSmartReading rawSmartReading = smartReadDao.findSmartMeterReading(accountNumber);

        if(rawSmartReading != null) {
            SmartReading reading = new SmartReading(
                    rawSmartReading.getGasId() != null ? rawSmartReading.getGasSmartRead() : null,
                    rawSmartReading.getElecId() != null ? rawSmartReading.getElecSmartRead() : null);
            return reading;
        } else {
            throw new SmartReadException("Reading for account " + accountNumber + " was not found");
        }


    }
}
