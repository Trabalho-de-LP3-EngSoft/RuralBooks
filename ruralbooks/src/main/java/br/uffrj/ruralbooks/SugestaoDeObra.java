package br.uffrj.ruralbooks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SugestaoDeObra extends JFrame {
    private JComboBox<String> comboTipoObra;
    private JPanel panelForm;

    public SugestaoDeObra() {
        setTitle("Sugestão de Obra");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel labelTitulo = new JLabel("Sugestão de Obra", JLabel.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(labelTitulo, BorderLayout.NORTH);

        JPanel panelTipoObra = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelTipoObra = new JLabel("Tipo da Obra:");
        String[] tiposObra = {"Livro", "Artigo", "Tese Doutorado/Mestrado", "Revista Acadêmica"};
        comboTipoObra = new JComboBox<>(tiposObra);
        comboTipoObra.addActionListener(new TipoObraActionListener());
        panelTipoObra.add(labelTipoObra);
        panelTipoObra.add(comboTipoObra);
        panel.add(panelTipoObra, BorderLayout.WEST);

        panelForm = new JPanel();
        panel.add(panelForm, BorderLayout.CENTER);

        add(panel);
    }

    private class TipoObraActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tipoSelecionado = (String) comboTipoObra.getSelectedItem();
            atualizarFormulario(tipoSelecionado);
        }
    }

    private void atualizarFormulario(String tipoSelecionado) {
        panelForm.removeAll();
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));

        addCommonFields(panelForm);

        switch (tipoSelecionado) {
            case "Livro":
                panelForm.add(new JLabel("Volume:"));
                panelForm.add(new JTextField(20));
                panelForm.add(new JLabel("Editora:"));
                panelForm.add(new JTextField(20));
                panelForm.add(new JLabel("Número de Páginas:"));
                panelForm.add(new JTextField(20));
                panelForm.add(new JLabel("ISBN:"));
                panelForm.add(new JTextField(20));
                break;
            case "Artigo":
                panelForm.add(new JLabel("Revista:"));
                panelForm.add(new JTextField(20));
                panelForm.add(new JLabel("Apêndices:"));
                panelForm.add(new JTextField(20));
                break;
            case "Tese Doutorado/Mestrado":
                panelForm.add(new JLabel("Instituição:"));
                panelForm.add(new JTextField(20));
                panelForm.add(new JLabel("Orientadores:"));
                panelForm.add(new JTextField(20));
                panelForm.add(new JLabel("Ano de Defesa:"));
                panelForm.add(new JTextField(20));
                break;
            case "Revista Acadêmica":
                panelForm.add(new JLabel("Editora:"));
                panelForm.add(new JTextField(20));
                panelForm.add(new JLabel("ISSN:"));
                panelForm.add(new JTextField(20));
                panelForm.add(new JLabel("Média de Citações:"));
                panelForm.add(new JTextField(20));
                break;
        }

        panelForm.revalidate();
        panelForm.repaint();
    }

    private void addCommonFields(JPanel panelForm) {
        panelForm.add(new JLabel("Título:"));
        panelForm.add(new JTextField(20));
        panelForm.add(new JLabel("Autor:"));
        panelForm.add(new JTextField(20));
        panelForm.add(new JLabel("Área de Estudo:"));
        panelForm.add(new JTextField(20));
        panelForm.add(new JLabel("Data de Lançamento:"));
        panelForm.add(new JTextField(20));
        panelForm.add(new JLabel("Normalizada:"));
        JCheckBox normalizadaCheckBox = new JCheckBox();
        panelForm.add(normalizadaCheckBox);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SugestaoDeObra sugestaoDeObra = new SugestaoDeObra();
            sugestaoDeObra.setVisible(true);
        });
    }
}
