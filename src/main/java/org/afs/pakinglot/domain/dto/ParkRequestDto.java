package org.afs.pakinglot.domain.dto;

public class ParkRequestDto {
    private String plateNumber;
    private int strategyIndex;

    // Getters and setters
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getStrategyIndex() {
        return strategyIndex;
    }

    public void setStrategyIndex(int strategyIndex) {
        this.strategyIndex = strategyIndex;
    }
}