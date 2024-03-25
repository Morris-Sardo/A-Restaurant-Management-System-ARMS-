package appication;

import javafx.scene.control.Alert.AlertType;

/**
 * This is the controller for the stock page.
 * 
 * @author jonathan, micheal
 */
public class StockController {
private KitchenView viewK;
	
	public StockController(KitchenView viewK) {
	    this.viewK = viewK;


	  }
	
	public void stockUpdate() {

	    if (viewK.getstockItmNum() == -1 || viewK.getstockItmName().isEmpty()
	        || viewK.getstockCal() == -1 || viewK.getstockAllergy().isEmpty()
	        || viewK.getstockAvailable().isEmpty() || viewK.getstockQuantity() == -1
	        || viewK.getstockTags().isEmpty() || viewK.getstockPrice() == 0 ) {
	      AlertText.alert(AlertType.ERROR, "Error Message", "Please fill insert a valids input");
	    } else if (viewK.getstockPrice() > 9999999.99 || viewK.getstockPrice() < 0) {
	      AlertText.alert(AlertType.ERROR, "Error message", "Prize no  correct");
	      viewK.stockClearBtn();

	    } else if (viewK.getstockItmNum() < 0) {
	      AlertText.alert(AlertType.ERROR, "Error message", "Product ID no correct");
	    } else if (viewK.getstockQuantity() < 0) {
	      AlertText.alert(AlertType.ERROR, "Error message", "Stock no valid");
	    } else {


	      StockModel.stockUpdate(viewK.getstockItmNum(), viewK.getstockItmName(),
	          viewK.getstockCal(), viewK.getstockAvailable(), viewK.getstockQuantity(), viewK.getstockAllergy(),
	          viewK.getstockPrice(), viewK.getstockTags());
	      AlertText.alert(AlertType.INFORMATION, "Successfully Update data into dataBase",
	          "Data added into Stock Table");
	      viewK.setAllFieldClean();
	      viewK.steTableItems(InventoryModel.getInventoryTable());


	    }

	  }
	
	

}
