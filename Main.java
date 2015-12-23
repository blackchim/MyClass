
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {

    Stage window;
    TableView<Product> table;
    TextField namnInput, telInput, emailInput, infoInput;



    public static void main(String[] args) {

        launch(args);



    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle(System.getProperty("user.name") + "´s telefonboken");
        String col1 = "Namn:";
        String col2 = "Telefonnr:";
        String col3 = "Email:";
        String col4 = "Info:";


        //Name column
        TableColumn<Product, String> namnColumn = new TableColumn<>(col1);
        namnColumn.setMinWidth(200);
        namnColumn.setCellValueFactory(new PropertyValueFactory<>("namn"));

        //Price column
        TableColumn<Product, Long> telColumn = new TableColumn<>(col2);
        telColumn.setMinWidth(200);
        telColumn.setCellValueFactory(new PropertyValueFactory<>("tel"));

        //Quantity column
        TableColumn<Product, String> emailColumn = new TableColumn<>(col3);
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        //Lokal column
        TableColumn<Product, String> infoColumn = new TableColumn<>(col4);
        infoColumn.setMinWidth(400);
        infoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));


        //nameInput textfält
        namnInput = new TextField();
        namnInput.setPromptText(col1);
        namnInput.setMinWidth(100);

        //telInput textfält
        telInput = new TextField();
        telInput.setPromptText(col2);


        //emailInput textfält
        emailInput = new TextField();
        emailInput.setPromptText(col3);

        //infoInput textfält
        infoInput = new TextField();
        infoInput.setPromptText(col4);


        //Button handlingar
        Button addButton = new Button("Lägga till");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Tabort");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(namnInput, telInput, emailInput, infoInput, addButton, deleteButton);


        table = new TableView<>();
        table.setItems(getProduct9());
        table.getColumns().addAll(namnColumn, telColumn, emailColumn, infoColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //add button clicked
    public void addButtonClicked() {
        Product product = new Product();
        product.setNamn(namnInput.getText());
        product.setTel(telInput.getText());
        product.setEmail(emailInput.getText());
        product.setInfo(infoInput.getText());
        table.getItems().add(product);
        namnInput.clear();
        emailInput.clear();
        telInput.clear();
        infoInput.clear();
    }

    //delete button clicked
    public void deleteButtonClicked() {
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();


        productSelected.forEach(allProducts::remove);

    }


    //alla namn i telefonboken
    public ObservableList<Product> getProduct9() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Randy Le", "0736393901", "blackchim@yahoo.com", "Sweden handsome kille"));
        products.add(new Product("Minh Nguyen", "1234566789", "minh@yahoo.com", "feta summossen"));
        products.add(new Product("Teddy Bear", "231231231299", "blackchim@yahoo.com", "Sweden"));
        products.add(new Product("Tom Jones", " 1234234234239", "-", "Kina"));
        products.add(new Product("Zombois", " 12342342234234", "-", "DK"));
        return products;

    }

}