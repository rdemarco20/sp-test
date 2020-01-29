package com.spower.smartmeter.model;

public class RawSmartReading {

    private final String accountNumber;
    private final String gasId;
    private final String elecId;
    private final int gasSmartRead;
    private final int elecSmartRead;

    public RawSmartReading(String accountNumber, String gasId, String elecId, int gasSmartRead, int elecSmartRead) {
        this.accountNumber = accountNumber;
        this.gasId = gasId;
        this.elecId = elecId;
        this.gasSmartRead = gasSmartRead;
        this.elecSmartRead = elecSmartRead;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getGasId() {
        return gasId;
    }

    public String getElecId() {
        return elecId;
    }

    public int getElecSmartRead() {
        return elecSmartRead;
    }

    public int getGasSmartRead() {
        return gasSmartRead;
    }

    @Override
    public String toString() {
        return "RawSmartReading{" +
                "accountNumber='" + accountNumber + '\'' +
                ", gasId='" + gasId + '\'' +
                ", elecId='" + elecId + '\'' +
                ", elecSmartRead=" + elecSmartRead +
                ", gasSmartRead=" + gasSmartRead +
                '}';
    }
}
