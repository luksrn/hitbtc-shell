package com.github.luksrn.hitbtc.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.shell.table.ArrayTableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.CellMatcher;
import org.springframework.shell.table.SimpleHorizontalAligner;
import org.springframework.shell.table.SimpleVerticalAligner;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;

public class TableGenerator<T> {

	public T[] data;
	
	private List<Column<T>> columns = new ArrayList<>();
	
	public static class Column<T> {
		
		String header;
		
		Function<T, String> function;
	}
	
	public TableGenerator<T> withData(T[] data) {
		this.data = data;
		return this;
	}
	
	public TableGenerator<T> withColumn(String header , Function<T,String> f){
		Column<T> c = new Column<>();
		c.header = header;
		c.function = f;
		columns.add(c);
		return this;
	}
	
	public Table toTable() {
		
		String[][] tableData = new String[data.length + 1][ columns.size()];
		TableModel model = new ArrayTableModel(tableData);
		TableBuilder tableBuilder = new TableBuilder(model);

		for (int j = 0; j < columns.size() ; j++) {
			tableData[0][j] = columns.get(j).header;
			tableBuilder.on(at(0, j)).addAligner(SimpleHorizontalAligner.center);
			tableBuilder.on(at(0, j)).addAligner(SimpleVerticalAligner.middle);
		}
		
		for (int i = 0; i < data.length ; i++) {
			for (int j = 0; j < columns.size() ; j++) {
				tableData[i + 1][j] = columns.get(j).function.apply(data[i]);
				tableBuilder.on(at(i + 1, j)).addAligner(SimpleHorizontalAligner.center);
				tableBuilder.on(at(i + 1, j)).addAligner(SimpleVerticalAligner.middle);
			}
		}

		return tableBuilder.addFullBorder(BorderStyle.oldschool).build();
	}

	public static CellMatcher at(final int theRow, final int col) {
		return new CellMatcher() {
			@Override
			public boolean matches(int row, int column, TableModel model) {
				return row == theRow && column == col;
			}
		};
	}
}
