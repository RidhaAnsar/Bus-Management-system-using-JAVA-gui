package com.mycompany.mavenproject3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public final class bus_system extends javax.swing.JFrame {
public bus_system () {
initComponents();
connect();
load(&quot;select * from bus&quot;);
}
Connection con;
PreparedStatement pat;
DefaultTableModel def;
public void connect() {
try {
Class.forName(&quot;com.mysql.cj.jdbc.Driver&quot;);
con = DriverManager.getConnection(&quot;jdbc:mysql://localhost/bus_management&quot;, &quot;root&quot;,
&quot;&quot;);
} catch (ClassNotFoundException ex) {
Logger.getLogger(bus_system.class.getName()).log(Level.SEVERE, null, ex);
} catch (SQLException ex) {
Logger.getLogger(bus_system.class.getName()).log(Level.SEVERE, null, ex);
}
}
private void back() {
Welcome dashboard = new Welcome();
dashboard.setVisible(true);
this.dispose();
}
public void load(String sql) {

try {
pat = con.prepareStatement(sql);
ResultSet rs = pat.executeQuery();
ResultSetMetaData rss = rs.getMetaData();
int c;
c = rss.getColumnCount();
def = (DefaultTableModel) jTable1.getModel();
def.setRowCount(0);
while (rs.next()) {
Vector v = new Vector();
for (int i = 0; i &lt; c; i++) {
v.add(rs.getString(&quot;id&quot;));
v.add(rs.getString(&quot;name&quot;));
v.add(rs.getString(&quot;number&quot;));
v.add(rs.getString(&quot;state&quot;));
v.add(rs.getString(&quot;from_place&quot;));
v.add(rs.getString(&quot;to_place&quot;));
}
def.addRow(v);
}
} catch (SQLException ex) {
Logger.getLogger(bus_system..class.getName()).log(Level.SEVERE, null, ex);
}
}
private void initComponents() {
jLabel3 = new javax.swing.JLabel();
txtName = new javax.swing.JTextField();
txtNumber = new javax.swing.JTextField();
Addbtn = new javax.swing.JButton();
jLabel4 = new javax.swing.JLabel();
jLabel1 = new javax.swing.JLabel();
jScrollPane1 = new javax.swing.JScrollPane();
jTable1 = new javax.swing.JTable();
jLabel5 = new javax.swing.JLabel();
txtCountry = new javax.swing.JTextField();
jLabel6 = new javax.swing.JLabel();
txtFrom = new javax.swing.JTextField();

txtTo = new javax.swing.JTextField();
jLabel7 = new javax.swing.JLabel();
jButton2 = new javax.swing.JButton();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
jLabel3.setText(&quot;Plate Number&quot;);
txtName.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
txtNameActionPerformed(evt);
}
});
txtNumber.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
txtNumberActionPerformed(evt);
}
});
Addbtn.setFont(new java.awt.Font(&quot;Times New Roman&quot;, 0, 14)); // NOI18N
Addbtn.setText(&quot;Add Bus&quot;);
Addbtn.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
AddbtnActionPerformed(evt);
}
});
jLabel4.setBackground(new java.awt.Color(255, 153, 153));
jLabel4.setFont(new java.awt.Font(&quot;Times New Roman&quot;, 0, 24)); // NOI18N
jLabel4.setForeground(new java.awt.Color(0, 51, 51));
jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
jLabel4.setText(&quot;Bus Management System &quot;);
jLabel1.setText(&quot;Name&quot;);
jTable1.setModel(new javax.swing.table.DefaultTableModel(
new Object [][] {
},

new String [] {
&quot;ID&quot;, &quot;Name&quot;, &quot;Plate Number&quot;, &quot;State&quot;, &quot;From&quot;, &quot;To&quot;
}
));
jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseClicked(java.awt.event.MouseEvent evt) {
jTable1MouseClicked(evt);
}
});
jScrollPane1.setViewportView(jTable1);
jLabel5.setText(&quot;State&quot;);
jLabel6.setText(&quot;From&quot;);
jLabel7.setText(&quot;To&quot;);
jButton2.setBackground(new java.awt.Color(255, 51, 51));
jButton2.setText(&quot;Back&quot;);
jButton2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(51, 51, 51)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jLabel1)
.addComponent(jLabel3)
.addComponent(jLabel5)
.addComponent(jLabel6)

.addComponent(jLabel7))
.addGap(93, 93, 93)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
.addComponent(txtNumber)
.addComponent(txtName)
.addComponent(txtCountry)
.addComponent(txtFrom,
javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE,
103, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(18, 18, 18)
.addComponent(jScrollPane1,
javax.swing.GroupLayout.PREFERRED_SIZE, 515,
javax.swing.GroupLayout.PREFERRED_SIZE))
.addGroup(layout.createSequentialGroup()
.addGap(29, 29, 29)
.addComponent(Addbtn, javax.swing.GroupLayout.PREFERRED_SIZE,
222, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGroup(layout.createSequentialGroup()
.addGap(100, 100, 100)
.addComponent(jButton2))))
.addGroup(layout.createSequentialGroup()
.addGap(173, 173, 173)
.addComponent(jLabel4)))
.addContainerGap(387, Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(19, 19, 19)
.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(47, 47, 47)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel1)
.addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(46, 46, 46)

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel3)
.addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(20, 20, 20)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel5))
.addGap(12, 12, 12)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel6)
.addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel7)))
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219,
javax.swing.GroupLayout.PREFERRED_SIZE))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33,
Short.MAX_VALUE)
.addComponent(Addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(18, 18, 18)
.addComponent(jButton2)
.addGap(93, 93, 93))
);
pack();
}// &lt;/editor-fold&gt;
private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
}
private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {
try {
String name,number,state,from_place, to_place;

name = txtName.getText();
number = txtNumber.getText();
state = txtCountry.getText();
from_place=txtFrom.getText();
to_place= txtTo.getText();

pat = con.prepareStatement(&quot;Insert into bus(name, number, state, from_place,
to_place)values(?,?,?,?,?)&quot;);
pat.setString(1, name);
pat.setString(2, number);
pat.setString(3, state);
pat.setString(4, from_place);
pat.setString(5, to_place);

pat.executeUpdate();
txtName.setText(&quot;&quot;);
txtNumber.setText(&quot;&quot;);
txtCountry.setText(&quot;&quot;);
txtFrom.setText(&quot;&quot;);
txtTo.setText(&quot;&quot;);
txtName.requestFocus();
load(&quot;select * from bus&quot;);
JOptionPane.showMessageDialog(this, &quot;Records Added&quot;);
} catch (SQLException ex) {
Logger.getLogger(bus_system.class.getName()).log(Level.SEVERE, null, ex);
}
}
private void txtNumberActionPerformed(java.awt.event.ActionEvent evt) {
}
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
back();
}

private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
def = (DefaultTableModel) jTable1.getModel();
int selected = jTable1.getSelectedRow();
int id = Integer.parseInt(def.getValueAt(selected, 0).toString());
txtName.setText(def.getValueAt(selected, 1).toString());
txtNumber.setText(def.getValueAt(selected, 2).toString());
txtCountry.setText(def.getValueAt(selected, 3).toString());
txtFrom.setText(def.getValueAt(selected, 4).toString());
txtTo.setText(def.getValueAt(selected, 5).toString());
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
java.util.logging.Logger.getLogger(bus_system.class.getName()).log(java.util.logging.Level.SE
VERE, null, ex);
} catch (InstantiationException ex) {
java.util.logging.Logger.getLogger(bus_system.class.getName()).log(java.util.logging.Level.SE
VERE, null, ex);
} catch (IllegalAccessException ex) {
java.util.logging.Logger.getLogger(bus_system.class.getName()).log(java.util.logging.Level.SE
VERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
java.util.logging.Logger.getLogger(bus_system.class.getName()).log(java.util.logging.Level.SE
VERE, null, ex);
}
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
new bus_system().setVisible(true);
}
});

}
private javax.swing.JButton Addbtn;
private javax.swing.JButton jButton2;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel4;
private javax.swing.JLabel jLabel5;
private javax.swing.JLabel jLabel6;
private javax.swing.JLabel jLabel7;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTable jTable1;
private javax.swing.JTextField txtCountry;
private javax.swing.JTextField txtFrom;
private javax.swing.JTextField txtName;
private javax.swing.JTextField txtNumber;
private javax.swing.JTextField txtTo;
// End of variables declaration
}
