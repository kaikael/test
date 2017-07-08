/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportradartest;

import com.sportradar.sdk.common.exceptions.SdkException;
import com.sportradar.sdk.feed.common.entities.EventIdentifier;
import com.sportradar.sdk.feed.livescout.entities.MatchUpdateEntity;
import com.sportradar.sdk.feed.livescout.entities.ScoutEventEntity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PH1286
 */
public class UI extends JFrame {

    SportradarTest srt;
    JFrame frame;
    JPanel panel;
    JButton btnConnect;
    JButton btnGetMatches;
    JButton btnSubscribe;
    JTable matchTable;
    String[] columns;
    JTextArea jTextArea;
    Long selectedRow;

    @SuppressWarnings("empty-statement")
    public UI() {
        srt = new SportradarTest(this);

        frame = new JFrame();
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnConnect = new JButton("Connect");
        btnConnect.setBounds(0, 0, 100, 25);
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    srt.start();
                } catch (SdkException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        frame.add(btnConnect);

        btnGetMatches = new JButton("Get Booked Match List");
        btnGetMatches.setBounds(105, 0, 175, 25);
        btnGetMatches.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                srt.getMatches();
            }
        });
        frame.add(btnGetMatches);

        JScrollPane scrollPaneTable = new JScrollPane();
        scrollPaneTable.setBounds(0, 50, 400, 500);
        frame.getContentPane().add(scrollPaneTable);

        columns = new String[]{"Match Id", "Date", "Team1", "Team2"};
        DefaultTableModel tm = new DefaultTableModel(new Object[][]{}, columns);
        matchTable = new JTable(tm);
        scrollPaneTable.setViewportView(matchTable);
//        frame.add(matchTable);
        
        matchTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                selectedRow = (Long) matchTable.getValueAt(matchTable.getSelectedRow(), 0);
                
            }
        });

        btnSubscribe = new JButton("Subscribe");
        btnSubscribe.setBounds(0, 555, 100, 25);
        btnSubscribe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                EventIdentifier[] eiList = new EventIdentifier[1];
                eiList[0] = EventIdentifier.id(selectedRow);
                jTextArea.setText("");
                srt.subscribeMatch(eiList);
            }
        });
        frame.add(btnSubscribe);

        JScrollPane scrollPaneTextArea = new JScrollPane();
        scrollPaneTextArea.setBounds(450, 50, 400, 500);
        jTextArea = new JTextArea();
        scrollPaneTextArea.setViewportView(jTextArea);
        frame.getContentPane().add(scrollPaneTextArea);

        frame.setVisible(true);
    }

    public void displayMatches(List<MatchUpdateEntity> matchList) {
        System.out.println("displayMatches");
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columns);
        for (MatchUpdateEntity match : matchList) {
            if (match.getMatchHeader().isBooked()) {
                Object[] obj = new Object[4];
                obj[0] = match.getMatchHeader().getMatchId();
                obj[1] = match.getMatchHeader().getStart();
                obj[2] = match.getMatchHeader().getTeam1().getName();
                obj[3] = match.getMatchHeader().getTeam2().getName();
                model.addRow(obj);
            }
        }
        matchTable.setModel(model);
    }

    void displayEvents(MatchUpdateEntity mue) {
        System.out.println("displayEvents");
//        StringBuilder sb = new StringBuilder();
        
//        System.out.println(mue.getMatchHeader().getMatchId());
//        System.out.println(mue.getEventId());
        for(ScoutEventEntity see: mue.getEvents()){
            jTextArea.append(see.getMatchTime()+" "
                    +see.getRemainingTimeInPeriod()+" "
                    +see.getType()+" "
                    +see.getInfo()+"\n");
        }
    }

    public static void main(String[] args) {
        new UI();

    }

}
