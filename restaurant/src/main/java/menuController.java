import javafx.scene.control.Alert.AlertType;

public class menuController {
	private menuView view;
	private menuModelDatabase mmd;
	
	public menuController(menuView view, menuModelDatabase mmd) {
	  this.view = view;
	  this.mmd = mmd;
	  
	  view.HandleIncreases(this:: decreases);
	  
	}
	
	public void decreases() {
	  if(view.getIncreasePasta().isPressed() && mmd.getQuantity() <1 ) {
	    view.alert(AlertType.INFORMATION, "Info Message", "OUT OF STOCK");
	    }else {
	      view.alert(AlertType.INFORMATION, "quantity", "cart has been updated");
	    }
	}
}
