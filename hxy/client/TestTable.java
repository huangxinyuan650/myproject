package hxy.client;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TestTable extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestTable(Object [][]data,Object []title) {
//		TableModel tableModel = new DefaultTableModel();
	}
	
	@Override
	public int getColumnCount() {//��ȡ�������
		return 0;
	}

	@Override
	public int getRowCount() {//��ȡ�������
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
