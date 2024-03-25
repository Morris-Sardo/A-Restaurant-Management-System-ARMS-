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
	      AlertText.alert(AlertType.ERROR, "Error Message", "Please fill insert a valid input");
	    } else if (viewK.getstockPrice() > 9999999.99 || viewK.getstockPrice() < 0) {
	      AlertText.alert(AlertType.ERROR, "Error message", "Price no  correct");
	      viewK.stockClearBtn();

	    } else if (viewK.getstockItmNum() < 0) {
	      AlertText.alert(AlertType.ERROR, "Error message", "Product Number no correct");
	    } else if (viewK.getstockQuantity() < 0) {
	      AlertText.alert(AlertType.ERROR, "Error message", "Stock no valid");
	    } else {


	      StockModel.stockUpdate(viewK.getstockItmName(), viewK.getstockPrice(), viewK.getstockAllergy(),
	          viewK.getstockCal(), viewK.getstockAvailable(),viewK.getstockTags(),  viewK.getstockQuantity(),
	          viewK.getstockItmNum());
	      AlertText.alert(AlertType.INFORMATION, "Successfully Update data into dataBase",
	          "Data added into Stock Table");
	      viewK.stockClearBtn();
	      viewK.setTableItems(StockModel.getStockTable());


	    }

	  }
	
	

}
