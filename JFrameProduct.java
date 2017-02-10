package com.faikturan.demo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.faikturan.entities.*;
import com.faikturan.model.*;

public class JFrameProduct{
	protected Shell shlProductManagement;
	private Table tableProduct;
	private Text textId;
	private Text textName;
	private Text textPrice;
	private Text textQuantity;
	private Text textDescription;
	
	private TableItem tableItem;
	private ProductModel pm = new ProductModel();
	
	public static void main(String[] args) {
	}
	
	private void FiillData(){
		tableProduct.removeAll();
		for (Product p : pm.findAll()) {
			TableItem tableItem = new TableItem(tableProduct, SWT.NONE);
			tableItem.setText(new String[]
					{String.valueOf(p.getId()),
							p.getName(), String.valueOf(p.getPrice()),
							String.valueOf(p.getQuantity()), p.getDescription()});
		}
	}
	
	public void open(){
		Display display = Display.getDefault();
		createContents();
		FiillData();
		shlProductManagement.open();
		shlProductManagement.layout();
		while (!shlProductManagement.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void createContents() {
		shlProductManagement = new Shell();
		shlProductManagement.setSize(540, 401);
		shlProductManagement.setText("Product Management");
		shlProductManagement.setLayout(null);
		
		tableProduct = new Table(shlProductManagement, SWT.BORDER | SWT.FULL_SELECTION);
		tableProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				TableItem[] selection = tableProduct.getSelection();
				int id = Integer.parseInt(selection[0].getText());
				Product p = pm.find(id);
				textDescription.setText(p.getDescription());
				textId.setText(String.valueOf(p.getId()));
				textName.setText(p.getName());
				textPrice.setText(String.valueOf(p.getPrice()));
				textQuantity.setText(String.valueOf(p.getQuantity()));
			}
		});
		
		tableProduct.setBounds(10, 10, 504, 125);
		tableProduct.setHeaderVisible(true);
		tableProduct.setLinesVisible(true);
		
		TableColumn tblclmId = new TableColumn(tableProduct, SWT.NONE);
		tblclmId.setWidth(100);
		tblclmId.setText("Id");
		
		TableColumn tblclmName = new TableColumn(tableProduct, SWT.NONE);
		tblclmName.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				Product p = (Product) pm.findAll();
			}
		});
		
		tblclmName.setWidth(100);
		tblclmName.setText("Name");
		
		TableColumn tblclmnPrice = new TableColumn(tableProduct, SWT.NONE);
		tblclmnPrice.setWidth(100);
		tblclmnPrice.setText("Price");
		
		TableCursor tableCursor = new TableCursor(tableProduct, SWT.NONE);
		
		TableColumn tblclmnQuantity = new TableColumn(tableProduct, SWT.NONE);
		tblclmnQuantity.setWidth(100);
		tblclmnQuantity.setText("Quantity");
		
		TableColumn tblclmnDescription = new TableColumn(tableProduct, SWT.NONE);
		tblclmnDescription.setWidth(100);
		tblclmnDescription.setText("Description");
		
		Label lblId = new Label(shlProductManagement, SWT.NONE);
		lblId.setBounds(10, 156, 55, 15);
		lblId.setText("Id:");
		
		textId = new Text(shlProductManagement, SWT.NONE);
		textId.setBounds(81, 156, 169, 21);
		
		
		Label lblName = new Label(shlProductManagement, SWT.NONE);
		lblName.setBounds(10, 186, 55, 15);
		lblName.setText("Name:");
		
		textName = new Text(shlProductManagement, SWT.NONE);
		textName.setBounds(81, 183, 169, 21);
		
		Label lblPrice = new Label(shlProductManagement, SWT.NONE);
		lblPrice.setBounds(10, 213, 55, 15);
		lblPrice.setText("Price:");
		
		textPrice = new Text(shlProductManagement, SWT.NONE);
		textPrice.setBounds(81, 210, 169, 21);
		
		Label lblQuantity = new Label(shlProductManagement, SWT.NONE);
		lblQuantity.setBounds(10, 234, 55, 15);
		lblQuantity.setText("Quantity:");
		
		textQuantity = new Text(shlProductManagement, SWT.NONE);
		textQuantity.setBounds(81, 237, 169, 21);
		
		Label lblDescription = new Label(shlProductManagement, SWT.NONE);
		lblDescription.setBounds(10, 267, 55, 15);
		lblDescription.setText("Description:");
		
		textDescription = new Text(shlProductManagement, SWT.NONE);
		textDescription.setBounds(81, 264, 169, 21);
		
		
		
		
		
		
		
		
		
	
	}

}
