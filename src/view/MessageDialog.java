package view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class MessageDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MessageDialog dialog = new MessageDialog("Bạn có muốn xoá không?");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MessageDialog(String message) {
		setBounds(200, 200, 400, 203);
		setTitle("Xác nhận");
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 384, 98);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel messageLb = new JLabel(message);
			messageLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
			messageLb.setBounds(49, 33, 286, 32);
			contentPanel.add(messageLb);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 98, 384, 66);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.setBounds(199, 17, 64, 32);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setBounds(273, 17, 80, 32);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JButton getOkButton() {
		return this.okButton;
	}

	public JButton getCancelButton() {
		return this.cancelButton;
	}

}
