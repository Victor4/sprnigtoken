package com.curso.tcc.schedules;

import com.curso.tcc.Utils.LeituraCSV;
import com.curso.tcc.model.OrdemServico;
import com.curso.tcc.model.Usuario;
import com.curso.tcc.repository.OrdemServicoRepository;
import com.curso.tcc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class ConsumirCSVBanco {

    private static final Logger LOGGER = Logger.getLogger(ConsumirCSVBanco.class.getName());
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Scheduled(initialDelay = 1000 * 30, fixedDelay=Long.MAX_VALUE)
    public void iniciar(){
        LOGGER.log(Level.INFO, "fim git");

        String clientes = getClass().getClassLoader().getResource("clientes.csv").getFile();
        String ordensS = getClass().getClassLoader().getResource("ordens.csv").getFile();

        List<Usuario> usuarios = LeituraCSV.lerArquivoComClientes(clientes);
        List<OrdemServico> ordens = LeituraCSV.lerArquivoComOrdens(ordensS);
        for (Usuario usuario: usuarios) {
            usuarioRepository.save(usuario);
        }
        for (OrdemServico ordemServico: ordens) {
            ordemServicoRepository.save(ordemServico);
        }
    }

}
