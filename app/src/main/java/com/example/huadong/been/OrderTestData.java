package com.example.huadong.been;

public class OrderTestData {

        private String cpu;

        private String mianboard;

        private String graphics;

        private String memorysticks;

        private String power;

        private String harddisk;

        private String radiator;

        private String chassis;
        public OrderTestData(){

        }
        public OrderTestData(String cpu,String mianboard,String graphics,String memorysticks,String power,String harddisk,String radiator,String chassis){
            this.cpu=cpu;
            this.mianboard=mianboard;
            this.graphics=graphics;
            this.memorysticks=memorysticks;
            this.power=power;
            this.harddisk=harddisk;
            this.radiator=radiator;
            this.chassis=chassis;

        }

        public String getCpu() {
            return cpu;
        }

        public void setCpu(String cpu) {
            this.cpu = cpu;
        }

        public String getMianboard() {
            return mianboard;
        }

        public void setMianboard(String mianboard) {
            this.mianboard = mianboard;
        }

        public String getGraphics() {
            return graphics;
        }

        public void setGraphics(String graphics) {
            this.graphics = graphics;
        }

        public String getMemorysticks() {
            return memorysticks;
        }

        public void setMemorysticks(String memorysticks) {
            this.memorysticks = memorysticks;
        }

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public String getHarddisk() {
            return harddisk;
        }

        public void setHarddisk(String harddisk) {
            this.harddisk = harddisk;
        }

        public String getRadiator() {
            return radiator;
        }

        public void setRadiator(String radiator) {
            this.radiator = radiator;
        }

        public String getChassis() {
            return chassis;
        }

        public void setChassis(String chassis) {
            this.chassis = chassis;
        }

    @Override
    public String toString() {
        return "OrderTestData{" +
                "cpu='" + cpu + '\'' +
                ", mianboard='" + mianboard + '\'' +
                ", graphics='" + graphics + '\'' +
                ", memorysticks='" + memorysticks + '\'' +
                ", power='" + power + '\'' +
                ", harddisk='" + harddisk + '\'' +
                ", radiator='" + radiator + '\'' +
                ", chassis='" + chassis + '\'' +
                '}';
    }
}
