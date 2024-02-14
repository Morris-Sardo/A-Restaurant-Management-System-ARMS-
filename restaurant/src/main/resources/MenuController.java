
public class MenuController implements Initializable{
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.image.ImageView;
	import javafx.scene.layout.AnchorPane;

	public class PleaseProvideControllerClassName {

	    @FXML
	    private AnchorPane Inventory_page;

	    @FXML
	    private Button customer_btn;

	    @FXML
	    private Button inventory_add_btn;

	    @FXML
	    private Button inventory_btn;

	    @FXML
	    private Button inventory_clear_btn;

	    @FXML
	    private Button inventory_delete_bnt;

	    @FXML
	    private ImageView inventory_image_view;

	    @FXML
	    private Button inventory_import_btn;

	    @FXML
	    private TableView<?> inventory_table;

	    @FXML
	    private Button inventory_update_btn;

	    @FXML
	    private AnchorPane main_form;

	    @FXML
	    private Button menu_btn;

	    @FXML
	    private ImageView out_btn;

	    @FXML
	    private Button review_btn;

	    @FXML
	    private TableColumn<?, ?> table_col_price;

	    @FXML
	    private TableColumn<?, ?> table_col_prod_id;

	    @FXML
	    private TableColumn<?, ?> table_col_prod_name;

	    @FXML
	    private TableColumn<?, ?> table_col_stock;

	    @FXML
	    private TableColumn<?, ?> table_col_type;

	    @FXML
	    private Label username;
	    
	    public void displayUsername() {
	    	
	    	String user = data.username;
	    	user = user.substring(0, 1).toUpperCase() + user.substring(1);
	    	username.setText(user);
	    	
	    }

	}


}
