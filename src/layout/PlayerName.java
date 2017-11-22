package layout;
import java.util.ArrayList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PlayerName {

	private int rank;
	private String name;
	private int score;

	public PlayerName(int rank, String name, int score) {
		super();
		this.rank = rank;
		this.name = name;
		this.score = score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScopre(int score) {
		this.score = score;
	}


	public static ArrayList<TableColumn<PlayerName,?>> getColumn(TableView table) {
		int i;
		ArrayList<TableColumn<PlayerName,?>> columns = new ArrayList<TableColumn<PlayerName,?>>();
		
		String[] columnNames = {"Rank", "Player", "Score"};
		String[] variableNames = {"rank", "name", "score"};
		Integer[] column_width = {10, 50, 15};
		
		i = 0;
		TableColumn<PlayerName, Integer> rankCol = new TableColumn<>(columnNames[i++]);
		TableColumn<PlayerName, String> nameCol = new TableColumn<>(columnNames[i++]);
		TableColumn<PlayerName, Integer> scoreCol = new TableColumn<>(columnNames[i++]);
		
		i = 0;
		rankCol.prefWidthProperty().bind(table.widthProperty().divide(100 / column_width[i++]));
		nameCol.prefWidthProperty().bind(table.widthProperty().divide(100 / column_width[i++]));
		scoreCol.prefWidthProperty().bind(table.widthProperty().divide(100 / column_width[i++]));

		i = 0;
		rankCol.setCellValueFactory(new PropertyValueFactory<PlayerName, Integer>(variableNames[i++]));
		nameCol.setCellValueFactory(new PropertyValueFactory<PlayerName, String>(variableNames[i++]));
		scoreCol.setCellValueFactory(new PropertyValueFactory<PlayerName, Integer>(variableNames[i++]));

		
		columns.add(rankCol);
		columns.add(nameCol);
		columns.add(scoreCol);
		
		return columns;
	}
}