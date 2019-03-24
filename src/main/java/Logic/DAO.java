/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Orders;
import Data.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Renz
 */
public class DAO {

    public void createUser(String email, String password) {
        try {
            DBConnector c = new DBConnector();
            String query = "INSERT INTO Users(Email, Admin, Password)"
                    + "VALUES('" + email + "', " + 0 + ", '" + password + "');";
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean checkLogin(String email, String password) {
        String _password = "";
        try {
            DBConnector c = new DBConnector();

            String query = "SELECT Password FROM `Users` WHERE Email = '" + email + "';";
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                _password = rs.getString("Password");
            }
            return _password.equals(password);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public User getUser(String email) {
        User u = null;
        try {
            DBConnector c = new DBConnector();

            String query = "SELECT * \n"
                    + "FROM Users \n"
                    + "WHERE Email = '" + email + "';";
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                email = rs.getString("email");
                boolean isAdmin = rs.getBoolean("admin");

                u = new User(email, isAdmin);
            }
            return u;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void makeOrder(int Width, int Length, int Height, String Bandtype, String Email) {
        try {
            DBConnector c = new DBConnector();
            String query = "INSERT INTO `Order`\n"
                    + "VALUES(" + 0 + ", " + Width + ", " + Length + ", " + Height + ", '"
                    + Bandtype + "', " + 0 + ", '" + Email + "');";

            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Orders> getMyOrderList(String email) {
        try {
            DBConnector c = new DBConnector();
            String query = "SELECT * \n"
                    + "FROM legohouse.Order\n"
                    + "where Email = '" + email + "';";
            ArrayList<Orders> list = new ArrayList<>();
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int orderID = rs.getInt("Order_id");
                int width = rs.getInt("Width");
                int length = rs.getInt("Length");
                int height = rs.getInt("Height");
                String bandType = rs.getString("BandType");
                boolean isShipped = rs.getBoolean("IsShipped");
                Orders order = new Orders(width, length, height, bandType, email);
                order.setIsShipped(isShipped);
                order.setOrderID(orderID);
                list.add(order);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Orders getOrder(int orderID) {
        Orders order = null;
        try {
            DBConnector c = new DBConnector();
            String query = "SELECT * FROM legohouse.Order\n"
                    + "where Order_id = " + orderID + ";";
            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int width = rs.getInt("Width");
                int length = rs.getInt("Length");
                int height = rs.getInt("Height");
                String bandType = rs.getString("BandType");
                String email = rs.getString("Email");
                order = new Orders(width, length, height, bandType, email);
            }
            return order;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int[] calBricks(int width, int length, int height, int bandType) {
        int x4 = 0;
        int x2 = 0;
        int x1 = 0;

        int[] list = new int[6];

        list[0] = x4;
        list[1] = x2;
        list[2] = x1;
        list[3] = x4;
        list[4] = x2;
        list[5] = x1;

        switch (bandType) {
            case 1:
                //bricks for width
                if (width < 4) {
                    list[0] = 0;
                }
                if (width % 4 == 0) {
                    list[0] = (width / 4) * 2 * height;
                }
                if (width > 4 && width % 4 != 0) {
                    list[0] = ((width - (width % 4)) / 4) * 2 * height;
                }
                if (width % 4 == 2) {
                    list[1] = 1 * 2 * height;
                }
                if (width % 4 == 1) {
                    list[2] = 1 * 2 * height;
                }
                if (width % 4 > 2) {
                    list[1] = 1 * 2 * height;
                    list[2] = 1 * 2 * height;
                }
                //bricks for length
                if (length < 4) {
                    list[3] = 0;
                }
                if (length % 4 == 0) {
                    list[3] = (length / 4) * 2 * height;
                }
                if (length > 4 && length % 4 != 0) {
                    list[3] = ((length - (length % 4)) / 4) * 2 * height;
                }
                if (length % 4 == 2) {
                    list[4] = 1 * 2 * height;
                }
                if (length % 4 == 1) {
                    list[5] = 1 * 2 * height;
                }
                if (length % 4 > 2) {
                    list[4] = 1 * 2 * height;
                    list[5] = 1 * 2 * height;
                }
                break;
            //second bandtype
            case 2:

                break;
            //third bandtype
            case 3:

                break;
            //fourth bandtype
            case 4:

                break;
            default:
                throw new AssertionError();
        }

        return list;
}

}
