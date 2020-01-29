package com.spower.smartmeter.model;

public class SmartReading {

    private final Integer gasSmartRead;
    private final Integer elecSmartRead;

    public SmartReading(Integer gasSmartRead, Integer elecSmartRead) {
        this.gasSmartRead = gasSmartRead;
        this.elecSmartRead = elecSmartRead;
    }


    public Integer getGasSmartRead() {
        return gasSmartRead;
    }

    public Integer getElecSmartRead() {
        return elecSmartRead;
    }

    @Override
    public String toString() {
        return "SmartReading{" +
                ", gasSmartRead=" + gasSmartRead +
                ", elecSmartRead=" + elecSmartRead +
                '}';
    }
}
