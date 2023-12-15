package com.dealership.demo.models.repositories;

import com.dealership.demo.models.Dealership;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class DealershipRepository {
    private final DataSource dataSource;

    @Autowired
    public DealershipRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //CRUD functions for dealership
    //getAllDealerships, getDealershipById, createDealership, updateDealership, deleteDealership
    //CREATE
    private BasicDataSource basicDataSource;

    public DealershipRepository(String url, String userName, String password, DataSource dataSource) {
        this.dataSource = dataSource;
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }

    public void createDealership(Dealership dealership) {
        String query = "INSERT INTO Dealerships(dealership_id, fullname, address, phone) VALUES(?, ?, ?, ?)";

        try (Connection conn = basicDataSource.getConnection();

///checked exception vs unchecked
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, dealership.getName());
            ps.setString(2, dealership.getAddress());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

        //READ


        //UPDATE

    public void updateDealership(Dealership dealership) {
            String query = "UPDATE Dealerships SET fullname = ? WHERE Dealership = ?";

            try (Connection conn = basicDataSource.getConnection();

///checked exception vs unchecked
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setString(1, dealership.getName());
                ps.setString(2, dealership.getAddress());
                ps.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }



        //DELETE

    public void deleteDealership(int id){
        String query = "DELETE FROM Dealerships WHERE fullname = ?";
        try (Connection conn = basicDataSource.getConnection();

///checked exception vs unchecked
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    }

