package myservice.client;

import java.util.List;

public class CitiBikeStationData {
    private String executionTime;
    private List<Station> stationBeanList;

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public List<Station> getStationBeanList() {
        return stationBeanList;
    }

    public void setStationBeanList(List<Station> stationBeanList) {
        this.stationBeanList = stationBeanList;
    }

    public static class Station {
        private int id;
        private String stationName;
        private int availableDocks;
        private int totalDocks;
        private int availableBikes;
        private String stAddress1;
        private String statusValue;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public int getAvailableDocks() {
            return availableDocks;
        }

        public void setAvailableDocks(int availableDocks) {
            this.availableDocks = availableDocks;
        }

        public int getTotalDocks() {
            return totalDocks;
        }

        public void setTotalDocks(int totalDocks) {
            this.totalDocks = totalDocks;
        }

        public int getAvailableBikes() {
            return availableBikes;
        }

        public void setAvailableBikes(int availableBikes) {
            this.availableBikes = availableBikes;
        }

        public String getStAddress1() {
            return stAddress1;
        }

        public void setStAddress1(String stAddress1) {
            this.stAddress1 = stAddress1;
        }

        public String getStatusValue() {
            return statusValue;
        }

        public void setStatusValue(String statusValue) {
            this.statusValue = statusValue;
        }
    }
}
