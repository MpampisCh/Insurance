public class InsuranceApp {
    public static void main(String[] args) throws Exception {
        InsuranceDB insuranceDB = new InsuranceDB();
//        insuranceDB.selectInsuranceStatus();
//        insuranceDB.selectInsecuredVehicle();
//        insuranceDB.selectOwnerInsecuredVehicles();

        VehicleEnvironment ve = new VehicleEnvironment();

        ve.showVehiclesList();

        ve.showEndDateForVehicle("\nION-5564");

        insuranceDB.CloseDBConnection();

    }
}
