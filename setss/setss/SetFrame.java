import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SetFrame extends JFrame implements ActionListener{

 JPanel north, center;
 JButton btnSetA, btnSetB, btnShow;
 JLabel lblSetA, lblSetB, lblUnion, lblIntersection,lblAB,lblBA,lblSubsetA, lblSubsetB, lblCardinalA, lblCardinalB;
 MySet setA = new MySet();
 MySet setB = new MySet();
 
 public SetFrame(){
  super("Set");
  setSize(500,500);
  setVisible(true);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  
  north = new JPanel();
  center = new JPanel();
  north.setLayout(new FlowLayout());
  center.setLayout(new GridLayout(11,2));
  
  btnSetA = new JButton("setA");
  btnSetB = new JButton("setB"); 
  btnShow = new JButton("Show Results");
  
  lblSetA = new JLabel();
  lblSetB = new JLabel();
  lblUnion = new JLabel();
  lblIntersection = new JLabel();
  lblAB = new JLabel();
  lblBA = new JLabel();
  lblSubsetA = new JLabel();
  lblSubsetB = new JLabel();
  lblCardinalA = new JLabel();
  lblCardinalB = new JLabel();
  add(north,BorderLayout.NORTH);
  add(center);
  
  north.add(new JLabel("Enter elements for"));
  north.add(btnSetA);
  north.add(btnSetB);
 center.add(btnShow);
 center.add(new JLabel());
 center.add(new JLabel("setA contains:"));
 center.add(lblSetA);
 center.add(new JLabel("setB contains:"));
 center.add(lblSetB);
 center.add(new JLabel("union:"));
 center.add(lblUnion);
 center.add(new JLabel("intersection:"));
 center.add(lblIntersection);
 center.add(new JLabel("A-B:"));
 center.add(lblAB);
 center.add(new JLabel("B-A:"));
 center.add(lblBA);
 center.add(new JLabel("Set A is subset of Set B:"));
 center.add(lblSubsetA);
 center.add(new JLabel("Set B is subset of Set A:"));
 center.add(lblSubsetB);
 center.add(new JLabel("The Cardinality of Set A is :"));
 center.add(lblCardinalA);
 center.add(new JLabel("The Cardinality of Set B is:"));
 center.add(lblCardinalB);
  
 pack();
 btnSetA.addActionListener(this);
 btnSetB.addActionListener(this);
 btnShow.addActionListener(this);
 }
 
 public void actionPerformed(ActionEvent e)
 {
 if(e.getSource() == btnSetA)
 {
  String input = JOptionPane.showInputDialog("Enter elements for setA[separate by space]");
  String [] strData = input.split(" ");
  for(int i = 0; i < strData.length; i++){
   setA.add(Integer.parseInt(strData[i]));
  }
 }
 if(e.getSource() == btnSetB)
 {
   String input = JOptionPane.showInputDialog("Enter elements for setB[separate by space]");
  String [] strData = input.split(" ");
  for(int i = 0; i < strData.length; i++)
  {
   setB.add(Integer.parseInt(strData[i]));
  }
 }
 if(e.getSource() == btnShow)
 {
   lblSetA.setText(setA.toString());
   lblSetB.setText(setB.toString());
   lblUnion.setText(setA.union(setB).toString());
   lblIntersection.setText(setA.intersection(setB).toString());
   lblAB.setText(setB.difference(setA).toString());
   lblBA.setText(setA.difference(setB).toString());
   lblSubsetA.setText(setA.isSubset(setB).toString());
   lblSubsetB.setText(setB.isSubset(setA));
   lblCardinalA.setText(String.parseString(setA.cardinality()));
 }
 }
 
 public static void main(String [] args){
  new SetFrame();
 }
}