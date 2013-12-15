import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class EnderecoController implements Initializable {
	
	@FXML
	private TableView<Endereco> tableView;
	
	@FXML
	private TableColumn<Endereco, String> cep;
	
	@FXML
	private TableColumn<Endereco, String> logradouro;
	
	@FXML
	private TableColumn<Endereco, String> bairro;
	
	@FXML
	private TableColumn<Endereco, String> cidade;
	
	@FXML
	private TableColumn<Endereco, String> estado;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cep.setCellValueFactory(new PropertyValueFactory<Endereco, String>("cep"));
		logradouro.setCellValueFactory(new PropertyValueFactory<Endereco, String>("logradouro"));
		bairro.setCellValueFactory(new PropertyValueFactory<Endereco, String>("bairro"));
		cidade.setCellValueFactory(new PropertyValueFactory<Endereco, String>("cidade"));
		estado.setCellValueFactory(new PropertyValueFactory<Endereco, String>("estado"));
		
		tableView.getItems().setAll(parseEnderecos());
	}
	
	private List<Endereco> parseEnderecos() {
		AcademixClient client = new AcademixClient();
		return client.allEnderecos();
	}

}
