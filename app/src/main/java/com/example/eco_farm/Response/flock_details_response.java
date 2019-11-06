package com.example.eco_farm.Response;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class flock_details_response {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("Information")
    @Expose
    private List<Information> information = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Information> getInformation() {
        return information;
    }

    public void setInformation(List<Information> information) {
        this.information = information;
    }
    public class Information {

        @SerializedName("flock_id")
        @Expose
        private String flockId;
        @SerializedName("flock_name")
        @Expose
        private String flockName;
        @SerializedName("flock_breed")
        @Expose
        private String flockBreed;
        @SerializedName("flock_source")
        @Expose
        private String flockSource;
        @SerializedName("chick_qty")
        @Expose
        private String chickQty;
        @SerializedName("hen_qty")
        @Expose
        private String henQty;
        @SerializedName("cock_qty")
        @Expose
        private String cockQty;
        @SerializedName("flock_description")
        @Expose
        private String flockDescription;
        @SerializedName("acquired_date")
        @Expose
        private String acquiredDate;
        @SerializedName("registration_date")
        @Expose
        private String registrationDate;

        public String getFlockId() {
            return flockId;
        }

        public void setFlockId(String flockId) {
            this.flockId = flockId;
        }

        public String getFlockName() {
            return flockName;
        }

        public void setFlockName(String flockName) {
            this.flockName = flockName;
        }

        public String getFlockBreed() {
            return flockBreed;
        }

        public void setFlockBreed(String flockBreed) {
            this.flockBreed = flockBreed;
        }

        public String getFlockSource() {
            return flockSource;
        }

        public void setFlockSource(String flockSource) {
            this.flockSource = flockSource;
        }

        public String getChickQty() {
            return chickQty;
        }

        public void setChickQty(String chickQty) {
            this.chickQty = chickQty;
        }

        public String getHenQty() {
            return henQty;
        }

        public void setHenQty(String henQty) {
            this.henQty = henQty;
        }

        public String getCockQty() {
            return cockQty;
        }

        public void setCockQty(String cockQty) {
            this.cockQty = cockQty;
        }

        public String getFlockDescription() {
            return flockDescription;
        }

        public void setFlockDescription(String flockDescription) {
            this.flockDescription = flockDescription;
        }

        public String getAcquiredDate() {
            return acquiredDate;
        }

        public void setAcquiredDate(String acquiredDate) {
            this.acquiredDate = acquiredDate;
        }

        public String getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
        }

    }

}