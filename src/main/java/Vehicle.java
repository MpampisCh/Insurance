public class Vehicle {

    import java.util.Date;

    public class Vehicle {

        private String plate;
        private String endDate;
        private int ownerId;


        public Vehicle(String plate, String endDate, int ownerId) {
            this.plate = plate;
            this.endDate = endDate;
            this.ownerId = ownerId;
        }

        public String getPlate() {
            return plate;
        }

        public void setPlate(String plate) {
            this.plate = plate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public int getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(int ownerId) {
            this.ownerId = ownerId;
        }
    }
}
