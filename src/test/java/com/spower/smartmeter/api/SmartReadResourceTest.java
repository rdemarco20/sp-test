package com.spower.smartmeter.api;

import com.spower.smartmeter.model.SmartReading;
import com.spower.smartmeter.service.SmartReadException;
import com.spower.smartmeter.service.SmartReadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SmartReadResourceTest {

    @Mock
    SmartReadService smartReadService;

    @InjectMocks
    SmartReadResource smartReadResource;

    @Test
    public void testReadAccount() {
        SmartReading reading = mock(SmartReading.class);
        when(smartReadService.readSmartMeter(eq("account1"))).thenReturn(reading);
        SmartReading actualReading = smartReadResource.readAccount("account1");
        assertEquals(reading, actualReading);
    }

    @Test(expected = SmartReadException.class)
    public void testReadAccount_exception() {
        doThrow(new SmartReadException("error")).when(smartReadService).readSmartMeter(anyString());
        smartReadResource.readAccount("causesError");
    }
}
