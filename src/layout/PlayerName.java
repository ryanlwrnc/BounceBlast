package layout;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PlayerName {

	private int rank;
	private String name;
	private int score;
	private int numWin;
	private int numLoss;

	public PlayerName(int rank, String name, int score, int numWin, int numLoss) {
		super();
		this.rank = rank;
		this.name = name;
		this.score = score;
		this.numWin = numWin;
		this.numLoss = numLoss;
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

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getWin() {
		return numWin;
	}

	public void setWins(int numWin) {
		this.numWin = numWin;
	}
	
	public int getLoss() {
		return numLoss;
	}

	public void setLoss(int numLoss) {
		this.numLoss = numLoss;
	}


	public static List<TableColumn<PlayerName,?>> getColumn(TableView table) {
		int i;
		ArrayList<TableColumn<PlayerName,?>> columns = new ArrayList<>();
		
		String[] columnNames = {"Rank", "Player", "Score","Wins", "Losses"};
		String[] variableNames = {"rank", "name", "score", "win", "loss"};
		Integer[] columnWidth = {10, 50, 15, 15, 15};
		
		i = 0;
		TableColumn<PlayerName, Integer> rankCol = new TableColumn<>(columnNames[i++]);
		TableColumn<PlayerName, String> nameCol = new TableColumn<>(columnNames[i++]);
		TableColumn<PlayerName, Integer> scoreCol = new TableColumn<>(columnNames[i++]);
		TableColumn<PlayerName, Integer> winsCol = new TableColumn<>(columnNames[i++]);
		TableColumn<PlayerName, Integer> lossesCol = new TableColumn<>(columnNames[i]);
		
		i = 0;
		rankCol.prefWidthProperty().bind(table.widthProperty().divide(100 / columnWidth[i++]));
		nameCol.prefWidthProperty().bind(table.widthProperty().divide(100 / columnWidth[i++]));
		scoreCol.prefWidthProperty().bind(table.widthProperty().divide(100 / columnWidth[i++]));
		winsCol.prefWidthProperty().bind(table.widthProperty().divide(100 / columnWidth[i++]));
		lossesCol.prefWidthProperty().bind(table.widthProperty().divide(100 / columnWidth[i]));

		i = 0;
		rankCol.setCellValueFactory(new PropertyValueFactory<PlayerName, Integer>(variableNames[i++]));
		nameCol.setCellValueFactory(new PropertyValueFactory<PlayerName, String>(variableNames[i++]));
		scoreCol.setCellValueFactory(new PropertyValueFactory<PlayerName, Integer>(variableNames[i++]));
		winsCol.setCellValueFactory(new PropertyValueFactory<PlayerName, Integer>(variableNames[i++]));
		lossesCol.setCellValueFactory(new PropertyValueFactory<PlayerName, Integer>(variableNames[i]));
		
		columns.add(rankCol);
		columns.add(nameCol);
		columns.add(scoreCol);
		columns.add(winsCol);
		columns.add(lossesCol);
		
		return columns;
	}
}