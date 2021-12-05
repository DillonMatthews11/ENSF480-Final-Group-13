import Resources.Controllers.LoginController;
import Resources.FrontEnd.LoginView;

public class Main {
	public static void main(String[] args) {
		LoginView theView = new LoginView();
		LoginController controller = new LoginController(theView);
		theView.setVisible(true);
	}
}
