package cadastro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestaProduto {
    // Variável para armazenar o texto digitado pelo usuário
    private static String textoDigitado = "";
    private static String textoDigitado2 = "";
    private static String textoDigitado3 = "";
    public static int id;
    public static double valor;
    public static String descricao;
    public static int quantidade;
    private static String textoDigitado21 = "";
    private static String textoDigitado22 = "";
    private static String textoDigitado23 = "";
    private static String textoDigitado24 = "";
    public static int id_perecivel;
    public static double valor_perecivel;
    public static String descricao_perecivel;
    public static int quantidade_perecivel;
    public static String data_perecivel;
    private static Set<Integer> ids = new HashSet<>();
    public static int dia, mes, ano, dia_atual, mes_atual, ano_atual;
    public static boolean vencido = false;

    public static void main(String[] args) {
        JFrame janela = new JFrame("Minha janela");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 30, 30, 30); // Espaçamento entre os componentes
        gbc.fill = GridBagConstraints.BOTH; // Preenchimento tanto horizontal quanto vertical

        JButton btn1 = new JButton("Criar Produto");
        JButton btn2 = new JButton("Criar Produto Perecível");
        JButton btn3 = new JButton("Sair");

        // Adicionar botões ao painel com GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Proporção horizontal de expansão
        gbc.weighty = 1.0; // Proporção vertical de expansão
        painel.add(btn1, gbc);

        gbc.gridy = 1;
        painel.add(btn2, gbc);

        gbc.gridy = 2;
        painel.add(btn3, gbc);

        // Adicionar ouvintes de ação aos botões
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela1();
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela2();
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int escolha = JOptionPane.showConfirmDialog(
                        null,
                        "Deseja sair?",
                        null,
                        JOptionPane.YES_NO_OPTION
                );
                if (escolha == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Adicionar o painel ao frame
        janela.add(painel);

        // Fazer a janela ficar visível
        janela.setSize(600, 400);
        janela.setLocationRelativeTo(null); // Centralizar a janela na tela
        janela.setVisible(true);
    }
    
    public static void pegaData() {
    	// Obter a data atual
        LocalDate dataAtual = LocalDate.now();

        // Extrair dia, mês e ano
        dia_atual = dataAtual.getDayOfMonth();
        mes_atual = dataAtual.getMonthValue();
        ano_atual = dataAtual.getYear();
    }
    
  //NORMAL
    private static void tela1() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Criar Produto");
        dialog.setSize(300, 200);

        JPanel painel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Digite o ID:"); //ESCRITO DO SISTEMA
        JTextField textField = new JTextField(15); //USUARIO
        JLabel label2 = new JLabel("Digite o valor:");
        JTextField textField2 = new JTextField(15);
        JLabel label3 = new JLabel("Digite a descrição:");
        JTextField textField3 = new JTextField(15);
        JButton salvarBotao = new JButton("Salvar");
        JButton novoProduto = new JButton("Adicionar novo produto");

        salvarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                    // Armazenar o texto digitado pelo usuário
                    textoDigitado = textField.getText();
                    id = Integer.parseInt(textoDigitado);
                    
                    // Verificar se o ID já existe
                    if (ids.contains(id)) {
                        JOptionPane.showMessageDialog(null, "ID já existe. Por favor, escolha um ID diferente.");
                        return; // Saia do método se o ID já existir
                    }

                    ids.add(id); // Adicionar o ID ao conjunto

                    textoDigitado2 = textField2.getText().replace(",", ".");
                    valor = Double.parseDouble(textoDigitado2);

                    textoDigitado3 = textField3.getText();
                    descricao = textoDigitado3;

                    quantidade++;
                    
                    // Criar um objeto Produto com base nos valores inseridos
                    Produto produto = new Produto(id, valor, descricao, quantidade);

                    // Exemplo de como você pode usar o objeto Produto
                    System.out.println("\nProduto criado:");
                    System.out.println("ID: " + produto.getId());
                    System.out.println("Valor: " + produto.getValor());
                    System.out.println("Descrição: " + produto.getDescricao());
                    System.out.println("Quantidade: " + quantidade);
                    
                    dialog.dispose(); // Fecha o diálogo ao clicar no botão "Salvar"
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos nos campos numéricos.");
                }
            }
        });
        
        novoProduto.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		try {
                    // Armazenar o texto digitado pelo usuário
                    textoDigitado = textField.getText();
                    id = Integer.parseInt(textoDigitado);
                    
                    // Verificar se o ID já existe
                    if (ids.contains(id)) {
                        JOptionPane.showMessageDialog(null, "ID já existe. Por favor, escolha um ID diferente.");
                        return; // Saia do método se o ID já existir
                    }

                    ids.add(id); // Adicionar o ID ao conjunto

                    textoDigitado2 = textField2.getText().replace(",", ".");
                    valor = Double.parseDouble(textoDigitado2);

                    textoDigitado3 = textField3.getText();
                    descricao = textoDigitado3;
                    
                    quantidade++;

                    // Criar um objeto Produto com base nos valores inseridos
                    Produto produto = new Produto(id, valor, descricao, quantidade);

                    // Exemplo de como você pode usar o objeto Produto
                    System.out.println("\nProduto criado:");
                    System.out.println("ID: " + produto.getId());
                    System.out.println("Valor: " + produto.getValor());
                    System.out.println("Descrição: " + produto.getDescricao());
                    System.out.println("Quantidade: " + quantidade);

                    // Limpar os campos de texto
                    textField.setText("");
                    textField2.setText("");
                    textField3.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos nos campos numéricos.");
                }
        	}
        });
     
        painel.add(label);
        painel.add(textField);
        painel.add(label2);
        painel.add(textField2);
        painel.add(label3);
        painel.add(textField3);
        painel.add(salvarBotao);
        painel.add(novoProduto);

        dialog.add(painel);
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    //PERECIVEL
    private static void tela2() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Criar Produto");
        dialog.setSize(400, 300);

        GroupLayout layout = new GroupLayout(dialog.getContentPane());
        dialog.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel label = new JLabel("Digite o ID:");
        JTextField textField = new JTextField(15);
        JLabel label2 = new JLabel("Digite o valor:");
        JTextField textField2 = new JTextField(15);
        JLabel label3 = new JLabel("Digite a descrição:");
        JTextField textField3 = new JTextField(15);
        JLabel label4 = new JLabel("Digite a data (DD MM AAAA):");
        JTextField textField4 = new JTextField(15);
        JButton salvarBotao = new JButton("Salvar");
        JButton novoProduto = new JButton("Adicionar novo produto");

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(label)
                .addComponent(label2)
                .addComponent(label3)
                .addComponent(label4)
                .addComponent(salvarBotao));
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(textField)
                .addComponent(textField2)
                .addComponent(textField3)
                .addComponent(textField4)
                .addComponent(novoProduto));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label)
                .addComponent(textField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label2)
                .addComponent(textField2));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label3)
                .addComponent(textField3));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label4)
                .addComponent(textField4));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(salvarBotao)
                .addComponent(novoProduto));
        layout.setVerticalGroup(vGroup);

        salvarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                    // Armazenar o texto digitado pelo usuário
                    textoDigitado21 = textField.getText();
                    id_perecivel = Integer.parseInt(textoDigitado21);
                    
                    // Verificar se o ID já existe
                    if (ids.contains(id)) {
                        JOptionPane.showMessageDialog(null, "ID já existe. Por favor, escolha um ID diferente.");
                        return; // Saia do método se o ID já existir
                    }

                    ids.add(id); // Adicionar o ID ao conjunto

                    textoDigitado22 = textField2.getText().replace(",", ".");
                    valor_perecivel = Double.parseDouble(textoDigitado22);

                    textoDigitado23 = textField3.getText();
                    descricao_perecivel = textoDigitado23;
                    
                    textoDigitado24 = textField4.getText();
                    data_perecivel = textoDigitado24;
                    
                    pegaData();
                    
                    Scanner scanner = new Scanner(data_perecivel);
                    scanner.useDelimiter(" ");
                    
                    try {
                        // Leia cada parte como uma variável int
                        dia = scanner.nextInt();
                        mes = scanner.nextInt();
                        ano = scanner.nextInt();
                        
                        if(ano <= ano_atual) {
                        	if(mes <= mes_atual) {
                        		if(dia < dia_atual) {
                        			vencido = true;
                        		}
                        	}
                        } 

                    } catch (Exception e1) {
                        System.out.println("Formato de data inválido");
                    } finally {
                        // Certifique-se de fechar o scanner para liberar recursos
                        scanner.close();
                    }

                    quantidade++;
                    
                    // Criar um objeto Perecível com base nos valores inseridos
                    Perecível perecivel = new Perecível(id_perecivel, valor_perecivel, descricao_perecivel, dia, mes, ano);
                    
                    // Exemplo de como você pode usar o objeto Produto
                    System.out.println("\nProduto criado:");
                    System.out.println("ID: " + perecivel.getIdperecivel());
                    System.out.println("Valor: " + perecivel.getValorperecivel());
                    System.out.println("Descrição: " + perecivel.getDescricaoperecivel());
                    System.out.printf("Data de Validade: %d/%d/%d\n", perecivel.getDia(), perecivel.getMes(), perecivel.getAno());
                    System.out.printf("Data Atual: %d/%d/%d\n", dia_atual, mes_atual, ano_atual);
                    System.out.println("Quantidade: " + quantidade);
                    if(vencido == true) {
                    	System.out.println("O produto está vencido, o desconto de 15% será aplicado ao valor total.");
                    	double valor_final = perecivel.getValorperecivel() * 0.15;
                    	valor_perecivel = perecivel.getValorperecivel() - valor_final;
                    	System.out.printf("Valor final do produto após desconto: %.2f", valor_perecivel);
                    }
                    
                    dialog.dispose(); // Fecha o diálogo ao clicar no botão "Salvar"
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos nos campos numéricos.");
                }
            }
        });
        
        novoProduto.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		try {
        			// Armazenar o texto digitado pelo usuário
                    textoDigitado21 = textField.getText();
                    id_perecivel = Integer.parseInt(textoDigitado21);
                    
                    // Verificar se o ID já existe
                    if (ids.contains(id)) {
                        JOptionPane.showMessageDialog(null, "ID já existe. Por favor, escolha um ID diferente.");
                        return; // Saia do método se o ID já existir
                    }

                    ids.add(id); // Adicionar o ID ao conjunto

                    textoDigitado22 = textField2.getText().replace(",", ".");
                    valor_perecivel = Double.parseDouble(textoDigitado22);

                    textoDigitado23 = textField3.getText();
                    descricao_perecivel = textoDigitado23;
                    
                    textoDigitado24 = textField3.getText();
                    data_perecivel = textoDigitado24;

                    quantidade++;
                    
                    // Criar um objeto Produto com base nos valores inseridos
                    Perecível perecivel = new Perecível(id_perecivel, valor_perecivel, descricao_perecivel, dia, mes, ano);

                    // Exemplo de como você pode usar o objeto Produto
                    System.out.println("\nProduto criado:");
                    System.out.println("ID: " + perecivel.getIdperecivel());
                    System.out.println("Valor: " + perecivel.getValorperecivel());
                    System.out.println("Descrição: " + perecivel.getDescricaoperecivel());
                    System.out.printf("Data de Validade: %d/%d/%d\n", perecivel.getDia(), perecivel.getMes(), perecivel.getAno());
                    System.out.printf("Data Atual: %d/%d/%d\n", dia_atual, mes_atual, ano_atual);
                    System.out.println("Quantidade: " + quantidade);
                    if(vencido == true) {
                    	System.out.println("O produto está vencido, o desconto de 15% será aplicado ao valor total.");
                    	double valor_final = perecivel.getValorperecivel() * 0.15;
                    	valor_perecivel = perecivel.getValorperecivel() - valor_final;
                    	System.out.printf("Valor final do produto após desconto: %.2f", valor_perecivel);
                    }

                 // Limpar os campos de texto
                    textField.setText("");
                    textField2.setText("");
                    textField3.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos nos campos numéricos.");
                }
        	}
        });
     
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}

