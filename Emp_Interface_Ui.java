package in.pennant.emp.crud;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Emp_Interface_Ui {
	protected static Frame mainframe = null;
	private static Image frameicon = null;
	private static Font mainfont = null;
	private static Font labelfont = null;
	private static Label mainlabel = null;
	private static Label empnolbl = null;
	private static Label namelbl = null;
	private static Label joblbl = null;
	private static Label sallbl = null;
	private static Label deptnolbl = null;
	private static Label hiredatelbl = null;
	protected static TextField empnofld = null;
	protected static TextField namefld = null;
	protected static TextField jobfld = null;
	protected static TextField salfld = null;
	protected static Choice deptnochc = null;
	protected static DateTextField hiredatefld = null;
	protected static Button firstbtn = null;
	protected static Button nextbtn = null;
	protected static Button prevbtn = null;
	protected static Button lastbtn = null;
	protected static Button addbtn = null;
	protected static Button editbtn = null;
	protected static Button delbtn = null;
	protected static Button savebtn = null;
	private static Button clearbtn = null;
	private static Button exitbtn = null;
	protected static int selected_option = 0;
	private static final HashSet<String> DEPT_NO_CHOICE = new HashSet<>();
	// result set to select get data
	protected static ResultSet result_set_scrollable = Jdbc_Crud_Methods.getResulSet();
	// private static
	protected static DefaultTableModel Table_Content = new DefaultTableModel();
	protected static JTable table_Reference = null;
	protected static JScrollPane table_Scroll_pane = null;
	static {
		try {
			while (result_set_scrollable.next()) {
				DEPT_NO_CHOICE.add(String.valueOf(result_set_scrollable.getInt("deptno")));
			}
			DEPT_NO_CHOICE.add("40");
		} catch (SQLException e) {
		}

	}
	static {
		mainframe = new Frame("EMP_CRUD_APP");
		mainframe.setSize(820, 800);
		mainframe.setLayout(null);
		mainframe.setVisible(true);
		Actions_Events_Emp_Crud.set_Table_Data();
		table_Reference = new JTable(Table_Content);
		// table_Reference.addMouseListener(new MouseListener() {
		//
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// if (e.getButton() == MouseEvent.BUTTON1) {
		// try {
		// result_set_scrollable.absolute(table_Reference.getSelectedRow() + 1);
		// } catch (SQLException e1) {
		// e1.printStackTrace();
		// }
		// Actions_Events_Emp_Crud.set_Records();
		// }
		// }
		//
		// @Override
		// public void mousePressed(MouseEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void mouseReleased(MouseEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void mouseEntered(MouseEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void mouseExited(MouseEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// });
		table_Reference.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					result_set_scrollable.absolute(table_Reference.getSelectedRow() + 1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				Actions_Events_Emp_Crud.set_TextFields();
			}
		});
		table_Scroll_pane = new JScrollPane(table_Reference);
		table_Scroll_pane.setBounds(20, 450, 780, 300);
		table_Scroll_pane.setEnabled(true);
		mainframe.add(table_Scroll_pane);
	}

	public Emp_Interface_Ui() {
		// creating a main frame for the app and setting the parameters

		mainframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		// setting an icon for the app
		frameicon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hemanthraju.v\\Desktop\\icon.png");
		mainframe.setIconImage(frameicon);
		// creating a font variable and setting title of the app
		// font declaration for title
		mainfont = new Font("SansSerif", Font.BOLD, 30);
		// label declaration and setup the font to frame
		mainlabel = new Label("EMPLOYEE CRUD APP");
		mainlabel.setAlignment(Label.CENTER);
		mainlabel.setBounds(150, 0, 500, 100);
		mainlabel.setFont(mainfont);
		mainframe.add(mainlabel);

		// labels for the fields names

		labelfont = new Font("SansSerif", Font.BOLD, 15);
		empnolbl = new Label("EMP NO :: ");
		empnolbl.setBounds(20, 150, 180, 20);
		empnolbl.setFont(labelfont);
		mainframe.add(empnolbl);

		empnofld = new TextField();
		empnofld.setBounds(200, 150, 200, 20);
		mainframe.add(empnofld);

		namelbl = new Label("EMP NAME :: ");
		namelbl.setBounds(420, 150, 150, 20);
		namelbl.setFont(labelfont);
		mainframe.add(namelbl);

		namefld = new TextField();
		namefld.setBounds(600, 150, 200, 20);
		mainframe.add(namefld);

		joblbl = new Label("JOB ROLE :: ");
		joblbl.setBounds(20, 200, 150, 20);
		joblbl.setFont(labelfont);
		mainframe.add(joblbl);

		jobfld = new TextField();
		jobfld.setBounds(200, 200, 200, 20);
		mainframe.add(jobfld);

		sallbl = new Label("SALARY :: ");
		sallbl.setBounds(420, 200, 150, 20);
		sallbl.setFont(labelfont);
		mainframe.add(sallbl);

		salfld = new TextField();
		salfld.setBounds(600, 200, 200, 20);
		mainframe.add(salfld);

		deptnolbl = new Label("DEPARTMENT NO :: ");
		deptnolbl.setBounds(20, 250, 150, 20);
		deptnolbl.setFont(labelfont);

		deptnochc = new Choice();
		deptnochc.setBounds(200, 250, 200, 20);
		DEPT_NO_CHOICE.forEach(deptnochc::add);
		mainframe.add(deptnochc);

		mainframe.add(deptnolbl);
		hiredatelbl = new Label("HIRED DATE ::");
		hiredatelbl.setBounds(420, 250, 150, 20);
		hiredatelbl.setFont(labelfont);
		mainframe.add(hiredatelbl);

		hiredatefld = new DateTextField();
		hiredatefld.setBounds(600, 250, 150, 20);
		mainframe.add(hiredatefld);

		// buttons for iterating the records
		firstbtn = new Button("First");
		firstbtn.setBounds(50, 300, 100, 20);
		firstbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actions_Events_Emp_Crud.first_Action();
			}
		});
		mainframe.add(firstbtn);

		nextbtn = new Button("Next");
		nextbtn.setBounds(250, 300, 100, 20);
		nextbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actions_Events_Emp_Crud.next_Action();
			}
		});
		mainframe.add(nextbtn);

		prevbtn = new Button("Previous");
		prevbtn.setBounds(450, 300, 100, 20);
		mainframe.add(prevbtn);
		prevbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actions_Events_Emp_Crud.prev_Action();
			}
		});
		mainframe.add(prevbtn);

		lastbtn = new Button("Last");
		lastbtn.setBounds(650, 300, 100, 20);
		lastbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actions_Events_Emp_Crud.last_Action();
			}
		});
		mainframe.add(lastbtn);

		// buttons for crud
		addbtn = new Button("Add");
		addbtn.setBounds(50, 340, 100, 20);
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Jdbc_Crud_Methods.JDBC_CONNECTION.setAutoCommit(true);
					Actions_Events_Emp_Crud.add_Action();
				} catch (SQLException e1) {

				}

			}
		});
		mainframe.add(addbtn);

		editbtn = new Button("Edit");
		editbtn.setBounds(250, 340, 100, 20);
		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actions_Events_Emp_Crud.edit_Action();
			}
		});
		mainframe.add(editbtn);

		delbtn = new Button("Delete");
		delbtn.setBounds(450, 340, 100, 20);
		delbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_option = JOptionPane.showConfirmDialog(mainframe, "are you you want to delete the record?");
				if (selected_option == JOptionPane.YES_OPTION) {
					Actions_Events_Emp_Crud.delete_Action();
				}

			}
		});
		mainframe.add(delbtn);

		savebtn = new Button("Save");
		savebtn.setBounds(650, 340, 100, 20);
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_option = JOptionPane.showConfirmDialog(mainframe, "are you sure you want to save the record?");
				if (selected_option == JOptionPane.YES_OPTION) {
					Actions_Events_Emp_Crud.save_Action();
				}
			}
		});
		mainframe.add(savebtn);

		// buttons for clear screen and exit app
		clearbtn = new Button("Clear");
		clearbtn.setBounds(150, 380, 100, 20);
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actions_Events_Emp_Crud.clear_Action();
			}
		});
		mainframe.add(clearbtn);

		exitbtn = new Button("Exit");
		exitbtn.setBounds(550, 380, 100, 20);
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mainframe.add(exitbtn);

	}

	public static void main(String[] args) {
		new Emp_Interface_Ui();
	}
}