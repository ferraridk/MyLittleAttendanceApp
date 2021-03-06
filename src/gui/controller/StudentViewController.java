package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import be.Attendance;
import be.Student;
import gui.model.SchoolAppModel;
import gui.controller.LoginController;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;

/**
 *
 * @author simge
 */
public class StudentViewController implements Initializable
{

    private ObservableList<Attendance> allAttendance;
    private SchoolAppModel model;
    private static Student student;
    private BorderPane borderPane;
    private gui.controller.LoginController mainViewController;
    private ObservableList<String> allOfDays = FXCollections.observableArrayList();
    private BorderPane rootLayout;
    
    @FXML
    private Label absence;
    @FXML
    private Label name;
    @FXML
    private TableView<Attendance> tableView;
    @FXML
    private TableColumn<Attendance, String> date;
    @FXML
    private TableColumn<Attendance, String> presence;
    @FXML
    private LineChart<String, Double> chart;
    @FXML
    private NumberAxis percentage;
    @FXML
    private CategoryAxis days;
    @FXML
    private Label email;
    @FXML
    private Button logUd;
    @FXML
    private AnchorPane studentPage;
    

    public void initialize(URL url, ResourceBundle rb)
    {

        try {
            model = new SchoolAppModel();
        } catch (IOException ex) {
            Logger.getLogger(StudentViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        showAlert();
        
        double ab = student.getAbsencePercentage();
        String toShow = String.format("%.1f", ab);
        absence.setText(toShow + "%");
        name.setText(student.getName());
        date.setSortType(TableColumn.SortType.DESCENDING);

        // init tableview
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        presence.setCellValueFactory(new PropertyValueFactory<>("attendance"));
        tableView.setItems(student.getFullAttendance());

        chart.setTitle("Fraværshistorik");
        chart.setLegendVisible(false);
        chart.setTitleSide(Side.TOP);
        percentage.setLowerBound(0);
        percentage.setUpperBound(100);

        calculateAbsence();
        tableView.getSortOrder().setAll(date);

        name.setText(student.getName());
        email.setText(student.getEmail());
    }

    private void calculateAbsence()
    {
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        allAttendance = student.getFullAttendance();

        int numberOfDays = 0;
        double daysAttended = 0;

        for (Attendance x : allAttendance)
        {
            numberOfDays++;
            if (x.getWasThere() == true)
            {
                daysAttended++;
            }
            int calAttendance = (int) (100 - daysAttended / numberOfDays * 100);

            series.getData().add(new XYChart.Data("" + numberOfDays, calAttendance));
        }

        chart.getData().add(series);

    }

    private void showAlert()
    {
        if (model.checkForSchoolNetwork() == true && model.checkForDailyAttendance(Date.valueOf(LocalDate.MAX)) == false)
        {
            Alert showAlert = new Alert(Alert.AlertType.INFORMATION);
            showAlert.setHeaderText("Fraværs alarm");
            showAlert.setContentText("Du er ikke registreret for i dag - lad mig gøre det for dig!");
            showAlert.showAndWait();
        }
    }

    @FXML
    private void askForAttendance(ActionEvent event)
    {
        Attendance chosenAttendance = tableView.getSelectionModel().getSelectedItem();

        if (chosenAttendance != null && chosenAttendance.getWasThere() == false && chosenAttendance.getRequestAttendance() == false)
        {
            Alert showAlert = new Alert(Alert.AlertType.INFORMATION);
            showAlert.setHeaderText("Anmodning om godkendelse");
            showAlert.setContentText("Din anmodning om godkendelse af fravær d. " + chosenAttendance.getDate() + " er sendt til din lærer!");
            showAlert.showAndWait();
            chosenAttendance.setAttendance("Fravær (Anmodet om godkendelse)");
            chosenAttendance.setRequestAttendance(true);
            model.askForAttendance(student.getId(), chosenAttendance);
            tableView.refresh();
            return;
        }

        if (chosenAttendance != null)
        {
            Alert showAlert = new Alert(Alert.AlertType.INFORMATION);
            showAlert.setHeaderText("Anmodning om godkendelse");
            showAlert.setContentText("Du har ikke fravær den valgte dag");
            showAlert.showAndWait();
        } else
        {
            Alert showAlert = new Alert(Alert.AlertType.INFORMATION);
            showAlert.setHeaderText("Anmodning om godkendelse");
            showAlert.setContentText("Du har ikke valgt en dag");
            showAlert.showAndWait();
        }
    }

    @FXML
    private void openChart(MouseEvent event)
    {
        Stage newStage = new Stage();

        NumberAxis y = new NumberAxis();
        CategoryAxis x = new CategoryAxis();
        LineChart l = new LineChart(x, y);

        XYChart.Series<String, Double> series = new XYChart.Series<>();
        allAttendance = student.getFullAttendance();

        int numberOfDays = 0;
        double daysAttended = 0;

        for (Attendance k : allAttendance)
        {
            numberOfDays++;
            if (k.getWasThere() == true)
            {
                daysAttended++;
            }
            int calAttendance = (int) (100 - daysAttended / numberOfDays * 100);

            series.getData().add(new XYChart.Data("" + numberOfDays, calAttendance));
        }

        l.getData().add(series);
        l.setLegendVisible(false);
        l.setTitle("Fraværshistorik");
        y.setLabel("Fravær i procent");
        x.setLabel("Antal skoledage");

        
        BorderPane bPane = new BorderPane();
        bPane.setCenter(l);
        
        bPane.getStyleClass().add("background");

        Scene newScene = new Scene(bPane);
        newStage.setHeight(600);
        newStage.setWidth(1000);
        newStage.setResizable(false);

        newScene.getStylesheets().add("/gui/view/Style.css");

        newStage.setScene(newScene);
        newStage.show();

    }

    @FXML
    private void studentLogOut(ActionEvent event) throws IOException
        {

         FXMLLoader loader  = new FXMLLoader(getClass().getResource("/gui/view/LoginView.fxml"));
        Parent root = loader.load();
        LoginController con = loader.getController();
        con.setRootLayout(rootLayout);
        rootLayout.setCenter(root);
        }

    void setRootLayout(BorderPane rootLayout)
    {
      this.rootLayout=rootLayout;
    }

    public static void setStudent(Student s) {
        StudentViewController.student = s;
    }
    
    
}