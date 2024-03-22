package com.mycompany.mavenproject3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class LoginForm extends javax.swing.JFrame {
private Connection con;
public LoginForm() {
initComponents();
connect();
System.out.println(&quot;Connection status after connect method: &quot; + (con != null ? &quot;Connected&quot;
: &quot;Not connected&quot;));
}

private void connect() {
try {
Class.forName(&quot;com.mysql.cj.jdbc.Driver&quot;);
con = DriverManager.getConnection(&quot;jdbc:mysql://localhost/bus_management&quot;, &quot;root&quot;, &quot;&quot;);
System.out.println(&quot;Connection established successfully&quot;);
} catch (ClassNotFoundException | SQLException ex) {
Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
System.out.println(&quot;Exception during connection: &quot; + ex.getMessage());
}
}
@SuppressWarnings(&quot;unchecked&quot;)
private void initComponents() {
jLabel1 = new javax.swing.JLabel();
jLabel2 = new javax.swing.JLabel();
jButton1 = new javax.swing.JButton();
jTextField1 = new javax.swing.JTextField();
jLabel3 = new javax.swing.JLabel();
jPasswordField1 = new javax.swing.JPasswordField();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
setBackground(new java.awt.Color(255, 153, 153));
jLabel1.setFont(new java.awt.Font(&quot;Times New Roman&quot;, 0, 14)); // NOI18N
jLabel1.setText(&quot;USERNAME&quot;);
jLabel2.setFont(new java.awt.Font(&quot;Times New Roman&quot;, 0, 14)); // NOI18N
jLabel2.setText(&quot;PASSWORD&quot;);
jButton1.setFont(new java.awt.Font(&quot;Times New Roman&quot;, 0, 14)); // NOI18N
jButton1.setText(&quot;LOGIN&quot;);
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});
jLabel3.setFont(new java.awt.Font(&quot;Times New Roman&quot;, 0, 24)); // NOI18N
jLabel3.setText(&quot;Bus Management System&quot;);

jPasswordField1.setText(&quot;password&quot;);
jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jPasswordField1ActionPerformed(evt);
}
});
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap(227, Short.MAX_VALUE)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
layout.createSequentialGroup()
.addGap(111, 111, 111)
.addComponent(jButton1))
.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jLabel1)
.addComponent(jLabel2))
.addGap(160, 160, 160)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
.addComponent(jTextField1)
.addComponent(jPasswordField1,
javax.swing.GroupLayout.PREFERRED_SIZE, 71,
javax.swing.GroupLayout.PREFERRED_SIZE))))
.addGap(220, 220, 220))
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
layout.createSequentialGroup()
.addComponent(jLabel3)
.addGap(272, 272, 272))))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

.addGroup(layout.createSequentialGroup()
.addGap(176, 176, 176)
.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62,
Short.MAX_VALUE)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel1)
.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(45, 45, 45)
.addComponent(jLabel2))
.addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING,
javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(46, 46, 46)
.addComponent(jButton1)
.addGap(132, 132, 132))
);
pack();
}
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
String enteredUsername = jTextField1.getText();
char[] enteredPasswordArray = jPasswordField1.getPassword();
String enteredPassword = new String(enteredPasswordArray);
if (checkCredentials(enteredUsername, enteredPassword)) {
// If credentials are correct, open the dashboard
System.out.println(&quot;Credentials are correct. Opening Dashboard...&quot;);
openDashboard();
JOptionPane.showMessageDialog(this, &quot;You have successfully logged in&quot;);
} else {
System.out.println(&quot;Invalid username or password&quot;);
showErrorDialog(&quot;Invalid username or password&quot;);
}
}

private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {
}
private boolean checkCredentials(String username, String password) {
try {
if (con == null) {
System.out.println(&quot;Connection is null. Please check the connect method.&quot;);
return false;
}
// Prepare the SQL query
String sql = &quot;SELECT * FROM login WHERE username = ? AND password = ?&quot;;
try (PreparedStatement pstmt = con.prepareStatement(sql)) {
pstmt.setString(1, username);
pstmt.setString(2, password);
ResultSet resultSet = pstmt.executeQuery();
return resultSet.next();
}
} catch (SQLException ex) {
ex.printStackTrace();
return false;
}
}
private void openDashboard() {
Welcome dashboard = new Welcome();
dashboard.setVisible(true);
this.dispose();
}
private void showErrorDialog(String errorMessage) {
javax.swing.JOptionPane.showMessageDialog(this, errorMessage, &quot;Error&quot;,
javax.swing.JOptionPane.ERROR_MESSAGE);
}
public static void main(String args[]) {
try {
for (javax.swing.UIManager.LookAndFeelInfo info :
javax.swing.UIManager.getInstalledLookAndFeels()) {
if (&quot;Nimbus&quot;.equals(info.getName())) {
javax.swing.UIManager.setLookAndFeel(info.getClassName());

break;
}
}
} catch (ClassNotFoundException ex) {
java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SE
VERE, null, ex);
} catch (InstantiationException ex) {
java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SE
VERE, null, ex);
} catch (IllegalAccessException ex) {
java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SE
VERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SE
VERE, null, ex);
}
java.awt.EventQueue.invokeLater(new Runnable() {
@Override
public void run() {
new LoginForm().setVisible(true);
}
});
}

private javax.swing.JButton jButton1;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel3;
private javax.swing.JPasswordField jPasswordField1;
private javax.swing.JTextField jTextField1;
// End of variables declaration
}
