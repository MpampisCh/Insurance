package com.teamone.db;

import com.teamone.app.Vehicle;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VehicleFacade{

    private ConnectionDB connectionDB;

    public VehicleFacade(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    public ArrayList<Vehicle> getVehiclesList() throws ExceptionDBLayer {
        String query = "SELECT * FROM vehicle";
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        try (PreparedStatement preparedStatement = ConnectionDB.getDBConnection().prepareStatement(query)){
            ResultSet rs = preparedStatement.executeQuery(query);
            Vehicle vehicle;
            while (rs.next()){
                vehicle = new Vehicle(rs.getString("plate"),
                        rs.getString("end_date"),rs.getInt("owner_id"));
                vehicleList.add(vehicle);
            }
        } catch (SQLException exe){
            throw new ExceptionDBLayer(" VehicleFacade getVehicleList" , exe);
        }
        return vehicleList;
    }

    public Date getEndDateForVehicle(String plate) throws ExceptionDBLayer {
        String query = "SELECT end_date FROM vehicle WHERE plate=?";
        String endDate = null;
        Date day;

        try (PreparedStatement preparedStatement = ConnectionDB.getDBConnection().prepareStatement(query)) {
            preparedStatement.setString(1, plate);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                endDate = rs.getString("end_date");
            }


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        day = dateFormat.parse(endDate);
        }
         catch (SQLException  | ParseException exe){
            throw new ExceptionDBLayer("VehicleFacade getEndDateForVehicle", exe);
        }
        return day;
    }

    public ArrayList<Vehicle> getOwnersVehicles(String lastName) throws ExceptionDBLayer {
        String query = "SELECT vehicle.plate, vehicle.end_date, vehicle.owner_id " +
                "FROM vehicle " +
                "INNER JOIN owner ON vehicle.owner_id = owner.owner_id" +
                " WHERE last_name=?";
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        try (PreparedStatement preparedStatement = ConnectionDB.getDBConnection().prepareStatement(query)){
            preparedStatement.setString(1,lastName);
            ResultSet rs = preparedStatement.executeQuery();
            Vehicle vehicle;

            while (rs.next()){
                vehicle = new Vehicle(rs.getString("plate"),
                        rs.getString("end_date"),rs.getInt("owner_id"));
                vehicleList.add(vehicle);
            }
        } catch (SQLException exe){
            throw new ExceptionDBLayer("VehicleFacade gegtOwnerVehicles" , exe);
        }
        return vehicleList;
    }

    public boolean checkIfThePlateExists(String plate) throws Exception {
        boolean existence;
        existence = getEndDateForVehicle(plate) != null;

        return existence;
    }

}

