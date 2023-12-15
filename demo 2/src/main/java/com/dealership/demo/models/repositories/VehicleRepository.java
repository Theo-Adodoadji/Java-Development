package com.dealership.demo.models.repositories;

import com.dealership.demo.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class VehicleRepository {
    //Dependency
    //Without this, we can't connect to the database
    private final DataSource dataSource;

    //Autowired says, go and get me a copy of this
    @Autowired
    public VehicleRepository(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    public List<Vehicle> getAllVehicles() {
        String query = "SELECT * FROM vehicles";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("color"),
                        rs.getString("type"), rs.getInt("odomoter"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> getVehicleByPrice(double min, double max) {
        String query = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("color"),
                        rs.getString("type"), rs.getInt("odometer"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model) {
        String query = "SELECT * FROM vehicles WHERE make = ? AND model = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, make);
            ps.setString(2, model);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("color"),
                        rs.getString("type"), rs.getInt("odometer"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicles;

    }

    public List<Vehicle> getVehicleByYear(int min, int max) {
        String query = "SELECT * FROM vehicles WHERE year >= min AND year <= max";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, min);
            ps.setInt(2, max);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("color"),
                        rs.getString("type"), rs.getInt("odometer"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> getVehicleByColor(String color) {
        String query = "SELECT * FROM vehicles WHERE color = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, color);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("color"),
                        rs.getString("type"), rs.getInt("odometer"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> getVehicleByMileage(int min, int max) {
        String query = "SELECT * FROM vehicles WHERE mileage >= min AND mileage <= max";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, min);
            ps.setInt(2, max);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                var vehicle = new Vehicle(rs.getString("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("color"),
                        rs.getString("type"), rs.getInt("odometer"), rs.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vehicles;
    }





}

