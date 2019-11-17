// 
// Decompiled by Procyon v0.5.36
// 

package aula8_3QQSM;

import java.util.Iterator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.Random;
import java.util.Enumeration;
import javax.swing.JOptionPane;
import java.awt.LayoutManager;
import org.jdesktop.layout.GroupLayout;
import javax.swing.AbstractButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.util.ArrayList;
import java.io.File;
import javax.swing.JFrame;

public class QuizGUI extends JFrame
{
    private Question currentQuestion;
    private File quizFile;
    private ArrayList[] quizes;
    private int[] money;
    private int currentLevel;
    private int subLevel;
    private JButton btn5050;
    private JButton btnFim;
    private JButton btnPublico;
    private JButton btnSeguinte;
    private JButton btnTelefone;
    private ButtonGroup buttonGroup1;
    private JScrollPane jScrollPane1;
    private JLabel lblImage;
    private JLabel lblLevel;
    private JRadioButton radioA;
    private JRadioButton radioB;
    private JRadioButton radioC;
    private JRadioButton radioD;
    private JTextArea txtPergunta;
    
    public QuizGUI() {
        this.quizFile = new File("questions.txt");
        this.quizes = new ArrayList[] { new ArrayList(), new ArrayList(), new ArrayList() };
        this.money = new int[] { 25, 50, 125, 250, 500, 750, 1500, 2500, 5000, 10000, 16000, 32000, 64000, 125000, 250000 };
        this.currentLevel = 0;
        this.subLevel = 0;
        this.initComponents();
        this.initFiles();
        this.loadQuizes();
        this.printQuizes();
        this.showNextQuiz();
    }
    
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.lblImage = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.txtPergunta = new JTextArea();
        this.btnPublico = new JButton();
        this.btnTelefone = new JButton();
        this.btn5050 = new JButton();
        this.btnSeguinte = new JButton();
        this.lblLevel = new JLabel();
        this.btnFim = new JButton();
        this.radioA = new JRadioButton();
        this.radioB = new JRadioButton();
        this.radioC = new JRadioButton();
        this.radioD = new JRadioButton();
        this.setDefaultCloseOperation(3);
        this.setTitle("Quem Quer Ser Milion\u00e1rio");
        this.lblImage.setText("jLabel1");
        this.txtPergunta.setBackground(new Color(240, 240, 240));
        this.txtPergunta.setColumns(20);
        this.txtPergunta.setEditable(false);
        this.txtPergunta.setFont(new Font("Trebuchet MS", 0, 24));
        this.txtPergunta.setLineWrap(true);
        this.txtPergunta.setRows(5);
        this.txtPergunta.setWrapStyleWord(true);
        this.txtPergunta.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240), 0));
        this.jScrollPane1.setViewportView(this.txtPergunta);
        this.btnPublico.setText("Ajuda Publico");
        this.btnPublico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                QuizGUI.this.btnPublicoActionPerformed(evt);
            }
        });
        this.btnTelefone.setText("Telefonema");
        this.btnTelefone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                QuizGUI.this.btnTelefoneActionPerformed(evt);
            }
        });
        this.btn5050.setText("50 - 50");
        this.btn5050.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                QuizGUI.this.btn5050ActionPerformed(evt);
            }
        });
        this.btnSeguinte.setText("Confirmar");
        this.btnSeguinte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                QuizGUI.this.btnSeguinteActionPerformed(evt);
            }
        });
        this.lblLevel.setFont(new Font("Vrinda", 0, 14));
        this.lblLevel.setHorizontalAlignment(11);
        this.lblLevel.setText("50\u20ac");
        this.btnFim.setText("Desistir");
        this.btnFim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                QuizGUI.this.btnFimActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.radioA);
        this.radioA.setText("jRadioButton1");
        this.buttonGroup1.add(this.radioB);
        this.radioB.setText("jRadioButton2");
        this.buttonGroup1.add(this.radioC);
        this.radioC.setText("jRadioButton1");
        this.buttonGroup1.add(this.radioD);
        this.radioD.setText("jRadioButton2");
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout((LayoutManager)layout);
        layout.setHorizontalGroup((GroupLayout.Group)layout.createParallelGroup(1).add((GroupLayout.Group)layout.createSequentialGroup().addContainerGap().add((GroupLayout.Group)layout.createParallelGroup(1).add((GroupLayout.Group)layout.createSequentialGroup().add((Component)this.lblImage, -2, 297, -2).addPreferredGap(1).add((GroupLayout.Group)layout.createParallelGroup(1).add((Component)this.jScrollPane1, -2, 274, -2).add((Component)this.lblLevel, -1, 274, 32767))).add((GroupLayout.Group)layout.createSequentialGroup().add((GroupLayout.Group)layout.createParallelGroup(2).add(1, (Component)this.radioC, -1, 203, 32767).add(1, (GroupLayout.Group)layout.createSequentialGroup().add((Component)this.btnPublico, -1, -1, 32767).addPreferredGap(0).add((Component)this.btnTelefone, -2, 100, -2)).add(1, (Component)this.radioA, -1, 203, 32767)).addPreferredGap(0).add((GroupLayout.Group)layout.createParallelGroup(1).add((Component)this.btn5050, -2, 99, -2).add((Component)this.radioB, -2, 218, -2).add((GroupLayout.Group)layout.createSequentialGroup().add((Component)this.radioD, -2, 218, -2).addPreferredGap(0).add((Component)this.btnFim, -1, -1, 32767).addPreferredGap(0).add((Component)this.btnSeguinte))))).addContainerGap()));
        layout.setVerticalGroup((GroupLayout.Group)layout.createParallelGroup(1).add((GroupLayout.Group)layout.createSequentialGroup().add((GroupLayout.Group)layout.createParallelGroup(2, false).add((Component)this.lblImage, -2, 283, -2).add(1, (GroupLayout.Group)layout.createSequentialGroup().add((Component)this.lblLevel, -2, 26, -2).addPreferredGap(0, -1, 32767).add((Component)this.jScrollPane1, -2, 190, -2))).addPreferredGap(1).add((GroupLayout.Group)layout.createParallelGroup(1).add((GroupLayout.Group)layout.createParallelGroup(3).add((Component)this.btnTelefone).add((Component)this.btn5050)).add((Component)this.btnPublico)).add(11, 11, 11).add((GroupLayout.Group)layout.createParallelGroup(2).add((GroupLayout.Group)layout.createSequentialGroup().add((GroupLayout.Group)layout.createParallelGroup(1).add((Component)this.radioA).add((Component)this.radioB)).add(16, 16, 16).add((GroupLayout.Group)layout.createParallelGroup(3).add((Component)this.radioC).add((Component)this.radioD))).add((GroupLayout.Group)layout.createParallelGroup(3).add((Component)this.btnSeguinte).add((Component)this.btnFim))).addContainerGap()));
        this.pack();
    }
    
    private void btnSeguinteActionPerformed(final ActionEvent evt) {
        final Enumeration<AbstractButton> radios = this.buttonGroup1.getElements();
        while (radios.hasMoreElements()) {
            final AbstractButton radio = radios.nextElement();
            if (radio.isSelected()) {
                if (radio.getText().equals(this.currentQuestion.answers[0])) {
                    ++this.subLevel;
                    this.showNextQuiz();
                }
                else {
                    JOptionPane.showConfirmDialog(null, "Ganhou " + this.money[this.currentLevel * 5] + "\u20ac", "Fim do Jogo!", 2);
                    System.exit(0);
                }
            }
        }
    }
    
    private void btnFimActionPerformed(final ActionEvent evt) {
        final int i = this.currentLevel * 5 + this.subLevel;
        JOptionPane.showConfirmDialog(null, "Ganhou " + this.money[i] + "\u20ac", "Fim do Jogo!", 2);
        System.exit(0);
    }
    
    private JRadioButton getRightRadio() {
        if (this.radioA.getText().equals(this.currentQuestion.answers[0])) {
            return this.radioA;
        }
        if (this.radioB.getText().equals(this.currentQuestion.answers[0])) {
            return this.radioB;
        }
        if (this.radioC.getText().equals(this.currentQuestion.answers[0])) {
            return this.radioC;
        }
        return this.radioD;
    }
    
    private void btn5050ActionPerformed(final ActionEvent evt) {
        final JRadioButton right = this.getRightRadio();
        final JRadioButton[] all = { this.radioA, this.radioB, this.radioC, this.radioD };
        int idx1 = 0;
        int idx2 = 0;
        do {
            final Random ran = new Random(System.currentTimeMillis());
            idx1 = ran.nextInt(4);
            idx2 = ran.nextInt(4);
        } while (idx1 == idx2 || right.equals(all[idx1]) || right.equals(all[idx2]));
        this.buttonGroup1.clearSelection();
        all[idx1].setEnabled(false);
        all[idx2].setEnabled(false);
        this.btn5050.setEnabled(false);
    }
    
    private void btnPublicoActionPerformed(final ActionEvent evt) {
        final Random ran = new Random(System.currentTimeMillis());
        final boolean[][] array = { { true, true, true, true, true, true, true, true, true, false }, null, null };
        final int n = 1;
        final boolean[] array2 = new boolean[10];
        array2[1] = (array2[0] = true);
        array2[3] = (array2[2] = true);
        array[n] = array2;
        final int n2 = 2;
        final boolean[] array3 = new boolean[10];
        array3[1] = (array3[0] = true);
        array[n2] = array3;
        final boolean[][] all = array;
        final boolean[] now = all[this.currentLevel];
        final int[] errado = new int[3];
        int certo = 0;
        for (int total = 100, i = 0; i < total; ++i) {
            final int pos = ran.nextInt(now.length);
            if (now[pos]) {
                ++certo;
            }
            else {
                final int[] array4 = errado;
                final int nextInt = ran.nextInt(3);
                ++array4[nextInt];
            }
        }
        final JRadioButton right = this.getRightRadio();
        final JRadioButton[] radios = { this.radioA, this.radioB, this.radioC, this.radioD };
        String msg = "";
        int j = 0;
        JRadioButton[] array5;
        for (int length = (array5 = radios).length, k = 0; k < length; ++k) {
            final JRadioButton r = array5[k];
            if (right.equals(r)) {
                msg = String.valueOf(msg) + r.getText() + ": " + certo + "%\n";
            }
            else {
                msg = String.valueOf(msg) + r.getText() + ": " + errado[j] + "%\n";
                ++j;
            }
        }
        JOptionPane.showConfirmDialog(null, msg, "Ajuda do P\u00fablico", 2);
        this.btnPublico.setEnabled(false);
    }
    
    private void btnTelefoneActionPerformed(final ActionEvent evt) {
        final Random ran = new Random(System.currentTimeMillis());
        final boolean[][] array = { { true, true, true, true, true, true, true, true, true, false }, null, null };
        final int n = 1;
        final boolean[] array2 = new boolean[10];
        array2[1] = (array2[0] = true);
        array2[3] = (array2[2] = true);
        array[n] = array2;
        final int n2 = 2;
        final boolean[] array3 = new boolean[10];
        array3[1] = (array3[0] = true);
        array[n2] = array3;
        final boolean[][] all = array;
        final boolean[] now = all[this.currentLevel];
        final int[] errado = new int[3];
        int certo = 0;
        for (int total = 100, i = 0; i < total; ++i) {
            final int pos = ran.nextInt(now.length);
            if (now[pos]) {
                ++certo;
            }
            else {
                final int[] array4 = errado;
                final int nextInt = ran.nextInt(3);
                ++array4[nextInt];
            }
        }
        final JRadioButton right = this.getRightRadio();
        final JRadioButton[] radios = { this.radioA, this.radioB, this.radioC, this.radioD };
        String msg = "Duvida entre:\n";
        int j = 0;
        JRadioButton[] array5;
        for (int length = (array5 = radios).length, k = 0; k < length; ++k) {
            final JRadioButton r = array5[k];
            if (right.equals(r)) {
                msg = String.valueOf(msg) + "\t" + r.getText() + ": " + certo + "%\n";
            }
            else if (j != 1) {
                msg = String.valueOf(msg) + "\t" + r.getText() + ": " + errado[0] + "%\n";
                ++j;
            }
        }
        JOptionPane.showConfirmDialog(null, msg, "Ajuda do P\u00fablico", 2);
        this.btnTelefone.setEnabled(false);
    }
    
    public static void main(final String[] args) {
        new QuizGUI().setVisible(true);
    }
    
    private void showNextQuiz() {
        this.enableComp();
        assert this.currentLevel < 4;
        this.buttonGroup1.clearSelection();
        if (this.subLevel == 5) {
            if (this.currentLevel == 2) {
                JOptionPane.showConfirmDialog(null, "Ganhou 250.000\u20ac!!!", "Ganhou TUDO", 2);
                System.exit(0);
            }
            ++this.currentLevel;
            this.subLevel = 0;
            System.out.println("++" + this.currentLevel + " " + this.subLevel);
        }
        final int i = 5 * this.currentLevel + this.subLevel;
        this.lblLevel.setText(String.valueOf(this.money[i]) + "\u20ac");
        final Random ran = new Random(System.currentTimeMillis());
        final ArrayList<Question> quiz = (ArrayList<Question>)this.quizes[this.currentLevel];
        final int idx = ran.nextInt(quiz.size());
        this.currentQuestion = quiz.remove(idx);
        this.txtPergunta.setText(this.currentQuestion.question);
        final int[] d = { -1, -1, -1, -1 };
        d[0] = ran.nextInt(4);
        do {
            d[1] = ran.nextInt(4);
        } while (d[1] == d[0]);
        do {
            d[2] = ran.nextInt(4);
        } while (d[2] == d[0] || d[2] == d[1]);
        do {
            d[3] = ran.nextInt(4);
        } while (d[3] == d[0] || d[3] == d[1] || d[3] == d[2]);
        this.radioA.setText(this.currentQuestion.answers[d[0]]);
        this.radioB.setText(this.currentQuestion.answers[d[1]]);
        this.radioC.setText(this.currentQuestion.answers[d[2]]);
        this.radioD.setText(this.currentQuestion.answers[d[3]]);
        if (new File(this.currentQuestion.imgPath).exists()) {
            final ImageIcon residedImg = ImageUtil.resize(new ImageIcon(this.currentQuestion.imgPath), this.lblImage.getHeight(), this.lblImage.getWidth());
            this.lblImage.setIcon(residedImg);
        }
        else {
            this.lblImage.setText("Image not Found!");
        }
    }
    
    private void initFiles() {
        try {
            final File imgDir = new File("imgs");
            if (!imgDir.exists()) {
                imgDir.mkdir();
            }
            if (!this.quizFile.exists()) {
                final PrintWriter writer = new PrintWriter(this.quizFile);
                writer.println("imgs:img0.png&&N\u00famero de membros tem o sapo?&&4&&2&&3&&1&&0");
                writer.println("imgs:img1.png&&Qual foi o primeiro Rei de Portugal?&&D. Afonso Henriques&&Napole\u00e3o&&Lady Gaga&&Eus\u00e9bio&&0");
                writer.println("imgs:img1.png&&A Guerra dos Bal\u00f5es do DETI op\u00f5e?&&CT TSI vs ET&&ET vc CT&&CT ET vs TSI&&ET TSI vs CT&&0");
                writer.println("imgs:img1.png&&Qual era o primeiro nome de Picasso?&&Pablo&&Tito&&Eug\u00e9nio&&Diego&&0");
                writer.println("imgs:img1.png&&Qual \u00e9 o clube de futebol portugu\u00eas com mais t\u00edtulos oficiais da UEFA?&&FCP&&SLB&&SCB&&SCP&&0");
                writer.println("imgs:img0.png&&Qual foi o Cognome do sexto Rei de Portugal?&&O Lavrador&&O Desejado&&O Africano&&O Povoador&&1");
                writer.println("imgs:img1.png&&Qual o s\u00edmbulo do Pot\u00e1ssio?&&K&&Po&&P&&Pt&&1");
                writer.println("imgs:img1.png&&Qual \u00e9 o elemento mais abundante no Universo?&&Hidrog\u00e9nio&&Oxig\u00e9nio&&Ferro&&Ouro&&1");
                writer.println("imgs:img1.png&&Qual destes materi\u00e1is \u00e9 o mais precioso?&&Platina&&Ouro&&Prata&&Bronze&&1");
                writer.println("imgs:img1.png&&Como se chama a claque do Beira-Mar?&&Auri-Negros&&Milhafres&&Pac Mans&&Beira Beira&&1");
                writer.println("imgs:img0.png&&Qual a data da Batalha de Aljubarrota?&&1385&&1445&&1259&&1301&&2");
                writer.println("imgs:img1.png&&Tyrannosaurus Rex significa?&&lagarto tirano rei&&Dinossauro tirano rei&&Rei dos lagartos&&Tirano dos R\u00e9pteis&&2");
                writer.println("imgs:img1.png&&Fernando Pessoa desdobrava-se em quantas entidades liter\u00e1rias?&&4&&3&&2&&1&&2");
                writer.println("imgs:img1.png&&Quem descobriu o raio-x?&&Wilhelm Conrad R\u00f6ntgen&&Hermann von Helmholtz&&Fernando Sanford&&Nikola Tesla&&2");
                writer.println("imgs:img1.png&&Qual \u00e9 o n\u00famero at\u00f3mico do laur\u00eancio?&&103&&99&&40&&15&&2");
                writer.close();
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(QuizGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadQuizes() {
        try {
            final Scanner scan = new Scanner(this.quizFile);
            while (scan.hasNextLine()) {
                final String line = scan.nextLine();
                final String[] tmp = line.split("&&");
                String path = tmp[0];
                if (File.separator.equals("\\")) {
                    path = path.replace(":", "\\");
                }
                else {
                    path = path.replace(":", "/");
                }
                final String[] ans = { tmp[2], tmp[3], tmp[4], tmp[5] };
                final int lvl = Integer.parseInt(tmp[6]);
                final Question q = new Question(path, tmp[1], ans, lvl);
                this.quizes[lvl].add(q);
            }
            scan.close();
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(QuizGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void printQuizes() {
        ArrayList[] quizes;
        for (int length = (quizes = this.quizes).length, i = 0; i < length; ++i) {
            final ArrayList<Question> arr = (ArrayList<Question>)quizes[i];
            System.out.println("Dificuldade: ++");
            for (final Question q : arr) {
                System.out.println("\t" + q.question);
            }
        }
    }
    
    private void enableComp() {
        this.radioA.setEnabled(true);
        this.radioB.setEnabled(true);
        this.radioC.setEnabled(true);
        this.radioD.setEnabled(true);
    }
    
    private class Question
    {
        private String imgPath;
        private String question;
        private String[] answers;
        private int lvl;
        
        public Question(final String imgPath, final String question, final String[] answers, final int lvl) {
            assert answers.length == 4;
            this.imgPath = imgPath;
            this.question = question;
            this.answers = answers;
            this.lvl = lvl;
        }
    }
}
