package com.curso.tcc.Utils;

import com.curso.tcc.model.OrdemServico;
import com.curso.tcc.model.Usuario;
import com.opencsv.CSVReader;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LeituraCSV {


    public static List<OrdemServico> lerArquivoComOrdens(String file) {
        List<OrdemServico> ordemServicosList = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String [] nextLine;
            int lineNumber = 0;
            while ((nextLine = reader.readNext()) != null) {
                OrdemServico ordemServico = new OrdemServico();
                lineNumber++;
                if(lineNumber == 1979){
                    System.out.println("a");
                }
                System.out.println("Line # " + lineNumber);
                ordemServico.setCodOS(nextLine[0].trim());
                ordemServico.setDataFinalizacao(nextLine[1]);
                ordemServico.setDataOS(nextLine[2]);
                if(nextLine[3].length() > 254){
                    ordemServico.setDescricaoProblema(nextLine[3].substring(0,253));
                }else{
                    ordemServico.setDescricaoProblema(nextLine[3]);
                }
                ordemServico.setQuilometragem(nextLine[4]);
                ordemServico.setStatusOS(nextLine[5]);
                ordemServico.setTotalProdutos(nextLine[6]);
                ordemServico.setTotalServico(nextLine[7]);
                ordemServico.setValorTotal(nextLine[8]);
                ordemServico.setPlacaVeiculo(nextLine[9]);
                ordemServico.setChassiVeiculo(nextLine[10]);
                ordemServico.setCorVeiculo(nextLine[11]);
                ordemServico.setMarcaVeiculo(nextLine[12]);
                ordemServico.setModeloVeiculo(nextLine[13]);
                ordemServico.setCodCliente(nextLine[14]);
                ordemServico.setNomeCliente(nextLine[15]);
                ordemServicosList.add(ordemServico);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ordemServicosList;
    }


    public static List<Usuario> lerArquivoComClientes(String file) {
        List<Usuario> usuariosList = new ArrayList<>();
        String senha = new BCryptPasswordEncoder().encode("123456");
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String [] nextLine;
            int lineNumber = 0;
            while ((nextLine = reader.readNext()) != null) {
                Usuario usuario = new Usuario();
                lineNumber++;
                System.out.println("Line # " + lineNumber);
                usuario.setCodCliente(nextLine[0]);
                byte array[] = nextLine[1].getBytes("UTF-8");
                String email = new String(array, "ISO-8859-1");
                usuario.setEmail(nextLine[1]);
                byte array2[] = nextLine[2].getBytes("UTF-8");
                String nome = new String(array2, "ISO-8859-1");
                usuario.setNome(nextLine[2]);
                usuario.setSenha(senha);
                usuario.setAtivo("0");
                if(usuario.getEmail().isEmpty()){
                    StringTokenizer token = new StringTokenizer(usuario.getNome()," ");
                    if(token.countTokens() > 1){
                        usuario.setEmail(token.nextToken().toLowerCase()+token.nextToken().toLowerCase()+"@email.com");
                    }else{
                        usuario.setEmail(token.nextToken().toLowerCase()+"@email.com");
                    }
                }
                usuariosList.add(usuario);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuariosList;
    }
}
