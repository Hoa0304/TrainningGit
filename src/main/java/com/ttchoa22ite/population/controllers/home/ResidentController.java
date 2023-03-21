package com.ttchoa22ite.population.controllers.home;

import com.ttchoa22ite.population.models.Resident;
import com.ttchoa22ite.population.utils.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ResidentController implements Initializable {

    @FXML
    private TextField CccdText;

    @FXML
    private TextField addressText;

    @FXML
    private Button homeBtn;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSearch;

    @FXML
    private TextField nameText;

    @FXML
    private TextField phoneText;

    @FXML
    private TableColumn<Resident, String> residentAddressCol;

    @FXML
    private TableColumn<Resident, String> residentCccdCol;

    @FXML
    private TableColumn<Resident, String> residentDomicileCol;

    @FXML
    private TableColumn<Resident, String> residentJobCol;

    @FXML
    private TableColumn<Resident, String> residentNameCol;

    @FXML
    private TableColumn<Resident, String> residentNationalityCol;

    @FXML
    private TableColumn<Resident, String> residentPhoneCol;

    @FXML
    private TableColumn<Resident, String> residentSexCol;

    @FXML
    private TableColumn<Resident, String> residentSshkCol;

    @FXML
    private TableColumn<Resident, Date> residentUpDateCol;
    @FXML
    private TableColumn<Resident, Date> residentDateCol;

    @FXML
    private TableView<Resident> residentView;


    @FXML
    private TextField sexText;

    @FXML
    private TextField sshkText;
    @FXML
    private TextField dateText;

    @FXML
    private TextField upDateText;
    @FXML
    private TextField jobText;
    @FXML
    private TextField nationalityText;

    @FXML
    private TextField domicileText;

    @FXML
    private Button deleteall;



    @FXML
    private void handleButtonAction(ActionEvent event) throws ParseException, ClassNotFoundException, SQLException {

        if(event.getSource() == btnInsert){
            insertResident();
        }else if (event.getSource() == btnUpdate){
            editAction();
        }else if(event.getSource() == btnDelete){
            deleteAction();
//        }else if (event.getSource()== btnSearch){
//            searchResident();
        }

    }

    void deleteAction()  {
        String query = "DELETE FROM resident WHERE sshk =" + sshkText.getText() + "";
        executeQuery(query);
        show();
    }


    void editAction() throws ParseException, SQLException {
        String query = "UPDATE  resident SET " +
                "name  = ? " +
                ", nationality = ? " +
                ", domicile = ? " +
                ", job = ? " +
                ",sex = ? "+
                ", date = ? " +
                ", address = ? " +
                ", NOphone = ? "+
                ", up_Date = ? "  +
                ", cccd = ? " +
                " WHERE sshk = ? ";
        PreparedStatement ppstmt = ConnectionDB.DAO().prepareStatement(query);
        ppstmt.setString(1, nameText.getText());
        ppstmt.setString(2,nationalityText.getText());
        ppstmt.setString(3,domicileText.getText() );
        ppstmt.setString(4,jobText.getText());
        ppstmt.setString(5,sexText.getText());
        ppstmt.setDate(6,date());
        ppstmt.setString(7,addressText.getText());
        ppstmt.setString(8, phoneText.getText());
        ppstmt.setDate(9,update());
        ppstmt.setString(10,CccdText.getText());
        ppstmt.setString(11, sshkText.getText());

        ppstmt.executeUpdate();
//        executeQuery(query);
//        deleteAction();
        show();

    }
//    void editAction1() throws ParseException {
//        String query = "UPDATE  resident SET " +
//                "name  = '" + nameText.getText() +
//                "', nationality = '" + nationalityText.getText() +
//                "', domicile = '" + domicileText.getText() +
//                "', job = '" + jobText.getText()+
//                "',sex = '" + sexText.getText()+
//                "', date = '" + date()+
//                "', address = '" + addressText.getText()+
//                "', NOphone = '" + phoneText.getText()+
//                "', up_Date = " + update() +
//                ", cccd = '" + CccdText.getText() +
//                "' WHERE sshk = '" + sshkText.getText() + "'";
//        executeQuery(query);
////        deleteAction();
//        show();
//
//    }

    Date date() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(formatter.parse(dateText.getText()).getTime());
        return date;
    }
    Date update() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(formatter.parse(upDateText.getText()));
        Date date = new Date(formatter.parse(upDateText.getText()).getTime());
        return date;}
    @FXML
    void home(ActionEvent event) {
        if (event.getSource()== homeBtn){
            try {
                Parent parent = FXMLLoader.load(((getClass().getResource("home.fxml"))));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                scene.setFill(Color.TRANSPARENT);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ResidentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


//    private void searchResident() throws ClassNotFoundException {
////        String sql = "SELECT * FROM 'resident' WHERE 'sshk'="+sshkText.getText();
////        executeQuery(sql);
////        populateAndShowResident();
////        try {
////
////            Resident resident1 = ResidentDAO.searchResident(sshkText.getText());
////
////            populateAndShowResident(resident1);
////        } catch (SQLException e) {
////            e.printStackTrace();
////            throw e;
////        }
//    }



//    private void populateAndShowResident() throws ClassNotFoundException {
//        Resident resident1 = null;
//        if (resident1 != null) {
//            populateResident(resident1);
//
//        }
//    }
//
//
//    private void populateResident(Resident resident1) throws ClassNotFoundException {
//        ObservableList<Resident> residentData = FXCollections.observableArrayList();
//
//        residentData.add(resident1);
//        residentView.setItems(residentData);
//    }


    private void insertResident() throws ParseException {
        String query = "INSERT INTO resident VALUES (" + sshkText.getText() + ",'" + nameText.getText() + "','"
                + nationalityText.getText() +  "','"+ domicileText.getText()+"','"+ jobText.getText()+"','"+sexText.getText()+"','"+ date()+"','"+addressText.getText()+"','"+ phoneText.getText()+"','"+ update()+"',"+CccdText.getText()+ ")";
        executeQuery(query);
        show();

    }

    private void executeQuery(String query) {
        Connection conn = ConnectionDB.DAO();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO
        show();
    }

    public static ObservableList<Resident> getResidentsList() {
        ObservableList<Resident> residentsList = FXCollections.observableArrayList();
        String sql = "Select * from resident";
        Connection connection = ConnectionDB.DAO();
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Resident resident = new Resident();
                resident.setSshk(rs.getString("sshk"));
                resident.setCccd(rs.getString("cccd"));
                resident.setSex(rs.getString("sex"));
                resident.setName(rs.getString("name"));
                resident.setNOphone(rs.getString("NOphone"));
                resident.setAddress(rs.getString("address"));
                resident.setJob(rs.getString("job"));
                resident.setNationality(rs.getString("nationality"));
                resident.setDomicile(rs.getString("domicile"));
                resident.setDate(rs.getDate("date"));
                resident.setUpDate(rs.getDate("up_Date"));

                residentsList.add(resident);
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return residentsList;
    }
@FXML
    public void show(){
        ObservableList<Resident> list = getResidentsList();
        residentSshkCol.setCellValueFactory((new PropertyValueFactory<>("sshk")));
        residentNameCol.setCellValueFactory((new PropertyValueFactory<>("name")));
        residentDateCol.setCellValueFactory((new PropertyValueFactory<>("date")));
        residentCccdCol.setCellValueFactory((new PropertyValueFactory<>("cccd")));
        residentAddressCol.setCellValueFactory((new PropertyValueFactory<>("address")));
        residentPhoneCol.setCellValueFactory((new PropertyValueFactory<>("NOphone")));
        residentSexCol.setCellValueFactory((new PropertyValueFactory<>("sex")));
        residentJobCol.setCellValueFactory((new PropertyValueFactory<>("job")));
        residentNationalityCol.setCellValueFactory((new PropertyValueFactory<>("nationality")));
        residentDomicileCol.setCellValueFactory((new PropertyValueFactory<>("domicile")));
        residentUpDateCol.setCellValueFactory((new PropertyValueFactory<>("upDate")));
        residentView.setItems(list);
    }

    @FXML
    void handledelete(ActionEvent event) {
        if (event.getSource()==deleteall){


        }
    }



}


