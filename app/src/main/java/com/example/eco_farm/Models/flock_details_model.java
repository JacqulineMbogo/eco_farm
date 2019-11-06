package com.example.eco_farm.Models;

public class flock_details_model {

    private String flockId,
            flockName,
            flockBreed,
            flockSource,
            chickQty,
            henQty,
            cockQty,
            flockDescription,
            acquiredDate,
            registrationDate;

    public flock_details_model(String flockId, String flockName, String flockBreed, String flockSource, String chickQty, String henQty, String cockQty, String flockDescription, String acquiredDate, String registrationDate) {
        this.flockId = flockId;
        this.flockName = flockName;
        this.flockBreed = flockBreed;
        this.flockSource = flockSource;
        this.chickQty = chickQty;
        this.henQty = henQty;
        this.cockQty = cockQty;
        this.flockDescription = flockDescription;
        this.acquiredDate = acquiredDate;
        this.registrationDate = registrationDate;
    }
//getters
    public String getFlockId() {
        return flockId;
    }

    public String getFlockName() {
        return flockName;
    }

    public String getFlockBreed() {
        return flockBreed;
    }

    public String getFlockSource() {
        return flockSource;
    }

    public String getChickQty() {
        return chickQty;
    }

    public String getHenQty() {
        return henQty;
    }

    public String getCockQty() {
        return cockQty;
    }

    public String getFlockDescription() {
        return flockDescription;
    }

    public String getAcquiredDate() {
        return acquiredDate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    //setters


    public void setFlockId(String flockId) {
        this.flockId = flockId;
    }

    public void setFlockName(String flockName) {
        this.flockName = flockName;
    }

    public void setFlockBreed(String flockBreed) {
        this.flockBreed = flockBreed;
    }

    public void setFlockSource(String flockSource) {
        this.flockSource = flockSource;
    }

    public void setChickQty(String chickQty) {
        this.chickQty = chickQty;
    }

    public void setHenQty(String henQty) {
        this.henQty = henQty;
    }

    public void setCockQty(String cockQty) {
        this.cockQty = cockQty;
    }

    public void setFlockDescription(String flockDescription) {
        this.flockDescription = flockDescription;
    }

    public void setAcquiredDate(String acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
