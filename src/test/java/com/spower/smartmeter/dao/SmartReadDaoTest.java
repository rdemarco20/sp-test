package com.spower.smartmeter.dao;

import com.spower.smartmeter.model.RawSmartReading;
import com.spower.smartmeter.service.SmartReadException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SmartReadDaoTest {

    @Mock
    Map<String, RawSmartReading> smartReadingMap;

    @InjectMocks
    SmartReadDao smartReadDao;

    @Before
    public void setUp() {
        when(smartReadingMap.get("acc1")).thenReturn(new RawSmartReading("acc1", "gasID", "elecId", 12345, 54231));
    }

    @Test
    public void testFindSmartMeterReading_foundAccount() throws SmartReadException {
        RawSmartReading reading = smartReadDao.findSmartMeterReading("acc1");
        assertEquals("acc1", reading.getAccountNumber());
        assertEquals("gasID", reading.getGasId());
        assertEquals("elecId", reading.getElecId());
        assertEquals(12345, reading.getGasSmartRead());
        assertEquals(54231, reading.getElecSmartRead());
        verify(smartReadingMap, times(1)).get(eq("acc1"));
    }

    @Test(expected = SmartReadException.class)
    public void testFindSmartMeterReading_notFoundAccount() throws SmartReadException {
        smartReadDao.findSmartMeterReading("12312");
    }
}
