package org.afs.pakinglot.domain.dto;

public class ParkRequestDto {
    private String licenseNumber;
    private int strategyIndex;

    // Getters and setters
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getStrategyIndex() {
        return strategyIndex;
    }

    public void setStrategyIndex(int strategyIndex) {
        this.strategyIndex = strategyIndex;
    }
}