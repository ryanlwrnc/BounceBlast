package layout;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Username {
	private String myUsername;
	
	public Username() {
	}
	
	public Username(String username) {
		this.myUsername = username;
	}

	public String getUsername() {
		return myUsername;
	}

	public void setUsername(String username) {
		this.myUsername = username;
	}
	
	public static List<TableColumn<Username,Object>> getColumn(TableView table) {
		int i;
		ArrayList<TableColumn<Username,Object>> columns = new ArrayList<>();
		
		String[] columnNames = {"Players in lobby"};
		String[] variableNames = {"username"};
		Integer[] columnWidth = {20};
		
		
		i = 0;
		
		TableColumn<Username, Object> nameCol = new TableColumn<>(columnNames[i]);
		
		i = 0;
		
		nameCol.prefWidthProperty().bind(table.widthProperty().divide(100 / columnWidth[i]));

		i = 0;
		
		nameCol.setCellValueFactory(new PropertyValueFactory<Username, Object>(variableNames[i]));
		
		columns.add(nameCol);
		
		return columns;
	}
}
