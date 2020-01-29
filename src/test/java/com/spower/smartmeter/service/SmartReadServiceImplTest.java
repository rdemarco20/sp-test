package com.spower.smartmeter.service;

import com.spower.smartmeter.dao.SmartReadDao;
import com.spower.smartmeter.model.RawSmartReading;
import com.spower.smartmeter.model.SmartReading;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SmartReadServiceImplTest {

    @Mock
    SmartReadDao smartReadDao;

    @InjectMocks
    SmartReadServiceImpl smartReadService;

    @Test
    public void testReadSmartMeter() throws SmartReadException {
        String accountNum = "account1";
        RawSmartReading reading = new RawSmartReading("gas1", "gasId", "elec", 5213, 12312);
        when(smartReadDao.findSmartMeterReading(accountNum)).thenReturn(reading);

        SmartReading actualReading = smartReadService.readSmartMeter("account1");
        assertEquals(new Integer(5213), actualReading.getGasSmartRead());
        assertEquals(new Integer(12312), actualReading.getElecSmartRead());

        verify(smartReadDao, times(1)).findSmartMeterReading(accountNum);
    }

    @Test(expected = SmartReadException.class)
    public void testReadSmartMeter_nullAccountSupplied() throws SmartReadException {
        smartReadService.readSmartMeter(null);
    }

    @Test(expected = SmartReadException.class)
    public void testReadSmartMeter_emptyAccountSupplied() throws SmartReadException {
        smartReadService.readSmartMeter("");
    }

}
