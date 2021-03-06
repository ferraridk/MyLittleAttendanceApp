package gui.controller;

import be.Student;
import be.Teacher;
import dal.Authentication;
import dal.AttendanceDbDAO;
import dal.StudentDbDAO;
import bll.SchoolAppManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import dal.Authentication;
import gui.model.SchoolAppModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author simge
 */
public class LoginController implements Initializable
{

    @FXML
    private Button button;
    @FXML
    private Label label;

    private BorderPane rootLayout;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private Label infoLabel;

    SchoolAppManager bll;
    SchoolAppModel sam;

    public LoginController() throws IOException {
        this.bll = new SchoolAppManager();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void openStudent(ActionEvent event) throws IOException, SQLException
    {
        Student stud = bll.getLoginStudent(username.getText(), password.getText());
        if (stud != null)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/view/StudentView.fxml"));
            
            StudentViewController.setStudent(stud);
            Parent root = loader.load();
            StudentViewController controller = loader.getController();
            System.out.println(controller);
            controller.setRootLayout(rootLayout);
            rootLayout.setCenter(root);
        } else
        {
            infoLabel.setText("Please type a valid password");
        }
    }

    public void setRootLayout(BorderPane rootLayout)
    {
        System.out.println(rootLayout);
        this.rootLayout = rootLayout;
    }

    @FXML
    private void openTeacher(ActionEvent event) throws IOException, SQLException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/view/TeacherView.fxml"));
        Parent root = loader.load();
        TeacherViewController controller = loader.getController();
//        controller.setTeacher(sam.getTeacher());
        controller.setRootLayout(rootLayout);
        rootLayout.setCenter(root);
//        } else
        {
            infoLabel.setText("Please type a valid password");
        }
    }

}
