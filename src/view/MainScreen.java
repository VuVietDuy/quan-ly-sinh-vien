package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private StudentManagementView studentManagementView;
	private ClassManagementView classManagementView;
	private MajorManagementView majorManagementView;
	private InstructorManagementView instructorManagementView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainScreen frame = new MainScreen();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

    public MainScreen() {
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 650);

        MenuBarManager menuBar = new MenuBarManager(this);
        setJMenuBar(menuBar.getMenuBar());

        studentManagementView = new StudentManagementView();
        classManagementView = new ClassManagementView();
        majorManagementView = new MajorManagementView();
        instructorManagementView = new InstructorManagementView();
        setContentPane(studentManagementView);
    }
    
    

    public void setStudentManagementView() {
        setContentPane(studentManagementView);
        revalidate();
        repaint();
    }

    public void setClassManagementView() {
        setContentPane(classManagementView);
        revalidate();
        repaint();
    }
    
    public void setMajorManagementView() {
        setContentPane(majorManagementView);
        revalidate();
        repaint();
    }
    
    public void setInstructorManagementView() {
        setContentPane(instructorManagementView);
        revalidate();
        repaint();
    }
    
    public void closeJWindow() {
    	setVisible(false);
    }
}
