//*********************************************
//
// Assignment 2 
//
// Author: Joshua Spencer
// Date: 9/9/2026
// Course: CPT-237
// Section: W38
// Semester: Fall 2026
//
// Modified to call encryptMiscString() method.
//
//*********************************************

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.*;

public class EncryptionApplication extends Application {

   public void start(Stage primaryStage) {
   
      TextArea taInput = new TextArea("hello world");
      TextArea taOutput = new TextArea("Output Text:");
      
      GridPane pane = new GridPane();
      pane.setPadding(new Insets(10, 10, 10, 10));
      pane.setVgap(5);
      
      pane.add(new Label("Input Text:"), 0, 0);
      pane.add(taInput, 0, 1);

      FlowPane btnPane = new FlowPane();
      btnPane.setAlignment(Pos.CENTER);
      pane.setHgap(5);
      btnPane.setPadding(new Insets(10, 10, 10, 10));
      btnPane.setHgap(10);
      
      // Encrypt Button with Try-Catch Block
      Button btnEncrypt = new Button("Encrypt");
      btnEncrypt.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e) {
            try {
               // Try block execution
               EncryptString eObj = new EncryptString(taInput.getText());
               taOutput.setText(eObj.encryptString());
            } catch (IllegalArgumentException ex) {
               // Catch block - display an error dialog
               Alert alert = new Alert(AlertType.ERROR);
               alert.setTitle("Input Error");
               alert.setHeaderText("Invalid Character Encountered");
               alert.setContentText(ex.getMessage());
               alert.showAndWait();
            }
         }
      });
      
      // Clear Button
      Button btnClear = new Button("Clear");
      btnClear.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e) {
            taInput.setText("");
            taOutput.setText("");
         }
      });
      
      // Decrypt Button
      Button btnDecrypt = new Button("Decrypt");
      btnDecrypt.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e) {
            String eString = taInput.getText();
            taOutput.setText(EncryptString.decryptString(eString));
         }
      });
      
      btnPane.getChildren().addAll(btnEncrypt, btnClear, btnDecrypt);
      pane.add(btnPane, 0, 2);
                                                                                                                            
      pane.add(new Label("Output Text:"), 0, 3);
      pane.add(taOutput, 0, 4);
      
      Scene scene = new Scene(pane);
      primaryStage.setTitle("CPT 236 Encryption Application");
      primaryStage.setScene(scene);
      primaryStage.show();
   }

   public static void main(String[] args) { 
      launch(args);
   }
}                                                                                                                                                                        