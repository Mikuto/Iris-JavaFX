import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {


	@Override
	public void start(Stage stage) {

		main_all all = new main_all();
		all.start(stage);
	}
	 public static void main(String[] args) {
	        launch(args);
	    }
	 

}